import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

object AndroidCapabilities {
    // TODO add driver setting
    fun getCapabilities(): DesiredCapabilities = DesiredCapabilities().apply {
        setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        setCapability(MobileCapabilityType.PLATFORM_VERSION, "8")
        setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator")
    }
}