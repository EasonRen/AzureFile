package win.nicecode.azurefile.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import win.nicecode.azurefile.activity.MainActivity;
import win.nicecode.azurefile.bean.AzureFileStatus;
import win.nicecode.azurefile.network.DataManager;
import win.nicecode.azurefile.utils.AppConfig;

public class UpdateAzureFileStatusService extends Service {
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        final Intent intent = new Intent();
        intent.setAction(MainActivity.ACTION_UPDATE_AZURE);
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                DataManager.getInstance()
                        .getAzureFileStatus()
                        .enqueue(new Callback<AzureFileStatus>() {
                            @Override
                            public void onResponse(Call<AzureFileStatus> c, Response<AzureFileStatus> response) {
                                AzureFileStatus result = response.body();
                                intent.putExtra("filestatus", result);
                                sendBroadcast(intent);
                            }

                            @Override
                            public void onFailure(Call<AzureFileStatus> c, Throwable t) {
                                handler = new Handler(Looper.getMainLooper());
                                handler.post(new Runnable() {
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Bad request", 2 * 1000).show();
                                    }
                                });
                            }
                        });
            }
        };
        timer.schedule(timerTask, AppConfig.REFRESH_INTERVAL * 1000, AppConfig.REFRESH_INTERVAL * 1000);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
