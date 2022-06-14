package pl.comarch.avantiavanti

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Match(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var host: String,
    var opponent: String,
    var imageUrl: String? = null
)