package grails.plugins.springsecurity.annotation;
 
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import org.codehaus.groovy.transform.GroovyASTTransformationClass;
 
/**
 * @author Burt Beckwith
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@GroovyASTTransformationClass(
    "grails.plugins.springsecurity.annotation.AuthoritiesTransformation")
public @interface Authorities {
   /**
    * The property file key; the property value will be a
    * comma-delimited list of role names.
    * @return the key
    */
   String value();
}