package pl.comarch.avantiavanti

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import java.util.Locale.getDefault

class MatchesAdapter(var matchesList: List<Match> = emptyList(), var actionClick: (Match) -> Unit) : RecyclerView.Adapter<MatchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matchesList[position]
        val host = holder.itemView.findViewById<TextView>(R.id.host)
        val opponent = holder.itemView.findViewById<TextView>(R.id.opponent)

        val image = holder.itemView.findViewById<ImageView>(R.id.image)

        Glide.with(image)
            .load(match.imageUrl)
            .centerCrop()
            .into(image)

        host.text = match.hostDisplayName()
        opponent.text =  match.guestDisplayName()

        holder.itemView.setOnClickListener {
            actionClick(match)
        }
    }

    override fun getItemCount() = matchesList.size

    fun updateDate(list: List<Match>){
        matchesList = list
        notifyDataSetChanged()
    }

}

class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view)

fun Locale.displayCountry(countryCode : String) =  Locale(getDefault().language, countryCode).displayCountry

fun Match.hostDisplayName() = getDefault().displayCountry(host)

fun Match.guestDisplayName() = getDefault().displayCountry(opponent)