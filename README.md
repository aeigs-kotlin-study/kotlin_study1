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



#### 동등성, 동일성

**Java**

- Java에서는 동일성에 ==를 사용, 동등성에 equals를 호출



**Kotlin**

- Kotlin에서는 동일성에 ===를 사용, 동등성에 ==를 사용하며, ==를 사용하면 간접적으로 equals를 호출해준다.



#### 연산자 오버로딩

- +연산을 plus() 메소드로 오버로딩 해서 직접 정의할 수 있다.



## 05. 코틀린에서 조건문을 다루는 방법

### if문

- Java

  - Java에서는 if-else는 Statement이다.

- Kotlin

  - Kotlin에서는 Expression이다.

  - Kotlin에서는 If문이 값 하나를 의미한다.

    

### When 문

Kotlin은 Java의 switch 문을 when을 이용하여 표현할 수 있다.

- When문도 Expression이다.

  ~~~kotlin
  fun getGradeWithSwitch(score: Int): String {
      return when (score / 10) {
          in 90..99 -> "A"
          in 80 .. 89 -> "B"
          in 70..79 -> "C"
          else -> "D"
      }
  }
  ~~~

  

- if문과 동일하게 조건에서 타입을 확인하면 스마팅 캐스팅을 진행하여 준다.

  ~~~kotlin
  fun startsWithA(obj: Any): Boolean {
      return when (obj) {
          is String -> obj.startsWith("A")
          else -> false
      }
  }
  ~~~

  

- 조건문에 여러개의 조건을 넣을 수 있다.

  ~~~kotlin
  fun judgeNumber(number: Int) {
      when (number) {
          1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
          else -> println("1, 0, -1이 아닙니다.")
      }
  }
  ~~~

  

- when에 값을 넣지 않아도 가능하다.

  ~~~kotlin
  fun judgeNumber2(number: Int) {
      when {
          number == 0 -> println("주어진 수는 0입니다.")
          number % 2 == 0 -> println("주어진 수는 짝수입니다.")
          else -> println("주어진 수는 홀수입니다.")
      }
  }
  ~~~

  

## 06. 코를린에서 반복문을 다루는 방법

### for each문

- kotlin의 for each문은 :대신 In을 사용한다.

  ```kotlin
  val numbers = listOf(1, 2, 3)
  for (number in numbers) {
      println(number)
  }
  ```

- 범위를 ..를 이용하여 지정할 수 있다.

  ~~~kotlin
  for (i in 1..3) {
          println(i)
  }
  ~~~

- 내려가는 경우에는 downTo를 사용한다.

  ~~~kotlin
  for (i in 3 downTo 1) {
          println(i)
  }
  ~~~

- 값의 증감범위는 step을 이용하여 설정한다.

  ~~~kotlin
  for (i in 1..5 step 2) {
          println(i)
  }
  ~~~

#### Progression과 Range

- Progression
  - 등차수열을 의미
- Range
  - Progression을 상속받는다.
  - for(i in 1..3) 에서 1..3 부분의 타입은 Range이다.

- downTo와 step 둘다 함수이다.
  - 중위함수이다.



## 07. 코틀린에서 예외를 다루는 법

#### Try catch finally

- Try-catch문도 Expression이기에 바로 return이 가능하다.

  ~~~kotlin
  fun parseIntOrThrow2(str: String): Int? {
      return try {
          str.toInt()
      } catch (e: NumberFormatException) {
          null
      }
  }
  ~~~



#### Checked Exception과 Unchecked Exception

- Java와 달리 Checked Exception에 대해 throw를 하지 않아도 오류가 발생하지 않는다.

- Kotlin에서는 Checked Exception과 Unchecked Exception을 **구분하지 않는다.**

  ~~~kotlin
  fun readFile() {
          val currentFile = File("./taewoo")
          val file = File(currentFile.absolutePath + "/a.txt")
          val reader = BufferedReader(FileReader(file))
          println(reader.readLine())
          reader.close()
      }
  ~~~



#### Try with resources

- 코틀린에서는 try with resources 구문이 없다.

  - Java에서의 try with resources 구문

    ~~~java
    try(BufferedReader reader = new BufferedReader(new FileReader(path))){
    //...
    }
    ~~~

  - Kotlin에서는 use를 이용하여 처리한다.

    ~~~kotlin
    BufferedReader(FileReader(path)).use { reader ->
                println(reader.readLine())
    }
    ~~~



## 08. 코틀린에서 함수를 다루는 법

#### 함수선언 문법

