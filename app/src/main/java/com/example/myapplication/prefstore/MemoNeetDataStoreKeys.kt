package com.example.myapplication.prefstore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

class MemoNeetDataStoreKeys {

    companion object{
        val NAME = stringPreferencesKey("name")

    }
}