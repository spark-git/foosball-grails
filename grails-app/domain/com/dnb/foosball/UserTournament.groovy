package com.dnb.foosball

class UserTournament {

	User user
	Tournament tournament
	
    static constraints = {
		user blank: false
		tournament blank: false
    }
}
