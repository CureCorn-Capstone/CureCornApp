package com.example.curecornapp.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.curecornapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btnRegis.setOnClickListener {
            val email = binding.edtEmailRegis.text.toString()
            val password = binding.edtPasswordRegis.text.toString()

            //Validasi Email
            if (email.isEmpty()) {
                binding.edtEmailRegis.error = "Please Fill Out"
                binding.edtEmailRegis.requestFocus()
                return@setOnClickListener
            }

            //Validasi invalid email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmailRegis.error = "Invalid Email"
                binding.edtEmailRegis.requestFocus()
                return@setOnClickListener
            }

            //Validasi Password
            if (password.isEmpty()) {
                binding.edtPasswordRegis.error = "Please Fill Out"
                binding.edtPasswordRegis.requestFocus()
                return@setOnClickListener
            }

            //Validasi length password
            if (password.length < 6) {
                binding.edtPasswordRegis.error = "Minimum 6 Character Password"
                binding.edtPasswordRegis.requestFocus()
                return@setOnClickListener
            }
            RegisterFirebase(email,password)
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Success Register", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}