- 아래와 같이 if문을 바로 return 가능

  ~~~kotlin
  fun max(a: Int, b: Int): Int {
      return if (a > b) {
          a
      } else {
          b
      }
  }
  ~~~

- if문은 expression이기에 블럭 자체를 = 로 변경 가능

  ~~~kotlin
  fun max(a: Int, b: Int): Int =
      if (a > b) {
          a
      } else {
          b
      }
  ~~~

- return 타입을 추론이 가능한 경우에는 생략이 가능하다.

  - 함수를 쓸 때 줄괄호 대신 "="을 사용했기에 생략이 가능하다.

  ~~~kotlin
  fun max(a: Int, b: Int) = if (a > b) {
      a
  } else {
      b
  }
  ~~~

- 중괄호도 생략이 가능하다.

  ~~~kotlin
  fun max(a: Int, b: Int) = if (a > b) a else b
  ~~~

  

#### default parameter

- kotlin은 Java와는 달리 default paramter를 사용할 수 있다.

  ~~~kotlin
  fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
      for (i in 1..num) {
          if (useNewLine) {
              println(str)
          } else {
              print(str)
          }
      }
  }
  ~~~



#### named arugment 

- 함수를 호출할 때 파라미터중에 내가 설정하고 싶은 파라미터만 설정이 가능하다.

  ~~~kotlin
  repeat("Hello World", useNewLine = false)
  ~~~

  - **허나 Java 함수를 쓸 때는 named arugment를 사용할 수 없다.**



#### 같은 타입의 여러 파라미터 받기(가변인자)

- Kotlind에서도 가변인자가 가능하다.

  - Java의 String... 역할을 한다.
  - kotlin에서는 vararg을 붙여줘야 한다.

  ~~~kotlin
  fun printAll(vararg strings: String) {
      for (str in strings) {
          println(str)
      }
  }
  
  //호출부
  printAll("A", "B", "C")
  val array = arrayOf("A", "B", "C")
  printAll(*array)
  ~~~

  - 호출 시에 array를 넘길 때는 인자 앞에 *를 붙여줘야 한다.
    - 왜냐하면 *(spread 연산자)이 배열안의 원소들을 ,로 붙여서 넘겨주는 역할을 하기 때문이다.



## 09. 코틀린에서 클래스를 다루는 방법

### 생성자

#### 주생성자

```kotlin
class Person(
    val name: String = "홍길동",
    var age: Int = 3
) {
  init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }

        println("기본생성자")
    }
}
```

- 주생성자는 필수이다.
- 멤버변수와 생성자를 Class의 Body에 넣는 것이 아니라 위와같이 간단하게 정의할 수 있다.
- **init**키워드를 이용하여 기본생성자에 Body를 정의할 수 있다.

#### 부생성자

~~~kotlin
constructor(name: String) : this(name, 1)

constructor(): this("김태우")
~~~

- Body 안에 주생성자가 아닌 새로이 정의한 생성자를 부생성자라한다.

- 부생성자는 결국엔 기본생성자를 호출해야 한다.

- 생성자가 호출되는 순서는 역으로 호출된다

  ~~~kotlin
  init {
    if (age <= 0) {
        throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
    }
    println("기본생성자")
  }
  
  constructor(name: String) : this(name, 1){
      println("첫번째 생성자")
  }
  
  constructor(): this("김태우"){
      println("두번째 생성자")
  }
  
  fun main() {
      val p = Person() // <- 두번째 생성자를 호출했지만, 막상 출력을 보면 기본생성자부터 호출이된다.
  }
  
  기본생성자
  첫번째 생성자
  두번째 생성자
  ~~~



#### 주의 사항

- 부생성자를 사용하기보다는 default parameter를 활용할 것
  - **객체를 받아야하는 경우에도 부생성자를 사용하기 보단, 정적 Factory Method를 사용하는 것을 추천**



### 프로퍼티

- 코틀린에서는 맴버 변수를 만들면 property를 만들지 않아도 자동으로 생성해준다.

  ~~~kotlin
  class Person(
      val name: String = "홍길동",
      var age: Int = 3
  ) 
  
  fun main() {
  	val p = Pesron();
  	println(p.name);
  	println(p.age);
  }
  ~~~

  - main 함수를 보면 멤버변수에 직접 접근한 것 처럼 보이지만, 동작할 때는 getter를 호출해준다.

