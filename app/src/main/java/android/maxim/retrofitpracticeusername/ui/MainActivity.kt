package android.maxim.retrofitpracticeusername.ui

import android.maxim.retrofitpracticeusername.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var inputId: EditText
    private lateinit var outputFirstName: TextView
    private val model: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputId = findViewById(R.id.et_enter_id)
        outputFirstName = findViewById(R.id.tv_output_firstName)

        showFirstName()

        findViewById<Button>(R.id.btn_show_name).setOnClickListener { getUserData() }
    }

    private fun getUserData() {
        val id = inputId.text.toString().toInt()
        model.getUserData(id)
        showFirstName()
    }

    private fun showFirstName() {
        model.getFirstName()
            .observe(this, Observer { outputFirstName.text = it })
    }

    companion object {
        const val BaseUrl = "https://dummyjson.com/"
    }
}