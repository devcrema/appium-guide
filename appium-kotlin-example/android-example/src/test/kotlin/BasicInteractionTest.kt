import io.appium.java_client.android.Activity
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement


@DisplayName("홈화면 테스트")
@AndroidTest
class BasicInteractionTest {

    private val driver: AndroidDriver<WebElement> = AndroidDriverManager.getAndroidDriver()

    @BeforeEach
    fun beforeEach() {
        println("before each")
    }

    @AfterEach
    fun afterEach() {
        println("after each")
    }

    @Test
    @Order(1)
    @DisplayName("given alert dialog activity를 열고 when 버튼을 클릭하면 then 항목들이 제대로 나와야한다.")
    fun testAlertDialog() {
        // given Open the "Alert Dialog" activity of the android app
        driver.startActivity(Activity(AndroidConstants.PACKAGE, AndroidConstants.ALERT_DIALOG_ACTIVITY))
        // when Click button that opens a dialog
        driver.findElementById("io.appium.android.apis:id/two_buttons").click()
        // then Check that the dialog is there
        val alertText = driver.findElementById("android:id/alertTitle").text
        Assertions.assertEquals(
            "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.",
            alertText
        )
        driver.findElementById("android:id/button1").click()
    }

    companion object {
        @BeforeAll
        fun setUp() {
            println("setup")
        }

        @AfterAll
        fun tearDown() {
            println("teardown")
        }
    }
}
