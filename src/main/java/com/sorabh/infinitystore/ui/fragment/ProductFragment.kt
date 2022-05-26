package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentProductBinding


class ProductFragment : Fragment() {
    private val args: ProductFragmentArgs by navArgs()
private lateinit var productBinding: FragmentProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        productBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_product, container, false)
        productBinding.productName.text = args.product
        productBinding.productQuantity.text = args.item

        return productBinding.root
    }

}