package com.github.isacwq.businesscard

import android.app.Application
import com.github.isacwq.businesscard.database.AppDatabase
import com.github.isacwq.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessCardDao()) }
}