package pl.comarch.avantiavanti

import androidx.room.*
import androidx.room.Database


@Database(entities = [Match::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getMatchesDao(): MatchesDao
}

@Dao
interface MatchesDao{

    @Query("SELECT * FROM `Match`")
    fun getAll() : List<Match>

    @Query("DELETE FROM `Match`")
    fun deleteAll()

    @Insert
    fun insert(matches: List<Match>)
}