import com.dnb.foosball.*
class BootStrap {

    def init = { servletContext ->
		def User basicUser = new User(username:"basic", password:"password", email:"oneill6p@dnb.com", enabled:true).save(flush:true)
		def User adminUser = new User(username:"admin", password:"password", email:"oneil4lp@dnb.com", enabled:true).save(flush:true)
		def User adminUser2 = new User(username:"admin", password:"password", email:"on6eillp@dnb.com", enabled:true).save(flush:true)
		def Role basicRole = new Role(authority:"BASIC_ROLE").save(flush:true)
		def Role adminRole = new Role(authority:"ADMIN_ROLE").save(flush:true)
		UserRole.create(adminUser, adminRole, true)
		
		assert User.count() == 2
		assert Role.count() == 2
		assert UserRole.count() == 1
    }
    def destroy = {
    }
}
