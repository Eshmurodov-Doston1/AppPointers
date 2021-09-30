package com.example.apppointers.models

class Lesson {
    var name:String?=null
    var check:Boolean?=null
    var task:String?=null
    var date:String?=null

    constructor(name: String?, check: Boolean?, task: String?, date: String?) {
        this.name = name
        this.check = check
        this.task = task
        this.date = date
    }
}