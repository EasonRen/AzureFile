package win.nicecode.azurefile.network;

import retrofit2.Call;
import win.nicecode.azurefile.bean.AzureFileStatus;

/**
 * Created by Eason.Ren on 1/22/2018.
 */

public class DataManager {
    private static DataManager dataManager;
    private ApiServiceInterface apiService;

    private DataManager() {
        apiService = RetrofitClient.getInstance().getApiService();
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            synchronized (DataManager.class) {
                dataManager = new DataManager();
            }
        }
        return dataManager;
    }

    public Call<AzureFileStatus> getAzureFileStatus() {
        return apiService.getAzureFileStatus();
    }
}
