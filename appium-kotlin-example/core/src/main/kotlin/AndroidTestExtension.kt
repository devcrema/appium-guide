import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class AndroidTestExtension: BeforeAllCallback, AfterAllCallback{

    override fun beforeAll(context: ExtensionContext) {
        AndroidDriverManager.getAppiumService()
    }

    override fun afterAll(context: ExtensionContext) {
        AndroidDriverManager.getAppiumService().stop()
    }
}