package com.example.loginauthenticationroomdatabasecompose

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.loginauthenticationroomdatabasecompose.db.AppDatabase
import com.example.loginauthenticationroomdatabasecompose.db.DataEntry
import kotlinx.coroutines.launch
import java.util.Date

class DataViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).dataDao()

    val allEntries = dao.getAll().asLiveData()

    fun addEntry(name: String, date: Date, image: String) {
        viewModelScope.launch {
            dao.insert(DataEntry(name = name, date = date, image = image))
        }
    }
}