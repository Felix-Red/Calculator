package com.example.calculator

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity() : AppCompatActivity() , View.OnClickListener {
    lateinit var btnadd : Button
    lateinit var btnsubtract : Button
    lateinit var btnmultiply : Button
    lateinit var btndivide : Button

    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var resultTv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnadd = findViewById(R.id.btn_add)
        btnsubtract = findViewById(R.id.btn_subtract)
        btnmultiply = findViewById(R.id.btn_multiply)
        btndivide = findViewById(R.id.btn_divide)
        etA = findViewById(R.id.e_ta)
        etB = findViewById(R.id.e_tb)
        resultTv = findViewById(R.id.resulttv)

        btnadd.setOnClickListener(this)
        btnsubtract.setOnClickListener(this)
        btnmultiply.setOnClickListener(this)
        btndivide.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
    override fun onClick(v: View?) {
        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        var result = 0.0
        when(v?.id){
            R.id.btn_add -> {
                result = a + b
            }
            R.id.btn_subtract -> {
                result = a-b
            }
            R.id.btn_multiply -> {
                result = a*b
            }
            R.id.btn_divide -> {
                result = a/b
            }
        }
        resultTv.text = "Result is $result"
    }
}