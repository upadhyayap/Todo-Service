package com.pramati.imaginea

import java.text.DateFormat
import java.text.SimpleDateFormat
import javax.xml.bind.DatatypeConverter

class datetest {

	static main(args) {
	String stringDate = "2015-06-16T18:30:00:000Z"  
	/*Calendar cal = DatatypeConverter.parseDateTime(stringDate)
	println "${cal.getTime()}"*/
	/*def formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ")
	println "${Date.parse("yyyy-MM-dd'T'HH:mm:ss'Z'", stringDate)}"*/
	println "${Date.parse("yyyy-MM-dd'T'HH:mm:ss:000'Z'", stringDate)}"
	}

}
