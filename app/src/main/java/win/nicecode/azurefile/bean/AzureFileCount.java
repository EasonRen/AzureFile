package win.nicecode.azurefile.bean;

import java.io.Serializable;

/**
 * Created by eason on 2018/1/5.
 */

public class AzureFileCount implements Serializable {
    private FileCount Carrie;
    private FileCount Dispatcher;
    private FileCount DBPost;

    public FileCount getCarrie() {
        return Carrie;
    }

    public void setCarrie(FileCount carrie) {
        Carrie = carrie;
    }

    public FileCount getDispatcher() {
        return Dispatcher;
    }

    public void setDispatcher(FileCount dispatcher) {
        Dispatcher = dispatcher;
    }

    public FileCount getDBPost() {
        return DBPost;
    }

    public void setDBPost(FileCount DBPost) {
        this.DBPost = DBPost;
    }
}
