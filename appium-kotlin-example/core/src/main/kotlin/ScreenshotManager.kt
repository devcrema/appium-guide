import org.openqa.selenium.OutputType
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object ScreenshotManager {
    private val screenshotPath: String =
            System.getProperty("user.dir", "") +
                    File.separator +
                    "screenshots" +
                    File.separator +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) +
                    File.separator

    fun androidScreenshot(filename: String = UUID.randomUUID().toString()) {
        if (AppiumDriverManager.isAndroidDriverExists()) {
            AppiumDriverManager.getAndroidDriver()
                    .getScreenshotAs(OutputType.FILE)
                    .copyTo(target = File(screenshotPath, "$filename.jpg"))
        }
    }

    fun iosScreenshot(filename: String = UUID.randomUUID().toString()) {
        if (AppiumDriverManager.isIosDriverExists()) {
            AppiumDriverManager.getIosDriver()
                .getScreenshotAs(OutputType.FILE)
                .copyTo(target = File(screenshotPath, "$filename.jpg"))
        }
    }
}