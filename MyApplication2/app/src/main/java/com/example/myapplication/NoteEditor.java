package com.example.myapplication;

//sources:
//http://www.vogella.com/tutorials/JavaRegularExpressions/article.html

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.myapplication.R.styleable.View;

/**
 * Created by Jor on 1/31/2017.
 */

public class NoteEditor extends Activity {


    String textEntered;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext);
        //getText(R.id.textEditor);


        Button button = (Button) findViewById(R.id.buttonPhoneSearch);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //getting the text from the text field
                EditText et = (EditText)findViewById(R.id.textEditor);
                String entered = et.getText().toString();
               // int converted = Integer.parseInt(entered);
                Log.i("Entered Text is: ", entered);

                //creating a patern object
               // Pattern p = Pattern.compile("\\([0-9][0-9][0-9]\\)( |)[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]");
               // Pattern p = Pattern.compile("\\([0-9][0-9][0-9]\\)( |)[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]");

                //bachka otdsds
               // Pattern p = Pattern.compile("(\\([0-9][0-9][0-9]\\))? ?\\(?[0-9][0-9][0-9]\\)?-[0-9][0-9][0-9][0-9]");


                Pattern p = Pattern.compile("(\\([0-9][0-9][0-9]\\))? ?\\(?[0-9][0-9][0-9]\\)?-[0-9][0-9][0-9][0-9]");
                //Pattern p1 = Pattern.compile("[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]");
               // Pattern p1 = Pattern.compile("\\([0-9][0-9][0-9]\\)( |)[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]");
                //"\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$"
                //"\\([0-9][0-9][0-9]\\)( |)[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]"
                //Pattern p1 = Pattern.compile("[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]");

                //creating a matcher object
                Matcher m = p.matcher(entered);

                //creating an intent which will be used to send the result back to
                //the calling activity - either a phone was found or that
                //one wasn't found

                Intent in = new Intent();

                while(m.find()) {

                    //when match was found we create ne intent and set the action to \
                    //action_dial

                        Intent letsDial = new Intent(Intent.ACTION_DIAL);
                        Log.i("and m.group: ", m.group());
                        letsDial.setData(Uri.parse("tel:"+ m.group()));

                        in.setData(Uri.parse("tel:"+ m.group()));
                        setResult(RESULT_OK, in);

                        startActivityForResult(letsDial,1);

                }



            }
        });

    }

}
