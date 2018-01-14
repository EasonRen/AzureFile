package win.nicecode.azurefile.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import win.nicecode.azurefile.R;
import win.nicecode.azurefile.bean.AzureFileStatus;
import win.nicecode.azurefile.network.ApiServiceInterface;
import win.nicecode.azurefile.network.RetrofitClient;
import win.nicecode.azurefile.service.UpdateAzureFileStatusService;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txtBinQueueCount)
    TextView binQueueCountView;
    @BindView(R.id.txtAlgorithmQueueCount)
    TextView algorithmQueueView;
    @BindView(R.id.txtDBPostQueueCount)
    TextView dbpostQueueView;

    public static final String ACTION_UPDATE_AZURE="action.updateAzure";
    public UpdateAzureFileStatusBroadcastReceiver updateAzureFileStatusBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_UPDATE_AZURE);
        updateAzureFileStatusBroadcastReceiver = new UpdateAzureFileStatusBroadcastReceiver();
        registerReceiver(updateAzureFileStatusBroadcastReceiver, filter);

        bindData();
        initServie();
    }

    @OnClick(R.id.button)
    public void helloClick() {
        bindData();
    }

    private void bindData() {

        RetrofitClient.getInstance()
                .createApi(ApiServiceInterface.class)
                .getAzureFileStatus()
                .enqueue(new Callback<AzureFileStatus>() {
            @Override
            public void onResponse(Call<AzureFileStatus> c, Response<AzureFileStatus> response) {
                AzureFileStatus result = response.body();
                binQueueCountView.setText(result.getQueueMessageCount().getBin() + "");
                algorithmQueueView.setText(result.getQueueMessageCount().getAlgorithm() + "");
                dbpostQueueView.setText(result.getQueueMessageCount().getDBPost() + "");
                Log.i("DS", "LAST CHECK DATE:" + result.getLastCheckDate());
            }

            @Override
            public void onFailure(Call<AzureFileStatus> c, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void initServie(){
        Intent i = new Intent(this,  UpdateAzureFileStatusService.class);
        i.setAction("win.nicecode.azurefile.service.UpdateAzureFileStatusService");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startService(i);
    }

    private class UpdateAzureFileStatusBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            binQueueCountView.setText(String.valueOf(intent.getExtras().getInt("bin")));
            algorithmQueueView.setText(String.valueOf(intent.getExtras().getInt("algorithm")));
            dbpostQueueView.setText(String.valueOf(intent.getExtras().getInt("dbpost")));
        }
    }
}
