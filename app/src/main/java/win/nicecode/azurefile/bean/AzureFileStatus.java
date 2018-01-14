package win.nicecode.azurefile.bean;

/**
 * Created by eason on 2018/1/5.
 */

public class AzureFileStatus {
    private String LastCheckDate;

    private QueueMessageCount QueueMessageCount;

    private AzureFileCount Carrie;

    private AzureFileCount Dispatcher;

    private AzureFileCount DBPost;

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

    public AzureFileCount getCarrie() {
        return Carrie;
    }

    public void setCarrie(AzureFileCount carrie) {
        Carrie = carrie;
    }

    public AzureFileCount getDispatcher() {
        return Dispatcher;
    }

    public void setDispatcher(AzureFileCount dispatcher) {
        Dispatcher = dispatcher;
    }

    public AzureFileCount getDBPost() {
        return DBPost;
    }

    public void setDBPost(AzureFileCount DBPost) {
        this.DBPost = DBPost;
    }
}
