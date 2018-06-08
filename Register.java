package kashika.jain.sjsu.edu.heartprediction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import static kashika.jain.sjsu.edu.heartprediction.R.array.age_values;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
Button bRegister;
EditText etName, etUsername, etPassword;
Spinner spin_age, spin_sex;
SQLiteOpenHelper openHelper;
SQLiteDatabase db;
    String name1;
    String age1;
    String sex1;
    String username1;
    String passwrd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addListOnSpin_age();
        addListOnSpin_sex();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        openHelper = new DatabaseHelper(this);
        etName = (EditText)findViewById(R.id.editText_name);
        etUsername = (EditText)findViewById(R.id.editText_username);
        spin_age = (Spinner)findViewById(R.id.spin_age);
        spin_sex = (Spinner)findViewById(R.id.spin_sex);
        etPassword = (EditText)findViewById(R.id.editText_password);
        bRegister = (Button)findViewById(R.id.btn_register);
        bRegister.setOnClickListener(this);
//        openHelper = new DatabaseHelper(this);
//        db=openHelper.getReadableDatabase();
    }


    public void addListOnSpin_age()
    {
        Spinner spin_age = (Spinner) findViewById(R.id.spin_age);
        spin_age.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Register.this, android.R.layout.simple_list_item_1, getResources().getStringArray(age_values));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_age.setAdapter(adapter);
    }

    public void addListOnSpin_sex(){
        Spinner spin_sex = (Spinner) findViewById(R.id.spin_sex);
        spin_sex.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Register.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sex_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_sex.setAdapter(adapter1);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()) {
            case R.id.spin_age:
                String str_age = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(),"Selected : "+ str_age, Toast.LENGTH_LONG).show();
            case R.id.spin_sex:
                String str_sex = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(),"Selected : "+ str_sex, Toast.LENGTH_LONG).show();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.btn_register:

//            String email1 = etUsername.getText().toString();
//            String passwrd1 = etPassword.getText().toString();
//
//            cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL5+ "=? AND " + DatabaseHelper.COL6+ "=?", new String[]{email1, passwrd1});
//            if(cursor!=null){
//                if(cursor.getCount()>0){
//                    Toast.makeText(getApplicationContext(),"Email adress already exists",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
                    db = openHelper.getWritableDatabase();
                    name1 = etName.getText().toString();
                    age1 = spin_age.getSelectedItem().toString();
                    sex1 = spin_sex.getSelectedItem().toString();
                    username1 = etUsername.getText().toString();
                    passwrd1 = etPassword.getText().toString();
                    User registerdData = new User(name1, age1, sex1, username1,passwrd1);
                    validateData();
            if(!validateData())
            {
                Toast.makeText(getApplicationContext(), "Signup failed", Toast.LENGTH_LONG).show();
            }
                    else{
                    insertdata(name1, age1, sex1, username1, passwrd1);
                }

            break;
    }
    }
    public boolean validateData(){

    boolean valid = true;
    if(name1.isEmpty() | name1.length()>32 | name1.length()<2){
        etName.setError("Please enter valid name");
        valid = false;
    }
    if(!name1.matches("[a-zA-Z0-9]+")){
            etName.setError("Please enter valid name");
            valid = false;
        }
    if(username1.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(username1).matches()){
            etUsername.setError("Please enter valid Email address");
            valid = false;
    }
        if(passwrd1.isEmpty() ){
            etPassword.setError("Please enter Password");
            valid = false;
        }
    return valid;
    }


    public void insertdata(String name, String age, String sex, String username, String passwrd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL2, name);
        contentValues.put(DatabaseHelper.COL3, age);
        contentValues.put(DatabaseHelper.COL4, sex);
        contentValues.put(DatabaseHelper.COL5, username);
        contentValues.put(DatabaseHelper.COL6, passwrd);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null, contentValues);
        if (id == -1)
        {
            Toast.makeText(getApplicationContext(),"Email adress already exists",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "registered success", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Register.this, SignIn.class);
            startActivity(i);
        }
    }

}
