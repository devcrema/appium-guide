import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File


object AndroidDriverManager {

    private var appiumService: AppiumDriverLocalService? = null

    fun getAppiumService(): AppiumDriverLocalService {
        if (appiumService == null) {
            // run local AppiumDriverLocalService.buildDefaultService()
            // bind remote
            appiumService = AppiumDriverLocalService.buildService(AppiumServiceBuilder().withIPAddress("127.0.0.1"))
        }
        if (!appiumService!!.isRunning) {
            appiumService!!.start()
        }
        return appiumService!!
    }

    fun getAndroidDriver(): AndroidDriver<WebElement> {
        val classpathRoot = File(System.getProperty("user.dir"))
        val appDir = File(classpathRoot, "../apps")
        val app = File(appDir.canonicalPath, "ApiDemos-debug.apk")
        val capabilities = getRealDeviceCapabilities(app.absolutePath)
        return AndroidDriver<WebElement>(getAppiumService().url, capabilities)
    }

    fun getCapabilities(absolutePath: String): DesiredCapabilities = DesiredCapabilities().apply {
        setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        setCapability(MobileCapabilityType.PLATFORM_VERSION, "8")
        setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator")
        setCapability("app", absolutePath)
    }

    fun getRealDeviceCapabilities(absolutePath: String): DesiredCapabilities = DesiredCapabilities().apply {
        setCapability(MobileCapabilityType.DEVICE_NAME, "Android")
        setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        setCapability("app", absolutePath)
    }
}