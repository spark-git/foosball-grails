package com.dnb.foosball

class User {

	transient springSecurityService

	String username
	String firstName
	String lastName
	BigDecimal rank
	String password
	String email
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	static hasMany = [tournaments: UserTournament]

	static constraints = {
		firstName blank: false
		lastName blank: false
		username blank: false, unique: true
		password blank: false, password:true
		email blank: false, unique:true, email:true
		rank blank: true,nullable: true,  display:false
		
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
