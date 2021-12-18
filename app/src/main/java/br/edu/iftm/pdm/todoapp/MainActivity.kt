package br.edu.iftm.pdm.todoapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var etxtTarefa: EditText
    private lateinit var swtUrgent: Switch
    private lateinit var rv_task_list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.etxtTarefa = findViewById(R.id.etxtTarefa)
        this.swtUrgent = findViewById(R.id.swtUrgent)
        this.rv_task_list = findViewById(R.id.rv_task_list)

        val mAdapter: MyAdapter = MyAdapter()
    }

    fun onClickSend(v: View) {
        if(this.etxtTarefa.text.toString().isNotEmpty()) {
            val itemView = View.inflate(this, R.layout.card_layout, null)
            val txtBackground: TextView = itemView.findViewById(R.id.txtBackground)
            val txtTask: TextView = itemView.findViewById(R.id.txtTask)
            txtTask.text = this.etxtTarefa.text.toString()
            if(this.swtUrgent.isChecked) {
                txtBackground.setBackgroundColor(Color.RED)
            } else {
                txtBackground.setBackgroundColor(Color.GREEN)
            }

            this.lnvTaskList.addView(itemView)
            this.etxtTarefa.setText("")
        }
    }
}