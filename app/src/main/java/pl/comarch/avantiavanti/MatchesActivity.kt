package pl.comarch.avantiavanti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MatchesActivity : AppCompatActivity() {

    var matches = listOf(
        Match(host = "MX", opponent = "MX"),
        Match(host = "PL", opponent = "MX"),
        Match(host = "NU", opponent = "MX"),
        Match(host = "AZ", opponent = "MX"),
        Match(host = "NL", opponent = "MX"),
        Match(host = "EN", opponent = "MX")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)
        NetworkService.avantiService.getMatches().enqueue(object : retrofit2.Callback<List<Match>>{
            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
               matches = response.body() ?: emptyList()
                val recyclerView = findViewById<RecyclerView>(R.id.matches_list)
                recyclerView.adapter = MatchesAdapter(matches){
                    val intent = Intent(this@MatchesActivity, MainActivity::class.java)
                    intent.putExtra(MainActivity.hostKey, it.host)
                    intent.putExtra("Opponent", it.opponent)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}