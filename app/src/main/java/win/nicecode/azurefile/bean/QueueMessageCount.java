package win.nicecode.azurefile.bean;

import java.io.Serializable;

/**
 * Created by eason on 2018/1/5.
 */

public class QueueMessageCount implements Serializable {
    private int Bin;
    private int Algorithm;
    private int DBPost;

    public void setBin(int Bin){
        this.Bin = Bin;
    }

    public int getBin(){
        return this.Bin;
    }

    public void setAlgorithm(int Algorithm){
        this.Algorithm = Algorithm;
    }

    public int getAlgorithm(){
        return this.Algorithm;
    }

    public void setDBPost(int DBPost){
        this.DBPost = DBPost;
    }

    public int getDBPost(){
        return this.DBPost;
    }
}
