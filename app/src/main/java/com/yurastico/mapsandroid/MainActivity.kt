package com.yurastico.mapsandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yurastico.mapsandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btIntentMap.setOnClickListener {
            val latitudeLongitude = "-23.5565804,-46.662113"

            val zoom = 15
            val geo = "geo:$latitudeLongitude?z=$zoom"

            val geoUri = Uri.parse( geo )
            val intent = Intent( Intent.ACTION_VIEW, geoUri )

            intent.setPackage( "com.google.android.apps.maps" )
            if( intent.resolveActivity( packageManager ) != null ) {
                startActivity( intent )
            } else{

                Toast.makeText(this, "Nenhum mapa instalado", Toast.LENGTH_LONG).show()
            }
        }
        binding.btInternMap.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }

}
