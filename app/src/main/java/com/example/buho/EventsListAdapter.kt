package com.example.buho

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class EventsListAdapter(private val home: HomeFragment) : RecyclerView.Adapter<EventsViewHolder>() {

    private val cards = ArrayList<MyEventCardComponent>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.my_event_card, parent, false)
        return EventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val cardN = cards[position]
        holder.title.text = cardN.title
        holder.state.text = cardN.state
        holder.classroom.text = cardN.classroom
        holder.schedule.text = cardN.schedule
        holder.description.text = cardN.description

        holder.layout.setOnClickListener {
            DetailsFragment(
                tittle = cardN.title,
                state =  cardN.state,
                classroom =  cardN.classroom,
                schedule =  cardN.schedule,
                details =  cardN.description,
                speaker_type =  "Ponente: ",
                speaker_name =  "John Doe",
                mainButtonText = "Estoy aquí",
                onClickMethod = { imHere() }
            ).show(home.parentFragmentManager, "details")
        }

    }

    private fun imHere(){
        (home.main[0] as BottomNavigationView).selectedItemId = R.id.assistenceItem
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun addCard(cardComponent: MyEventCardComponent) {
        cards.add(cardComponent)

    }
}