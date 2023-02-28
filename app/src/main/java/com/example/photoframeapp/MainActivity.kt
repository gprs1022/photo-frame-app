package com.example.photoframeapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0

    lateinit var image : ImageView

    var names = arrayOf("Narendra Modi" ,"Swami Vivekanand", "Virat Kohli", "Atal Bihari Bajpeyi","Pradeep Singh", "Saumya Singh")

    //0 1 2 3 4 5 -> 0 1 2 3 4 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imgprev)
        val next = findViewById<ImageButton>(R.id.imgnext)
        val text = findViewById<TextView>(R.id.textView)
        prev.setOnClickListener {

            val idCurrentImageString = "pic$currentImage"

            // convert string id into integer address associated with it

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id",packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = ((6 + currentImage) - 1) % 6


            val idImageToShowString = "pic$currentImage"

            // convert string id into integer address associated with it

            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id",packageName)

            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]



        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"

            // convert string id into integer address associated with it

            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id",packageName)

            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = ((6 + currentImage) + 1) % 6


            val idImageToShowString = "pic$currentImage"

            // convert string id into integer address associated with it

            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id",packageName)

            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]
        }

    }
}