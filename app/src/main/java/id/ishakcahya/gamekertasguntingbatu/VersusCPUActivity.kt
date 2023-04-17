package id.ishakcahya.gamekertasguntingbatu

import android.app.Dialog
import android.content.DialogInterface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import id.ishakcahya.gamekertasguntingbatu.databinding.ActivityVersusCpuactivityBinding

class VersusCPUActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVersusCpuactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVersusCpuactivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        initListeners()
    }

    private fun initListeners() {
        val mediaPlayerGame = MediaPlayer.create(this, R.raw.game_click)
        val mediaPlayerRefresh = MediaPlayer.create(this, R.raw.refresh_click)

        binding.ivBatu.setOnClickListener {
            binding.ivBatu.setBackgroundResource(R.drawable.bg_selected_suit)
            binding.ivGunting.setBackgroundResource(R.drawable.bg_clear)
            binding.ivKertas.setBackgroundResource(R.drawable.bg_clear)
            mediaPlayerGame.start()
            startGame("BATU")
            confirmStartGame()
            Log.i("TAG", "Option Pemain 1")
        }

        binding.ivKertas.setOnClickListener {
            binding.ivKertas.setBackgroundResource(R.drawable.bg_selected_suit)
            binding.ivBatu.setBackgroundResource(R.drawable.bg_clear)
            binding.ivGunting.setBackgroundResource(R.drawable.bg_clear)
            mediaPlayerGame.start()
            startGame("KERTAS")
            confirmStartGame()
            Log.i("TAG", "Option Pemain 1")
        }

        binding.ivGunting.setOnClickListener {
            binding.ivGunting.setBackgroundResource(R.drawable.bg_selected_suit)
            binding.ivKertas.setBackgroundResource(R.drawable.bg_clear)
            binding.ivBatu.setBackgroundResource(R.drawable.bg_clear)
            mediaPlayerGame.start()
            startGame("GUNTING")
            confirmStartGame()
            Log.i("TAG", "Option Pemain 1")
        }

        binding.ivRefresh.setOnClickListener {
            binding.ivBatu.setBackgroundResource(R.drawable.bg_clear)
            binding.ivGunting.setBackgroundResource(R.drawable.bg_clear)
            binding.ivKertas.setBackgroundResource(R.drawable.bg_clear)
            binding.ivBatuCom.setBackgroundResource(R.drawable.bg_clear)
            binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_clear)
            binding.ivKertasCom.setBackgroundResource(R.drawable.bg_clear)
            binding.ivResult.setImageResource(R.drawable.vs)
            mediaPlayerRefresh.start()
        }
    }

    fun confirmStartGame() {
        val newFragment = StartGameDialogFragment()
        newFragment.show(supportFragmentManager, "game")
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickComputerOption()
        Game.pickNextComputerOption(computerOption)
        Log.i("TAG", "Option Computer")
        when {
            computerOption == "BATU" -> {
                binding.ivBatuCom.setBackgroundResource(R.drawable.bg_selected_suit)
                binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_clear)
                binding.ivKertasCom.setBackgroundResource(R.drawable.bg_clear)
            }
            computerOption == "GUNTING" -> {
                binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_selected_suit)
                binding.ivKertasCom.setBackgroundResource(R.drawable.bg_clear)
                binding.ivBatuCom.setBackgroundResource(R.drawable.bg_clear)
            }
            else -> {
                binding.ivKertasCom.setBackgroundResource(R.drawable.bg_selected_suit)
                binding.ivBatuCom.setBackgroundResource(R.drawable.bg_clear)
                binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_clear)
            }
        }

        when {
            Game.isDraw(option, computerOption) -> binding.ivResult.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> binding.ivResult.setImageResource(R.drawable.pemain_1_menang)
            else -> binding.ivResult.setImageResource(R.drawable.pemain_2_menang)
        }
    }
}
