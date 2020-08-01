package com.csuryadharma.my.id.jualanbpropolis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_edit_text.*

private const val TITLE = "param1"
private const val TEXT_TO_EDIT = "param2"

class EditTextFragment : AppCompatDialogFragment() {
    private var onEditText: (String) -> Unit = {}
    private var mTitle: String? = null
    private var mTextToEdit: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, 0)
        arguments?.let {
            mTitle = it.getString(TITLE)
            mTextToEdit = it.getString(TEXT_TO_EDIT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_text, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle.text = mTitle
        etTextToEdit.setText(mTextToEdit)

        btnEdit.setOnClickListener { saveNewText() }
    }

    private fun saveNewText() {
        val newText = etTextToEdit.text.toString()
        onEditText(newText)
        dismiss()
    }

    fun setOnEditText(onEditText: (String) -> Unit) {
        this.onEditText = onEditText

    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, textToEdit: String) =
            EditTextFragment().apply {
                arguments = Bundle().apply {
                    putString(TITLE, title)
                    putString(TEXT_TO_EDIT, textToEdit)
                }
            }
    }
}