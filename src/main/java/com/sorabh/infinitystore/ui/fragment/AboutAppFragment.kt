package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentAboutAppBinding


class AboutAppFragment : Fragment() {
    private lateinit var aboutAppBinding: FragmentAboutAppBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        aboutAppBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_about_app, container, false)

        return aboutAppBinding.root
    }

}