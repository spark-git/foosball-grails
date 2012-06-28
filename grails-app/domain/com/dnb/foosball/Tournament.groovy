package com.dnb.foosball

class Tournament {

	String name
	Date startDate
	
	/** Deadline for joining the tournament */
	//TODO: deadline shouldn't be later than start date
	Date deadlineDate
	static hasMany = [matches: Match, players: Player]
	
	//TODO customise validation message, it doesn't pick up com.dnb.foosball.Tournament.startDate.min key
    static constraints = {
		name blank: false, uniqe: true
		startDate blank: false, min: new Date()
		deadlineDate blank: false, min: new Date()
		players display: false 
		matches display: false
    }
	
	String toString() {
		// TODO format start date
		return "${name} (${startDate})"
	}
	
}
