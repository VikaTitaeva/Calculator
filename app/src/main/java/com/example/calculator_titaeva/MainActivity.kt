package com.example.calculator_titaeva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    lateinit var tvOne : TextView
    lateinit var tvTwo : TextView
    lateinit var tvThree : TextView
    lateinit var tvFour : TextView
    lateinit var tvFive : TextView
    lateinit var tvSix : TextView
    lateinit var tvSeven: TextView
    lateinit var tvEight: TextView
    lateinit var tvNine : TextView
    lateinit var tvZero : TextView
    lateinit var tvPlus : TextView
    lateinit var tvMinus : TextView
    lateinit var tvMul : TextView
    lateinit var tvDivide : TextView
    lateinit var tvDot : TextView
    lateinit var tvClear : TextView
    lateinit var tvEquals : TextView
    lateinit var tvExpression : TextView
    lateinit var tvResult : TextView
    lateinit var tvBack : TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvOne = findViewById(R.id.tvOne)
        tvTwo = findViewById(R.id.tvTwo)
        tvThree = findViewById(R.id.tvThree)
        tvFour = findViewById(R.id.tvFour)
        tvFive= findViewById(R.id.tvFive)
        tvSix = findViewById(R.id.tvSix)
        tvSeven = findViewById(R.id.tvSeven)
        tvEight = findViewById(R.id.tvEight)
        tvNine = findViewById(R.id.tvNine)
        tvZero = findViewById(R.id.tvZero)
        tvPlus = findViewById(R.id.tvPlus)
        tvMinus = findViewById(R.id.tvMinus)
        tvMul = findViewById(R.id.tvMul)
        tvDivide = findViewById(R.id.tvDivide)
        tvDot = findViewById(R.id.tvDot)
        tvClear = findViewById(R.id.tvClear)
        tvEquals = findViewById(R.id.tvEquals)
        tvExpression = findViewById(R.id.tvExpression)
        tvResult= findViewById(R.id.tvResult)
        tvBack = findViewById(R.id.tvBack)


        /*Number Buttons*/

        tvOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        tvTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        tvThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        tvFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        tvFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        tvSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        tvSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        tvEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        tvNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        tvZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        tvPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        tvMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        tvMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        tvDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }
        tvDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.drop(1)
            }

            tvResult.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, clear: Boolean) {
        try {
            if (clear) {
                tvResult.text = ""
                tvExpression.append(string)
            } else {
                tvExpression.append(tvResult.text)
                tvExpression.append(string)
                tvResult.text = ""
            }
        }
        catch (e: ArithmeticException)
        {
            tvResult.text = "Error"
        }
    }
}
