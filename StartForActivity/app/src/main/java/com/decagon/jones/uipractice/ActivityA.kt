package com.decagon.jones.uipractice


import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ActivityA : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText: EditText


    }

    public fun onClick(view: View): Unit {

        val editText: EditText = findViewById<EditText>(R.id.editText)

        val intent: Intent = Intent(this, ActivityB::class.java)

        val myString: String = editText.getText().toString()

        intent.putExtra("Question", myString);

        startActivityForResult(intent, 100)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val editText: EditText = findViewById<EditText>(R.id.editText)
        editText.setText("")
        if(requestCode == 100 && resultCode == RESULT_OK){
            val textView1 = findViewById<View>(R.id.editTextView1) as TextView

            textView1.setText(data?.getStringExtra("Answer"))
        }
    }
}