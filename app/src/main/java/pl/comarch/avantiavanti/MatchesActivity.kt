package pl.comarch.avantiavanti

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MatchesActivity : AppCompatActivity() {

    val matches = listOf(
        Match(host = "PL", opponent = "PT"),
        Match(host = "PL", opponent = "MX"),
        Match(host = "NU", opponent = "MX"),
        Match(host = "AZ", opponent = "MX"),
        Match(host = "NL", opponent = "MX"),
        Match(host = "EN", opponent = "MX")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)
        val recyclerView = findViewById<RecyclerView>(R.id.matches_list)
        //recyclerView.

    }
}