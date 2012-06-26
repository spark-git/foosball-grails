package com.dnb.foosball.security

import grails.plugins.springsecurity.Secured
import grails.plugins.springsecurity.annotation.Authorities

class SecureController {

	@Authorities("anon")
    def open() {
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
