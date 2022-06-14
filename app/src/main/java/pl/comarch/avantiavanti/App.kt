package pl.comarch.avantiavanti

import android.app.Application
import androidx.room.Room

class App : Application() {

    companion object {
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(this, Database::class.java, "appDatabase")
                .build()
    }
}