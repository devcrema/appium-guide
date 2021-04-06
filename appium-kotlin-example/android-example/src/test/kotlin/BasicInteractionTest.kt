import io.appium.java_client.android.Activity
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import org.junit.jupiter.api.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


@DisplayName("홈화면 테스트")
@MobileTest
class BasicInteractionTest {

    private val driver: AndroidDriver<WebElement> = AppiumDriverManager.getAndroidDriver()

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
        // given Open the Alert Dialog activity of the android app
        driver.startActivity(Activity(AndroidConstants.PACKAGE, AndroidConstants.ALERT_DIALOG_ACTIVITY))

        // when Click button that opens a dialog
        driver.findElementById("io.appium.android.apis:id/two_buttons").click()

        // then Check that the dialog is there
        Assertions.assertEquals(
                "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.",
                driver.findElementById("android:id/alertTitle").text
        )
        Assertions.assertDoesNotThrow { driver.findElementById("android:id/button1").click() }
    }

    @Test
    @DisplayName("search 테스트")
    fun testSearchText() {
        // given open search activity and fill saerch box
        val searchKeyword = "Hello world!"
        driver.startActivity(Activity(AndroidConstants.PACKAGE, AndroidConstants.SEARCH_ACTIVITY))
        val searchBox = driver.findElementById("txt_query_prefill") as AndroidElement
        searchBox.sendKeys(searchKeyword)

        // when click search button
        driver.findElementById("btn_start_search").click()

        // then resulting message should appear within 300ms
        val searchText = WebDriverWait(
                driver,
                300
        ).until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/search_src_text")))
        Assertions.assertEquals(searchKeyword, searchText.text)
    }
}
