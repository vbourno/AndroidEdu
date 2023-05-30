package gr.aueb.cf.customlistview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        String[] friends = {
                "First",
                "Second",
                "Third",
                "Fourth",
                "First",
                "Second",
                "Third",
                "Fourth",
                "First",
                "Second",
                "Third",
                "Fourth",
                "First",
                "Second",
                "Third",
                "Fourth"
        };

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                                this,
                                R.layout.item_view,
                                R.id.myItemTV,
                                friends);

        listView.setAdapter(arrayAdapter);
    }
}