import junit.framework.TestCase
import org.junit.Test
import java.io.File

class PackrleTest : TestCase() {

    fun testEncode() {
        assertEquals("4A4BE3q2Á2æ",Packrle().encode("AAAABBBBEqqq1122"))
        assertEquals("1a1h1s1d1h1a1s1h1d1a1h1s1d1h1a1s1h1dh",Packrle().encode("ahsdhashdahsdhashdh"))
        assertEquals("27â1w18â",Packrle().encode("222222222222222222222222222w222222222222222222"))
    }

    fun testDecode() {
        assertEquals("AAAABBBBEqqq1122",Packrle().decode("4A4BE3q2Á2æ"))
        assertEquals("ahsdhashdahsdhashdh",Packrle().decode("1a1h1s1d1h1a1s1h1d1a1h1s1d1h1a1s1h1dh"))
        assertEquals("222222222222222222222222222w222222222222222222",Packrle().decode("27æ1w18æ"))

    }

    fun testPackRLE() {
        val testPackRLEinput = File("src/test/resources/TestEncode1.txt").readLines().joinToString("")
        val testPackRLEcontrol = File("src/test/resources/TestEncode2.txt")
        val testPackRLEoutput = Packrle().packRLE(true,"src/test/resources/TestEncode1.txt","src/test/resources/TestEncode3.txt")
        assertEquals(File("src/test/resources/TestEncode2.txt").readLines().joinToString(""),File("src/test/resources/TestEncode3.txt").readLines().joinToString(""))

    }
}