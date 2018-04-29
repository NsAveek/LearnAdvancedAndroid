package aveek.com.myapplication.Application

import android.app.Application

object CoreApp : Application(){

    fun getRealm() : String{
        return "Test"
    }
}