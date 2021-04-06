import io.appium.java_client.ios.IOSDriver
import org.junit.jupiter.api.DisplayName
import org.openqa.selenium.WebElement
import io.appium.java_client.MobileBy

import org.openqa.selenium.support.ui.ExpectedConditions

import org.openqa.selenium.support.ui.WebDriverWait

import io.appium.java_client.ios.IOSElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@DisplayName("홈화면 테스트")
@MobileTest
class BasicInteractionTest {
    private val driver: IOSDriver<WebElement> = AppiumDriverManager.getIosDriver()


    @Test
    @DisplayName("alert 다이얼로그 테스트")
    fun testOpenAlert() {
        // given Find Button element
        val buttonElementId = "show alert"
        val buttonElement = WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(buttonElementId))) as IOSElement

        // when click on it and Wait for the alert to show up
        buttonElement.click()
        val alertTitleId = "Cool title"
        val alertTitleElement = WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(alertTitleId))) as IOSElement

        // then Check the text and Dismiss the alert
        val alertTitle = alertTitleElement.text
        Assertions.assertEquals(alertTitle, "Cool title")
        val okButtonElement = WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("OK"))) as IOSElement
        okButtonElement.click()
    }
}