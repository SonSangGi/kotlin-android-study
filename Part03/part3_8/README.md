# Part3_8 DBMS를 이용한 데이터 영속화

### lab1 SQLite
<p>오픈 소스로 만들어진 관계형 데이터베이스. 복잡하고 구조화된 애플리케이션 데이터를 저장하고 관리한다.</p>
<p>프로세스가 아닌 라이브러리를 이용하여 데이터페이스가 애플리케이션의 일부로 통합된다.</p>
<p>데이터는 파일로 저장되며 MP3, 아이폰, 아이팟 터치 등 모바일 장치에서 많이 사용된다.</p>
<p>저장 경로: data/data/[package_name]/databases</p>

> ##### SQLiteDatabase 클래스
>
> 데이터베이스 프로그램의 핵심 클래스, 모든 CRUD 질의문은 SQLiteDatabase에서 이루어진다.
>
> SQLiteDatabase 객체를 얻으려면 openOrCreateDatabase() 함수를 이용한다.
>
> ``` kotlin
> // 데이터베이스 생성
> val db = openOrCreateDataBase("memodb", MODE_PRIVATE, null)
> //데이터 저장
> db.execSQL("insert into person (name, age) values(?, ?)", arrayOf(name, age))
> // 데이터 조회
> val cursor = db.rawQuery("select name, age from person", null) // null은 ?에 들어갈 매개변수
> ```
>
> ##### SQLiteOpenHelper
>
> 데이터 페이스 관리만을 목적으로 하는 클래스
>
> 데이터 저장이나 획득등의 코드는 SQLiteDatabase를 이용하여 작업하고,  
> 테이블 생성이나 스키마 변경등은 SQLiteOpenHelper로 작업한다.
>
> ``` kotlin
> class DBHelper(context: Context) : SQLiteOpenHelper(context, "memodb", null, 1) {
> 
>     private val DATABASE_VERSION = 1
> 
>     // Helper 클래스가 최초로 사용되는 순간 호출
>     override fun onCreate(db: SQLiteDatabase) {
>         //...
>     }
> 
>     // Helper 클래스의 생성자에 전달되는 버전이 변경될 때 호출
>     override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
>         //...
>     }
>}
> ```
> DBHelper를 정의 후 실제 SQL 문을 수행하기 위해 SQLiteDatabase를 획득한다.
> ``` kotlin
> val helper = DBHelper(this)
> val db = helper.writableDatabase
> ```
>
> ##### insert(), query(), update(), delete() 함수 이용
>
> SQL 문을 수행하기 위해 위에서 사용했던 rawQuery(), execSQL() 함수 이외에 다음 함수를 이용할 수 있다.
>
> ``` kotlin
> insert(table: String, nummColumnHack: String, values: ContentValues)
> update(table: String, values: ContentValues, whereClause: String, whereArgs: String[])
> delete(table: String, whereClause: String, whereArgs: String[]) 
> query(distinct: Boolean, table: String, columns: String[], selection: String, selectionArgs: String[],
>          groupBy: String, having: String, orderBy: String, limit: String)
> ```


### lab2 Realm

<p>Realm은 SQLite보다 빠른 속도와 ORM(Object Realational Mappings)를 가진 오픈소스 라이브러리다.</p>
<p>자바의 ORM 표준인 JPA와 유사하다.</p>

`프로젝트의 build.gradle`
``` js
dependencies {
        ...
        classpath 'io.realm:realm-gradle-plugin:2.2.0'
}
```

`모듈의 build.gradle`
```
apply plugin: 'kotlin-kapt'

apply plugin: 'realm-android'
```
<p>kotlin에서 realm을 사용하려면 kapt를 추가해야한다. 버전에 따라 추가하지 않아도 된다고 하니 버전을 잘 확인하자.</p>

##### Realm 사용

<p>Realm을 사용하기 위해서 ORM에서 관리할 데이터 클래스를 만들어야한다. (JPA의 domain과 같음)</p>
<p>사용할 클래스를 만들고, RealmObject를 상속받아 사용 가능하다.</p>

``` kotlin
open class Person(var name: String = "", var age: Int = "") : RealmObject()
```

<p>Realm 객체를 이용해 데이터르 ㄹ저장하거나 획득하는 작업은 아래와 같이 사용한다.</p>

``` kotlin
// 저장
Realm.getDefaultInstance()
    mRealm.executeTransaction { realm ->
        val vo = realm.createObject(Person::class.java)
        vo.name = "손상기"
        vo.age = 25
    }

// 조회
var vo = mRealm.where(Person::class.java).equalTo("name", "손상기").findFirst()

// 삭제
// 획득된 vo의 deleteFromRealm() 함수를 사용
vo.deleteFromRealm()

// 특정 타입의 모든 데이터 삭제
mRealm.delete(Person::class.java)
```