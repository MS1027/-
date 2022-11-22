package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        switch (v.getId()){
            case R.id.btnTest1:
                Intent resultIntent1 = new Intent(this, SubActivity.class);
                PendingIntent contentIntent1 = PendingIntent.getActivity(this, 0,
                        resultIntent1, PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);


                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this, "notification_ch_id");
                builder1.setSmallIcon(R.mipmap.ic_launcher);
                builder1.setContentTitle("첫 번째 알림 제목");
                builder1.setContentText("첫 번째 알림 텍스트");
                builder1.setContentIntent(contentIntent1);
                builder1.setAutoCancel(true);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    builder1.setSmallIcon(R.drawable.ic_launcher_foreground);
                    CharSequence channelName = "notification channel";
                    String description = "오레오 이상을 위한 것임";
                    int importance = NotificationManager.IMPORTANCE_HIGH;

                    NotificationChannel channel = new NotificationChannel("notification_ch_id", channelName, importance);
                    channel.setDescription(description);

                    assert notificationManager != null;
                    notificationManager.createNotificationChannel(channel);
                } else builder1.setSmallIcon(R.mipmap.ic_launcher);

                assert notificationManager != null;

                notificationManager.notify(0, builder1.build());
                break;

            case R.id.btnTest2:
                Intent resultIntent2 = new Intent(this, SubActivity.class);
                PendingIntent contentIntent2 = PendingIntent.getActivity(this, 0,
                        resultIntent2, PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, "notification_ch_id");
                builder2.setSmallIcon(R.mipmap.ic_launcher);
                builder2.setContentTitle("두 번째 알림 제목");
                builder2.setContentText("두 번째 알림 텍스트");
                builder2.setContentIntent(contentIntent2);
                builder2.setAutoCancel(true);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    builder2.setSmallIcon(R.drawable.ic_launcher_foreground);
                    CharSequence channelName = "notification channel";
                    String description = "오레오 이상을 위한 것임";
                    int importance = NotificationManager.IMPORTANCE_HIGH;

                    NotificationChannel channel = new NotificationChannel("notification_ch_id", channelName, importance);
                    channel.setDescription(description);

                    assert notificationManager != null;
                    notificationManager.createNotificationChannel(channel);
                } else builder2.setSmallIcon(R.mipmap.ic_launcher);

                assert notificationManager != null;

                notificationManager.notify(0, builder2.build());
                break;
        }
    }
}