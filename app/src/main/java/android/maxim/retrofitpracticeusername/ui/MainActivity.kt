package android.maxim.retrofitpracticeusername.ui

import android.maxim.retrofitpracticeusername.R
import android.maxim.retrofitpracticeusername.app.App
import android.maxim.retrofitpracticeusername.model.APIService
import android.maxim.retrofitpracticeusername.model.UserResponse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var inputId: EditText
    lateinit var outputFirstName: TextView
    private val model: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputId = findViewById(R.id.et_enter_id)
        outputFirstName = findViewById(R.id.tv_output_firstName)

        findViewById<Button>(R.id.btn_show_name).setOnClickListener { getUserData() }
    }

    private fun getUserData() {
        val id = inputId.text.toString().toInt()
        model.getUserData(id)
        outputFirstName.text = model.outputFirstName
    }

    companion object {
        const val BaseUrl = "https://dummyjson.com/"
    }
}