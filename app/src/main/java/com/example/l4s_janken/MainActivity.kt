package com.example.l4s_janken

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var win :Int = 0
    var lose :Int = 0
    var draw :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (result).setTextColor(Color.rgb(0,0,0))
        // (cpu).setTextColor(Color.rgb(0,0,0))
        // (player).setTextColor(Color.rgb(0,0,0))
        text()

        reset.setOnClickListener {
            win = 0
            lose = 0
            draw = 0
            text()
        }
    }

    fun paa(view: View?){
        /// player.text = "あなたの手はパーです"
        player.setImageResource(R.drawable.paa)
        val number = Random().nextInt(3)
        //val number = Random.nextInt(3) でもOK　なにをimportしているかによって書き方が変わる

        (result).setTextColor(Color.rgb(0,0,0))

        when (number){
            0 -> {
                // cpu.text = "相手の手はパーです"
                cpu.setImageResource(R.drawable.paa_cpu)
                drawMove()
            }
            1 -> {
                //   cpu.text = "相手の手はグーです"
                cpu.setImageResource(R.drawable.goo_cpu)
                winMove()
            }
            2 -> {
                // cpu.text = "相手の手はチョキです"
                cpu.setImageResource(R.drawable.choki_cpu)
                loseMove()
            }
        }
        text()
    }

    fun choki(view: View?){
        // player.text = "あなたの手はチョキです"
        player.setImageResource(R.drawable.choki)
        val number = Random().nextInt(3)

        (result).setTextColor(Color.rgb(0,0,0))

        when (number){
            0 -> {
                // cpu.text = "相手の手はチョキです"
                cpu.setImageResource(R.drawable.choki_cpu)
                drawMove()
            }
            1 -> {
                // cpu.text = "相手の手はパーです"
                cpu.setImageResource(R.drawable.paa_cpu)
                winMove()
            }
            2 ->{
                //cpu.text = "相手の手はグーです"
                cpu.setImageResource(R.drawable.goo_cpu)
                loseMove()
            }
        }
        text()
    }

    fun goo(view: View?){
        // player.text = "あなたの手はグーです"
        player.setImageResource(R.drawable.goo)
        val number = Random().nextInt(3)

        (result).setTextColor(Color.rgb(0,0,0))

        when (number){
            0 -> {
                // cpu.text = "相手の手はグーです"
                cpu.setImageResource(R.drawable.goo_cpu)
                drawMove()
            }
            1 -> {
                //cpu.text = "相手の手はチョキです"
                cpu.setImageResource(R.drawable.choki_cpu)
                winMove()
            }
            2 -> {
                //cpu.text = "相手の手はパーです"
                cpu.setImageResource(R.drawable.paa_cpu)
                loseMove()
            }
        }

        text()
    }

    fun winMove (){
        result.text = "あなたの勝ちです"
        (result).setTextColor(Color.rgb(255,0,0))
        win += 1
    }

    fun loseMove(){
        result.text = "あなたの負けです"
        lose += 1
    }

    fun drawMove(){
        result.text = "引き分けです"
        draw += 1
    }

    fun text(){
        score.text = "${win}勝${lose}敗${draw}引分"
    }

}
