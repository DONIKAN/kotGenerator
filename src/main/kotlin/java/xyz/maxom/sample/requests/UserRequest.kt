package xyz.maxom.sample.requests

import android.content.Context

import xyz.maxom.sample.R
import xyz.maxom.sample.constants.UrlConstants
import xyz.maxom.sample.interfaces.RequestCallback
import xyz.maxom.sample.entities.User
import xyz.maxom.sample.entities.requests.DataRequest
import xyz.maxom.sample.entities.requests.DataResponse

import com.orhanobut.logger.Logger

import com.android.volley.*
import com.android.volley.toolbox.JsonObjectRequest

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject
import java.lang.reflect.Type

class UserRequest(private val queue: RequestQueue, private val context: Context){
	private val gson: Gson
	private val collectionType: Type

	init {
		this.gson = Gson()
		this.collectionType = object : TypeToken<DataResponse<User>>() {}.type
	}

	fun update(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_UPDATE, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun resetPassword(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_RESETPASSWORD, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun getByCriteria(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_GETBYCRITERIA, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun delete(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_DELETE, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun forgotPasswordValidation(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_FORGOTPASSWORDVALIDATION, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun forgotPassword(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_FORGOTPASSWORD, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun getByCriteria copy(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_GETBYCRITERIA COPY, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


	fun create(data: DataRequest<User>, callback: RequestCallback<User>){
		try {
			val dataObject = JSONObject(gson.toJson(data))

			val request = object : JsonObjectRequest(Method.POST, UrlConstants.URL_USER_CREATE, dataObject, Response.Listener<JSONObject> { response ->
				Logger.d("REQUEST SUUCESS: ")
				Logger.json(dataObject)

				val responseRequest = gson.fromJson<DataResponse<User>(response.toString(), collectionType)

				when {
					responseRequest.hasError -> callback.onError(responseRequest.status!!.message!!)
					responseRequest.items != null -> callback.onSuccess(responseRequest.status!!.message!!, responseRequest.items!!)
					else -> callback.onError(context.resources.getString(R.string.request_none_user))
				}

				//Logger.d(responseRequest.status!!.message!!)
			}, Response.ErrorListener { error ->
				error.printStackTrace()
				Looger.d("REQUEST ERROR: ")
				Looger.json(dataObject)

				Looger.d("ERROR: " + error.localizedMessage)
				//Logger.d("ERROR CODE: " + error.networkResponse.statusCode)

				var error_msg = error.localizedMessage ?: ""

				if (error is NetworkError) {
					error_msg = context.resources.getString(R.string.volley_error__network)
				//} else if( error instanceof ClientError) {
				} else if (error is ServerError) {
					error_msg = context.resources.getString(R.string.volley_error__server)
				} else if (error is AuthFailureError) {
					error_msg = context.resources.getString(R.string.volley_error__auth_failure)
				} else if (error is ParseError) {
					error_msg = context.resources.getString(R.string.volley_error__parse)
				} else if (error is NoConnectionError) {
					error_msg = context.resources.getString(R.string.volley_error__no_connection)
				} else if (error is TimeoutError) {
					error_msg = context.resources.getString(R.string.volley_error_timeout)
				}

				Looger.e(error_msg)
				callback.onError(error_msg)
			}){
				@Throws(AuthFailureError::class)
				override fun getHeaders(): Map<String, String> {
					val headers = HashMap<String, String>()
					headers.put("Content-Type", "application/json; charset=utf-8")
					/*headers.put("lang", Util.language)*/
					return headers
				}
			}

			request.retryPolicy = DefaultRetryPolicy(
				AppConstants.REQUEST_TIMEOUT,
				DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
				DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

			queue.add(request)
		} catch (e: JSONException) {
			e.printStackTrace()
			Logger.e("JSON Error: " + e.localizedMessage)
		}
	}


}