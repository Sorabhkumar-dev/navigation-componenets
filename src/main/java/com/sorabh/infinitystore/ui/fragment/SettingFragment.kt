package com.sorabh.infinitystore.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {
    private lateinit var settingBinding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        settingBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_setting, container, false)

        return settingBinding.root
    }

}