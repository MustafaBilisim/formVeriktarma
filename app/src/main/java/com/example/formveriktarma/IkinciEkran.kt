package com.example.formveriktarma

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.formveriktarma.databinding.ActivityIkinciEkranBinding

class IkinciEkran : AppCompatActivity() {
    private lateinit var binding: ActivityIkinciEkranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIkinciEkranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ad = intent.getStringExtra("adSoyad")
        val ogrNo = intent.getIntExtra("ogrNo",9)   // getInt komutu için varsayılan değer 9. Sınıf
        val sinif = intent.getStringExtra("sinif")
        val cinsiyet = intent.getStringExtra("cinsiyet")
        val katilim = intent.getBooleanExtra("katilim",true)   // Cinsiyet için varsayılan değer erkek

        binding.txt2AdSoyad.setText(ad)
        binding.txt2OgrenciNo.setText(ogrNo.toString())
        binding.txtCinsiyet.setText(cinsiyet)
        binding.txtSinif.setText(sinif)
        if(katilim) {
            binding.txtDurum.setText("KATILIYOR")
            binding.txtDurum.setTextColor(Color.GREEN)
        }
        else {
            binding.txtDurum.setText("== KATILMIYOR == ")
            binding.txtDurum.setTextColor(Color.RED)
        }

    }

}