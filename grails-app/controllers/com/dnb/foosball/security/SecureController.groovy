package com.dnb.foosball.security

import grails.plugins.springsecurity.Secured
import grails.plugins.springsecurity.annotation.Authorities

class SecureController {

	@Authorities("everyone")
    def index() {
		render 'not secured' 
	}

	@Authorities("known")
	def allUsers() {
		render 'Logged in users only'
	}
	
	@Authorities("admin")
	def adminsOnly() {
		render 'Admin users only!'
	}
	
}
