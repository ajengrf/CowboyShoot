package com.catnip.cowboyshoot.ui.onboarding.inputname

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.catnip.cowboyshoot.databinding.FragmentInputNameBinding
import com.catnip.cowboyshoot.ui.menu.MenuActivity
import com.catnip.cowboyshoot.ui.onboarding.OnFinishNavigateListener

class InputNameFragment : Fragment(), OnFinishNavigateListener {
    private lateinit var binding: FragmentInputNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onFinishNavigateListener() {
        val name = binding.etInputName.text.toString().trim()
        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Please input your name", Toast.LENGTH_SHORT).show()
        } else {
            navigateToMenu(name)
        }
    }

    private fun navigateToMenu(name: String) {
//        Toast.makeText(requireContext(), "Name $name", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@InputNameFragment.requireContext(), MenuActivity::class.java)
        intent.putExtra("username", name)
        startActivity(intent)
    }
}

