package gr.aueb.cf.registrerformsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView welcomeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTV = findViewById(R.id.welcomeTV);

        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        welcomeTV.setText("Welcome " + user + ". Your registration with " + email + " is completed.");
    }
}