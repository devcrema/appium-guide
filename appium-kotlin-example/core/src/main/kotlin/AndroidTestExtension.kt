import org.junit.jupiter.api.extension.*

class AndroidTestExtension: BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

    override fun beforeAll(context: ExtensionContext) {
        AppiumDriverManager.getAppiumService()
    }

    override fun afterAll(context: ExtensionContext) {
        AppiumDriverManager.getAppiumService().stop()
    }

    override fun beforeTestExecution(context: ExtensionContext?) {
        context?.testClass?.ifPresent { testClass ->
            context.testMethod?.ifPresent { method ->
                ScreenshotManager.androidScreenshot("${testClass.simpleName}_${method.name}_1")
            }
        }
    }

    override fun afterTestExecution(context: ExtensionContext?) {
        context?.testClass?.ifPresent { testClass ->
            context.testMethod?.ifPresent { method ->
                ScreenshotManager.androidScreenshot("${testClass.simpleName}_${method.name}_2")
            }
        }
    }
}