package id.ishakcahya.gamekertasguntingbatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ishakcahya.gamekertasguntingbatu.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        menuVsPemainListener()
        menuVsCPUListener()
    }

    private fun menuVsPemainListener() {
        binding.llVsPemain.setOnClickListener {
            startActivity(Intent(applicationContext, VersusPemainActivity::class.java))
        }
    }

    private fun menuVsCPUListener() {
        binding.llVsCPU.setOnClickListener {
            startActivity(Intent(applicationContext, VersusCPUActivity::class.java))
        }
    }
}