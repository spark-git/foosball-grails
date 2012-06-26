package com.dnb.foosball

class Tournament {

	String name
	Date startDate
	
	/** Deadline for joining the tournament */
	//TODO: deadline shouldn't be later than start date
	Date deadlineDate
	static hasMany = [matches: Match, players: UserTournament]
	
	//TODO customise validation message, it doesn't pick up com.dnb.foosball.Tournament.startDate.min key
    static constraints = {
		name blank: false, unique: true
		startDate blank: false, min: new Date()
		deadlineDate blank: false, min: new Date()
    }
}
