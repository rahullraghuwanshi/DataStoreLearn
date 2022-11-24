package com.example.myapplication.prefstore

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface MemoNeetDataStore {

    fun <T> getValue(key: Preferences.Key<T>, defaultValue: T): Flow<T>
    suspend fun <T> putValue(key: Preferences.Key<T>, value: T)
}