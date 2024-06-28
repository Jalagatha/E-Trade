package com.ivanj.e_trade


import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.util.*
import kotlin.collections.ArrayList


class Order : AppCompatActivity() {
    private lateinit var product: AutoCompleteTextView
    private lateinit var st: AutoCompleteTextView
    private lateinit var en: AutoCompleteTextView
    private lateinit var m: TextInputEditText
    private lateinit var ph: TextInputEditText
    private lateinit var submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        product=findViewById(R.id.rs)
        en=findViewById(R.id.en)
        st=findViewById(R.id.st)
        submit=findViewById(R.id.submit)
        m=findViewById(R.id.m)
        ph=findViewById(R.id.ph)
        ///set academic year
        val amount = ArrayList<String>()
        amount.add("Books")
        amount.add("Pens")
        amount.add("Rims")
        amount.add("Computer")
        amount.add("Accessories")


        val itemAcademicYear = ArrayAdapter(this@Order, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, amount)
        product.setAdapter(itemAcademicYear)
        product.setOnItemClickListener { adapterView, _, i, _ ->
            Toast.makeText(
                this@Order,
                adapterView.getItemAtPosition(i).toString(),
                Toast.LENGTH_SHORT
            ).show()
            adapterView.getItemAtPosition(i).toString()
        }
        val calender: Calendar = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val day = calender.get(Calendar.DAY_OF_MONTH)
        val month = calender.get(Calendar.MONTH)
        st.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this@Order,
                OnDateSetListener { _, mYear, mMonth, mDay ->
                    st.setText("$mDay/$mMonth/$mYear")
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        en.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this@Order,
                OnDateSetListener { _, mYear, mMonth, mDay ->
                    en.setText("$mDay/$mMonth/$mYear")
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        submit.setOnClickListener {
            val progressBar = ProgressDialog(this@Order)
            progressBar.setTitle("E-Trade")
            progressBar.setMessage("Loading Please wait\n Please wait ")
            progressBar.show()
            val phone = ph.text.toString().take(9)
            val amountSaved = product.text.toString()
            val fullName = m.text.toString()
            val startDate = st.text.toString()
            val endDate = en.text.toString()
            if (amountSaved.isNotBlank() && fullName.isNotBlank() && startDate.isNotBlank() && endDate.isNotBlank() && phone.isNotBlank()) {
                Toast.makeText(this@Order, "Thanks for Validating Info ", Toast.LENGTH_SHORT)
                    .show()

                val intent= Intent(this,MainActivity::class.java)
                intent.putExtra("name",fullName)
                intent.putExtra("amount",amountSaved)
                intent.putExtra("start",startDate)
                intent.putExtra("stop",endDate)
                intent.putExtra("phone",phone)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this@Order, " Fill in Missing Fields ", Toast.LENGTH_SHORT).show()
                progressBar.hide()
            }

        }


    }
}