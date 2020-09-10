package com.soumik.weatherzone.utils


/**
 * Created by Soumik Bhattacharjee on 9/11/2020.
 * soumikcse07@gmail.com,http://soumikbhatt.github.io/
 */
interface RequestCompleteListener<T> {
    fun onRequestCompleted(data:T)
    fun onRequestFailed(errorMessage:String?)
}