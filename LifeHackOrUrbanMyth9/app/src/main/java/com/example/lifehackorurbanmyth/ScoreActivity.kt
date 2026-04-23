package com.example.lifehackorurbanmyth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        findViewById<TextView>(R.id.scoreText).text = "Score: $score/$total"

        val feedback = when {
            score == total -> "Master Hacker!"
            score >= total / 2 -> "Great Job!"
            else -> "Stay Safe Online!"
        }

        findViewById<TextView>(R.id.resultText).text = feedback

        findViewById<Button>(R.id.reviewButton).setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }
    }
}