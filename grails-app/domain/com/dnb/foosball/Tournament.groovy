package com.dnb.foosball

class Tournament {

	String name
	Date startDate
	
	/** Deadline for joining the tournament */
	Date deadlineDate
	static hasMany = [matches: Match, players: UserTournament]
	
    static constraints = {
		name blank: false, unique: true
		startDate blank: false
		deadlineDate blank: false
    }
}
