package edu.csueb.android.temperature

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : Activity() {
    private var text: EditText? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.editText)
    }

    // Called when the "Calculate" button is clicked
    fun onClick(view: View) {
        if (view.id == R.id.button) {
            val celsiusButton = findViewById<RadioButton>(R.id.radioButton)
            val fahrenheitButton = findViewById<RadioButton>(R.id.radioButton1)

            if (text?.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show()
                return
            }

            val inputValue = text!!.text.toString().toFloat()

            if (celsiusButton.isChecked) {
                text!!.setText(
                    ConverterUtil.convertFahrenheitToCelsius(inputValue).toString()
                )
                celsiusButton.isChecked = false
                fahrenheitButton.isChecked = true
            } else {
                text!!.setText(
                    ConverterUtil.convertCelsiusToFahrenheit(inputValue).toString()
                )
                fahrenheitButton.isChecked = false
                celsiusButton.isChecked = true
            }
        }
    }
}


