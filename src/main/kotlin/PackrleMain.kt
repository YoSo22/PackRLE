
import java.lang.StringBuilder
import java.io.File

class Packrle() {

    private val symbols = mutableListOf('À', 'Á', 'æ', 'Ã', 'Ã', 'Ã', 'Å', 'Æ', 'à','á')

    fun encode(text: String): String {
        if (text == "") return ""
        val result = StringBuilder()
        var count = 0
        var prev = text[0]
        for (char in text) {
            if (char != prev) {
                if (count > 1) result.append(count)
                if (prev.isDigit()) result.append(symbols.elementAt(prev - '0')) else result.append(prev)
                count = 0
                prev = char
            }
            count++
        }
        if (count > 1) result.append(count)
        if (prev.isDigit()) result.append(symbols.elementAt(prev - '0')) else result.append(prev)
        return result.toString()
    }

    fun decode(str: String): String {
        val result = StringBuilder()
        var i = 0
        while (i in str.indices) {
            val times = str.substring(i).takeWhile { it.isDigit() }
            val count = times.count()
            val index = symbols.indexOf(str[i + count])
            val char = if (index != -1) '0' + index else str[i + count]
            repeat(times.toIntOrNull() ?: 1) { result.append(char) }
            i += 1 + count
        }
        return result.toString()
    }

    fun packRLE(pack: Boolean, inputFile: String, outputFile: String?) {
        val inputLines = File(inputFile).readLines()
        var numberOflines = 0L
        for (i in inputLines) {
            numberOflines ++
        }
        var numberOflinesСount = 1L
        val outputStream = File(outputFile ?: inputFile).bufferedWriter()
        outputStream.use {
            for (string in inputLines) {
                val changedLine = if (pack) encode(string) else decode(string)
                it.write(changedLine)
                if(numberOflinesСount < numberOflines) {
                    it.newLine()
                }
                numberOflinesСount ++
            }

        }
        println("Pack-rle: " + if (pack) "pack" else {
            "unpack"
        } + " successful")
    }
}
fun main(args: Array<String>) {
    Parser.main(args)
}




