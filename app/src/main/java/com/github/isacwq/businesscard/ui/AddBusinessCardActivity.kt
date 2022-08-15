package com.github.isacwq.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.github.isacwq.businesscard.App
import com.github.isacwq.businesscard.R
import com.github.isacwq.businesscard.data.BusinessCard
import com.github.isacwq.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBusinessCardBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)

        setupListeners()
    }

    private fun setupListeners() {
        binding.bConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString(),
                color = "#${Integer.toHexString(binding.cpvColor.color)}",
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.add_card_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}