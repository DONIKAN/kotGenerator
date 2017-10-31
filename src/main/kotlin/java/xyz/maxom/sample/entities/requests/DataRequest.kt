package xyz.maxom.sample.entities.requests

data class DataRequest<T>(
	var index: Int?,
	var size: Int?,
	var topSize: Int?,
	var data: T?,
	var datas: MutableList<T>?)