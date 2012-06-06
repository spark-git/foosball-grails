package com.dnb.foosball

import grails.plugins.springsecurity.Secured

class WelcomeController {

	def springSecurityService
	
    def index() { 
		redirect (action: 'landing', params:params)
	}	

	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	def landing() {				
		[user:springSecurityService.currentUser];		
	}
}
