package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentBottomSheeetBinding


class BottomSheetFragment : BottomSheetDialogFragment() {
    lateinit var bottomSheetBinding: FragmentBottomSheeetBinding
    private val args: BottomSheetFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bottomSheetBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheeet, container, false)
        val money = args.money
        val user = args.userName
        val heading = "are you want send Rs.$money to $user ?"
        bottomSheetBinding.txtMessage.text = heading
        bottomSheetBinding.btnCancel.setOnClickListener {
            dismiss()
        }
        bottomSheetBinding.btnOk.setOnClickListener {
            Toast.makeText(activity, "Rs.$money sent to $user", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return bottomSheetBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        bottomSheetBinding.unbind()
    }

}