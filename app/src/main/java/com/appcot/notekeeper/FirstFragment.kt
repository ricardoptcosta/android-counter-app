package com.appcot.notekeeper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_create_enemy).setOnClickListener {
            val showCountEnemiesCreated = view.findViewById<TextView>(R.id.enemies_created)
            val currentCount = showCountEnemiesCreated.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.button_play).setOnClickListener {
            val playToast = Toast.makeText(context, "Dice Launched", Toast.LENGTH_SHORT)
            playToast.show()
        }

        view.findViewById<Button>(R.id.button_create_player).setOnClickListener {
            createPlayer(view)
        }
    }

    private fun createPlayer(view: View) {
        val showCountEnemiesCreated = view.findViewById<TextView>(R.id.enemies_created)
        val countString = showCountEnemiesCreated.text.toString()
        var count = countString.toInt()
        count++
        showCountEnemiesCreated.text=count.toString()
    }
}