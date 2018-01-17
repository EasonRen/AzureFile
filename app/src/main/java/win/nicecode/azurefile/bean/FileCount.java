package win.nicecode.azurefile.bean;

import java.io.Serializable;

/**
 * Created by Eason.Ren on 1/17/2018.
 */

public class FileCount implements Serializable {
    private int In;
    private int Out;
    private int Error;

    public void setIn(int In){
        this.In = In;
    }

    public int getIn(){
        return this.In;
    }

    public void setOut(int Out){
        this.Out = Out;
    }

    public int getOut(){
        return this.Out;
    }

    public void setError(int Error){
        this.Error = Error;
    }

    public int getError(){
        return this.Error;
    }
}
