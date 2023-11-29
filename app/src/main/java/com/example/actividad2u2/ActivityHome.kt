package com.example.actividad2u2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.actividad2u2.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityHome : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostActivHome) as NavHostFragment

        val navController = navHostFragment.navController

        // Intentar obtener la categoría y el nombre de los extras del Intent
        val categoria = intent.getStringExtra("categoria")
        val nombre = intent.getStringExtra("nombre")


        // Configurar el gráfico de navegación según la categoría
        when (categoria) {
            getString(R.string.cb1) -> navController.navigate(R.id.noticiasGenerales)
            getString(R.string.cb2) -> navController.navigate(R.id.noticiasDeportes)
            getString(R.string.cb3) -> navController.navigate(R.id.noticiasTecnologia)
            // Agrega más casos según sea necesario

        }

        // Limpiar el back stack
        clearBackStack(supportFragmentManager)

        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.noticiasGenerales, R.id.noticiasDeportes, R.id.noticiasTecnologia))
        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<BottomNavigationView>(R.id.nav_view).setupWithNavController(navController)
    }

    private fun clearBackStack(fragmentManager: FragmentManager) {
        val backStackEntryCount = fragmentManager.backStackEntryCount
        for (i in 0 until backStackEntryCount) {
            fragmentManager.popBackStack()
        }
    }
}