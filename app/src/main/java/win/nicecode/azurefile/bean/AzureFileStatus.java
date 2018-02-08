package win.nicecode.azurefile.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by eason on 2018/1/5.
 */

public class AzureFileStatus implements Serializable {
    @SerializedName("ID")
    private int id;
    @SerializedName("BinQueueMessage")
    private int binQueueMessage;
    @SerializedName("AlgorithmQueueMessage")
    private int algorithmQueueMessage;
    @SerializedName("DBpostQueueMessage")
    private int dBpostQueueMessage;
    @SerializedName("CarrierInFile")
    private int carrierInFile;
    @SerializedName("CarrierOutFile")
    private int carrierOutFile;
    @SerializedName("CarrierErrorFile")
    private int carrierErrorFile;
    @SerializedName("DispatcherInFile")
    private int dispatcherInFile;
    @SerializedName("DispatcherOutFile")
    private int dispatcherOutFile;
    @SerializedName("DispatcherErrorFile")
    private int dispatcherErrorFile;
    @SerializedName("DBPostInFile")
    private int dBPostInFile;
    @SerializedName("DBPostOutFile")
    private int dBPostOutFile;
    @SerializedName("DBPostErrorFile")
    private int dBPostErrorFile;
    @SerializedName("UpdateDate")
    private String lastCheckDate;
    @SerializedName("CreateDate")
    private String createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBinQueueMessage() {
        return binQueueMessage;
    }

    public void setBinQueueMessage(int binQueueMessage) {
        this.binQueueMessage = binQueueMessage;
    }

    public int getAlgorithmQueueMessage() {
        return algorithmQueueMessage;
    }

    public void setAlgorithmQueueMessage(int algorithmQueueMessage) {
        this.algorithmQueueMessage = algorithmQueueMessage;
    }

    public int getdBpostQueueMessage() {
        return dBpostQueueMessage;
    }

    public void setdBpostQueueMessage(int dBpostQueueMessage) {
        this.dBpostQueueMessage = dBpostQueueMessage;
    }

    public int getCarrierInFile() {
        return carrierInFile;
    }

    public void setCarrierInFile(int carrierInFile) {
        this.carrierInFile = carrierInFile;
    }

    public int getCarrierOutFile() {
        return carrierOutFile;
    }

    public void setCarrierOutFile(int carrierOutFile) {
        this.carrierOutFile = carrierOutFile;
    }

    public int getCarrierErrorFile() {
        return carrierErrorFile;
    }

    public void setCarrierErrorFile(int carrierErrorFile) {
        this.carrierErrorFile = carrierErrorFile;
    }

    public int getDispatcherInFile() {
        return dispatcherInFile;
    }

    public void setDispatcherInFile(int dispatcherInFile) {
        this.dispatcherInFile = dispatcherInFile;
    }

    public int getDispatcherOutFile() {
        return dispatcherOutFile;
    }

    public void setDispatcherOutFile(int dispatcherOutFile) {
        this.dispatcherOutFile = dispatcherOutFile;
    }

    public int getDispatcherErrorFile() {
        return dispatcherErrorFile;
    }

    public void setDispatcherErrorFile(int dispatcherErrorFile) {
        this.dispatcherErrorFile = dispatcherErrorFile;
    }

    public int getDBPostInFile() {
        return dBPostInFile;
    }

    public void setDBPostInFile(int dBPostInFile) {
        this.dBPostInFile = dBPostInFile;
    }

    public int getDBPostOutFile() {
        return dBPostOutFile;
    }

    public void setdBPostOutFile(int dBPostOutFile) {
        this.dBPostOutFile = dBPostOutFile;
    }

    public int getDBPostErrorFile() {
        return dBPostErrorFile;
    }

    public void setDBPostErrorFile(int dBPostErrorFile) {
        this.dBPostErrorFile = dBPostErrorFile;
    }

    public String getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(String lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
