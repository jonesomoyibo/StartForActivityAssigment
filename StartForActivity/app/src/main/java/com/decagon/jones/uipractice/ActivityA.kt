package com.decagon.jones.uipractice



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



    }

    public fun onClick(view: View): Unit {

        val editTextView: EditText = findViewById<EditText>(R.id.questionEditView)

        val intent: Intent = Intent(this, ActivityB::class.java)

        val myString: String = editTextView.getText().toString()

        intent.putExtra("Question", myString);

        startActivityForResult(intent, 100)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val editText: EditText = findViewById<EditText>(R.id.questionEditView)
        editText.setText("")
        if(requestCode == 100 && resultCode == RESULT_OK){
            val answerTextView = findViewById<View>(R.id.answerTextView) as TextView

            answerTextView.setText(data?.getStringExtra("Answer"))
        }
    }
}