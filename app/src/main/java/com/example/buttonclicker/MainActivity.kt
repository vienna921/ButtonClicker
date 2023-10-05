package com.example.buttonclicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    //need an instance variable for the button which we'll
    //link to the xml widget

    //in java: private Button clickerButton
    //in kotlin: var varName: DataType
    //var or val --> variable or is it a final value
    //lateinit is a promise to initialize the var later
    //before using it
    lateinit var clickerButton: Button
    lateinit var layout: ConstraintLayout
    lateinit var counter: TextView

    //in kotlin, there are no primitives. all classes
    //if the data type can be inferred, you don't
    //have to write out. great for numbers & strings
    var points = 0

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wire widget -- link xml code to the kotlin code
        clickerButton = findViewById(R.id.button_main_clicker)
        layout = findViewById(R.id.layout_main)
        counter = findViewById(R.id.text_main_counter)
        clickerButton.text = "Click me!"
        counter.text="Points: 0"


        //react to a button click event
        clickerButton.setOnClickListener {
            //this code gets executed when the button is clicked
            points++

            //update the button to show current points
            //old java concatenation way
            //clickerButton.text = "Points: " + points
            //kotlin string template way
            counter.text = "Points: $points!!!"

            counter.setTextColor(Color.rgb((Math.random()*256).toInt(), (Math.random()*256).toInt(), (Math.random()*256).toInt()))

            //send a message to the user when they hit 10 clicks
            if (points == 10){
                //context is generally the current activity you are in
                //which is "this"
                Toast.makeText(this, "Hooray 10 Clicks!", Toast.LENGTH_SHORT).show()
            }
            if(points % 10 == 0){
                Toast.makeText(this, "Hooray $points Clicks!", Toast.LENGTH_SHORT).show()
                clickerButton.setBackgroundColor(Color.rgb((Math.random()*256).toInt(), (Math.random()*256).toInt(), (Math.random()*256).toInt()))
                clickerButton.setTextColor(Color.rgb((Math.random()*256).toInt(), (Math.random()*256).toInt(), (Math.random()*256).toInt()))
            }

            layout.setBackgroundColor(Color.rgb((Math.random()*256).toInt(), (Math.random()*256).toInt(), (Math.random()*256).toInt()))


        }
    }
}