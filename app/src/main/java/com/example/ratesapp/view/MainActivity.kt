package com.example.ratesapp.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.*
import com.example.ratesapp.R
import com.example.ratesapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_conversao,
            R.id.nav_historico,
            R.id.nav_sair
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //escuta ação de click para logout
        navView.setNavigationItemSelectedListener {
            if(it.itemId == R.id.nav_sair){
                mainViewModel.logout()
            }else{
                NavigationUI.onNavDestinationSelected(it, navController);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            true
        }

        observer()
    }

    override fun onResume() {
        mainViewModel.loadUserName()
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun observer(){
        mainViewModel.logout.observe(this, Observer {
            if (it){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        })

        mainViewModel.userInfor.observe(this, Observer {
            val navView = findViewById<NavigationView>(R.id.nav_view)
            val header = navView.getHeaderView(0)

            header.findViewById<TextView>(R.id.textViewNome).text = "Seja bem vindo ${it.nome}"
            header.findViewById<TextView>(R.id.textViewEmail).text = it.email
        })
    }
}