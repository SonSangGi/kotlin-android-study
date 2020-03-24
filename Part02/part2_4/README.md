# PART2_4 레이아웃을 활용한 다양한 뷰 배치

###  Part2 4-1 LinearLayout
- 가장 많이 이용되는 레이아웃 중 하나
- 해당 레이아웃에 포함된 뷰를 순서대로 가로나 세로 방향으로 나열
- 다른 레이아웃에는 없는 orientation 으로 기준을 정함
```

@ orientation: horizontal, vertical - 가로, 세로 나열

@ 안드로이드에서 뷰의 정렬과 관련된 속성은 gravity와 layout_gravity 두가지이다.
gravity: 뷰의 내용을 뷰영역 내에서 어디세 나타낼지 설정
layout_gravity: 뷰를 linearLayout영역 내에서 어디에 나타낼지 설정

@ weight 속성은 가로나 세로 방향으로 생기는 여백을 뷰들이 확장해서 차지하게 할 때 사용
```

### Part2 4-2 RelativeLayout

- 화면에 이미 배치된 뷰를 기준으로 다른 뷰의 위치를 지정하는 레이아웃
- 뷰의 상대 위치를 지정하여 배치
- 자동으로 가로나 세로로 나열하지 않음
```
 @ android: layout_above: 기존 뷰의
  윗부분에 위치 @ android: layout_below: 기존 뷰의 아랫부분에 배치 @ android:
  layout_toLeftOf: 기존 뷰의 왼쪽에 위치 @ android: layout_toRightOf: 기존 뷰의
  오른쪽에 배치

@ android: layout_alignTop: 기준 뷰와 윗부분을 정렬
@ android: layout_alignBottom: 기준뷰와 아랫부분을 정렬
@ android: layout_alignLeft: 기준뷰와 왼쪽을 정렬
@ android: layout_alignRight: 기준뷰와 오른쪽을 정렬
@ android: layout_alignBaseline: 기준뷰와 텍스트 기준선을 정

@ android: layout_alignParentTop: 부모의 윗부분에 뷰의 상단을 위치
@ android: layout_alignParentBottom: 부모의 아랫부분에 뷰의 하단을 위치
@ android: layout_alignParentLeft: 부모의 왼쪽에 뷰의 왼쪽을 위치
@ android: layout_alignParentRight: 부모의 오른쪽에 뷰의 오른쪽을 위치
@ android: layout_centerHorizontal: 부모의 가로 방향 중앙에 뷰를 위치
@ android: layout_centerVertical: 부모의 세로 방향 중앙에 뷰를 위치
@ android: layout_centerInParent: 부모의 가로세로 중앙에 뷰를 위치
```
** LinearLayout 보다 RelativeLayout 으로 개발하는 경우가 더 많음

###  Part2 4-3 FrameLayout
- 레이아웃에 포함된 뷰들을 같은 영역에 겹쳐서 배치할 때 사용
- 같은 영역에 여러 뷰를 겹치게 한다음, 한순간에 하나의 뷰만 보이기 위함 (visible 속성
사용)

! TabHost : 탭화면 구현
- 안드로이드 UI 프로그램에서 가장 많이 제공하는 화면 중 하나
- 탭화면을 여러 개 준비한 다음, 사용자가 버튼을 누를 때 버튼과 연결된 화면을 보여주는 형식
```

@ TabHost: 탭 전체 영역을 지칭
@ TabWidget: 탭 버튼이 들어갈 영역을 지칭
@ FrameLayout: 탭 버튼 클릭 시 나올 화면 영역을 지칭

! @android:id 를 사용하는 이유: 라이브러리의 R.java 파일을 사용하기 위해
```
탭 화면을 만들기 위해선 전체 영역을 TabHost로 감싸고
그안에 버튼이 들어갈 영역 TabWidget과
보일 화면인 FrameLayout을 지정해야함

###     Part2 4-4 TableLayout
- 뷰를 테이블 구조로 나열하는 레이아웃
- 대표적으로 계산기 앱 화면
```
@ android:shrinkColumns="0,1" : 화면 크기를 벗어나는 경우 인덱스 0,1의 열 크기를 줄임
@ android:stretchColumns="1": 화면 여백이 발생하는 경우 인덱스 1의 열의 크기를 늘림
@ android:layout_column="1": 뷰의 위치 지정, 인덱스 1의 위치에 뷰가 위치
@ android:layout_span="2": 두개의 열을 하나의 뷰가 차지
```

### Part2 4-5 ConstraintLayout

- RelativeLayout과 비슷함
- 상대 위치에 따라 뷰의 배치를 제공
- RelativeLayout보다 상대 위치 속성이 많음
```
# 1.상대적 위치 지정
@app:layout_constraintLeft_toLeftOf
@app:layout_constraintLeft_toRightOf
@app:layout_constraintRight_toLeftOf
@app:layout_constraintRight_toRightOf
@app:layout_constraintTop_toTopOf
@app:layout_constraintTop_toBottomOf
@app:layout_constraintBottom_toTopOf
@app:layout_constraintBottom_toBottomOf
@app:layout_constraintBaseline_toBaselineOf
@app:layout_constraintStart_toEndOf
@app:layout_constraintStart_toStartOf
@app:layout_constraintEnd_toStartOf
@app:layout_constraintEnd_toEndOf

속성값으로 상대뷰의 id값 혹은 parent라는 단어로 상위 뷰를 지칭

# 2.여백 (margin) : 뷰와 뷰 사이의 간격을 표현하기 위한 속성들
@android:layout_marginStart
@android:layout_marginEnd
@android:layout_marginLeft
@android:layout_marginRight
@android:layout_marginTop
@android:layout_marginBottom

상대 뷰가 View.GONE 상태일 때의 margin 값을 따로 설정 가능
@app:layout_gonMarginStart
@app:layout_gonMarginEnd
@app:layout_gonMarginLeft
@app:layout_gonMarginTop
@app:layout_gonMarginRight
@app:layout_gonMarginBottom

# 3.가운데 맞춤과 치우침 (bias) : 뷰를 부모 중앙에 위치시키지만, 어느 쪽으로 치우쳐서 나오게 하고 싶은 경우 사용
@app:layout_constraintHorizontal_bias: 가로 치우침 조절
@app:layout_constraintVertical_bias: 세로 치우침 조절
값은 실수 타입

# 4.비율 (Ratio) : 뷰의 크기를 지정할 때 가로세로 비율에 의한 크기를 지정, 크기 값을 0dp로 설정해야함
@app:layout_constraintDimensionRatio
```
