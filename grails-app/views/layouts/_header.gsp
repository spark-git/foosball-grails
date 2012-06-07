<div id='s2ui_header_body'>


	<span id='s2ui_login_link_container'>
		<nobr>
		<div id='loginLinkContainer' align='right'>
			<sec:ifLoggedIn>
				Logged in as <sec:username/> (<g:link controller='logout'>Logout</g:link>)
			</sec:ifLoggedIn>
			<sec:ifNotLoggedIn>
				<a href='#' id='loginLink'>Login</a>
			</sec:ifNotLoggedIn>
	
			<sec:ifSwitched>
				<a href='${request.contextPath}/j_spring_security_exit_user'>
				Resume as <sec:switchedUserOriginalUsername/>
				</a>
			</sec:ifSwitched>
		</div>
		</nobr>
	</span>
</div>
		