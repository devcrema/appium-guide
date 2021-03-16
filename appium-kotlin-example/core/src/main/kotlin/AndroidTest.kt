import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(value = [AndroidTestExtension::class])
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
annotation class AndroidTest
