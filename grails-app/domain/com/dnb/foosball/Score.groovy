package com.dnb.foosball

/**
 * Score of a player for all games of a match
 */
class Score {

	User user

	// TODO: do we need this? is this only for cascade operations: if we delete the match, it will get deleted
	static belongsTo = [match: Match]

	// TODO: how does Hibernate stores a list?
	def scores = []
	
	static constraints = {
		user blank: false
	}
}
