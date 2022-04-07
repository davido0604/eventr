package com.example.eventr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class LoginFragment : Fragment() {

    lateinit var loginButton: Button
    lateinit var username: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        loginButton = view.findViewById(R.id.loginbtn)
        username = view.findViewById(R.id.username)
        password = view.findViewById(R.id.password)

        loginButton.setOnClickListener {
            if (username.text.toString().length == 0) {
                Toast.makeText(activity, "vennligst skriv inn brukernavn", Toast.LENGTH_SHORT).show();
            } else if (password.text.toString().length == 0) {
                Toast.makeText(activity, "skriv inn passord", Toast.LENGTH_SHORT).show();
            } else if (password.text.toString().length < 8) {
                Toast.makeText(activity, "feil passord", Toast.LENGTH_SHORT).show();
            } else {
                activity?.supportFragmentManager?.commit {
                    setReorderingAllowed(true)
                    replace<SearchMainFragment>(R.id.fragmentContainerView)
                }
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }
}