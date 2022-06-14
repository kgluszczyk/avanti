package pl.comarch.avantiavanti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class MatchesActivity : AppCompatActivity() {

    lateinit var adapter: MatchesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)
        val recyclerView = findViewById<RecyclerView>(R.id.matches_list)
        adapter = MatchesAdapter(){
            val intent = Intent(this@MatchesActivity, MainActivity::class.java)
            intent.putExtra(MainActivity.hostKey, it.host)
            intent.putExtra("Opponent", it.opponent)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        NetworkService.avantiService.getMatches().enqueue(object : retrofit2.Callback<List<Match>>{
            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
               val matches = response.body() ?: emptyList()
                App.database.getMatchesDao().insert(matches)

                adapter.updateDate(App.database.getMatchesDao().getAll())
            }

            override fun onFailure(call: Call<List<Match>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}