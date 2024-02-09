package com.example.gamerater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gamerater.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* binding.terminos.setOnClickListener {
            if (binding.terminos.isActivated) {
                Toast.makeText(this, "has aceptado los terminos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Debes de aceptar los terminos", Toast.LENGTH_SHORT).show()

            }*/
            binding.next.setOnClickListener {
                if (binding.email.text.isEmpty()) {
                    Toast.makeText(this, "Debe de introducir un email", Toast.LENGTH_SHORT).show()
                } else {
                    if (binding.password.text.isEmpty()) {
                        Toast.makeText(this, "Debe de introducir la contraseña", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        val intent = Intent(
                            this,
                            CreateGameActivity::class.java
                        )


                        startActivity(intent)
                    }
                }
            }
        }
    }
