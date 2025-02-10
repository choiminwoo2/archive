# 코틀린 튜토리얼 정리

# 1. 코틀린은 함수 기반 언어

```kotlin
fun main() {
    println("Hello, world!")
    // Hello, world!
}
```

# 2. 코틀린에서 val

* 자바스크립트와 같은 동적 타입 변수
* 사칙 연산 방법은 타 프로그래밍 언어와 같다.

```kotlin

    var customer = 8
    customer += 5 // 13
    customer -= 5 // 8
    customer *= 2 // 16
    customer /= 8 // 2
```

# 3코틀린의 타입

## 3.1 여러가지 타입

![img_1.png](img_1.png)

## 3.2 타입 선언 방법

```kotlin
    val integerNum: Int
    integerNum = 4

    val e: String = "hello"

```

## 불변 변수 val 과 가변 변수 var

```kotlin
    fun main() {
    // 선언할 때 주입하면 
    val integerNum: Int = 4

    //integerNum = 5 // 에러
    val integerNum2: Int
    integerNum2 = 5
    
    println(integerNum)
    println(integerNum2)
    }

```

# 4. 컬렉션

* LIST, SET, MAP 의 컬렉션을 제공한다

## 4.1 List 계열

### 4.1.1 List

* 불변 list을 만들 수 있다.
* 재할당 불가능 및 변하지 않는 불변 데이터를 다루는데 사용
```kotlin
    //타입으로 생성 가능 없어도 생성가능.
    val list = listOf<T>()
```

### 4.1.2 MutableList, ArrayList

* add, remove 등 리스트의 데이터를 삭제하거나 추가가 가능함.
* ArrayList 경우 자바에서 제공하는 ArrayList 자바 관련 API 사용한다면 이것을 사용하는 것을 더 권장하는 편

```kotlin
    var list1 = mutableListOf<String>()
    var list2 = arrayListOf<String>()
```

## 4.2 SET

* 중복을 허용하지 않는 자료 구조
* 원래 SET은 순서를 보장하지 않지만, 코틀린은 어떤식으로 구성되있는지 모르겠.

## 4.3 MAP

* 키, 밸류 형식의 자료구조

