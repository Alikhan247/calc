package kz.alikhan.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var number = 0
    var sum = 0

    var operand = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buttonPressed(view: View) {
        var textView = findViewById<TextView>(R.id.calculationScreen)
        val b = view as Button
        val buttonText = b.text.toString()
        var screenValue = textView.text.toString()


        if(operand.equals("+")) {
            sum += buttonText.toInt()
        } else if (operand.equals("-")){
            sum -= buttonText.toInt()
        }else if (operand.equals("/")){
            sum /= buttonText.toInt()
        }else if (operand.equals("*")){
            sum *= buttonText.toInt()
        } else {
            sum = buttonText.toInt()
        }

        number = buttonText.toInt()
        textView.text = number.toString()
    }

    fun operatorPressed(view: View){
        var textView = findViewById<TextView>(R.id.calculationScreen)
        val b = view as Button
        val buttonText = b.text.toString()

        operand = buttonText

        if(buttonText.equals("AC")) {
            textView.text = "0"
            number = 0
            sum = 0
            operand =""
        }else if(buttonText.equals("=")) {
            textView.text = sum.toString()
            operand=""
        }
    }
}