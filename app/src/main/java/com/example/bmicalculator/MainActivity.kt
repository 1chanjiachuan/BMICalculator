package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReset.setOnClickListener() {
            txtbmi.text = null
            txtWeight.text.clear()
            txtHeight.text.clear()
            txtdesc.text = "( )"

            txtWeight.requestFocus()
        }

        btnCalculate.setOnClickListener() {
            val weight: Double = txtWeight.text.toString().toDouble()
            val height: Double = txtHeight.text.toString().toDouble()

            val bmi = calculateBMI(height, weight)


            if (bmi <= 18.5) {
                size_image.setImageResource(R.drawable.under)
                txtdesc.text = "Underweight"
            } else if (bmi <= 24.9) {
                size_image.setImageResource(R.drawable.normal)
                txtdesc.text = "Normal"
            } else {
                size_image.setImageResource(R.drawable.over)
                txtdesc.text = "Overweight"
            }
            txtbmi.text = "%.2f".format(bmi)
        }

    }

    private fun calculateBMI(height: Double, weight: Double): Double {
        return height / (weight * weight)
    }

}




