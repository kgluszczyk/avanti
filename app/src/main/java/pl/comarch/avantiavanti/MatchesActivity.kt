package pl.comarch.avantiavanti

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MatchesActivity : AppCompatActivity() {

    lateinit var adapter: MatchesAdapter
    val activityScope = CoroutineScope(Dispatchers.IO)

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

/*        val task1 = Thread {
            val matches =  NetworkService.avantiService.getMatches().execute().body() ?: emptyList()
            App.database.getMatchesDao().insert(matches)
            val matchesFromDb = App.database.getMatchesDao().getAll()
            runOnUiThread {
                adapter.updateDate(matchesFromDb)
            }
        }
        task1.start()*/

        activityScope.launch {
            val matches = NetworkService.avantiService.getMatches2()
            App.database.getMatchesDao().insert(matches)
            val matchesFromDb = App.database.getMatchesDao().getAll()
            runOnUiThread {
                adapter.updateDate(matchesFromDb)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activityScope.cancel()
    }
}