package com.ivanj.e_trade

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var amount: TextView
    private lateinit var start: TextView
    private lateinit var stop: TextView
    private lateinit var customer: TextView
    private lateinit var phone: TextView
    private lateinit var exit: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amount=findViewById(R.id.productName)
        exit=findViewById(R.id.exitC)
        start=findViewById(R.id.dateOfOrder)
        stop=findViewById(R.id.stopC)
        customer=findViewById(R.id.customerC)
        phone=findViewById(R.id.phoneC)

        val bundle: Bundle? =intent.extras

        amount.text=bundle!!.getString("amount")
        start.text= bundle.getString("start")
        stop.text= bundle.getString("stop")
        customer.text= bundle.getString("name")
        phone.text= bundle.getString("phone")

        exit.setOnClickListener {
            finish()
        }
    }
}