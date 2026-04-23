package com.example.lifehackorurbanmyth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val review = """
1. Airplane mode helps your phone charge faster → Hack

2. Rice always fixes water-damaged phones → Myth

3. Keyboard shortcuts improve productivity → Hack

4. Freezing batteries makes them last longer → Myth

5. Labeling cables saves time → Hack
        """.trimIndent()

        findViewById<TextView>(R.id.reviewText).text = review
    }
}

