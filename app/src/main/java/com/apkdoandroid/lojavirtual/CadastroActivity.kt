package com.apkdoandroid.lojavirtual

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        bt_cadastrar.setOnClickListener {
            cadastrarUsuario()
        }
    }

    private fun cadastrarUsuario() {
        val email = edit_email.text.toString()
        val senha = edit_senha.text.toString()
        if(email.isEmpty() || senha.isEmpty()){
//            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_SHORT).show()

            var snackbar  = Snackbar.make(layout_cadastro,"Preencha todos os campos",Snackbar.LENGTH_INDEFINITE)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.BLACK)
                .setAction("OK",{

                })
            snackbar.show()

        }else{
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
                if(it.isSuccessful){
              //      Toast.makeText(this,"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show()
                    var snackbar  = Snackbar.make(layout_cadastro,"Cadastro realizado com sucesso!",Snackbar.LENGTH_INDEFINITE)
                        .setBackgroundTint(Color.WHITE)
                        .setTextColor(Color.BLACK)
                        .setAction("OK",{

                    voltarLogin()
                        })
                    snackbar.show()

                }
            }.addOnFailureListener {
               // Toast.makeText(this,"Erro ao Cadastrar Usuário",Toast.LENGTH_SHORT).show()
                var snackbar  = Snackbar.make(layout_cadastro,"Erro ao Cadastrar Usuário",Snackbar.LENGTH_INDEFINITE)
                    .setBackgroundTint(Color.WHITE)
                    .setTextColor(Color.BLACK)
                    .setAction("OK",{

                    })
                snackbar.show()

            }
        }
    }
    private fun voltarLogin(){
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}