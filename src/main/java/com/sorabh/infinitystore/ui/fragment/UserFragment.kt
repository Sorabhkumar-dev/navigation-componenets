package com.sorabh.infinitystore.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentUserBinding


class UserFragment : Fragment() {
    private lateinit var fragmentUserBinding: FragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentUserBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        val navController = findNavController()
        fragmentUserBinding.makePayment.setOnClickListener {
            val user = fragmentUserBinding.userName.editText?.text
            val value = fragmentUserBinding.tranctionValue.editText?.text
            if (!user.isNullOrEmpty() && !value.isNullOrEmpty()) {
                val action = UserFragmentDirections.actionUserFragmentToPaymentFragment(
                    user.toString(),
                    value.toString().toLong()
                )
                navController.navigate(action)
            } else {
                Toast.makeText(
                    activity as Context,
                    "Please fill all the fields",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        fragmentUserBinding.cancelPayment.setOnClickListener {
            navController.popBackStack()
        }

        return fragmentUserBinding.root
    }

}