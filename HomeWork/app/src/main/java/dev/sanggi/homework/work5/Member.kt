package dev.sanggi.homework.work5

import io.realm.RealmObject

open class Member(var idx: Long = 0,var id: String = "", var password: String = "") : RealmObject()