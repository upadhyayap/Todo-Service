package com.pramati.imaginea

import java.util.Date;
import org.grails.databinding.BindingFormat

class Item {
	long id
    String title
	String summery
	Date dateCreated
	@BindingFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'")
	Date deadline
	String status
	static constraints = {
		title blank:false ,unique:true
		deadline nullable:false
	}
	String toString() {
		title
	}
}
