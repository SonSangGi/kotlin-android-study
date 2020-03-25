package dev.sanggi.part03.lab8_2

import io.realm.RealmObject

open class MemoVO(var title: String = "", var content: String = "") : RealmObject()
