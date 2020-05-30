package com.internshala.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.internshala.calculator.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        tvOne.setOnClickListener{appendOnExression("1",true)}
        tvTwo.setOnClickListener{appendOnExression("2",true)}
        tvThree.setOnClickListener{appendOnExression("3",true)}
        tvFour.setOnClickListener{appendOnExression("4",true)}
        tvFive.setOnClickListener{appendOnExression("5",true)}
        tvSix.setOnClickListener{appendOnExression("6",true)}
        tvSeven.setOnClickListener{appendOnExression("7",true)}
        tvEight.setOnClickListener{appendOnExression("8",true)}
        tvNine.setOnClickListener{appendOnExression("9",true)}
        tvZero.setOnClickListener{appendOnExression("0",true)}
        tvDot.setOnClickListener{appendOnExression(".",true)}

        tvPlus.setOnClickListener{appendOnExression("+",false)}
        tvMinus.setOnClickListener{appendOnExression("-",false)}
        tvMul.setOnClickListener{appendOnExression("*",false)}
        tvDivide.setOnClickListener{appendOnExression("/",false)}
        tvOpen.setOnClickListener{appendOnExression("(",false)}
        tvClose.setOnClickListener{appendOnExression(")",false)}

        tvClear.setOnClickListener {
            tvExpression.text=""
            tvResult.text=""}

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text=""
        }

        tvEqual.setOnClickListener {
            try{
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result==longResult.toDouble()){
                    tvResult.text=longResult.toString()
                }else
                    tvResult.text=result.toString()
            }
            catch (e:Exception){

            }
        }


    }
    fun appendOnExression( string:String, canClear:Boolean){

        if (tvResult.text.isNotEmpty()){
            tvExpression.text=""
        }

        if(canClear){
            tvResult.text=""
            tvExpression.append(string)
        }else
        {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text=""
        }

    }
}
