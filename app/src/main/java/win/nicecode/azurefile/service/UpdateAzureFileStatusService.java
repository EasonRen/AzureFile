package win.nicecode.azurefile.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import win.nicecode.azurefile.activity.MainActivity;
import win.nicecode.azurefile.bean.AzureFileStatus;
import win.nicecode.azurefile.network.ApiServiceInterface;
import win.nicecode.azurefile.network.RetrofitClient;
import win.nicecode.azurefile.utils.AppConfig;

public class UpdateAzureFileStatusService extends Service {
    private Timer timer;
    private TimerTask timerTask;

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
                RetrofitClient.getInstance()
                        .createApi(ApiServiceInterface.class)
                        .getAzureFileStatus().enqueue(new Callback<AzureFileStatus>() {
                    @Override
                    public void onResponse(Call<AzureFileStatus> c, Response<AzureFileStatus> response) {
                        AzureFileStatus result = response.body();
                        intent.putExtra("bin", result.getQueueMessageCount().getBin());
                        intent.putExtra("algorithm", result.getQueueMessageCount().getAlgorithm());
                        intent.putExtra("dbpost", result.getQueueMessageCount().getDBPost());
                        sendBroadcast(intent);
                    }

                    @Override
                    public void onFailure(Call<AzureFileStatus> c, Throwable t) {
                        t.printStackTrace();
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
