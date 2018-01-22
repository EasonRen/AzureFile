package win.nicecode.azurefile.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import win.nicecode.azurefile.utils.AppConfig;

/**
 * Created by eason on 2018/1/9.
 */

public class RetrofitClient {
    private Retrofit retrofit;
    private ApiServiceInterface apiService;
    private static RetrofitClient mInstance;

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                mInstance = new RetrofitClient();
            }
        }
        return mInstance;
    }

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_WEB_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiServiceInterface.class);
    }

    public ApiServiceInterface getApiService() {
        return apiService;
    }

    //    public <T> T createApi(Class<T> apiService){
//        return retrofit.create(apiService);
//    }
}
