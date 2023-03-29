package com.flow.example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            getUserName().forEach {
                Log.d("SANYAM", it)
            }
        }
    }

    private suspend fun getUserName(): List<String> {
        val list = mutableListOf<String>()
        list.add(getUser(1))
        list.add(getUser(2))
        list.add(getUser(3))

        return list
    }

    private suspend fun getUser(id: Int): String {
        delay(1000)//Assume network call
        return "User$id"
    }
}