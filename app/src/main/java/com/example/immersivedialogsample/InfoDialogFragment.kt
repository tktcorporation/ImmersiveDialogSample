package com.example.immersivedialogsample

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.immersivedialogsample.databinding.DialogInfoBinding

class InfoDialogFragment : DialogFragment() {
    private lateinit var binding: DialogInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogInfoBinding.inflate(inflater)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setCancelable(true)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        dialog?.window?.setFlags(
            WindowManager.LayoutParams.FLAG_DIM_BEHIND,
            WindowManager.LayoutParams.FLAG_DIM_BEHIND
        )
        dialog?.window?.setDimAmount(0.7f)

        dialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        dialog?. window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        fullScreenImmersive(dialog?.window?.decorView!!)

        binding.closeButton.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?. window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
    }

    private fun fullScreenImmersive(view: View) {
        var uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
        view.systemUiVisibility = uiOptions
        view.setOnSystemUiVisibilityChangeListener {
            uiOptions = uiOptions or 0x00001000
            view.systemUiVisibility = uiOptions
        }
    }
}