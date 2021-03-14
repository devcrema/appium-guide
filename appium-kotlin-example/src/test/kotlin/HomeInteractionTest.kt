import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@DisplayName("홈화면 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class HomeInteractionTest {

    @BeforeEach
    fun beforeEach(){
        println("before each")
    }

    @AfterEach
    fun afterEach(){
        println("after each")
    }

    @Test
    @Order(1)
    @DisplayName("given 로그인된 유저가 when 홈 화면 진입시에 then 항목들이 제대로 나와야한다.")
    fun testEnterHome(){

        // given

        // when

        // then

    }

    @Test
    @Order(2)
    @DisplayName("given 로그인 되지 않은 유저가 when 홈 화면 진입시에 then 로그인 팝업이 발생한다.")
    fun testEnterHomeWithOutLogin(){
        // given

        // when

        // then

    }

    companion object {
        @BeforeAll
        fun setUp(){
            println("setup")
        }

        @AfterAll
        fun tearDown(){
            println("teardown")
        }
    }
}
