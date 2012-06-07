package com.dnb.foosball

class Match {

	Tournament tournament
	Date date
	Score player1Score
	Score player2Score
	
    static constraints = {
		tournament blank: false
    }
}
