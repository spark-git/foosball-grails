import com.dnb.foosball.*
class BootStrap {

    def init = { servletContext ->
		def User paulon = new User(username:"paulon", firstName:'Paul', lastName:'O\'Neill', password:"password123!", email:"oneillp@dnb.com", enabled:true).save(flush:true)
		def User briang = new User(username:"briang", firstName:'Brian', lastName:'Gallagher', password:"password123!", email:"gallagherb@dnb.com", enabled:true).save(flush:true)
		def Role userRole = new Role(authority:"ROLE_USER").save(flush:true)
		def Role adminRole = new Role(authority:"ROLE_ADMIN").save(flush:true)
		UserRole.create(paulon, adminRole, true)
		UserRole.create(briang, userRole, true)
		
		assert User.count() == 2
		assert Role.count() == 2
		assert UserRole.count() == 2
		
		// add tournaments and players
		def date = new Date().parse("dd-MM-yyyy", "01-01-2065") 
		def Tournament worldCupTournament = new Tournament(name: "World Cup", startDate: date, deadlineDate: date)
		def Player paulPlayer = new Player(user: paulon)

		paulPlayer.tournament = worldCupTournament
		worldCupTournament.players = [paulPlayer]
		
		worldCupTournament.save(flush: true)
		paulPlayer.save(flush: true)
		assert 1 == Tournament.count()
		assert 1 == Player.count()
		assert 1 == worldCupTournament.players.size(), 'World Cup tournament should have Paul as player'
		assert worldCupTournament.matches == null
    }
    def destroy = {
    }
}
