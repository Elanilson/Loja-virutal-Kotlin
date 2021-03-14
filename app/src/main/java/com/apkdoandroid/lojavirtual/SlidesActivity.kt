package com.apkdoandroid.lojavirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class SlidesActivity : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_slides)


        isButtonBackVisible = false
        isButtonNextVisible = false

        addSlide(

            SimpleSlide.Builder()
                .background(R.color.roxo)
                .image(R.drawable.drawer)
                .backgroundDark(R.color.white)
                .title("Loja Online de Calçados")
                .description("Entre e confira as promoções que preparamos para você!")
                .build()

        )

        addSlide(

            SimpleSlide.Builder()
                .background(R.color.verde)
                .title("Crie uma conta Grátis")
                .canGoBackward(false)
                .description("Cadastre-se agora mesmo! E venha conhecer os nossos produtos.")
                .build()
        )


    }

    override fun onDestroy() {
        super.onDestroy()

        var intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
