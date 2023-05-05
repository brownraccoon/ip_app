package com.br.ipapp.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.br.ipapp.util.Constant
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    @ApplicationContext private val context: Context
) {

    //private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constant.PREFERENCES)

    private val keyPreferences = stringPreferencesKey(Constant.KEY)

    suspend fun saveKey(key: String) {
        dataStore.edit {
            it[keyPreferences] = key
        }
    }

    fun getKey() = dataStore.data.map {
        it[keyPreferences]
    }
}