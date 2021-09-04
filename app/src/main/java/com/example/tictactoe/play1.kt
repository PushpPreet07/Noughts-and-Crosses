package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_play1.*
import java.util.*
import kotlin.collections.ArrayList

class play1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play1)
    }
    fun buttonClick(view: View) {
        val buClick= view as Button
        var cellId= 0
        when(buClick.id){
            R.id.button1-> cellId=1
            R.id.button2-> cellId=2
            R.id.button3-> cellId=3
            R.id.button4-> cellId=4
            R.id.button5-> cellId=5
            R.id.button6-> cellId=6
            R.id.button7-> cellId=7
            R.id.button8-> cellId=8
            R.id.button9-> cellId=9

        }
        playGame(cellId,buClick)

    }
    var player1= ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1
    private fun playGame(cellId:Int ,buClick:Button ){
        if(activePlayer==1){
            buClick.text="X"
            buClick.setBackgroundColor(Color.YELLOW)
            player1.add(cellId)
            activePlayer=2
            autoPlay()

        }
        else{
            buClick.text="0"
            buClick.setBackgroundColor(Color.GRAY)
            player2.add(cellId)
            activePlayer=1

        }
        buClick.isEnabled=false
        winner()
    }
    private fun winner(){
        var w:Int =-1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            w = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            w = 2
        }
        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            w = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            w = 2
        }
        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            w = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            w = 2
        }
        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            w = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            w = 2
        }
        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            w = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            w = 2
        }
        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            w = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            w = 2
        }
        //d1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            w = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            w = 2
        }
        //d2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            w = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            w = 2
        }

        if(w!=-1){
            if(w==1){
                player1Wins+=1
                Toast.makeText(this,"Player 1 wins", Toast.LENGTH_LONG).show()

                restart()
            }else{
                player2Wins+=1
                Toast.makeText(this,"Player 2 wins", Toast.LENGTH_LONG).show()
                restart()

            }
        }
    }
    private fun autoPlay(){
        var emptyCell=ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCell.add(cellId)
            }
        }
        if(emptyCell.size==0){
            restart()
        }
        var r= Random()
        val randomIndex=r.nextInt(emptyCell.size-0)+0
        val cellId=emptyCell[randomIndex]
        val buttonClick:Button
        when(cellId){
            1->buttonClick=button1
            2->buttonClick=button2
            3->buttonClick=button3
            4->buttonClick=button4
            5->buttonClick=button5
            6->buttonClick=button6
            7->buttonClick=button7
            8->buttonClick=button8
            9->buttonClick=button9
            else->buttonClick=button1
        }
        playGame(cellId,buttonClick)
    }
    var player1Wins=0
    var player2Wins=0
    fun restart(){
        activePlayer=1
        player1.clear()
        player2.clear()
        for(cellId:Int in 1..9) {
            var buttonClick:Button
            when (cellId) {
                1 -> buttonClick = button1
                2 -> buttonClick = button2
                3 -> buttonClick = button3
                4 -> buttonClick = button4
                5 -> buttonClick = button5
                6 -> buttonClick = button6
                7 -> buttonClick = button7
                8 -> buttonClick = button8
                9 -> buttonClick = button9
                else -> buttonClick = button1
            }
            buttonClick.text=""
            buttonClick.setBackgroundColor(Color.MAGENTA)
            buttonClick.isEnabled=true
        }
        Toast.makeText(this,"Player 1 score: $player1Wins , Player 2 score :$player2Wins",Toast.LENGTH_LONG).show()

    }




}