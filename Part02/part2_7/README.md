<h1 align="center">리소스 활용 및 스마트폰 크기 호환성</h1>

## 리소스 종류
```
drawable: 이미지, 이미지와 관련된 xml, 그림을 표현한 xml
layout: 화면 UI를 정의한 레이아웃 xml
values: 문자열, 색상, 크기 등 여러가지 값
menu: 액티비티 메뉴를 구성하기 위한 xml
xml: 특정 폴더가 지정되어 있지 않은 기타 xml
anim: 애니메이션을 위한 xml
raw: 바이트 단위로 직접 이용되는 이진 파일
mipmap: 앱 아이콘 이미지
```

## 다양한 리소스 활용

### 애니메이션 리소스
```xml
<set xmlns:android="http://schemas.android.com/apk/res/android">
    <tanslate/>
    <rotate/>
    <alpha/>
    <scale/>
</set>
```

- scale: 크기변경 애니메이션, 크기 확대/축소
- rotate: 회전 애니메이션
- alpha: 투명도 조정 애니메이션
- translate: 이동 애니메이션

### 크기, 색상 리소스

values 하위에 위치
```
strings.xml: 문자열 리소스를 여러개 담는 파일, 파일 내에 <string>태그로 각 리소스 등록
colors.xml: 색상 리소스를 여러개 담는 파일, 파일 내에 <color>태그로 각 리소스 등록
styles.xml: 스타일 여러개 담는 파일, 파일 내에 <style>태그로 각 리소스 등록
arrays.xml: 배열 리소스를 여러개 담는 파일, 파일 내에 <string-array>,<integer-array>태그로 각 리소스 등록
dimens.xml: 크기 리소스를 여러개 담는 파일, 파일 내에 <dimen>태그로 각 리소스 등록
```
