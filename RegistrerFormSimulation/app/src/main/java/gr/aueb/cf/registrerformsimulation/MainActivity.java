package gr.aueb.cf.registrerformsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText usernameET;
    private EditText emailET;
    private EditText passwordET;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameET = findViewById(R.id.usernameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString().trim();
                String email = emailET.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}