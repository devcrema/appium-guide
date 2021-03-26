import java.lang.Thread.sleep

object Tester {

    private val defaultWaitMillis = System.getProperty("CONF_WAIT", "200").toLong()
    private val printOption = System.getProperty("CONT_ENABLE_PRINT_BDD", "true").toBoolean()

    fun given(description: String = "", waitMillis: Long = defaultWaitMillis, block: () -> Unit) {
        if(printOption) println("given $description")
        try {
            sleep(waitMillis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        block.invoke()
    }

    fun `when`(description: String = "", waitMillis: Long = defaultWaitMillis, block: () -> Unit) {
        if(printOption) println("when $description")
        try {
            sleep(waitMillis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        block.invoke()
    }

    fun then(description: String = "", waitMillis: Long = defaultWaitMillis, block: () -> Unit) {
        if(printOption) println("then $description")
        try {
            sleep(waitMillis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        block.invoke()
    }
}