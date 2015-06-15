package com.pramati.imaginea


class ItemInterceptor {

    boolean before() { 
		header( "Access-Control-Allow-Origin", "*" )
		header( "Access-Control-Allow-Credentials", "false" )
		header( "Access-Control-Allow-Methods", "POST, GET, PUT, DELETE,OPTIONS" )
		header("Access-Control-Allow-Headers", "X-Requested-With, X-Prototype-Version")
		header( "Access-Control-Max-Age", "1728000" )
		true 
	}

    boolean after() { true }

    void afterView() {
        // no-op
    }

}
