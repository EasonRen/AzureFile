package win.nicecode.azurefile.network;

import retrofit2.Call;
import retrofit2.http.GET;
import win.nicecode.azurefile.bean.AzureFileStatus;

/**
 * Created by eason on 2018/1/5.
 */

public interface ApiServiceInterface {
    @GET("azurefilestatus")
    Call<AzureFileStatus> getAzureFileStatus();
}
