package com.example.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.superheroes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        /*
        setContentView(R.layout.activity_main)

        val stHero = findViewById<EditText>(R.id.etNameHero)
        val button = findViewById<Button>(R.id.btnSend)
        */

        val hero:String = viewBinding.etNameHero.toString()

        viewBinding.btnSend.setOnClickListener{
            /* Snack and Toast:
                * Snack: View level
                * Toast: Context level
            */
            // Snackbar.make(it, "You send $hero", Snackbar.LENGTH_LONG).show()
            Toast.makeText(this, "You send $hero", Toast.LENGTH_LONG).show()
        }
    }
}