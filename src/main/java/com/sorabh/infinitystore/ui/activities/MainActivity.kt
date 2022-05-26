package com.sorabh.infinitystore.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.sorabh.infinitystore.NavigationDirections
import com.sorabh.infinitystore.R
import com.sorabh.infinitystore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupAction(activityMainBinding.toolBar)

        setupOptionMenu(R.menu.bottom_menu)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        //for easy configuration with toolbar and hide back button on these fragment with help of their id's
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.settingFragment,
                R.id.servicesFragment,
                R.id.homeFragment,
                R.id.aboutAppFragment
            ), activityMainBinding.drawerLayout

        )
        //implement navigation navigation components
//        setupActionBarWithNavController(navController)

        // implement navigation with toolBar
        activityMainBinding.toolBar.setupWithNavController(navController, appBarConfiguration)

        val navController = findNavController(R.id.nav_host)

        //setup Drawer Navigation with navigation  components
        activityMainBinding.drawerNavigation.setupWithNavController(navController)

        //setup Bottom Navigation with navigation  components
        activityMainBinding.bottomNavigation.setupWithNavController(navController)

    }


    //    showing home hamburger icon  in toolBar or ActionBar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    //to choose option menu item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.aboutAppFragment) {
            val action = NavigationDirections.actionGlobalAboutAppFragment()
            navController.navigate(action)
            return true
        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    // to create option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        activityMainBinding.toolBar.inflateMenu(R.menu.option_menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setupAction(materialToolbar: MaterialToolbar) {
        setSupportActionBar(materialToolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Home"
    }

    private fun setupOptionMenu(menu: Int) {
        with(activityMainBinding.toolBar) {
            inflateMenu(menu)
        }
    }
}