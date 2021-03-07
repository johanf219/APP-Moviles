package com.example.superheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener{
            val intent = Intent(this, VerDatosActivity::class.java)

            val hero : String = viewBinding.etHeroeName.text.toString()
            val power : Float = viewBinding.rbPower.rating

            intent.putExtra(VerDatosActivity.HERO_KEY, hero)
            intent.putExtra(VerDatosActivity.POWER_KEY, power)

            startActivity(intent)
        }
    }
}