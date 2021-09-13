import junit.framework.TestCase
import org.junit.Test
import java.io.File

class PackrleTest : TestCase() {

    fun testEncode() {
        assertEquals("4A4BE3q2Á2æ", Packrle().encode("AAAABBBBEqqq1122"))
        assertEquals("a2hsd2has2hda2hsd2has2hd2h", Packrle().encode("ahhsdhhashhdahhsdhhashhdhh"))
        assertEquals("27æw18æ", Packrle().encode("222222222222222222222222222w222222222222222222"))
    }

    fun testDecode() {
        assertEquals("AAAABBBBEqqq1122",Packrle().decode("4A4BE3q2Á2æ"))
        assertEquals("ahhsdhhashhdahhsdhhashhdhh",Packrle().decode("a2hsd2has2hda2hsd2has2hd2h"))
        assertEquals("222222222222222222222222222w222222222222222222",Packrle().decode("27æw18æ"))

    }

    fun testPackRLE() {
        val testPackRLEinput = File("src/test/resources/TestEncode1.txt").readLines().joinToString("")
        val testPackRLEcontrol = File("src/test/resources/TestEncode2.txt")
        val testPackRLEoutput = Packrle().packRLE(true,"src/test/resources/TestEncode1.txt","src/test/resources/TestEncode3.txt")
        assertEquals(File("src/test/resources/TestEncode2.txt").readLines().joinToString(""),File("src/test/resources/TestEncode3.txt").readLines().joinToString(""))

    }
}
