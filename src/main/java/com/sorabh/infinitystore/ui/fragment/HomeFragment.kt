package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var fragmentHomeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val navController = findNavController()

        fragmentHomeBinding.cart.setOnClickListener {
            /** navigating by destination id*/
            // navController.navigate(R.id.cartFragment)

            /** navigating through destination action id */
            //navController.navigate(R.id.action_homeFragment_to_cartFragment)

            val action = HomeFragmentDirections.actionHomeFragmentToCartFragment()
            navController.navigate(action)

        }
        fragmentHomeBinding.product.setOnClickListener {
            /** navigating by destination id*/
            // navController.navigate(R.id.productFragment)

            /** navigating through destination action id*/
            //navController.navigate(R.id.action_homeFragment_to_productFragment)

            val action = HomeFragmentDirections.actionHomeFragmentToProductFragment("","")
            navController.navigate(action)
        }
        fragmentHomeBinding.user.setOnClickListener {
            /** navigating by destination id*/
            // navController.navigate(R.id.userFragment)

            /** navigating through destination action id*/
            // navController.navigate(R.id.action_homeFragment_to_userFragment)

            val action = HomeFragmentDirections.actionHomeFragmentToUserFragment()
            navController.navigate(action)
        }

        return fragmentHomeBinding.root
    }

}