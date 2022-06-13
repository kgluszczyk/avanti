package pl.comarch.avantiavanti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        with(findViewById<TextView>(R.id.totalScore)){
            text = intent.getIntExtra("TotalScore", -1).toString()
            setOnLongClickListener {
                Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, text)
                    type = "text/plain"
                }.also {
                    startActivity(it)
                }
                true
            }
        }
    }
}