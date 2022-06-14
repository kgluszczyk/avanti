package pl.comarch.avantiavanti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    companion object {
        const val hostKey = "Host"
    }

    var totalScore: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        totalScore = savedInstanceState?.getInt("TotalScore") ?: totalScore
        val button = findViewById<Button>(R.id.action)
        button.setOnClickListener {
            totalScore = findViewById<EditText>(R.id.scoreTeamLeft).text.toString().toInt() +
                    findViewById<EditText>(R.id.scoreTeamRight).text.toString().toInt()
            //Toast.makeText(this, "Zagłosowano", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("TotalScore", totalScore)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.labelTeamLeft).text = intent.getStringExtra(hostKey).toString()
        findViewById<TextView>(R.id.labelTeamRight).text = intent.getStringExtra("Opponent").toString()
        intent.getIntExtra("Opponent", -1).toString()

        Log.i("Lifecycle", "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("TotalScore", totalScore)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "TotalScore: $totalScore", Toast.LENGTH_LONG).show()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "onDestroy")
    }
}

