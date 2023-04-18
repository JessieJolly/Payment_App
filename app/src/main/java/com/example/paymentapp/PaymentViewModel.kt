package com.example.paymentapp

import androidx.lifecycle.ViewModel
import com.example.paymentapp.data.PayBalanceDataClass
import kotlin.properties.Delegates


class PaymentViewModel: ViewModel() {
    private val data = PayBalanceDataClass(2000)
    private lateinit var transferToName: String
    private var transferAmount by Delegates.notNull<Int>()

    fun getData(): PayBalanceDataClass {
        return data
    }
    fun setData() {
        data.balance_amount -= transferAmount
    }
    fun setName(name: String) {
        transferToName = name
    }
    fun getName(): String {
        return transferToName
    }
    fun setAmount(amount: Int) {
        transferAmount = amount
    }
    fun getAmount(): Int {
        return transferAmount
    }
}