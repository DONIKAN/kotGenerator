package xyz.maxom.sample.entities.requests

data class DataResponse<T>(
	var status: Status?,
	var hasError: Boolean = false,
	var item: T?,
	var items: MutableList<T>?)