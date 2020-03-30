# Part4_10 AdapterView 활용

> <p>여러 데이터를 나열하고 그중 하나를 사용자가 선택하는 뷰</p>
>
> - ListView: 목록 화면
> - AutoCompleteTextView: 사용자 입력글에 추천 단어 목록
> - Spinner: 콤보박스
> - ...
>
> <p>항목을 나열하는 뷰를 안드로이드에서는 AdapterView라고 한다.</p>
> <p>AdapterView는 꼭 adapter로만 완성이 되며, AdapterView만으로는 아무것도 표현되지 않는다.</p>

### ArrayAdapter

ArrayAdapter는 각 항목에 문자열 데이터를 순서대로 하나씩 나열할 때 사용한다.

`layout`
``` xml
<ListView
    android:id="@+id/main_listview_array"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

`activity.kt`
``` kotlin
val arrayDatas = resources.getStringArray(R.array.location)

main_listview_array.adapter =
    ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayDatas)
```

- arrayDatas: 항목을 구성하는 데이터
- this: context 객체
- android.R.layout.simple_list_item_1: 항목 하나를 구성하기 위한 레이아웃 XML 파일 정보

android.R.layout.simple_list_item_1외에 ListView를 위해 제공되는 라이브러리의 XML 파일은 여러개이다.
- simple_list_item_1: 항목에 문자열 데이터 하나
- simple_list_item_2: 항목에 문자열 데이터 두 개 위아래 나열
- simple_list_item_single_choice: 문자열과 오른쪽 라디오 버튼 제공
- simple_list_item_multiple_choice: 문자열과 오른쪽 체크박스 제공


항목을 나열하는 뷰들은 대부분 클릭 이벤트를 처리해야한다.

`AdapterView.OnItemClickListener 인터페이스 상속`
``` kotlin
override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    Toast.makeText(this, arrayDatas[position], Toast.LENGTH_SHORT).show()
}
```

데이터가 동적으로 추가되거나 제거되는 경우 notifyDataSetChanged() 함수를 사용한다.
``` kotlin
adapter.notifyDataSetChanged()
```

### SimpleAdapter

<p>ArrayAdapter는 한 항목에 문자열 데이터 하나를 나열할 때 사용한다.</p>
<p>만약 한 항목에 문자열 데이터를 여러 개나열해야 하는 경유 SimpleAdapter로 구성할 수 있다.</p>

```kotlin
val simpledatas = arrayListOf<HashMap<String, String>>()
val helper = DBHelper(this)
val db = helper.writableDatabase
val cursor = db.rawQuery("select * from tb_data", null)
while (cursor.moveToNext())
    simpledatas.add(
        hashMapOf(
            "name" to cursor.getString(1),
            "content" to cursor.getString(2)
        )
    )

main_listview_simple.adapter = SimpleAdapter(
    this, simpledatas
    , android.R.layout.simple_list_item_2
    , arrayOf("name", "content")
    , intArrayOf(android.R.id.text1, android.R.id.text2)
)
```
<p>위 코드는 SQLite에서 데이터를 가져와 main_listview_simple 이라는 ListView에 데이터를 보여주는 코드이다.</p>
<p>여러개의 데이터를 표현하기 위해 hashMap을 사용하여 데이터를 담고, ListView에 연결한다.</p>

- arrayOf("name", "content"): 한 항목의 데이터를 가지는 hashMap에서 데이터를 추출하기 위한 키 값
- intArrayOf(android.R.id.text1, android.R.id.text2): 추출된 데이터를 화면에 출력하기 위한 레이아웃 파일 내의 뷰 id 값

### CursorAdapter

<p>안드로이드 DBMS프로그램의 select 결과값을 그대로 이용해 항목을 구성해준다.</p>
<p>위의 SimpleAdapter 예제 코드를 CursorAdapter 코드로 변경한다면 아래와 같다.</p>

``` kotlin
main_listview_cursor.adapter = SimpleCursorAdapter(
    this
    , android.R.layout.simple_list_item_2
    , cursor
    , arrayOf("name", "content")
    , intArrayOf(
        android.R.id.text1, android.R.id.text2
    )
)
```

<p>while문을 돌며 데이터를 추출할 필요 없이, cursor 객체로 알아서 항목을 구성해준다.</p>