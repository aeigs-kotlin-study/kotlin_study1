fun main() {
    //val = 변수
    var name1 = "variable Kotlin"
    println("Hello, " + name1 + "!")
    name1 = "change Kotlin"
    println("Hello, " + name1 + "!")


    //val = 상수
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
}