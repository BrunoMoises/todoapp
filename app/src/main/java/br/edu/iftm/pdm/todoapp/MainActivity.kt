package br.edu.iftm.pdm.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var etxtInteger: EditText? = null
    private var txtHistory: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.etxtInteger = findViewById(R.id.etxtTarefa)
        this.txtHistory = findViewById(R.id.txtHistory)
    }

    fun onClickSend(v: View) {
        val valueStr: String = this.etxtInteger?.text.toString()
        if(valueStr.isNotEmpty()) {
            this.txtHistory?.append(valueStr)
            this.etxtInteger?.setText("")
        }
        this.txtHistory?.append("\n")
    }
}