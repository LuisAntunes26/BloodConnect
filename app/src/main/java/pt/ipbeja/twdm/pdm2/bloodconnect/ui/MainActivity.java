package pt.ipbeja.twdm.pdm2.bloodconnect.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import pt.ipbeja.twdm.pdm2.bloodconnect.R;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_LAT = "lat";
    private static final String KEY_LON = "lon";

    private TextView textViewLat;
    private TextView textViewLon;

    public static void startActivity(Context context, String lat, String lon){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(KEY_LAT, lat);
        intent.putExtra(KEY_LON, lon);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cacheViews();

        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
        textViewLat.setText(bundle.getString(KEY_LAT));
        textViewLon.setText(bundle.getString(KEY_LON));
        }
    }

    private void cacheViews(){
        this.textViewLat = findViewById(R.id.textViewLat);
        this.textViewLon = findViewById(R.id.textViewLon);

    }
}