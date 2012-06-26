package com.dnb.foosball

class Player {

	User user
	Tournament tournament
	
    static constraints = {
		user blank: false
		tournament blank: false
    }
	
	String toString(){
		return user.toString()
	}
}
