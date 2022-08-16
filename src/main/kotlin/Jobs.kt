 import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val job1 = launch {
            delay(2000)
            println("Job1 launched")
            val job2 = launch {
                println("Job2 launched")
                delay(400)
                println("Job2 is finishing")
            }
            job2.invokeOnCompletion { //will be called even if job was cancelled
                println("Job2 is completed")
            }


        }

        delay(2500)
        println("Cancelling job")
        job1.cancel()

        job1.invokeOnCompletion {
            println("Job1 completed")
        }

    }
}
