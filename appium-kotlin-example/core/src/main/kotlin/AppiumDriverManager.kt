import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File

import java.util.concurrent.TimeUnit


object AppiumDriverManager {

    private var appiumService: AppiumDriverLocalService? = null
    private var androidDriver: AndroidDriver<WebElement>? = null
    private var iosDriver: IOSDriver<WebElement>? = null

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
            val capabilities = getAndroidCapabilities(app.absolutePath)
            androidDriver = AndroidDriver<WebElement>(getAppiumService().url, capabilities)
                    .apply {
                        manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS)
                    }
        }
        return androidDriver!!
    }

    fun getIosDriver(): IOSDriver<WebElement> {
        if (iosDriver == null) {
            val classpathRoot = File(System.getProperty("user.dir"))
            val appDir = File(classpathRoot, "../apps")
            val app = File(appDir.canonicalPath, "TestApp.app.zip")
            val capabilities = getIosCapabilities(app.absolutePath)
            iosDriver = IOSDriver<WebElement>(getAppiumService().url, capabilities)
                .apply {
                    manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS)
                }
        }
        return iosDriver!!
    }

    fun isAndroidDriverExists() = this.androidDriver != null

    fun isIosDriverExists() = this.iosDriver != null

    private fun getAndroidCapabilities(absolutePath: String): DesiredCapabilities = DesiredCapabilities().apply {
        setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
        setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        setCapability("app", absolutePath)
    }

    private fun getIosCapabilities(absolutePath: String): DesiredCapabilities = DesiredCapabilities().apply {
        setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
        setCapability("automationName", "XCUITest")
        setCapability("deviceName", "iPhone 12 Pro Max")
        setCapability("app", absolutePath)
    }
}
