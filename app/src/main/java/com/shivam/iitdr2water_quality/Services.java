package com.shivam.iitdr2water_quality;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import static com.shivam.iitdr2water_quality.Page1.pools;

public class Services extends Service {

    public static final int notify = 10000;  //interval between two services(Here Service run every 5 Minute)
    private Handler mHandler = new Handler();   //run on another Thread to avoid crash

    @Override
    public void onCreate() {
        if (mTimer != null) // Cancel if already existed
            mTimer.cancel();
        else
            mTimer = new Timer();   //recreate new
        mTimer.scheduleAtFixedRate(new TimeDisplay(), 0, notify);   //Schedule task
    }

    private Timer mTimer = null;    //timer handling


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTimer.cancel();    //For Cancel Timer
    }
    class TimeDisplay extends TimerTask {
        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    String heading="";
                    for (int i=0;i<pools.size();i++){
                        if(pools.get(i).getPh()<pools.get(i).getPhthreshold_min()||pools.get(i).getPh()>pools.get(i).getPhthreshold_max()||pools.get(i).getChlorine()<pools.get(i).getChlorinethreshold_min()||pools.get(i).getChlorine()>pools.get(i).getChlorinethreshold_max()){
                           heading+=pools.get(i).getName()+"\n";
                        }

                    }
                    if(heading.length()>0){
                    NotificationCompat.Builder builder =
                            new NotificationCompat.Builder(Services.this)
                                    .setSmallIcon(R.drawable.ic_launcher_background)
                                    .setContentTitle("NOT SAFE")
                                    .setContentText(heading);

                    Intent notificationIntent = new Intent(Services.this, MainActivity.class);
                    PendingIntent contentIntent = PendingIntent.getActivity(Services.this, 0, notificationIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(contentIntent);

                    // Add as notification
                    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    manager.notify(0, builder.build());

                }
                }
            });
        }
    }
}