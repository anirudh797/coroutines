import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
GlobalScope.launch {
    delay(2000)
    println("World !")
}
    print("Hello ")
    Thread.sleep(3000)
}