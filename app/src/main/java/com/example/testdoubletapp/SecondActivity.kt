package com.example.testdoubletapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testdoubletapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG_ACTIVITY, MSG_CREATE)
        acceptIntentActivity()
        btFinishSetOnClickListener()
    }

    private fun btFinishSetOnClickListener() {
        binding.btFinish.setOnClickListener {
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG_ACTIVITY, MSG_START)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG_ACTIVITY, MSG_RESTART)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG_ACTIVITY, MSG_RESUME)
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG_ACTIVITY, MSG_PAUSE)
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG_ACTIVITY, MSG_STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG_ACTIVITY, MSG_DESTROY)
    }

    private fun acceptIntentActivity() {
        count = intent.getIntExtra(INTENT_NAME, DEFAULT_VALUE)
        updateNumber()
    }

    private fun updateNumber() {
        binding.tvSecondCount.text = (count * count).toString()
    }


    companion object{
        private const val TAG_ACTIVITY = "FirstActivity"
        private const val MSG_RESUME = "onResume"
        private const val MSG_CREATE = "onCreate"
        private const val MSG_START = "onStart"
        private const val MSG_RESTART = "onRestart"
        private const val MSG_PAUSE = "onPause"
        private const val MSG_STOP = "onStop"
        private const val MSG_DESTROY = "onDestroy"
        private const val INTENT_NAME = "count"
        private const val DEFAULT_VALUE = 0
    }
}