package br.com.igti.modulo_iv.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.igti.modulo_iv.R
import br.com.igti.modulo_iv.databinding.ActivityMainBinding
import br.com.igti.modulo_iv.viewmodel.AlunoViewModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    // Initializate the viewmodel
    private val alunoViewModel : AlunoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }

        // Observe the livedata variable with the list of alunos
        /*alunoViewModel.listaAlunos.observe(lifecycleOwner, { lista ->
            if (!lista.isNullOrEmpty()) {
                exibirAlunos(lista)
            }
        })*/

        // Observe the livedata variable with the list of alunos using flow
        // Needs to be inside a coroutine block
        /*runBlocking { // This method is not recommended as it doesn't provide a good UI
            alunoViewModel.listaAlunos.collect { lista ->
                if (!lista.isNullOrEmpty()) {
                    exibirAlunos(lista)
                }
            }
        }*/


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}