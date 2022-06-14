package pl.comarch.avantiavanti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchesAdapter(var matchesList: List<Match>) : RecyclerView.Adapter<MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matchesList[position]
        val host = holder.itemView.findViewById<TextView>(R.id.host)
        val opponent = holder.itemView.findViewById<TextView>(R.id.opponent)
        host.text = match.host
        opponent.text = match.opponent
    }

    override fun getItemCount() = matchesList.size

}

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {


}