package pt.ipbeja.twdm.pdm2.bloodconnect.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.ramotion.circlemenu.CircleMenuView;

import pt.ipbeja.twdm.pdm2.bloodconnect.R;
import pt.ipbeja.twdm.pdm2.bloodconnect.ui.MainActivity;

public class RegisterActivity extends AppCompatActivity {

    private final String KEY_LAT = "lat";
    private final String KEY_LON = "lon";

    private CircleMenuView circleMenuView;
    private RegisterViewModel viewModel;
    private Button submitButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        cacheViews();
        this.context = this;

        submitButton.setEnabled(false);
        submitButton.setOnClickListener(submitButtonView -> {
        });

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            MainActivity.startActivity(context, bundle.get(KEY_LAT).toString(), bundle.get(KEY_LON).toString());
            finish();
        }

        this.viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        this.circleMenuView.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationEnd| index: " + index);
                viewModel.onBloodTypeClicked(index);
                submitButton.setEnabled(viewModel.getChosenBloodType() != null);
            }
        });
    }

    private void cacheViews(){
        this.circleMenuView = findViewById(R.id.circleMenuBloodType);
        this.submitButton = findViewById(R.id.buttonRegisterActivitySubmit);
    }
}