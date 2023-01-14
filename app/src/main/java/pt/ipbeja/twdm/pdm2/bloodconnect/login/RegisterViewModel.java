package pt.ipbeja.twdm.pdm2.bloodconnect.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class RegisterViewModel extends AndroidViewModel{

    private String[] bloodTypes = {"ab+", "ab-", "b+", "b-", "o+", "o-", "a+", "a-"};
    private String chosenBloodType;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public void onBloodTypeClicked(int index) {
        this.chosenBloodType = this.bloodTypes[index];
    }

    public void onSubmitClick(){

    }

    public String getChosenBloodType() {
        return chosenBloodType;
    }
}
