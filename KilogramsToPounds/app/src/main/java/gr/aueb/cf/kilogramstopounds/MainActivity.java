package gr.aueb.cf.kilogramstopounds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView header;
    private TextView unitConverter;
    private TextView EnterKilosPrompt;
    private EditText userEnterKilos;
    private Button convert;
    private TextView pounds;
    private TextView result;
    private String kilosTxt;
    private double kilos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEnterKilos = findViewById(R.id.userEnterKilos);
        convert = findViewById(R.id.convert);
        result = findViewById(R.id.result);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            kilosTxt = userEnterKilos.getText().toString().trim();
            try {
                kilos = Double.parseDouble(kilosTxt);
                result.setText(Double.toString(kilos * 2.205));
            } catch (Exception e) {
                    System.out.println("Invalid input");
                }

            }
        });
    }
}