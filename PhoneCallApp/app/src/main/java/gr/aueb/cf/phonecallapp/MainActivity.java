package gr.aueb.cf.phonecallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numberET;
    private Button callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberET = findViewById(R.id.numberET);
        callBtn = findViewById(R.id.callBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNum = numberET.getText().toString().trim();
                Intent call = new Intent(MainActivity.this, SecondActivity.class);
                call.putExtra("number", phoneNum);
                startActivity(call);
            }
        });
    }
}