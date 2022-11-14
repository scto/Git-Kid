package com.redeyesncode.gitkid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.redeyesncode.gitkid.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySplashBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Starting the splash handler here :)

        var handler = Handler().postDelayed(Runnable {
                                                     var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()


        },5000)
    }
}