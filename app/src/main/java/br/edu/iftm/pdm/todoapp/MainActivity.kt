package br.edu.iftm.pdm.todoapp

import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var etxtTarefa: EditText
    private lateinit var swtUrgent: Switch
    private lateinit var rv_task_list: RecyclerView
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.etxtTarefa = findViewById(R.id.etxtTarefa)
        this.swtUrgent = findViewById(R.id.swtUrgent)
        this.rv_task_list = findViewById(R.id.rv_task_list)


    }

    fun onClickSend() {
        if(this.etxtTarefa.text.toString().isNotEmpty()) {
            var mAdapter: MyAdapter = MyAdapter()
            var txtBackground: Int
            lateinit var txtTask: TextView
            txtTask.text = this.etxtTarefa.text.toString()
            if(this.swtUrgent.isChecked) {
                txtBackground = RED
            } else {
                txtBackground = GREEN
            }
            mAdapter.MyAdapter(this, txtTask.toString(), txtBackground)
            rv_task_list.adapter = mAdapter

            mLayoutManager = LinearLayoutManager(this)
            rv_task_list.layoutManager = mLayoutManager

            rv_task_list.hasFixedSize()
            this.etxtTarefa.setText("")
        }
    }
}