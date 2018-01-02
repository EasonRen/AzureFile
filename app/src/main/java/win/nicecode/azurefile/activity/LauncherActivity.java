package win.nicecode.azurefile.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import win.nicecode.azurefile.R;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        startHomeActivity();
    }

    private void startHomeActivity() {
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            public void run() {
//                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//            }
//        };
//        timer.schedule(task, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherActivity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                finish();
            }
        }, 3000);

    }
}
