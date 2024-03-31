# Kotlin 스터디를 위한 레포지토리입니다.



## 01. 코틀린에서 변수를 다루는 법

### var과 val

#### var
 - var(variable)은 변수형 타입이다.
   - 예를들면 java의 int, float과 같은 것이라고 생각하면 된다.
   - 타입스크립트의 변수 선언과 비슷하다고 생각하면 된다.
#### val
 - val(value)은 상수형 타입이다.
 - val collection 에서는 element를 추가할 수 있다.
   ~~~kotlin
   val collection = mutableListOf(1, 2, 3)
    collection.add(4)
    collection.add(5)
   ~~~

코드를 클린하게 가꾸기 위해서 Tip
- 모든 변수를 val로 선언한 뒤에, 필요할 때만 var로 선언한다.



### 코틀린에서 primitive type

- 변수의 타입을 reference Type인 Long으로 선언해도
  - 코틀린내에서 실행시에 적절한 타입으로 변경해준다.
  - 코드상에서는 평범한 클래스처럼 보인다.  



### 코틀린에서 nullable 변수

- Type 뒤에 ?를 붙여준다.
   ~~~ kotlin
   var number3: Long? = 30
   number3 = null
   ~~~



### 객체 인스턴스

   ~~~ kotlin
   var person = Person()
   ~~~



## 02. 코틀린에서 null을 다루는 법

### kotlin에서의 null 체크

- Java와 달리 kotlin에서는 null이 가능한 타입을 완전히 다르게 취급한다.
- 함수나 변수 선언 시 모두 타입 뒤에 ?를 붙여준다.



### kotlin에서의 null변수를 위한 특정한 기능

#### Safe call
~~~ kotlin
val str: String?? = "ABC"
str.length // 불가능
str?. length // 가능
~~~
- null이 아니면 실행
- null이면 실행하지 않는다. (그대로 null)

#### Elvis 연산자
- ?:
- 앞의 연산 결과가 null이면 뒤 값을 사용
~~~ kotlin
str?.length ?: 0
~~~
- 삼항 연산자와 비슷하다 생각하면 될 것 같다.



### null이 아님을 단언할 때

- !!
- 코드를 개발하다 어쩔 수 없이 nullable 변수로 선언했지만, 실제로는 null값이 들어갈 경우가 아닌경우에 사용한다.
~~~
fun ...(){
return str!!.startsWith("A")
}
~~~
- 허나 변수값이 null이면 런타임에서 NPE가 발생한다.

#### Kotlin에서 Java코드를 사용할 때 nullable에 대한 처리
- @Nullable 또는 @NotNull 어노테이션등을 통해 Kotlin에서 해당 변수가 nullable 인지 판단할 수 있다.
- @Nullable이 없다면 kotlin에서는 이값이 nullable인지 아닌지 판단할 수 없다.
~~~ java
// @Nullable이 없음
String str = "ABC";
~~~
  - 이런 타입을 **플랫폼 타입**이라 한다.
    - 코틀린이 null 관련 정보를 알 수 없는 타입, Runtime 시 Exception이 발생할 수 있다.
    - 이런 경우 kotlin에서 래핑을 하거나, 라이브러리 코드를 확인해본다.
    ~~~ kotlin
    println(startsWith(person.name ?: "null"))
    ~~~



## 03. 코틀린에서 Type을 다루는 법

### Kotlin은 명시적으로 타입 변환을 해줘야 된다.

- Java에서는 명시적으로 타입변환을 해주지 않아도 암시적으로 컴파일에서 자동으로 변경해준다.

- 허나 코틀린은 명시적으로 다 변환을 해줘야 한다.

  ~~~kotlin
  val number1 = 3
  val number2: Long = number1.toLong()
  ~~~

  

### 타입 캐스팅

- Kotlin에서는 더 명확하게 타입캐스팅 및 타입확인이 가능하다.

  ~~~kotlin
  fun printAgeIfPerson(obj: Any) {
      if (obj is Person) { // is = instanceof
          // val person = obj as Person // as = (Person)
        	// as 생략 가능
          println(person.age)
      }
  }
  ~~~

- 스마트 캐스트
  - if를 통해서 타입을 확인하면 코틀린이 영리하게 캐스팅을 해준다.



#### Any 타입

- Java의 Object 역할 (모든 객체의 상위 타입)
- 모든 Primitive Type의 최상위 타입도 Any이다.
- Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면, Any?로 표현
- Any에 equals / hashCode / toString 존재



### Unit 타입

- Unit은 Java의 void와 동일한 역할
  - Java에서는 리턴값이 없을 때 void를 쓰는데 코틀린에서는 비슷하게 사용하면 된다.
- void와는 다르게 Unit은 그자체로 타입 인자로 사용 가능하다.
- 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입 의미.
  - 즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현



#### 문자열 가공 및 인덱싱

- Java

  ~~~java
  String.format("name: %s, age :%d", person.getName(), person.getAge())
  ~~~

- kotlin

  ~~~kotlin
  val log: String = "이름: ${person.name}, 나이: ${person.age}"
  ~~~

- """

  - 해당 연산자를 사용하면 Java의 append대신에 편하게 사용할 수 있다.

  ~~~kotlin
  val log:String = """
  	ABC
  	DEF
  	${person.name}
  """.trimIndent()
  
  println(log)
  ~~~

  - trimIndent()는 각 라인의 들여쓰기 및 첫번째 줄과 마지막줄의 공백을 없애주는 함수이다.



## 04. 코틀린에서 연산자를 다루는 방법

### 비교연산자와 동등성, 동일성

#### 비교연산자

- kotlin은 Java와 달리 비교연산자를 호출하면 compraeTo를 호출해준다.

#### 

#### 동등성, 동일성

**Java**

- Java에서는 동일성에 ==를 사용, 동등성에 equals를 호출



**Kotlin**

- Kotlin에서는 동일성에 ===를 사용, 동등성에 ==를 사용하며, ==를 사용하면 간접적으로 equals를 호출해준다.



#### 연산자 오버로딩

- +연산을 plus() 메소드로 오버로딩 해서 직접 정의할 수 있다.
