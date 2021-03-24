package com.example.superheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import com.example.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.ivPhoto.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 200)
        }

        viewBinding.btnSend.setOnClickListener{
            val intent = Intent(this, VerDatosActivity::class.java)

            val hero : String = viewBinding.etHeroeName.text.toString()
            val power : Float = viewBinding.rbPower.rating
            val image : Bitmap = viewBinding.ivPhoto.drawable.toBitmap()

            intent.putExtra(VerDatosActivity.HERO_KEY, hero)
            intent.putExtra(VerDatosActivity.POWER_KEY, power)
            intent.putExtra(VerDatosActivity.IMAGE_KEY, image)

            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 200 && resultCode == Activity.RESULT_OK) {
            val image : Bundle? = data?.extras
            val heroImage : Bitmap? = image?.getParcelable<Bitmap>("data")

            viewBinding.ivPhoto.setImageBitmap(heroImage)
        }
    }
}