- 실무에서는 거의 대부분은 Setter를 막아둔다. 그래서 해당방법에 대해서 찾아봤다.

  ~~~kotlin
  class Person(
      val name: String = "홍길동",
      age: Int = 3
  ) {
      var age = age
          private set
  	//...
    
    	fun updateAge(age: Int) {
          this.age = age
      }
  }
  ~~~

  - 생성자에서는 변수를 선언하지 않고 Body에서 변수를 선언해준다.
  - set에 대해서만은 private으로 막아둔다.
    - set을 막는 이유는 무분별한 값의 변경을 막기 위해서다, set을 남용하게되면 값의 변화를 추적하기 매우 어렵기 때문이다.
    - updateAge등을 통해 직관적인 이름을 통해 메소드를 만든다.



## 10. 코틀린에서 상속을 다루는 방법

### 상속

#### 구조

<img src="/Users/xodn/Downloads/IMG_0A3D12853509-1.jpeg" alt="IMG_0A3D12853509-1" style="zoom:30%;" />

#### 추상클래스

~~~kotlin
abstract class Animal(
    protected val species: String,
    protected open val legCount: Int
) {
    abstract fun move();
}
~~~

- legCounter의 getter를 오버라이딩 하기 위해서는 추상프로퍼티가 아니라면  open해두어야 한다.

#### 구현클래스

- 클래스 상속 시 extends가 아닌 : 를 이용하여 상속한다.
- 상속 시 무조건 부모클래스의 생성자를 호출해준다.
- 자바에서는 @Override 어노테이션을 사용한 것과 달리 kotlin에서는 override 키워드를 사용하면 된다.

**Cat**

~~~kotlin
class Cat(species: String)
    : Animal(species, 4) {
    override fun move() {
        println("고양이가 사뿐사뿐 걸어갑니다.")
    }
}
~~~

**Penguin** 

~~~kotlin
class Penguin(spices: String)
    : Animal(spices, 2) {

    private val wingCount = 2;

    override fun move() {
        println("펭귄은 뒤뚱뒤뚱 걸어갑니다.")
    }

    override val legCount:Int
        get() = super.legCount + wingCount

}
~~~



#### 인터페이스

<img src="/Users/xodn/Downloads/IMG_C63E5D5F5C94-1.jpeg" alt="IMG_C63E5D5F5C94-1" style="zoom:33%;" />

~~~kotlin
// Flyable.kt
interface Flyable {

    fun act(){
        println("파닥 파닥")
    }
  
  	fun fly()
}

// Swimable.kt
interface Swimable {
    fun act(){
        println("어푸 어푸")
    }
  
}
~~~

- kotlin에서는 default 키워드를 사용하지 않아도 default 메소드를 사용할 수 있다.

- 추상메소드를 사용할 거면 그냥 선언하면 된다.

  

#### 구현 클래스

~~~kotlin
class Penguin(spices: String) : Animal(spices, 2), Flyable, Swimable {
 		//...
  
 		override fun act() {
        super<Flyable>.act()
        super<Swimable>.act()
    }
  
  	override fun fly() {
        println("하늘을 날아요")
    }
}
~~~

- 중복되는 인터페이스를 특정할 때는 super<타입>.메소드()를 이용한다.





### 주의 사항

- **상위 클래스를 설계할 때는 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 한다.**

  ~~~kotlin
  open class Base(
      open val number: Int = 100
  ){
      init {
          println("Base Class")
          println(number)
      }
  }
  
  class Derived(
      override val number: Int
  ) : Base(number) {
      init {
          println("Derived class")
          println(number)
      }
  }
  ~~~

  - 자식 객체가 생성 될 때, 부모클래스의 생성자가 먼저 호출하게된다. 
  - 부모 클래스에서 멤버를 참조할 때, 자식 클래스의 멤버를 가져온다
    - 허나 아직 자식 클래스의 맴버가 초기화가 되지 않았기에 0이 출력된다.

- **추상 멤버가 아니라면 기본적으로 오버라이드가 불가능하다.**

  - open을 사용해줘야 한다.
  - 허나 Java에서는 그냥 Override해줘도 된다.



## 11. 접근제어를 다루는 법

<img src="/Users/xodn/Library/Application Support/typora-user-images/image-20240501152430111.png" alt="image-20240501152430111" style="zoom:40%;" />



### Top-level method

- class가 아닌 파일 최상단에 메소드를 정의할 수 있다.
- 이렇게하면 Java에서의 static Method와 동일한 역할을 한다.

**StringUtils.kt**

~~~kotlin
fun isDirectoryPath(path: String): Boolean = path.endsWith("/")

fun isLowerCase(c: Char?): Boolean? = c?.isLowerCase()
~~~



**main.kt**

~~~kotlin
fun main(){
    isDirectoryPath("dfdf")
    isLowerCase('a')
}
~~~



