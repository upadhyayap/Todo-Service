package com.pramati.imaginea

import grails.converters.JSON
import grails.transaction.Transactional
import javax.xml.bind.DatatypeConverter
class ItemController{

    static allowedMethods = [save: "POST",update:"PUT",delete:"DELETE",optionsHandler:"OPTIONS"]
	
	def index() { 
		println "index action called"
		def items = Item.list() 
		def responseMap = ["items": items]
		render responseMap as JSON
	}
	@Transactional
	def save() {
		println "save is called"
		def jsonObject = request.JSON['item']
		Item task = new Item()
		task.properties  = jsonObject
		//Calendar cal = DatatypeConverter.parseDateTime(jsonObject.deadline)
		task.deadline = Date.parse("yyyy-MM-dd'T'HH:mm:ss.000'Z'", jsonObject.deadline)
		//task.deadline = jsonObject.deadline
		println "date created is : ${task.dateCreated} and deadline is ${task.deadline}"
		task.save()
		task.save(flush :true)
		println "date created is : ${task.dateCreated}"
		def res = ['item':task]
		render res as JSON  
	}
	
	def show(long id) {
		print "show is called with id ${id}"
	}
	
	def update() {
		print "update is called"
		def jsonObject = request.JSON['item']
		println " id is -- ${jsonObject.id}"
		def task = Item.findById(params.id)
		task.properties  = jsonObject
		//Calendar cal = DatatypeConverter.parseDateTime(jsonObject.deadline)
		task.deadline = Date.parse("yyyy-MM-dd'T'HH:mm:ss.000'Z'", jsonObject.deadline)
		//task.deadline = jsonObject.deadline
		println "date created is : ${task.dateCreated} and deadline is ${task.deadline}"
		task.save()
		task.save(flush :true)
		println "date created is : ${task.dateCreated}"
		render status: 200
	}
	@Transactional
	def delete() {
		print "delete is called"
		def task = Item.findById(params.id)
		task.delete(flush: true)
		print "${task.title}"
		render status: 200
	}
	def optionsHandler() {
		println 'options'
		response.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS')
		render status:200
	}
}
