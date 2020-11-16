package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity(){
    private lateinit var map:MutableMap<Int,Int>
   private val end:Int=9
   private val start:Int=1
    val player=ArrayList<Int>()
    val computer=ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      button.setOnClickListener(View.OnClickListener {
          emptyBoard()
      })
    }

    private fun emptyBoard() {
        button1.text=""
        button1.isEnabled=true
        button1.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button2.text=""
        button2.isEnabled=true
        button2.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button3.text=""
        button3.isEnabled=true
        button3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button4.text=""
        button4.isEnabled=true
        button4.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button5.text=""
        button5.isEnabled=true
        button5.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button6.text=""
        button6.isEnabled=true
        button6.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button7.text=""
        button7.isEnabled=true
        button7.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button8.text=""
        button8.setBackgroundColor(Color.parseColor("#FFFFFF"))
        button8.isEnabled=true
        button9.text=""
        button9.isEnabled=true
        button9.setBackgroundColor(Color.parseColor("#FFF856"))
    }

    fun btnClick(view: View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id){
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9

        }

        playGame(cellID,buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {
        if(activePlayer==1){
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellID)
            activePlayer = 2
            AutoPlay()
        }else{
            buSelected.text = "o"
            buSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false;
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }


        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }




        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }



        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }



        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if( winner != -1){

            if (winner==1){
                Toast.makeText(this," Player 1  win the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this," Player 2  win the game", Toast.LENGTH_LONG).show()

            }

        }
    }

    private fun AutoPlay() {
        val emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if(!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        Log.d("random_value","${randIndex}")
        val cellID = emptyCells[randIndex]

        var buSelected:Button
        when(cellID){
            1->buSelected=button1
            2-> buSelected=button2
            3-> buSelected=button3
            4-> buSelected=button4
            5-> buSelected=button5
            6-> buSelected=button6
            7-> buSelected=button7
            8-> buSelected=button8
            9-> buSelected=button9
            else -> buSelected = button1

        }

        playGame(cellID,buSelected)

    }
}
