package com.catnip.cowboyshoot.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catnip.cowboyshoot.R
import com.catnip.cowboyshoot.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private val binding: ActivityMenuBinding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        getUserName()
    }

    private fun getUserName() {
        val username = intent.getStringExtra("username")
        binding.tvTitle.text =
            getString(R.string.text_hi) + username + getString(R.string.text_exclamation_mark)
    }
}