package grails.plugins.springsecurity.annotation;
 
import grails.plugins.springsecurity.Secured;
 
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
 
import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.AnnotatedNode;
import org.codehaus.groovy.ast.AnnotationNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.ListExpression;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;
import org.springframework.util.StringUtils;
 
/**
 * @author Burt Beckwith
 */
@GroovyASTTransformation(phase=CompilePhase.CANONICALIZATION)
public class AuthoritiesTransformation implements ASTTransformation {
 
  protected static final ClassNode SECURED =
       new ClassNode(Secured.class);
 
  public void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
    try {
      ASTNode firstNode = astNodes[0];
      ASTNode secondNode = astNodes[1];
      if (!(firstNode instanceof AnnotationNode) ||
          !(secondNode instanceof AnnotatedNode)) {
        throw new RuntimeException("Internal error: wrong types: " +
            firstNode.getClass().getName() +
            " / " + secondNode.getClass().getName());
      }
 
      AnnotationNode rolesAnnotationNode = (AnnotationNode) firstNode;
      AnnotatedNode annotatedNode = (AnnotatedNode) secondNode;
 
      AnnotationNode secured = createAnnotation(rolesAnnotationNode);
      if (secured != null) {
        annotatedNode.addAnnotation(secured);
      }
    }
    catch (Exception e) {
      // TODO
      e.printStackTrace();
    }
  }
 
  protected AnnotationNode createAnnotation(AnnotationNode rolesNode)
        throws IOException {
    Expression value = rolesNode.getMembers().get("value");
    if (!(value instanceof ConstantExpression)) {
      // TODO
      System.out.println(
         "annotation @Authorities value isn't a ConstantExpression: " +
         value);
      return null;
    }
 
    String fieldName = value.getText();
    String[] authorityNames = getAuthorityNames(fieldName);
    if (authorityNames == null) {
      return null;
    }
 
    return buildAnnotationNode(authorityNames);
  }
 
  protected AnnotationNode buildAnnotationNode(String[] names) {
    AnnotationNode securedAnnotationNode = new AnnotationNode(SECURED);
    List<Expression> nameExpressions = new ArrayList<Expression>();
    for (String authorityName : names) {
      nameExpressions.add(new ConstantExpression(authorityName));
    }
    securedAnnotationNode.addMember("value",
              new ListExpression(nameExpressions));
    return securedAnnotationNode;
  }
 
  protected String[] getAuthorityNames(String fieldName)
       throws IOException {
 
    Properties properties = new Properties();
    File propertyFile = new File("roles.properties");
    if (!propertyFile.exists()) {
      // TODO
      System.out.println("Property file roles.properties not found");
      return null;
    }
 
    properties.load(new FileReader(propertyFile));
 
    Object value = properties.getProperty(fieldName);
    if (value == null) {
      // TODO
      System.out.println("No value for property '" + fieldName + "'");
      return null;
    }
 
    List<String> names = new ArrayList<String>();
    String[] nameArray = StringUtils.commaDelimitedListToStringArray(
        value.toString());
    for (String auth : nameArray) {
      auth = auth.trim();
      if (auth.length() > 0) {
        names.add(auth);
      }
    }
 
    return names.toArray(new String[names.size()]);
  }
}