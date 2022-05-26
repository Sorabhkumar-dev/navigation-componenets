package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {
    private lateinit var fragmentPaymentBinding: FragmentPaymentBinding
    private val args: PaymentFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentPaymentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_payment, container, false)
        val navController = findNavController()
        val value = "Rs. ${args.tranctionValue}"
        val user = args.userName
        val headline = "Send Money to $user"
        fragmentPaymentBinding.userName.text = headline
        fragmentPaymentBinding.tranctionValue.setText(value)

        fragmentPaymentBinding.btnSendMoney.setOnClickListener {
            val action = PaymentFragmentDirections.actionPaymentFragmentToBottomSheetFragment(
                args.tranctionValue.toString().toLong(), user
            )
            navController.navigate(action)

        }
        fragmentPaymentBinding.btnCancel.setOnClickListener {
            val action = PaymentFragmentDirections.actionPaymentFragmentToHomeFragment()
            navController.navigate(action)

            //to stope navigation cycle
//            navController.popBackStack(R.id.homeFragment,true)

        }
        return fragmentPaymentBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentPaymentBinding.unbind()
    }
}