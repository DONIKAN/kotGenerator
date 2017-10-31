package xyz.maxom.sample.constants

object UrlConstants {

		val URL_ROOT = "http://localhost:8080/api/"


		// ApprovisionnementRequest Urls
		val URL_APPROVISIONNEMENT_GETBYCRITERIA = URL_ROOT + "approvisionnement/getByCriteria"
		val URL_APPROVISIONNEMENT_SCUM = URL_ROOT + "approvisionnement/scum"
		val URL_APPROVISIONNEMENT_UPDATE = URL_ROOT + "approvisionnement/update"
		val URL_APPROVISIONNEMENT_DELETE = URL_ROOT + "approvisionnement/delete"
		val URL_APPROVISIONNEMENT_CREATE = URL_ROOT + "approvisionnement/create"


		// BillsMakerCopyRequest Urls
		val URL_BILLSMAKERCOPY_EDITBILLS = URL_ROOT + "billsmakercopy/editBills"


		// ConditioningRequest Urls
		val URL_CONDITIONING_GETBYCRITERIA = URL_ROOT + "conditioning/getByCriteria"
		val URL_CONDITIONING_UPDATE = URL_ROOT + "conditioning/update"
		val URL_CONDITIONING_CREATE = URL_ROOT + "conditioning/create"
		val URL_CONDITIONING_DELETE = URL_ROOT + "conditioning/delete"


		// CountryRequest Urls
		val URL_COUNTRY_GETBYCRITERIA = URL_ROOT + "country/getByCriteria"
		val URL_COUNTRY_ACTIVATE = URL_ROOT + "country/activate"


		// CurrencyRequest Urls
		val URL_CURRENCY_ACTIVATE = URL_ROOT + "currency/activate"
		val URL_CURRENCY_GETBYCRITERIA = URL_ROOT + "currency/getByCriteria"


		// FunctionalityRequest Urls
		val URL_FUNCTIONALITY_GETBYCRITERIA = URL_ROOT + "functionality/getByCriteria"


		// IndentRequest Urls
		val URL_INDENT_UPDATE = URL_ROOT + "indent/update"
		val URL_INDENT_VALIDATE = URL_ROOT + "indent/validate"
		val URL_INDENT_CREATE = URL_ROOT + "indent/create"
		val URL_INDENT_GETINDENTSSTATS COPY = URL_ROOT + "indent/getIndentsStats copy"
		val URL_INDENT_GETBYCRITERIA = URL_ROOT + "indent/getByCriteria"
		val URL_INDENT_CANCELED = URL_ROOT + "indent/canceled"
		val URL_INDENT_GETINDENTSSTATS = URL_ROOT + "indent/getIndentsStats"


		// PlaceRequest Urls
		val URL_PLACE_DELETE = URL_ROOT + "place/delete"
		val URL_PLACE_GETBYCRITERIA = URL_ROOT + "place/getByCriteria"
		val URL_PLACE_CREATE = URL_ROOT + "place/create"
		val URL_PLACE_UPDATE = URL_ROOT + "place/update"


		// ProductRequest Urls
		val URL_PRODUCT_ORDERED = URL_ROOT + "product/ordered"
		val URL_PRODUCT_UPDATE = URL_ROOT + "product/update"
		val URL_PRODUCT_CREATE = URL_ROOT + "product/create"
		val URL_PRODUCT_IMPORT = URL_ROOT + "product/import"
		val URL_PRODUCT_GETBYCRITERIA = URL_ROOT + "product/getByCriteria"
		val URL_PRODUCT_DELETE = URL_ROOT + "product/delete"


		// ProductCondiitioningRequest Urls
		val URL_PRODUCTCONDIITIONING_UPDATE = URL_ROOT + "productcondiitioning/update"
		val URL_PRODUCTCONDIITIONING_DELETE = URL_ROOT + "productcondiitioning/delete"
		val URL_PRODUCTCONDIITIONING_GENERATECODE = URL_ROOT + "productcondiitioning/generateCode"


