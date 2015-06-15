class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/items"(controller:"item", parseRequest: true){
			action = [OPTIONS: "optionsHandler"]
		}
		"/items/$id"(controller:"item", parseRequest: true){
			action = [OPTIONS: "optionsHandler"]
		}
		
		"/items"(resources:'Item')
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
