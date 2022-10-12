package com.catnip.cowboyshoot.ui.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.catnip.cowboyshoot.R
import com.catnip.cowboyshoot.databinding.ActivityMenuBinding
import com.catnip.cowboyshoot.ui.game.GameActivity

class MenuActivity : AppCompatActivity() {
    private val binding: ActivityMenuBinding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        getUserName()
        setOnClickListener()
    }

    private fun getUserName() {
        val username = intent.getStringExtra("username")
        binding.tvTitle.text =
            getString(R.string.text_hi) + username + getString(R.string.text_exclamation_mark)
    }

    private fun setOnClickListener() {
        binding.ivVersusComputer.setOnClickListener {
            playWithComputer()
        }
        binding.ivVersusPlayer.setOnClickListener {
            playWithAnotherPlayer()
        }
    }

    private fun playWithComputer() {
        val intent = Intent(this@MenuActivity, GameActivity::class.java)
        startActivity(intent)
    }

    private fun playWithAnotherPlayer() {
        Toast.makeText(applicationContext, getString(R.string.text_coming_soon), Toast.LENGTH_SHORT).show()
    }
}