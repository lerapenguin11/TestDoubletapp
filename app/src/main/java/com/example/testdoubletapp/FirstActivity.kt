package com.example.testdoubletapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testdoubletapp.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFirstBinding
    private var count = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG_ACTIVITY, MSG_CREATE)
        btNextOnClickListener()

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(INTENT_NAME)
        }
        binding.tvFirstCount.text = count.toString()
    }

    private fun btNextOnClickListener() {
        binding.btNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(INTENT_NAME, count)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        updateCount()
        Log.d(TAG_ACTIVITY, MSG_START)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG_ACTIVITY, MSG_RESTART)
    }

    private fun updateCount() {
        binding.tvFirstCount.text = (++count).toString()
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(INTENT_NAME, count)
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

    }
}