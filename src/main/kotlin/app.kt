import com.google.gson.Gson
import example.agnamc.pojogenerator.models.Postman
import java.io.File

fun main(args: Array<String>) {

    val DIRECTORY = "./src/main/kotlin/requests/"

    val directories = HashMap<String, String>()
    directories.put(keys.REQUESTS, "./src/main/kotlin/requests/")
    directories.put(keys.MODELS, "./src/main/kotlin/models/")

    // Set file content into string variable
    if (args.size == 0) return;

    val file = File(args[0])
    val inputStream = file.inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }

    // Deserialize object
    val gson = Gson()
    val postman = gson.fromJson<Postman>(inputString, Postman::class.java)

    // Create directories
    for ((key, value) in directories) {

        var directory = File("$value")
        if (!directory.mkdir()) {
            print("error creating directory")
            return
        }

        when (key) {

            keys.REQUESTS -> {

                // Create request files
                for (folder in postman.folders!!) {

                    val className = "${folder!!.name!!.toSnakeCase().replace(" ", "")}Request"

                    // Create file
                    val reqFile = File("$DIRECTORY/${className}.kt")
                    if (!reqFile.createNewFile()) {
                        print("error creating file")
                    }

                    val requests = postman.requests!!.filter { it!!.folder == folder.id }
                    var text = "public class $className(){\n\n\n\n"
                    for (request in requests) {
                        text += "\tfun ${request!!.name}(){\n\n\t}\n\n\n"
                    }
                    text += "}"
                    reqFile.writeText(text)

                }

            }

            keys.MODELS -> {

            }

        }

    }

}

fun String.toSnakeCase(): String {
    var text: String = ""

    val words = this.split(" ")

    if (words.isEmpty()) return this.capitalize()

    for (word in words) text += word.capitalize()
    return text
}

object keys {
    val MODELS = "models"
    val REQUESTS = "requests"
}