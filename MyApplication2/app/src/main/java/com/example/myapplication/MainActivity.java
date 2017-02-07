package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;
import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.lang.System.err;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void textEdit(View view){
        Intent intent = new Intent(MainActivity.this, NoteEditor.class);
        //MainActivity.this.startActivity(intent);

        //starting activity for result which will be sent back from
        //my text editor acitvity
        MainActivity.this.startActivityForResult(intent, 1);
    }


    //called once the text editor returns
    public void onActivityResult(int reqCode, int resulCode, Intent in){

        if(reqCode == reqCode){
            if(resulCode== RESULT_OK){
                //setting up the text field  to display the phone# which was found
                TextView myAwesomeTextView = (TextView)findViewById(R.id.textMessageBack);
                myAwesomeTextView.setText(in.getData().toString());
                Log.i("Got message back", in.getData().toString());
            }
            else{
                //setting up the text field  to display no phone# was found
                TextView myAwesomeTextView = (TextView)findViewById(R.id.textMessageBack);
                myAwesomeTextView.setText("there was no valid phone number :-( !");
                Log.i("Got message back", "there was no valid phone number :-( !");
            }
        }

    }

    //function which will be called when buttonBrwser is clicked
    public void browsURL(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://developer.android.com/index.html"));
        startActivity(intent);
    }





}
