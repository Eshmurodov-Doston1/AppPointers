package com.example.apppointers

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.apppointers.databinding.ActivityMainBinding
import com.infideap.drawerbehavior.AdvanceDrawerLayout
import android.view.WindowManager
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout: AdvanceDrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        setSupportActionBar(binding.appBarMain.toolbar)
        var toggle = ActionBarDrawerToggle(this,drawerLayout,binding.appBarMain.toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

//        drawerLayout.setViewScale(Gravity.START, 0.8f);
//         drawerLayout.setRadius(Gravity.START, 20F);
//        //drawerLayout.setViewElevation(Gravity.START,5F);
//        drawerLayout.setViewElevation(Gravity.START,5F)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_logo)
        }
        navView.itemIconTintList=null
        drawerLayout.useCustomBehavior(GravityCompat.START)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->{
                    navController.popBackStack()
                    navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home)
                    navController.navigate(R.id.nav_home)
                    drawerLayout.close()
                }
                R.id.nav_gallery->{
                    navController.popBackStack()
                    navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home_2)
                    navController.navigate(R.id.nav_gallery)
                    drawerLayout.close()
                }
                R.id.nav_slideshow->{
                    navController.popBackStack()
                    navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home_2)
                    navController.navigate(R.id.nav_slideshow)
                    drawerLayout.close()
                }
                R.id.about->{
                    navView.menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home_2)
                    drawerLayout.close()
                }
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}