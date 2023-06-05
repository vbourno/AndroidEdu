package gr.aueb.cf.moviesimdbapi2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import gr.aueb.cf.moviesimdbapi2023.adapters.MovieAdapter;
import gr.aueb.cf.moviesimdbapi2023.models.Movie;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    //private MovieAdapter movieAdapter;
    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);
        movieArrayList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        //linearLayoutManager.setReverseLayout(true);   ---- newest on top
        recyclerView.setLayoutManager(linearLayoutManager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().isEmpty()) {
                    editText.setError("Please insert a movie title");
                } else {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    String url = "https://imdb-api.com/en/API/SearchMovie/k_6pg2n139/" + editText.getText().toString().trim();

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                movieArrayList.clear();
                                JSONArray jsonArray = response.getJSONArray("results");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject movieJSONObject = jsonArray.getJSONObject(i);
                                    Movie movie = new Movie();
                                    movie.setId(movieJSONObject.getString("id"));
                                    movie.setTitle(movieJSONObject.getString("title"));
                                    movie.setDescription(movieJSONObject.getString("description"));
                                    movie.setImage(movieJSONObject.getString("image"));
                                    movie.setResultType(movieJSONObject.getString("resultType"));
                                    movieArrayList.add(movie);
                                }
                                recyclerView.setAdapter(new MovieAdapter(getApplicationContext(), movieArrayList));

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                     });

                    requestQueue.add(jsonObjectRequest);
                }
            }
        });
    }
}