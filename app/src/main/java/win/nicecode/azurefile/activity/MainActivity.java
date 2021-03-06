package win.nicecode.azurefile.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import win.nicecode.azurefile.R;
import win.nicecode.azurefile.bean.AzureFileStatus;
import win.nicecode.azurefile.network.DataManager;
import win.nicecode.azurefile.service.UpdateAzureFileStatusService;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_UPDATE_AZURE = "action.updateAzure";
    public static final String DATETIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss.SSS";
    public UpdateAzureFileStatusReceiver updateAzureFileStatusBroadcastReceiver;

    @BindView(R.id.txtBinQueueCount)
    TextView binQueueCountView;
    @BindView(R.id.txtAlgorithmQueueCount)
    TextView algorithmQueueView;
    @BindView(R.id.txtDBPostQueueCount)
    TextView dbpostQueueView;

    @BindView(R.id.carrierInCount)
    TextView carrierInCountView;
    @BindView(R.id.carrierOutCount)
    TextView carrierOutCountView;
    @BindView(R.id.carrierErrorCount)
    TextView carrierErrorCountView;

    @BindView(R.id.dispatcherInCount)
    TextView dispatcherInCountView;
    @BindView(R.id.dispatcherOutCount)
    TextView dispatcherOutCountView;
    @BindView(R.id.dispatcherErrorCount)
    TextView dispatcherErrorCountView;

    @BindView(R.id.dbpostInCount)
    TextView dbpostInCountView;
    @BindView(R.id.dbpostOutCount)
    TextView dbpostOutCountView;
    @BindView(R.id.dbpostErrorCount)
    TextView dbpostErrorCountView;

    @BindView(R.id.lastCheckTime)
    TextView lastCheckTimeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_UPDATE_AZURE);
        updateAzureFileStatusBroadcastReceiver = new UpdateAzureFileStatusReceiver();
        registerReceiver(updateAzureFileStatusBroadcastReceiver, filter);

        bindData();
        initService();
    }

    @OnClick(R.id.button)
    public void helloClick() {
        bindData();
    }

    private void bindData() {
        DataManager.getInstance()
                .getAzureFileStatus()
                .enqueue(new Callback<AzureFileStatus>() {
                    @Override
                    public void onResponse(Call<AzureFileStatus> c, Response<AzureFileStatus> response) {
                        AzureFileStatus result = response.body();
                        bindViewData(result);

                        Toast toast = Toast.makeText(MainActivity.this, "refresh success", 2*1000);
                        toast.show();
                    }

                    @Override
                    public void onFailure(Call<AzureFileStatus> c, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    private void initService() {
        Intent i = new Intent(this, UpdateAzureFileStatusService.class);
        i.setAction("win.nicecode.azurefile.service.UpdateAzureFileStatusService");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startService(i);
    }

    private void bindViewData(AzureFileStatus azureFileStatus) {
        if (azureFileStatus == null)
            return;

        binQueueCountView.setText(String.valueOf(azureFileStatus.getQueueMessageCount().getBin()));
        algorithmQueueView.setText(String.valueOf(azureFileStatus.getQueueMessageCount().getAlgorithm()));
        dbpostQueueView.setText(String.valueOf(azureFileStatus.getQueueMessageCount().getDBPost()));

        carrierInCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getCarrie().getIn()));
        carrierOutCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getCarrie().getOut()));
        carrierErrorCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getCarrie().getError()));

        dispatcherInCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getDispatcher().getIn()));
        dispatcherOutCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getDispatcher().getOut()));
        dispatcherErrorCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getDispatcher().getError()));

        dbpostInCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getDBPost().getIn()));
        dbpostOutCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getDBPost().getOut()));
        dbpostErrorCountView.setText(String.valueOf(azureFileStatus.getAzureFileCount().getDBPost().getError()));

        Date date = null;
        SimpleDateFormat utcDateFormat = new SimpleDateFormat(DATETIME_FORMAT_STRING);
        SimpleDateFormat localDateFormat = new SimpleDateFormat(DATETIME_FORMAT_STRING);
        utcDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        localDateFormat.setTimeZone(TimeZone.getDefault());
        try {
            date = utcDateFormat.parse(azureFileStatus.getLastCheckDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            lastCheckTimeView.setText(localDateFormat.format(date.getTime()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(updateAzureFileStatusBroadcastReceiver);
    }

    private class UpdateAzureFileStatusReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            AzureFileStatus azureFileStatus = (AzureFileStatus) intent.getSerializableExtra("filestatus");
            bindViewData(azureFileStatus);
        }
    }
}
