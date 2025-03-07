package com.example.a123

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a123.R

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var btnCheck: Button
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        btnCheck = findViewById(R.id.btnCheck)
        txtResult = findViewById(R.id.txtResult)

        btnCheck.setOnClickListener {
            checkAge()
        }
    }

    private fun checkAge() {
        val name = edtName.text.toString().trim()
        val ageStr = edtAge.text.toString().trim()

        if (name.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }

        val age = ageStr.toIntOrNull()
        if (age == null) {
            Toast.makeText(this, "Tuổi phải là số", Toast.LENGTH_SHORT).show()
            return
        }

        val category = when {
            age > 65 -> "Người già"
            age >= 6 -> "Người lớn"
            age >= 2 -> "Trẻ em"
            else -> "Em bé"
        }

        txtResult.text = "Xin chào $name, bạn là $category"
    }
}

