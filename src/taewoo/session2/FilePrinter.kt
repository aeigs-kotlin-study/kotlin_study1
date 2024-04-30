package taewoo.session2;

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

public class FilePrinter {
    fun readFile() {
        val currentFile = File("./src/taewoo")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }
}
