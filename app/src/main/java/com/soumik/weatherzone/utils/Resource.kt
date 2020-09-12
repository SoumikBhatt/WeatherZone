package com.soumik.weatherzone.utils


/**
 * Created by Soumik Bhattacharjee on 9/13/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
data class Resource<T> (val status: Status,val data:T?,val message:String?){
    companion object {
        fun <T> success(data:T?):Resource<T>{
            return Resource(Status.SUCCESS,data,null)
        }
        fun <T> error(data:T?,message: String?):Resource<T>{
            return Resource(Status.ERROR,data,message)
        }
        fun <T> loading(data:T?):Resource<T>{
            return Resource(Status.LOADING,data,null)
        }
    }
}