		// RestaurantRequest Urls
		val URL_RESTAURANT_CREATE = URL_ROOT + "restaurant/create"
		val URL_RESTAURANT_DELETE = URL_ROOT + "restaurant/delete"
		val URL_RESTAURANT_UPDATE = URL_ROOT + "restaurant/update"
		val URL_RESTAURANT_CREATE COPY = URL_ROOT + "restaurant/create copy"
		val URL_RESTAURANT_GETBYCRITERIA = URL_ROOT + "restaurant/getByCriteria"


		// RoleRequest Urls
		val URL_ROLE_GETBYCRITERIA = URL_ROOT + "role/getByCriteria"
		val URL_ROLE_UPDATE = URL_ROOT + "role/update"
		val URL_ROLE_CREATE = URL_ROOT + "role/create"
		val URL_ROLE_DELETE = URL_ROOT + "role/delete"
		val URL_ROLE_GETBYCRITERIA COPY = URL_ROOT + "role/getByCriteria copy"


		// ScumRequest Urls
		val URL_SCUM_GETBYCRITERIA = URL_ROOT + "scum/getByCriteria"
		val URL_SCUM_DELETE = URL_ROOT + "scum/delete"
		val URL_SCUM_UPDATE = URL_ROOT + "scum/update"
		val URL_SCUM_CREATE = URL_ROOT + "scum/create"


		// StatusRequest Urls
		val URL_STATUS_GETBYCRITERIA = URL_ROOT + "status/getByCriteria"


		// StockRequest Urls
		val URL_STOCK_GETBYPRODUCTTYPE = URL_ROOT + "stock/getByProductType"
		val URL_STOCK_GETBYCRITERIA = URL_ROOT + "stock/getByCriteria"
		val URL_STOCK_GETALL = URL_ROOT + "stock/getAll"
		val URL_STOCK_GETPRODUCTINFOS = URL_ROOT + "stock/getProductInfos"


		// TokenRequest Urls
		val URL_TOKEN_CONNEXION = URL_ROOT + "token/connexion"


		// TypeDeProductRequest Urls
		val URL_TYPEDEPRODUCT_UPDATE = URL_ROOT + "typedeproduct/update"
		val URL_TYPEDEPRODUCT_GETBYCRITERIA = URL_ROOT + "typedeproduct/getByCriteria"
		val URL_TYPEDEPRODUCT_GETALL = URL_ROOT + "typedeproduct/getAll"
		val URL_TYPEDEPRODUCT_CREATE = URL_ROOT + "typedeproduct/create"
		val URL_TYPEDEPRODUCT_DELETE = URL_ROOT + "typedeproduct/delete"


		// UserRequest Urls
		val URL_USER_UPDATE = URL_ROOT + "user/update"
		val URL_USER_RESETPASSWORD = URL_ROOT + "user/resetPassword"
		val URL_USER_GETBYCRITERIA = URL_ROOT + "user/getByCriteria"
		val URL_USER_DELETE = URL_ROOT + "user/delete"
		val URL_USER_FORGOTPASSWORDVALIDATION = URL_ROOT + "user/forgotPasswordValidation"
		val URL_USER_FORGOTPASSWORD = URL_ROOT + "user/forgotPassword"
		val URL_USER_GETBYCRITERIA COPY = URL_ROOT + "user/getByCriteria copy"
		val URL_USER_CREATE = URL_ROOT + "user/create"


		// VenteRequest Urls
		val URL_VENTE_GETBYCRITERIA = URL_ROOT + "vente/getByCriteria"
		val URL_VENTE_CREATE = URL_ROOT + "vente/create"
		val URL_VENTE_DELETE = URL_ROOT + "vente/delete"
		val URL_VENTE_UPDATE = URL_ROOT + "vente/update"

}