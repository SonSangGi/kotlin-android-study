# 사용자 이벤트 처리


스마트폰에서 화면에 발생하는 사용자 이벤트는 크게 두가지 모델로 나누어 볼 수 있다.
- 델리게이션 이벤트 모델: 뷰에서 발생하는 이벤트를 처리하기 위한 모델
- 하이어라키 이벤트 모델: 액티비티에서 발생하는 사용자의 터치나 키 이벤트를 직접 처리하기 위한 모델

### Part2_6 델리게이션 이벤트 모델

이벤트 소스와 이벤트 핸들러를 리스너로 연결하여 처리하는 구조

```
- 이벤트처리
    @OnClickListener: 뷰 클릭 시 발생하는 이벤트
    @OnLongClickListener: 뷰를 오래 클릭했을 때 발생하는 이벤트
    @OnCheckedChangeListener: CheckBox의 상태 변경 이벤트
    @OnItemClickListener: ListView의 항목 선택 이벤트
    @OnDateSetListener: DatePicker의 날짜 선택 이벤트
    @OnTimeSetListener: TimePicker의 시간 선택 이벤트
```

### Part2_6 하이어라키 이벤트 모델
액티비티가 화면에 출력되었을 때 발생하는 사용자의 키 이벤트와 화면 터치 이벤트를 처리하기 위한 모델
```
 - 이벤트처리
    @onTouchEvent: 액티비티에 보이는 내용을 사용자가 손가락으로 조작하는 일을 처리
        - ACTION_DOWN: 터치된 순간의 이벤트
        - ACTION_UP: 터치를 떼는 순간의 이벤트
        - ACTIVE_MOVE: 터치한 후 이동하는 순간의 이벤트
    @onKeyDown: 키를 늘렀을 때의 이벤트 처리
    @onKeyUp: 키를 떼는 순간의 이벤트 처리
    @onKeyLongPress: 키를 오래 늘렀을 때의 이벤트 처리
```