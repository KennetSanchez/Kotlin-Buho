package com.example.buho

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.allViews
import androidx.core.view.children
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.buho.databinding.HomePageBinding

class HomeFragment : Fragment(R.layout.home_page) {
    private var _binding: HomePageBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= HomePageBinding.inflate(inflater,container, false)
        val view= binding.root;

        val cardsMyEvents = binding.HPMECl.children

        cardsMyEvents.forEach { children ->
            children as CardView
            val childCl = children[0]
            childCl.setOnClickListener{showDetails(childCl)}
        }
        return view;
    }


    private fun showDetails(view : View){
        val cl = view as ConstraintLayout
        val textsArrays = cl.children

        val dialogParams : ArrayList<String> = ArrayList()
        textsArrays.forEach{
            val currentText = it as TextView

            if(currentText.text != ""){
                dialogParams.add(currentText.text as String)
            }
        }

        DetailsFragment(
            tittle = dialogParams[0],
            state =  dialogParams[1],
            classroom =  dialogParams[2],
            schedule =  dialogParams[3],
            speaker_type =  "Ponente: ",

            //Not implemented yet
            speaker_name =  "John Doe",

            details =  dialogParams[4]
        ).show(parentFragmentManager, "details")
    }
}