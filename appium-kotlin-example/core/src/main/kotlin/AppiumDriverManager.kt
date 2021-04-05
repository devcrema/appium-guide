import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import java.util.UUID
import java.util.concurrent.TimeUnit


object AppiumDriverManager {

    private var appiumService: AppiumDriverLocalService? = null
    private var androidDriver: AndroidDriver<WebElement>? = null

    fun getAppiumService(): AppiumDriverLocalService {
        if (appiumService == null) {
            // bind remote or create local server
            appiumService = AppiumDriverLocalService.buildService(AppiumServiceBuilder().withIPAddress("127.0.0.1"))
        }
        if (!appiumService!!.isRunning) {
            appiumService!!.start()
        }
        return appiumService!!
    }

    fun getAndroidDriver(): AndroidDriver<WebElement> {
        if (androidDriver == null) {
            val classpathRoot = File(System.getProperty("user.dir"))
            val appDir = File(classpathRoot, "../apps")
            val app = File(appDir.canonicalPath, "ApiDemos-debug.apk")
            val capabilities = getCapabilities(app.absolutePath)
            androidDriver = AndroidDriver<WebElement>(getAppiumService().url, capabilities)
                    .apply {
                        manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS)
                    }
        }
        return androidDriver!!
    }

    fun isAndroidDriverExists() = this.androidDriver != null

    private fun getCapabilities(absolutePath: String): DesiredCapabilities = DesiredCapabilities().apply {
        setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
        setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        setCapability("app", absolutePath)
    }
}
