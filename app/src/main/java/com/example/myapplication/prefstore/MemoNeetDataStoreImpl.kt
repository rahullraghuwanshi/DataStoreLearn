package com.example.myapplication.prefstore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapplication.Constants.DATASTORE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

//data store extension function to initialise datastore
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)

class MemoNeetDataStoreImpl(context: Context) : MemoNeetDataStore {

    private val datastore = context.dataStore

    override fun <T> getValue(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return datastore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[key] ?: defaultValue
            }
    }

    override suspend fun <T> putValue(key: Preferences.Key<T>, value: T) {
        datastore.edit { preferences ->
            preferences[key] = value
        }
    }
}