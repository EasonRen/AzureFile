package win.nicecode.azurefile.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import win.nicecode.azurefile.R;

public class MainActivity extends AppCompatActivity {
    private int clickCount = 0;
    OkHttpClient client = new OkHttpClient();

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.imageView)
    ImageView imageView;
    //@BindView(R.id.button) Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        try {
            run("https://coredemo.nicecode.win/api/azurefilestatus");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("ok", "mmsd");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // String str = response.body().string();
                    Log.i("ok", response.body().string());
                }
            }
        });
    }

    @OnClick(R.id.button)
    void helloClick() {
        clickCount++;
        textView.setText("任义" + clickCount);
        ImageLoader.getInstance().displayImage("http://pic1.win4000.com/pic/e/c0/2b9d350143.jpg", imageView);
    }
}
