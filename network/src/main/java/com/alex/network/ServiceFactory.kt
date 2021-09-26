package com.alex.network

interface ServiceFactory {

    fun <T> create(service: Class<T>): T
}
