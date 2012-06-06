import com.dnb.foosball.*
class BootStrap {

    def init = { servletContext ->
		def User paulon = new User(username:"paulon", firstName:'Paul', lastName:'O\'Neill', password:"password123!", email:"oneillp@dnb.com", enabled:true).save(flush:true)
		def Role userRole = new Role(authority:"ROLE_USER").save(flush:true)
		def Role adminRole = new Role(authority:"ROLE_ADMIN").save(flush:true)
		UserRole.create(paulon, adminRole, true)
		
		assert User.count() == 1
		assert Role.count() == 2
		assert UserRole.count() == 1
    }
    def destroy = {
    }
}
