package com.example.kotlin321

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private lateinit var clear: TextView
    private var operand = 0.0
    private var operation = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
    }

    fun numclick(clickedView: View) {
        if (clickedView is TextView) {
            val number = result.text.toString()
            var text = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            val result1 = text + number
            result.text = result1
        }
    }

    fun clickoperand(clickedView: View) {
        if (clickedView is TextView) {
            operand = result.text.toString().toDouble()
            operation = clickedView.text.toString()
            result.text = ""
        }
    }

    fun clearall(clickedView: View) {
        if (clickedView is TextView) {
            val clearing=clickedView.text.toString()
            if (clearing=="CLEAR") {
                result.text = ("0")
            }
        }
    }

    fun delete(clickedView: View) {
        if (clickedView is TextView) {
        val deleting=clickedView.text.toString()
            if (deleting=="DEL") {
                result.text = result.text.dropLast(1)
            }
        }
    }

    fun decimal(clickedView: View) {
        if (clickedView is TextView) {
            var dot=clickedView.text.toString()
            if (dot == result.text.lastIndex.toString()) {
                result.text = result.text
            } else {
                result.text = result.text.toString() + '.'.toString().toDouble()
            }
        }
    }

    fun equalsclick(clickedView: View) {
        if (clickedView is TextView) {
            val operand2 = result.text.toString().toDouble()
            when (operation) {

                "-" -> result.text = (operand - operand2).toString()
                "+" -> result.text = (operand + operand2).toString()
                "/" -> result.text = (operand / operand2).toString()
                "*" -> result.text = (operand * operand2).toString()
            }
        }
    }
}






