import io.appium.java_client.android.Activity
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


@DisplayName("홈화면 테스트")
@AndroidTest
class BasicInteractionTest {

    private val driver: AndroidDriver<WebElement> = AndroidDriverManager.getAndroidDriver()

    @BeforeEach
    fun beforeEach() {

    }

    @AfterEach
    fun afterEach() {
        driver.navigate().back()
    }

    @Test
    @DisplayName("alert dialog 테스트")
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

    @Test
    @DisplayName("search 테스트")
    fun test() {
        val searchKeyword = "Hello world!"
        Tester.given("open search activity") {
            driver.startActivity(Activity(AndroidConstants.PACKAGE, AndroidConstants.SEARCH_ACTIVITY))
        }
        Tester.given("fill searchBox") {
            val searchBox = driver.findElementById("txt_query_prefill") as AndroidElement
            searchBox.sendKeys(searchKeyword)
        }
        Tester.`when`("click search button") {
            val searchButton = driver.findElementById("btn_start_search")
            searchButton.click()
        }
        Tester.then("resulting message should appear within 300ms") {
            val searchText = WebDriverWait(
                driver,
                300
            ).until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/search_src_text")))
            Assertions.assertEquals(searchKeyword, searchText.text)
        }
    }
}
