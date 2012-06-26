package com.dnb.foosball

import grails.test.mixin.*
import org.junit.*

@TestFor(Score)
class ScoreTests {

	void testCreateScore() {
		def score = new Score(scores: [1, 5, 6], user: new User())
		score.match = new Match()
		
		score.save(flush: true)

		assertEquals 1, Score.list().size().intValue()
	}
}
