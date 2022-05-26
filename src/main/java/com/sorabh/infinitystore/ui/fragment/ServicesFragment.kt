package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {
private lateinit var servicesBinding: FragmentServicesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        servicesBinding =DataBindingUtil.inflate(inflater,R.layout.fragment_services_, container, false)

        return servicesBinding.root
    }

}