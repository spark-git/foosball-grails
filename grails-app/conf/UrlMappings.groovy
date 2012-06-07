class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:'welcome')
		"500"(view:'/error')
		"403" (controller:'login')
	}
}
