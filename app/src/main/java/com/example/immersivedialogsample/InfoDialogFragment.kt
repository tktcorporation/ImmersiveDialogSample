package com.example.immersivedialogsample

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.immersivedialogsample.databinding.DialogInfoBinding

class InfoDialogFragment : DialogFragment() {
    lateinit var binding: DialogInfoBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        // ダイアログの背景を透過にする
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)

        binding = DialogInfoBinding.inflate(requireActivity().layoutInflater)

        binding.closeButton.setOnClickListener {
            dismiss()
        }

        dialog.setContentView(binding.root)

        return dialog
    }
}