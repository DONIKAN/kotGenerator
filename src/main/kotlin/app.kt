import com.google.gson.Gson
import example.agnamc.pojogenerator.models.Postman
import java.io.File

fun main(args: Array<String>) {
    // Set file content into string variable
    if (args.isEmpty() or (args.size < 2)) return

    val package_name = args[0]
    val package_name_path = package_name.replace('.', '/')

    val file = File(args[1])
    val inputStream = file.inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }

    val url_root = args[2]

    var realmObject = false

    try {
        realmObject = args[3].toBoolean()
    } catch(e: Exception) {
    }

    val layout_root_path = "./src/main/kotlin/res/layout"
    val kotlin_root_path = "./src/main/kotlin/java/$package_name_path"

    val directories = HashMap<String, String>()
    directories.put(keys.CONSTANTS, "$kotlin_root_path/constants/")
    directories.put(keys.ENTITIES, "$kotlin_root_path/entities/")
    directories.put(keys.REQUESTS, "$kotlin_root_path/requests/")
    directories.put(keys.REQUESTS_ENTITIES, "$kotlin_root_path/entities/requests/")

    // Deserialize object
    val gson = Gson()
    val postman = gson.fromJson<Postman>(inputString, Postman::class.java)

    // Create layout directory
    val layout_directory = File(layout_root_path)
    if (!layout_directory.mkdirs()) {
        print("error creating layout directory")
        return
    }

    // Create directories
    for ((key, value) in directories) {
        val directory = File(value)
        if (!directory.mkdirs()) {
            print("error creating directory")
            return
        }

        when (key) {
            keys.CONSTANTS -> {
                // Create UrlConstants file
                val reqUrlConstantsFile = File("$value/UrlConstants.kt")
                if (!reqUrlConstantsFile.createNewFile()) {
                    print("error creating UrlConstants file")
                }
                val constants = "package $package_name.${keys.CONSTANTS}\n\n" +
                        "object UrlConstants {\n\n" +
                        "\t\tval URL_ROOT = \"$url_root\"\n"

                reqUrlConstantsFile.writeText(constants)
            }
            keys.ENTITIES -> {
                // Create request files
                for (folder in postman.folders!!) {
                    val className = folder!!.name!!.toSnakeCase()

                    // Create item layout
                    val itemXMLFile = File("$layout_root_path/item_${className.toLowerCase()}.xml")
                    if (!itemXMLFile.createNewFile()) {
                        print("error creating itemXMLFile")
                    }

                    val itemXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                            "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                            "\txmlns:tools=\"http://schemas.android.com/tools\"\n" +
                            "\tandroid:layout_width=\"match_parent\"\n" +
                            "\tandroid:layout_height=\"wrap_content\"\n" +
                            "\tandroid:layout_marginLeft=\"10dp\"\n" +
                            "\tandroid:layout_marginRight=\"10dp\"\n" +
                            "\tandroid:layout_marginTop=\"5dp\"\n" +
                            "\tandroid:layout_marginBottom=\"5dp\"\n" +
                            "\tandroid:background=\"@android:color/white\"\n" +
                            "\tandroid:padding=\"10dp\"\n" +
                            "\tandroid:orientation=\"vertical\">\n\n" +
                            "\t\t<TextView\n" +
                            "\t\t\tandroid:id=\"@+id/tvTest\"\n" +
                            "\t\t\tandroid:layout_width=\"match_parent\"\n" +
                            "\t\t\tandroid:layout_height=\"wrap_content\"\n" +
                            "\t\t\ttools:text=\"Test\"/>\n\n" +
                            "</LinearLayout>"

                    itemXMLFile.writeText(itemXML)

                    // Create fragment list
                    val listXMLFile = File("$layout_root_path/fragment_${className.toLowerCase()}.xml")
                    if (!listXMLFile.createNewFile()) {
                        print("error creating listXMLFile")
                    }

                    val listXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                            "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                            "\txmlns:tools=\"http://schemas.android.com/tools\"\n" +
                            "\tandroid:layout_width=\"match_parent\"\n" +
                            "\tandroid:layout_height=\"match_parent\"\n" +
                            "\tandroid:layout_marginLeft=\"10dp\"\n" +
                            "\tandroid:layout_marginRight=\"10dp\"\n" +
                            "\tandroid:layout_marginTop=\"5dp\"\n" +
                            "\tandroid:layout_marginBottom=\"5dp\"\n" +
                            "\tandroid:background=\"@android:color/white\"\n" +
                            "\tandroid:padding=\"10dp\"\n" +
                            "\tandroid:orientation=\"vertical\">\n\n" +
                            "\t\t<android.support.v7.widget.RecyclerView\n" +
                            "\t\t\tandroid:id=\"@+id/rvList\"\n" +
                            "\t\t\tandroid:layout_width=\"match_parent\"\n" +
                            "\t\t\tandroid:layout_height=\"wrap_content\" />\n\n" +
                            "</LinearLayout>"

                    listXMLFile.writeText(listXML)

                    // Create fragment edit
                    val editXMLFile = File("$layout_root_path/fragment_edit_${className.toLowerCase()}.xml")
                    if (!editXMLFile.createNewFile()) {
                        print("error creating editXMLFile")
                    }

                    val editXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                            "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                            "\txmlns:tools=\"http://schemas.android.com/tools\"\n" +
                            "\tandroid:layout_width=\"match_parent\"\n" +
                            "\tandroid:layout_height=\"wrap_content\"\n" +
                            "\tandroid:layout_marginLeft=\"10dp\"\n" +
                            "\tandroid:layout_marginRight=\"10dp\"\n" +
                            "\tandroid:layout_marginTop=\"5dp\"\n" +
                            "\tandroid:layout_marginBottom=\"5dp\"\n" +
                            "\tandroid:background=\"@android:color/white\"\n" +
                            "\tandroid:padding=\"10dp\"\n" +
                            "\tandroid:orientation=\"vertical\">\n\n" +
                            "\t\t<TextView\n" +
                            "\t\t\tandroid:id=\"@+id/tvTest\"\n" +
                            "\t\t\tandroid:layout_width=\"match_parent\"\n" +
                            "\t\t\tandroid:layout_height=\"wrap_content\"\n" +
                            "\t\t\tandroid:layout_marginBottom=\"5dp\"\n" +
                            "\t\t\tandroid:text=\"Test\"/>\n\n" +
                            "\t\t<EditText\n" +
                            "\t\t\tandroid:id=\"@+id/etTest\"\n" +
                            "\t\t\tandroid:layout_width=\"match_parent\"\n" +
                            "\t\t\tandroid:layout_height=\"wrap_content\"\n" +
                            "\t\t\ttools:text=\"Test\"/>\n\n" +
                            "</LinearLayout>"

                    editXMLFile.writeText(editXML)


                    // Create file
                    val reqFile = File("$value/$className.kt")
                    if (!reqFile.createNewFile()) {
                        print("error creating file")
                    }

                    var text = "package $package_name.$key\n\n"

                    when (realmObject) {
                        true -> text += "import io.realm.RealmObject\n\nopen "
                        else -> text += "data "
                    }

                    text += "class $className(var test: String?)"

                    if (realmObject) text += " : RealmObject()"

                    reqFile.writeText(text)
                }
            }
            keys.REQUESTS -> {
                // Create request files
                for (folder in postman.folders!!) {
                    val className = folder!!.name!!.toSnakeCase()
                    val classNameFolder = "${className}Request"

                    // Create file
                    val reqFile = File("$value/$classNameFolder.kt")
                    if (!reqFile.createNewFile()) {
                        print("error creating file")
                    }

                    val requests = postman.requests!!.filter { it!!.folder == folder.id }
                    var text = "package $package_name.$key\n\n" +
                            "import android.content.Context\n\n" +
                            "import $package_name.R\n" +
                            "import $package_name.constants.UrlConstants\n" +
                            "import $package_name.interfaces.RequestCallback\n" +
                            "import $package_name.${keys.ENTITIES}.$className\n" +
                            "import $package_name.${keys.ENTITIES}.requests.DataRequest\n" +
                            "import $package_name.${keys.ENTITIES}.requests.DataResponse\n\n" +
                            "import com.orhanobut.logger.Logger\n\n" +
                            "import com.android.volley.*\n" +
                            "import com.android.volley.toolbox.JsonObjectRequest\n\n" +
                            "import com.google.gson.Gson\n" +
                            "import com.google.gson.reflect.TypeToken\n" +
                            "import org.json.JSONException\n" +
                            "import org.json.JSONObject\n" +
                            "import java.lang.reflect.Type\n\n" +
                            "class $classNameFolder(private val queue: RequestQueue, private val context: Context){\n" +
                            "\tprivate val gson: Gson\n" +
                            "\tprivate val collectionType: Type\n\n" +
                            "\tinit {\n" +
                            "\t\tthis.gson = Gson()\n" +
                            "\t\tthis.collectionType = object : TypeToken<DataResponse<$className>>() {}.type\n" +
                            "\t}\n\n"
                    var constants = "\n\n\t\t// $classNameFolder Urls\n"
                    for (request in requests) {
                        constants += "\t\tval URL_${className.toUpperCase()}_${request!!.name!!.toUpperCase()} = URL_ROOT + \"${className.toLowerCase()}/${request!!.name}\"\n"
                        text += "\tfun ${request!!.name}(data: DataRequest<$className>, callback: RequestCallback<$className>){\n" +
                                "\t\ttry {\n" +
                                "\t\t\tval dataObject = JSONObject(gson.toJson(data))\n\n" +
                                "\t\t\tval request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_${className.toUpperCase()}_${request!!.name!!.toUpperCase()}, dataObject, Response.Listener<JSONObject> { response ->\n" +
                                "\t\t\t\tLogger.d(\"REQUEST SUUCESS: \")\n" +
                                "\t\t\t\tLogger.json(dataObject)\n\n" +
                                "\t\t\t\tval responseRequest = gson.fromJson<DataResponse<$className>(response.toString(), collectionType)\n\n" +
                                "\t\t\t\twhen {\n" +
                                "\t\t\t\t\tresponseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)\n" +
                                "\t\t\t\t\tresponseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)\n" +
                                "\t\t\t\t\telse -> callback.onError(context.resources.getString(R.string.request_none_${className.toLowerCase()}))\n" +
                                "\t\t\t\t}\n\n" +
                                "\t\t\t\t//Logger.d(responseRequest.status!!.message!!)\n" +
                                "\t\t\t}, Response.ErrorListener { error ->\n" +
                                "\t\t\t\terror.printStackTrace()\n" +
                                "\t\t\t\tLooger.d(\"REQUEST ERROR: \")\n" +
                                "\t\t\t\tLooger.json(dataObject)\n\n" +
                                "\t\t\t\tLooger.d(\"ERROR: \" + error.localizedMessage)\n" +
                                "\t\t\t\t//Logger.d(\"ERROR CODE: \" + error.networkResponse.statusCode)\n\n" +
                                "\t\t\t\tvar error_msg = error.localizedMessage ?: \"\"\n\n" +
                                "\t\t\t\tif (error is NetworkError) {\n" +
                                "\t\t\t\t\terror_msg = context.resources.getString(R.string.volley_error__network)\n" +
                                "\t\t\t\t//} else if( error instanceof ClientError) {\n" +
                                "\t\t\t\t} else if (error is ServerError) {\n" +
                                "\t\t\t\t\terror_msg = context.resources.getString(R.string.volley_error__server)\n" +
                                "\t\t\t\t} else if (error is AuthFailureError) {\n" +
                                "\t\t\t\t\terror_msg = context.resources.getString(R.string.volley_error__auth_failure)\n" +
                                "\t\t\t\t} else if (error is ParseError) {\n" +
                                "\t\t\t\t\terror_msg = context.resources.getString(R.string.volley_error__parse)\n" +
                                "\t\t\t\t} else if (error is NoConnectionError) {\n" +
                                "\t\t\t\t\terror_msg = context.resources.getString(R.string.volley_error__no_connection)\n" +
                                "\t\t\t\t} else if (error is TimeoutError) {\n" +
                                "\t\t\t\t\terror_msg = context.resources.getString(R.string.volley_error_timeout)\n" +
                                "\t\t\t\t}\n\n" +
                                "\t\t\t\tLooger.e(error_msg)\n" +
                                "\t\t\t\tcallback.onError(error_msg)\n" +
                                "\t\t\t}){\n" +
                                "\t\t\t\t@Throws(AuthFailureError::class)\n" +
                                "\t\t\t\toverride fun getHeaders(): Map<String, String> {\n" +
                                "\t\t\t\t\tval headers = HashMap<String, String>()\n" +
                                "\t\t\t\t\theaders.put(\"Content-Type\", \"application/json; charset=utf-8\")\n" +
                                "\t\t\t\t\t/*headers.put(\"lang\", Util.language)*/\n" +
                                "\t\t\t\t\treturn headers\n" +
                                "\t\t\t\t}\n" +
                                "\t\t\t}\n\n" +
                                "\t\t\trequest.retryPolicy = DefaultRetryPolicy(\n" +
                                "\t\t\t\tAppConstants.REQUEST_TIMEOUT,\n" +
                                "\t\t\t\tDefaultRetryPolicy.DEFAULT_MAX_RETRIES,\n" +
                                "\t\t\t\tDefaultRetryPolicy.DEFAULT_BACKOFF_MULT)\n\n" +
                                "\t\t\tqueue.add(request)\n" +
                                "\t\t} catch (e: JSONException) {\n" +
                                "\t\t\te.printStackTrace()\n" +
                                "\t\t\tLogger.e(\"JSON Error: \" + e.localizedMessage)\n" +
                                "\t\t}\n" +
                                "\t}\n\n\n"
                    }
                    text += "}"
                    reqFile.writeText(text)
                    val reqUrlConstantsFile = File("$kotlin_root_path/constants/UrlConstants.kt")
                    reqUrlConstantsFile.appendText(constants)
                }

            }
            keys.REQUESTS_ENTITIES -> {
                // Create Status file
                val reqStatusFile = File("$value/Status.kt")
                if (!reqStatusFile.createNewFile()) {
                    print("error creating status file")
                }

                val status = "package $package_name.${keys.ENTITIES}.${keys.REQUESTS}\n\n" +
                        "data class Status(var message: String?, var code: Int)"

                reqStatusFile.writeText(status)

                // Create DataRequest file
                val reqDataRequestFile = File("$value/DataRequest.kt")
                if (!reqDataRequestFile.createNewFile()) {
                    print("error creating dataRequest file")
                }

                val dataRequest = "package $package_name.${keys.ENTITIES}.${keys.REQUESTS}\n\n" +
                        "data class DataRequest<T>(\n" +
                        "\tvar index: Int?,\n" +
                        "\tvar size: Int?,\n" +
                        "\tvar topSize: Int?,\n" +
                        "\tvar data: T?,\n" +
                        "\tvar datas: MutableList<T>?)"

                reqDataRequestFile.writeText(dataRequest)

                // Create DataResponse file
                val reqDataResponseFile = File("$value/DataResponse.kt")
                if (!reqDataResponseFile.createNewFile()) {
                    print("error creating dataResponse file")
                }

                val dataResponse = "package $package_name.${keys.ENTITIES}.${keys.REQUESTS}\n\n" +
                        "data class DataResponse<T>(\n" +
                        "\tvar status: Status?,\n" +
                        "\tvar hasError: Boolean = false,\n" +
                        "\tvar item: T?,\n" +
                        "\tvar items: MutableList<T>?)"

                reqDataResponseFile.writeText(dataResponse)
            }
        }

    }

    val reqUrlConstantsFile = File("$kotlin_root_path/constants/UrlConstants.kt")
    reqUrlConstantsFile.appendText("\n}")

}

fun String.toSnakeCase(): String {
    var text: String = ""

    val words = this.split(" ")

    if (words.isEmpty()) return this.capitalize()

    for (word in words) text += word.capitalize()
    return text.replace(" ", "")
}

object keys {
    val ENTITIES = "entities"
    val REQUESTS = "requests"
    val REQUESTS_ENTITIES = "entities_requests"
    val CONSTANTS = "constants"
}

object requests {
    val GET_BY_CRITERIAS = "getByCriteria"
    val UPDATE = "update"
    val CREATE = "create"
    val DELETE = "delete"
}