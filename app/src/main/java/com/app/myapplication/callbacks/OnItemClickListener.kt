package com.app.myapplication.callbacks

interface OnItemClickListener<Data> {
    fun onItemClick(position: Int, data: Data? = null)
}