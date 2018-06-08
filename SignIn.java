package kashika.jain.sjsu.edu.heartprediction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener{
    Button bLogin, bsignup, blogout;
    EditText etUsername, etPassword;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    UserLocalStore userLocalStore;
    String txt_email,txt_passwrd;
    public static final String SEND_NAME = "kashika.jain.sjsu.edu.heartprediction.SEND_NAME";
    public static final String SEND_AGE = "kashika.jain.sjsu.edu.heartprediction.SEND_AGE";
    public static final String SEND_SEX = "kashika.jain.sjsu.edu.heartprediction.SEND_SEX";
    public static final String SEND_CHEST = "kashika.jain.sjsu.edu.heartprediction.SEND_CHEST";
    public static final String SEND_BPS = "kashika.jain.sjsu.edu.heartprediction.SEND_BPS";
    public static final String SEND_CHOL = "kashika.jain.sjsu.edu.heartprediction.SEND_CHOL";
    public static final String SEND_FBS = "kashika.jain.sjsu.edu.heartprediction.SEND_FBS";
    public static final String SEND_ECG = "kashika.jain.sjsu.edu.heartprediction.SEND_ECG";
    public static final String SEND_HEART = "kashika.jain.sjsu.edu.heartprediction.SEND_HEART";
    public static final String SEND_EXANG = "kashika.jain.sjsu.edu.heartprediction.SEND_EXANG";
    public static final String SENT_VALUE = "kashika.jain.sjsu.edu.heartprediction.SENT_VALUE";
    String rec_name;
    String rec_age;
    String rec_sex;
    String rec_chest;
    String rec_bps;
    String rec_chol;
    String rec_fbs;
    String rec_ecg;
    String rec_heart;
    String rec_exang;
    String  set_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        openHelper = new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        etUsername = (EditText)findViewById(R.id.edit_email);
        etPassword = (EditText)findViewById(R.id.edit_password);
        bLogin = (Button)findViewById(R.id.btn_signin);
        bsignup = (Button)findViewById(R.id.btn_signup);
        bLogin.setOnClickListener(this);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        userLocalStore = new UserLocalStore(this);
        bsignup.setOnClickListener(this);

        Intent intent = getIntent();
        set_value = intent.getStringExtra(PredictInquiryActivity.SENT_VALUE);
        if(set_value != null) {
            rec_age = intent.getStringExtra(Inquiry.SEND_AGE);
            rec_sex = intent.getStringExtra(Inquiry.SEND_SEX);
            rec_chest = intent.getStringExtra(Inquiry.SEND_CHEST);
            rec_bps = intent.getStringExtra(Inquiry.SEND_BPS);
            rec_chol = intent.getStringExtra(Inquiry.SEND_CHOL);
            rec_fbs = intent.getStringExtra(Inquiry.SEND_FBS);
            rec_ecg = intent.getStringExtra(Inquiry.SEND_ECG);
            rec_heart = intent.getStringExtra(Inquiry.SEND_HEART);
            rec_exang = intent.getStringExtra(Inquiry.SEND_EXANG);
            set_value = "X";
        }
        else {
            set_value = null;
        }
    }

    public void onClick(View v) {
    switch (v.getId())
    {
        case R.id.btn_signin:
            txt_email = etUsername.getText().toString();
            txt_passwrd = etPassword.getText().toString();
            validateData();
            if(!validateData())
            {
                Toast.makeText(getApplicationContext(), "Signup failed", Toast.LENGTH_LONG).show();
                break;
            }
            else {
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL5 + "=? AND " + DatabaseHelper.COL6 + "=?", new String[]{txt_email, txt_passwrd});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
//                        Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_LONG).show();
//                        if  (cursor.moveToFirst())
//                        {
//                            int row = cursor.getColumnIndex();
//                            rec_name = cursor.getColumnName(1);
                        cursor.moveToFirst();
                        rec_name = cursor.getString(cursor.getColumnIndex("name"));




//                        }



//                        String age1 = cursor.getString(cursor.getColumnIndex("age"));
//                        String sex1 = cursor.getString(cursor.getColumnIndex("sex"));
//                        String username1 = cursor.getString(cursor.getColumnIndex("username"));
//                        String passwrd1 = cursor.getString(cursor.getColumnIndex("passwrd"));
//                        User registerdData = new User(name1, age1, sex1, username1,passwrd1);
                        userLocalStore.setUserLoggedIn(true);


                        if(set_value !=null){
                            Intent i = new Intent(SignIn.this, PredictionActivity.class);
                            i.putExtra(SEND_AGE,rec_age);
                            i.putExtra(SEND_SEX,rec_sex);
                            i.putExtra(SEND_CHEST,rec_chest);
                            i.putExtra(SEND_BPS,rec_bps);
                            i.putExtra(SEND_CHOL,rec_chol);
                            i.putExtra(SEND_FBS,rec_fbs);
                            i.putExtra(SEND_ECG,rec_ecg);
                            i.putExtra(SEND_HEART,rec_heart);
                            i.putExtra(SEND_EXANG,rec_exang);
                            i.putExtra(SENT_VALUE,set_value);
                            i.putExtra(SEND_NAME,rec_name);
                            startActivity(i);
                            break;
                        }
                        else {
                            Intent i = new Intent(SignIn.this, SensorActivity.class);
                            i.putExtra(SEND_AGE,rec_age);
                            i.putExtra(SEND_SEX,rec_sex);
                            i.putExtra(SEND_CHEST,rec_chest);
                            i.putExtra(SEND_BPS,rec_bps);
                            i.putExtra(SEND_CHOL,rec_chol);
                            i.putExtra(SEND_FBS,rec_fbs);
                            i.putExtra(SEND_ECG,rec_ecg);
                            i.putExtra(SEND_HEART,rec_heart);
                            i.putExtra(SEND_EXANG,rec_exang);
                            i.putExtra(SENT_VALUE,set_value);
                            i.putExtra(SEND_NAME,rec_name);
                            startActivity(i);
                            break;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                        break;
                    }
                }

            }

        case R.id.btn_signup:

            Intent i = new Intent(SignIn.this, Register.class);
            startActivity(i);
            break;


//         case R.id.bLogout:
//            userLocalStore.clearUserData();
//                userLocalStore.setUserLoggedIn(false);
//        Intent i = new Intent(SignIn.this, SignIn.class);
//        startActivity(i);
//        break;
    }
    }

    public boolean validateData(){

        boolean valid = true;

        if(txt_email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(txt_email).matches()){
            etUsername.setError("Please enter valid Email address");
            valid = false;
        }
        if(txt_passwrd.isEmpty() ){
            etPassword.setError("Please enter Password");
            valid = false;
        }
        return valid;
    }
}
