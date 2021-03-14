package com.apkdoandroid.lojavirtual

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        VerificarUsuarioLogado()

        supportActionBar!!.hide()

        text_tela_cadastro.setOnClickListener {
            var intent = Intent(this,CadastroActivity::class.java)
            startActivity(intent)
        }

        bt_entrar.setOnClickListener {
            AutenticarUsuario()
        }
    }

    private fun AutenticarUsuario(){

        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()

        if (email.isEmpty() || senha.isEmpty()){
            var snackbar = Snackbar.make(layout_login,"Coloque um e-mail e uma senha!",Snackbar.LENGTH_INDEFINITE).setBackgroundTint(
                Color.WHITE).setTextColor(Color.BLACK)
                .setAction("OK", View.OnClickListener {

                })
            snackbar.show()
        }else{

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {

                if (it.isSuccessful){
                    frameL.visibility = View.VISIBLE
                    Handler().postDelayed({AbrirTelaPrincipal()},3000)

                }


            }.addOnFailureListener {

                var snackbar = Snackbar.make(layout_login,"Erro ao logar usuário!",Snackbar.LENGTH_INDEFINITE).setBackgroundTint(
                    Color.WHITE).setTextColor(Color.BLACK)
                    .setAction("OK", View.OnClickListener {

                    })
                snackbar.show()
            }
        }
    }

    private fun VerificarUsuarioLogado(){

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null){
            AbrirTelaPrincipal()
        }
    }

    private fun AbrirTelaPrincipal(){

        var intent = Intent(this,TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }
}
