package gr.aueb.cf.phonecallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView number2TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        number2TV = findViewById(R.id.number2TV);
        Intent call = getIntent();
        String phNum = call.getStringExtra("number");
        number2TV.setText(phNum);
        call(Intent.ACTION_CALL, Uri.parse(phNum));
    }

    private void call(String actionCall, Uri parse) {

    }
}