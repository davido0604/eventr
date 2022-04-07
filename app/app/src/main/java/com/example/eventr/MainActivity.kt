package com.example.eventr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    // slett hvis det trengs
    lateinit var listView: ListView
    var name: ArrayList<String> = ArrayList()
    var arrayAdapter: ArrayAdapter<String>? = null
    lateinit var etSearch: EditText
    // til her
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // også her
        title = "Eventr"
        listView = findViewById(R.id.listView)
        etSearch = findViewById(R.id.etSearch)
        name.add("Sasha")
        name.add("David")
        name.add("Miriam")
        name.add("Dimi")
        name.add("Øivind")
        name.add("Malin")
        name.add("Fabian")
        name.add("Samakab")
        name.add("Sander")
        name.add("Andreas")
        name.add("Thomas")
        name.add("Random")

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, name)
        listView.adapter = arrayAdapter

      etSearch.addTextChangedListener(object : TextWatcher {
          override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int){}
          override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
              arrayAdapter!!.filter.filter(s)
          }
          override fun afterTextChanged(s: Editable) {}
      })
        // til her

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<LoginFragment>(R.id.fragmentContainerView)
        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.searchMainFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.hide()

        bottomNavigationView.setupWithNavController(navController)



    }
}