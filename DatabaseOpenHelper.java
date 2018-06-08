package kashika.jain.sjsu.edu.heartprediction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "userData.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "userData";
    private static final String columnId = "id";
    private static final String columnName = "Name";
    private static final String columnEmail = "Email";
    private static final String columnPassword = "Pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table userData (id integer primary key not null auto_increment,"+
                            "Name text not null, Email text not null, Pass text not null);";

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
