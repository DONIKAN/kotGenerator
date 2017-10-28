package example.agnamc.pojogenerator.models

data class Request(
		val headerData: List<HeaderData?>? = null,
		val url: String? = null,
		val name: String? = null,
		val folder: String? = null,
		val description: String? = null
)
