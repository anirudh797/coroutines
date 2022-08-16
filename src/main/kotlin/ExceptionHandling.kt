import kotlinx.coroutines.*

fun main(){
    runBlocking {
        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception Handled : ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job ")
            throw IndexOutOfBoundsException("exception")
        }
        job.join() //joining the job coroutine with current thread

        val deferred = GlobalScope.async{
            println("Throwing exception from async")
            throw ArithmeticException("exception from async")
        }
        try { //cant use handler with async
            deferred.await()
        }
        catch(ex : Exception){
            println(ex.toString())
        }
    }
}