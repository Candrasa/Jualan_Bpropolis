package com.csuryadharma.my.id.jualanbpropolis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener { ValidateCredential() }
    }

    private fun ValidateCredential() {
        val username = etnamaAnda.text.toString()
        val password = etSandi.text.toString()

        when {
            username.isEmpty() -> showAlert("Isian Nama Kosong","Anda belum memasukkan nama")
            username != "tina" -> showAlert("Mohon Maaf", "nama anda tidak terdaftar")
            password.isEmpty() -> showAlert("Isian Sandi Kosong","Anda belum memasukkan Sandi")
            password != "Propolis_HuHa!!" -> showAlert("Mohon Maaf","Sandi Anda Salah")
            else -> gotoProfileActivity()
        }
    }


}