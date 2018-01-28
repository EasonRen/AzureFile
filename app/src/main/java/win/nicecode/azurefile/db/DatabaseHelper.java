package win.nicecode.azurefile.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eason on 2018/1/24.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context,"",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // db.execSQL(CREATE_NEWS_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
