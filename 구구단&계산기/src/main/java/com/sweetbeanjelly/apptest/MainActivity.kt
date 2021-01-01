package com.sweetbeanjelly.apptest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//     변경 extends : 로 표시
//     변경 @override
//     변경 Bundle?은 매개변수에 null 허용한다는 뜻
//     세미콜론 생략 가능

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        resultBtn.setOnClickListener {
//            val intent = Intent(this, SubActivity::class.java)
//            intent.putExtra("Name",edt1.text.toString())
//            intent.putExtra("Age",edt2.text.toString())
//            startActivity(intent)
//        }

//        if(num1.isFocusable) {
//            btn0.setOnClickListener {
//                num1.setText(num1.text.toString()+0)
//            }
//            btn1.setOnClickListener {
//                num1.setText(num1.text.toString()+1)
//            }
//            btn2.setOnClickListener {
//                num1.setText(num1.text.toString()+2)
//            }
//            btn3.setOnClickListener {
//                num1.setText(num1.text.toString()+3)
//            }
//            btn4.setOnClickListener {
//                num1.setText(num1.text.toString()+4)
//            }
//            btn5.setOnClickListener {
//                num1.setText(num1.text.toString()+5)
//            }
//            btn6.setOnClickListener {
//                num1.setText(num1.text.toString()+6)
//            }
//            btn7.setOnClickListener {
//                num1.setText(num1.text.toString()+7)
//            }
//            btn8.setOnClickListener {
//                num1.setText(num1.text.toString()+8)
//            }
//            btn9.setOnClickListener {
//                num1.setText(num1.text.toString()+9)
//            }
//        }
//        if(num2.isFocusable) {
//            btn0.setOnClickListener {
//                num2.setText(num2.text.toString()+0)
//            }
//            btn1.setOnClickListener {
//                num2.setText(num2.text.toString()+1)
//            }
//            btn2.setOnClickListener {
//                num2.setText(num2.text.toString()+2)
//            }
//            btn3.setOnClickListener {
//                num2.setText(num2.text.toString()+3)
//            }
//            btn4.setOnClickListener {
//                num2.setText(num2.text.toString()+4)
//            }
//            btn5.setOnClickListener {
//                num2.setText(num2.text.toString()+5)
//            }
//            btn6.setOnClickListener {
//                num2.setText(num2.text.toString()+6)
//            }
//            btn7.setOnClickListener {
//                num2.setText(num2.text.toString()+7)
//            }
//            btn8.setOnClickListener {
//                num2.setText(num2.text.toString()+8)
//            }
//            btn9.setOnClickListener {
//                num2.setText(num2.text.toString()+9)
//            }
//        }
//
//        btnPlus.setOnClickListener {
//            if((num1.text.toString()=="") || (num2.text.toString()==""))
//                Toast.makeText(this, "숫자를 입력하세요.",Toast.LENGTH_SHORT).show()
//
//            var number1 = num1.text.toString().toInt()
//            var number2 = num2.text.toString().toInt()
//            var Result: Int = 0
//            Result = number1 + number2
//            txtR.setText("Result : "+Result.toString())
//        }
//        btnMinus.setOnClickListener {
//            if((num1.text.toString()=="") || (num2.text.toString()==""))
//                Toast.makeText(this, "숫자를 입력하세요.",Toast.LENGTH_SHORT).show()
//
//            var number1 = num1.text.toString().toInt()
//            var number2 = num2.text.toString().toInt()
//            var Result: Int = 0
//            Result = number1 - number2
//            txtR.setText("Result : "+Result.toString())
//        }
//        btnMulti.setOnClickListener {
//            if((num1.text.toString()=="") || (num2.text.toString()==""))
//                Toast.makeText(this, "숫자를 입력하세요.",Toast.LENGTH_SHORT).show()
//
//            var number1 = num1.text.toString().toInt()
//            var number2 = num2.text.toString().toInt()
//            var Result: Int = 0
//            Result = number1 * number2
//            txtR.setText("Result : "+Result.toString())
//        }
//        btnDiv.setOnClickListener {
//            if((num1.text.toString()=="") || (num2.text.toString()==""))
//                Toast.makeText(this, "숫자를 입력하세요.",Toast.LENGTH_SHORT).show()
//
//            var number1 = num1.text.toString().toInt()
//            var number2 = num2.text.toString().toInt()
//            var Result: Int = 0
//            Result = number1 / number2
//            txtR.setText("Result : "+Result.toString())
//        }
//
//         btnClear.setOnClickListener {
////            num1.setText("")
////           num2.setText("")
//            txtR.setText("Result : ")
//        }

        var result: Int = 0

        btn1.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 1 * i
                textView.text = String.format("1 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn2.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 2 * i
                textView.text = String.format("2 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn3.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 3 * i
                textView.text = String.format("3 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn4.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 4 * i
                textView.text = String.format("4 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn5.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 5 * i
                textView.text = String.format("5 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn6.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 6 * i
                textView.text = String.format("6 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn7.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 7 * i
                textView.text = String.format("7 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn8.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) { // 9부터 1까지 1개씩 감소  ex) step 1은 굳이 안써도 댐.
                val textView = TextView(this)
                //TextView 를 생성.

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 8 * i
                textView.text = String.format("8 · %d = %d", i, result)
                //String class 에 format 이라는 메소드가 있음.
                // String.format = 내가 원하는 형태로 값을 바꿔줌.
                // %d 는 double 타입의 상수나 변수를 받음.

                scrollView.addView(textView, 0)
            }
        }
        btn9.setOnClickListener {
            scrollView.removeAllViews()
            for (i in 9 downTo 1 step 1) {

                val textView = TextView(this)

                textView.gravity = Gravity.CENTER
                textView.textSize = 20F

                result = 9 * i
                textView.text = String.format("9 · %d = %d", i, result)

                scrollView.addView(textView, 0)
            }
        }
    }
}
