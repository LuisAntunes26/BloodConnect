package pt.ipbeja.twdm.pdm2.bloodconnect;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import pt.ipbeja.twdm.pdm2.bloodconnect.login.RegisterActivity;

public class FireBaseManager extends FirebaseMessagingService{
    private final String TOKEN_TAG = "TOKEN_TAG";
    private final String NOTIFICATION_TAG = "NOTIFICATION_TAG";
    private final int LAT_INDEX = 0;
    private final int LON_INDEX = 1;

    private Context context;


    public FireBaseManager(){
    }

    public void getToken(Context context){
        this.context = context;
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TOKEN_TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d(TOKEN_TAG, token);
                        Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        if(message.getNotification() != null){
            Log.i(NOTIFICATION_TAG, message.getNotification().getTitle());
            Log.i(NOTIFICATION_TAG, message.getNotification().getBody());
            Log.i(NOTIFICATION_TAG, String.valueOf(message.getData().values().toArray()[LAT_INDEX]));
            Log.i(NOTIFICATION_TAG, String.valueOf(message.getData().values().toArray()[LON_INDEX]));
            Log.i(NOTIFICATION_TAG, "------------");
        }else {
            Log.i(NOTIFICATION_TAG, "Null Message");
        }
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
    }

}
