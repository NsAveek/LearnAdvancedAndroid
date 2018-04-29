package aveek.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import aveek.com.myapplication.Application.CoreApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,CoreApp.getRealm(),Toast.LENGTH_LONG).show()
    }

}
