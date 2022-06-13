package pl.comarch.avantiavanti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        findViewById<TextView>(R.id.totalScore).text = intent.getIntExtra("TotalScore", -1).toString()
    }
}