package win.nicecode.azurefile.bean;

import java.io.Serializable;

/**
 * Created by eason on 2018/1/5.
 */

public class AzureFileStatus implements Serializable {
    private String LastCheckDate;
    private QueueMessageCount QueueMessageCount;
    private AzureFileCount AzureFileCount;

    public void setLastCheckDate(String LastCheckDate){
        this.LastCheckDate = LastCheckDate;
    }

    public String getLastCheckDate(){
        return this.LastCheckDate;
    }

    public void setQueueMessageCount(QueueMessageCount QueueMessageCount){
        this.QueueMessageCount = QueueMessageCount;
    }

    public QueueMessageCount getQueueMessageCount(){
        return this.QueueMessageCount;
    }

    public win.nicecode.azurefile.bean.AzureFileCount getAzureFileCount() {
        return AzureFileCount;
    }

    public void setAzureFileCount(win.nicecode.azurefile.bean.AzureFileCount azureFileCount) {
        AzureFileCount = azureFileCount;
    }
}
