package com.maytemur.kullaniciadisaklama

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    //var sharedPreferences : SharedPreferences?= null böylede kullanılabilir
    lateinit var sharedPreferences: SharedPreferences //init : initiliaze
                                                    // late : sonra tanımlayacağım hata verme
    var alinanKullaniciAdi : String ? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences - bin tane bilgi için uygun değil
        //sadece bir kaç tane bilgi için uygun

        sharedPreferences = this.getSharedPreferences("com.maytemur.kullaniciadisaklama",
            MODE_PRIVATE)
        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
        if (alinanKullaniciAdi != null){
            textView.text = "Kaydedilen kullanici Adı : ${alinanKullaniciAdi}"
        }
    }

    fun kaydet (view: View){
        var kullaniciAdi = editText.text.toString()
        if(kullaniciAdi==""){
            Toast.makeText(this,"Lütfen bir Deger Giriniz",Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString("kullanici",kullaniciAdi).apply()
            textView.text = "Kaydedilen Kullanıcı adı : ${kullaniciAdi}"
        }

    }
    fun sil(view: View){
        alinanKullaniciAdi = sharedPreferences.getString("kullanici","")
        if(alinanKullaniciAdi != null){
            textView.text = "Kaydedilen Kullanıcı Adı :"
            sharedPreferences.edit().remove("kullanici").apply()
        }

    }
}