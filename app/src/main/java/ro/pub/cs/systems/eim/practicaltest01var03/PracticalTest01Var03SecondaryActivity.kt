package ro.pub.cs.systems.eim.practicaltest01var03

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class PracticalTest01Var03SecondaryActivity : Activity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        val resultText = intent.getStringExtra("RESULT")

        val result = findViewById<EditText>(R.id.result)
        result.setText(resultText)

        val correct = findViewById<Button>(R.id.correct)
        correct.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        val incorrect = findViewById<Button>(R.id.incorrect)
        incorrect.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}