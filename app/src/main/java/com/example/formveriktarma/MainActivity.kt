package com.example.formveriktarma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formveriktarma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun gonder(view: View)
    {
        val adSoyad = binding.txtAdSoyad.text.toString()
        val ogrNo   = binding.txtOgrNo.text.toString().toInt()
        val cinsiyet= if (binding.radioCinsErkek.isChecked)  "Erkek" else "Kadın"
        val sinif9  = binding.radioSinif9.isChecked
        val sinif10 = binding.radioSinif10.isChecked
        val sinif11 = binding.radioSinif11.isChecked
        val sinif12 = binding.radioSinif12.isChecked
        val katilim:Boolean = binding.katilmakIstiyorum.isChecked
        var sinif :String = "12"

        if(sinif9) sinif = "9"
        else if(sinif10) sinif = "10"
        else if(sinif11) sinif = "11"
        else sinif = "12"


        val IkinciEkraniAc = Intent(this,IkinciEkran::class.java)

        IkinciEkraniAc.putExtra("adSoyad",adSoyad)
        IkinciEkraniAc.putExtra("ogrNo",ogrNo)
        IkinciEkraniAc.putExtra("sinif",sinif)
        IkinciEkraniAc.putExtra("cinsiyet",cinsiyet)
        IkinciEkraniAc.putExtra("katilim",katilim)

        startActivity(IkinciEkraniAc)
    }
}