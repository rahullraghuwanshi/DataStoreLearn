package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.prefstore.MemoNeetDataStore
import com.example.myapplication.prefstore.MemoNeetDataStoreImpl
import com.example.myapplication.prefstore.MemoNeetDataStoreKeys.Companion.NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){

    private lateinit var context:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStore : MemoNeetDataStore = MemoNeetDataStoreImpl(this)


        CoroutineScope(Dispatchers.Main).launch {
            dataStore.putValue(NAME,"Rahu00")
           val name = dataStore.getValue(NAME,"")
                .first()
            Toast.makeText(this@MainActivity,name,Toast.LENGTH_LONG).show()
        }
    }
}