package com.example.battletank

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import com.example.battletank.Direction.UP
import com.example.battletank.Direction.DOWN
import com.example.battletank.Direction.LEFT
import com.example.battletank.Direction.RIGHT
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.battletank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KEYCODE_DPAD_UP -> move(UP)
            KEYCODE_DPAD_DOWN -> move(DOWN)
            KEYCODE_DPAD_LEFT -> move(LEFT)
            KEYCODE_DPAD_RIGHT -> move(RIGHT)

        }
        return super.onKeyDown(keyCode, event)
    }

    private fun move(direction: Direction) {
        when (direction) {
            UP -> {
                binding.tank.rotation = 0f
                (binding.tank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
            }

            DOWN -> {
                binding.tank.rotation = 180f
                (binding.tank.layoutParams as FrameLayout.LayoutParams).topMargin -= 50
            }

            LEFT -> {
                binding.tank.rotation = 270f
                (binding.tank.layoutParams as FrameLayout.LayoutParams).leftMargin -= 50
            }

            RIGHT -> {
                binding.tank.rotation = 90f
                (binding.tank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
            }
        }
        binding.container.removeView(binding.tank)
        binding.container.addView((binding.tank))
    }
}