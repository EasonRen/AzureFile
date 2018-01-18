package win.nicecode.azurefile.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by eason on 2018/1/5.
 */

public class AzureFileStatus implements Serializable {
    @SerializedName("LastCheckDate")
    private String lastCheckDate;
    @SerializedName("QueueMessageCount")
    private QueueMessageCount queueMessageCount;
    @SerializedName("AzureFileCount")
    private AzureFileCount azureFileCount;

    public void setLastCheckDate(String LastCheckDate){
        this.lastCheckDate = LastCheckDate;
    }

    public String getLastCheckDate(){
        return this.lastCheckDate;
    }

    public void setQueueMessageCount(QueueMessageCount QueueMessageCount){
        this.queueMessageCount = QueueMessageCount;
    }

    public QueueMessageCount getQueueMessageCount(){
        return this.queueMessageCount;
    }

    public win.nicecode.azurefile.bean.AzureFileCount getAzureFileCount() {
        return azureFileCount;
    }

    public void setAzureFileCount(win.nicecode.azurefile.bean.AzureFileCount azureFileCount) {
        azureFileCount = azureFileCount;
    }
}
