package com.decagon.jones.uipractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val extras:Bundle? = getIntent().getExtras()
        if (extras == null) {
            return;
        }

        val qString:String? = extras.getString("Question")
        val textView:TextView = findViewById<TextView>(R.id.questiontextView)

        textView.setText(qString);

    }

    public fun onClick(view: View): Unit {

      finish()


    }

    override fun finish() {
        val editText: EditText = findViewById<EditText>(R.id.questionEditView)
        val intent: Intent = Intent(this, ActivityA::class.java)

        val myString: String = editText.getText().toString()
        intent.putExtra("Answer", myString);
        setResult(RESULT_OK, intent);
        super.finish()
    }
    }
