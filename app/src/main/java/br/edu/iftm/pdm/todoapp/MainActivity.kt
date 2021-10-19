package br.edu.iftm.pdm.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var etxtTarefa: EditText? = null
    private var txtHistory: TextView? = null
    private var swtUrgent: Switch? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.etxtTarefa = findViewById(R.id.etxtTarefa)
        this.txtHistory = findViewById(R.id.txtHistory)
        this.swtUrgent = findViewById(R.id.swtUrgent)
    }

    fun onClickSend(v: View) {
        val valueStr: String = this.etxtTarefa?.text.toString()
        if(valueStr.isNotEmpty()) {
            if(this.swtUrgent?.isChecked == true) {
                this.txtHistory?.append(getString(R.string.urgent, valueStr))
            } else {
                this.txtHistory?.append(getString(R.string.not_urgent, valueStr))
            }
            this.txtHistory?.append("\n")
            this.etxtTarefa?.setText("")
        }
    }
}