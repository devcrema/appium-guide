import io.appium.java_client.android.Activity
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.*
import org.openqa.selenium.WebElement


@DisplayName("홈화면 테스트")
@AndroidTest
class BasicInteractionTest {

    private val driver: AndroidDriver<WebElement> = AndroidDriverManager.getAndroidDriver()

    @BeforeEach
    fun beforeEach() {
        driver.startActivity(Activity(AndroidConstants.PACKAGE, AndroidConstants.ALERT_DIALOG_ACTIVITY))
    }

    @AfterEach
    fun afterEach() {
        driver.navigate().back()
    }

    @Test
    @DisplayName("given alert dialog activity를 열고 when 버튼을 클릭하면 then 항목들이 제대로 나와야한다.")
    fun testAlertDialog() {
        Tester.given("Open the Alert Dialog activity of the android app") {
            driver.startActivity(Activity(AndroidConstants.PACKAGE, AndroidConstants.ALERT_DIALOG_ACTIVITY))
        }
        Tester.`when`("Click button that opens a dialog") {
            driver.findElementById("io.appium.android.apis:id/two_buttons").click()
        }
        Tester.then("Check that the dialog is there") {
            Assertions.assertEquals(
                "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.",
                driver.findElementById("android:id/alertTitle").text
            )
            driver.findElementById("android:id/button1").click()
        }
    }
}
