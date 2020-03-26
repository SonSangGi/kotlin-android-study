# 파일 및 SharedPreferences를 이용한 데이터 영속화

### 파일 읽고 쓰기

<p>파일 관련 프로그램은 대부분 자바 API의 java.io를 사용한다.</p>

```
- File: 파일 및 디렉터리
- FileInputStream: 파일에서 바이트 데이터를 읽기 위한 함수 제공
- FileOutputStream: 파일에 바이트 쓰기를 위한 함수 제공
- FileReader: 파일에서 문자열 데이터를 읽기 위한 함수 제공
- FileWriter: 파일에 문자열 데이터를 쓰기 위한 함수 제공
```

<p>안드로이드의 스마트폰 저장 공간은 내부와 외부로 구분한다. 내부는 기본 저장소, 외부는 SD카드 같은 외부 저장소를 뜻한다.</p>
<p>저장소와 관련된 각종 정보는 Environment 클래스로 얻을 수 있다.</p>

```
- Environment.getExternalStorageState() 외부 저장공간 상태
- Environment.getExternalStorageDirectory().getAbsolutePath() 외부 저장공간 경로
- Environment.getDataDirectory().getAbsolutePath() 내부 저장공간 경로
```

##### 외부 저장공간 이용
<p>외부 저장공간 이용 시 스마트폰에서 외부저장공간 제공 여부를 판단해야한다.</p>

``` kotlin
 val state = Environment.getExternalStorageState()

// 마운트 됐을 경우
if(state == Environment.MEDIA_MOUNTED) {
    // 읽기 전용일 경우
    if(state == Environment.MEDIA_MOUNTED_READ_ONLY) {
        ...
    }
}
else {...}

```

<p>실제 외부저장소의 파일을 읽거나 쓰기 위해 manifest.xml 파일에 퍼미션을 추가해준다.</p>
<p>안드로이드 개발자 사이트를 보면 Android 4.4버전 (API 레벨 19) 부터는 파일을 읽거나 쓰는데 권한이 필요하지 않다고 한다.</p>
<p><a href="https://developer.android.com/training/data-storage/files/external?hl=ko" target="_blank">참조문서</a></p>

```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" android:maxSdkVersion="18"/>
```

<p>해당 책에 나와있는 파일 읽고 쓰기 코드이다.</p>

```java


FileWriter writer;
try {
    // 외부 저장 공간 root 하위에 myApp이라는 폴더 경로 획득
    Strign dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/myApp";
    File dir = new File(dirPath);
    
    if(!dir.exists()) {
        dir.mkdir();
    }
    
    ...
}
```

<p>위 코드를 보면 Enviroment.getExternalStorageDirectory()를 사용하여 루트 경로를 가져온 후 폴더를 만드는데,</p>
<p>해당 코드를 작성 후 AVD로 실행해보면 Permission denied 오류가 난다.</p>
<p>Environment.getExternalStorageDirectory()를 사용 시 deprecated 표시가 나올 것이다.</p>
<p>이유는 안드로이드 버전이 올라가면서 외부 저장소 최상위 경로에 직접적으로 접근할 수 없게 됐기 때문이다.</p>
<p>때문에 최상위 경로가 아닌 개별 앱 공간에 파일을 저장해야 한다.</p>
<p><strong style="color:red">!! 안드로이드 버전에 따라 다르기 때문에, 버전에 맞는 저장소 설정을 하거나 버전 체크후 처리해야함</strong></p>

```kotlin
val dir = getExternalFilesDir("/myApp")
```

<p>해당 코드를 작성 후 실행 시 개별앱 공간에 myApp 이라는 디렉토리가 만들어진다.</p>
<p>getExternalFilesDir()은 해당 앱의 외부 저장소 파일을 리턴한다. 인자로 가져올 디렉토리 유형을 넘겨준다.</p>

|인자|경로|
|--------------------------------------|-----------------------------------------------------|
| nvironment.DIRECTORY_ALARMS          |/mnt/sdcard/Android/data/패키지 이름/files/Alarms       |
| Environment.DIRECTORY_DCIM           |/mnt/sdcard/Android/data/패키지 이름/files/DCIM         |
| Environment.DIRECTORY_DOWNLOADS      |/mnt/sdcard/Android/data/패키지 이름/files/Downloads    |
| Environment.DIRECTORY_MUSIC          |/mnt/sdcard/Android/data/패키지 이름/files/Music        |
| Environment.DIRECTORY_MOVIES         |/mnt/sdcard/Android/data/패키지 이름/files/Movies       |
| Environment.DIRECTORY_NOTIFICATIONS  |/mnt/sdcard/Android/data/패키지 이름/files/Notifications|
| Environment.DIRECTORY_PICTURES       |/mnt/sdcard/Android/data/패키지 이름/files/Pictures     |
| Environment.DIRECTORY_PODCASTS       |/mnt/sdcard/Android/data/패키지 이름/files/Podcasts     |
| null                                 |/mnt/sdcard/Android/data/패키지 이름/files              |

`파일 쓰기`
```kotlin
val dir = getExternalFilesDir("/myApp")
val file = File("$dir/myfile.txt")

if (!file.exists()) file.createNewFile()

file.appendText("파일 쓰기")

```

`파일 읽기`
```kotlin
val dir = getExternalFilesDir("aad")
val file = File("$dir/myfile.txt")

var line = ""

file.readLines().forEach {
    line += it.plus("\n")
}

Log.i("파일 읽기", line)
```

<p>파일을 읽고 쓰는 방법은 다양하기 때문에 원하는 방식을 선택하면 된다.<br/>
<a href="https://kotlinlang.org/docs/tutorials/kotlin-for-py/file-io.html" target="_blank">참고 사이트</a>
해당 사이트를 참고하여 작성하였다.
</p>