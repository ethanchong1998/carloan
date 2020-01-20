package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener{
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        //getting input from user
        val car_price = editTextcarprice.text.toString().toInt()
        val down_payment = downpayment.text.toString().toInt()
        val loan_period = loanperiod.text.toString().toInt()
        val interest_rate= interestrate.text.toString().toFloat()

        val car_loan = car_price-down_payment
        val interest = car_loan*interest_rate*loan_period
        val monthly_repayment = (car_loan+interest)/loan_period/12


        textViewLoan.text= getString(R.string.loan)+": ${car_loan}"
        textViewInterest.text=interest.toString()
        textViewMonthlyrepayment.text=monthly_repayment.toString()

    }
    fun resetInput(view: View){
        editTextcarprice.setText("")
        downpayment.setText("")
        loanperiod.setText("")
        interestrate.setText("")
        textViewLoan.setText("Loan")
        textViewInterest.setText("Interest")
        textViewMonthlyrepayment.setText("Monthly Repayment")


    }
}
