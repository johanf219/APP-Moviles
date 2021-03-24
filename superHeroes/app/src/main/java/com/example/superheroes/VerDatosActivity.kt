package com.example.superheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroes.databinding.ActivityVerDatosBinding

class VerDatosActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityVerDatosBinding

    companion object{
        const val HERO_KEY = "hero_key"
        const val POWER_KEY = "power_key"
        const val IMAGE_KEY = "image_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityVerDatosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val intent : Bundle = intent.extras!!

        viewBinding.tvNameEnviado.text = intent.getString(HERO_KEY)
        viewBinding.ratingBar.rating = intent.getFloat(POWER_KEY)
        viewBinding.photoEnviada.setImageBitmap(intent.getParcelable<Bitmap>(IMAGE_KEY))
    }
}