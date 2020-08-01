package com.csuryadharma.my.id.jualanbpropolis

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.esafirm.imagepicker.features.ImagePicker
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvFullname.setOnClickListener{ editText("Rubah Nama Lengkap",tvFullname)}
        tvEmail.setOnClickListener{ editText("Rubah Email",tvEmail)}
        ivAvatar.setOnClickListener{openImagePicker()}
        btnLogout.setOnClickListener { Logout() }
    }

    private fun editText(title: String, textView: TextView) {
        val textToEdit = textView.text.toString()
        val editTextFragment = EditTextFragment.newInstance(title, textToEdit)
        editTextFragment.setOnEditText { newText : String -> textView.text = newText}
        editTextFragment.show(supportFragmentManager, "editTextFragment")
    }

    private fun openImagePicker() {
        ImagePicker.create(this).start();
    }

    private fun Logout() {
        gotoLoginActivity()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            val image = ImagePicker.getFirstImageOrNull(data)
            Glide.with(this).
                load(image.path).
                transform(CircleCrop()).
                into(ivAvatar)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}