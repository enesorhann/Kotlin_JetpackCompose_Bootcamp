package com.enesorhan.sayacpreferences

import android.content.Context
import android.preference.PreferenceDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlin.coroutines.coroutineContext

class AppPref(var context: Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object{
        val SAYAC_KEY = intPreferencesKey("SAYAC")
    }

    suspend fun okuSayac():Int{
        val p = context.ds.data.first()
        return p[SAYAC_KEY] ?: 0
    }

    suspend fun kayitSayac(value:Int){
        context.ds.edit {
            it[SAYAC_KEY] = value
        }
    }

}