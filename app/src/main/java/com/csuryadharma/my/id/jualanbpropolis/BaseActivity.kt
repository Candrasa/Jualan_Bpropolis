package com.csuryadharma.my.id.jualanbpropolis

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideToolbar()
        setWhiteStatusBar()
    }

    fun hideToolbar() {
        if (supportActionBar != null) supportActionBar?.hide()
    }

    fun setWhiteStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        }
    }

    fun gotoLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun gotoProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()

    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showAlert(title: String, message: String) {
        val alertDialog = AlertDialog.Builder(this)
            AlertDialog.Builder(this).apply {
                setCancelable(false)
                setTitle(title)
                setMessage(message)
                setPositiveButton("Ok") {  _, _ -> showToast("Ok")   }
                setNegativeButton("Batal") { _, _ -> showToast("Batal")  }
                show()
        }
    }


}