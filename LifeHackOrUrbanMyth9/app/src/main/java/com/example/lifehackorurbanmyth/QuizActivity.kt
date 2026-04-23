package com.example.lifehackorurbanmyth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class QuizActivity : AppCompatActivity() {

    private lateinit var questions: List<Question>
    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questions = listOf(
            Question("Airplane mode helps your phone charge faster.", true,
                "It reduces wireless activity."),
            Question("Rice always fixes water-damaged phones.", false,
                "Rice is unreliable."),
            Question("Keyboard shortcuts improve productivity.", true,
                "They save time."),
            Question("Freezing batteries makes them last longer.", false,
                "This is outdated advice."),
            Question("Labeling cables saves time.", true,
                "It helps organisation.")
        )

        loadQuestion()

        findViewById<Button>(R.id.hackButton).setOnClickListener {
            checkAnswer(true)
        }

        findViewById<Button>(R.id.mythButton).setOnClickListener {
            checkAnswer(false)
        }

        findViewById<Button>(R.id.nextButton).setOnClickListener {
            nextQuestion()
        }
    }

    private fun loadQuestion() {
        answered = false

        val q = questions[currentIndex]

        findViewById<TextView>(R.id.questionNumberText).text =
            "Question ${currentIndex + 1} of ${questions.size}"

        findViewById<TextView>(R.id.questionText).text = q.statement
        findViewById<TextView>(R.id.feedbackText).text = ""

        Log.d("QuizActivity", "Loaded question $currentIndex")
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (answered) return

        answered = true

        val correct = questions[currentIndex].isHack
        val feedbackText = findViewById<TextView>(R.id.feedbackText)

        if (userAnswer == correct) {
            score++
            feedbackText.text = "Correct! ${questions[currentIndex].explanation}"
        } else {
            feedbackText.text = "Wrong! ${questions[currentIndex].explanation}"
        }

        Log.d("QuizActivity", "Answer checked. Score: $score")
    }

    private fun nextQuestion() {
        currentIndex++

        if (currentIndex < questions.size) {
            loadQuestion()
        } else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", questions.size)
            startActivity(intent)
            finish()
        }
    }
}