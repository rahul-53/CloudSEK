package com.rahul.cloudsek.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rahul.cloudsek.R


class SplashScreenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler().postDelayed({
            if (gotoHome()){
                findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
            }else{
                findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
            }
        },3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    private fun gotoHome():Boolean{
        val sharedPreference = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPreference.getBoolean("finished",false)
    }

}