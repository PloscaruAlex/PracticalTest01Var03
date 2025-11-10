package ro.pub.cs.systems.eim.practicaltest01var03

import android.app.Activity
import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts

class PracticalTest01Var03MainActivity : ComponentActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var result: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        result = findViewById(R.id.result)

        val plusButton = findViewById<Button>(R.id.plus)
        val minusButton = findViewById<Button>(R.id.minus)

        plusButton.setOnClickListener {
            var in1 = 0
            var in2 = 0
            try {
                in1 = input1.text.toString().toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "The input is not number.", Toast.LENGTH_LONG).show()
            }

            try {
                in2 = input2.text.toString().toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "The input is not number.", Toast.LENGTH_LONG).show()
            }
            val sum = in1 + in2
            result.setText(in1.toString() + " + " + in2.toString() + " = " + sum.toString())
        }

        minusButton.setOnClickListener {
            var in1 = 0
            var in2 = 0
            try {
                in1 = input1.text.toString().toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "The input is not number.", Toast.LENGTH_LONG).show()
            }

            try {
                in2 = input2.text.toString().toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "The input is not number.", Toast.LENGTH_LONG).show()
            }
            val diff = in1 - in2
            result.setText(in1.toString() + " - " + in2.toString() + " = " + diff.toString())
        }

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show()
            }
            else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
            }
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.navigate)
        navigateToSecondaryActivityButton.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var03SecondaryActivity::class.java)
            intent.putExtra("RESULT", result.text.toString())
            activityResultsLauncher.launch(intent)
        }



    }
}