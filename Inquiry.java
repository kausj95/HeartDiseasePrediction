package kashika.jain.sjsu.edu.heartprediction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static kashika.jain.sjsu.edu.heartprediction.R.array.age_values;


public class Inquiry extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    public Button btn_login;
    public Button btn_submit;
    TextView txt_login;
    ImageView display;
    public static final String SEND_AGE = "kashika.jain.sjsu.edu.heartprediction.SEND_AGE";
    public static final String SEND_SEX = "kashika.jain.sjsu.edu.heartprediction.SEND_SEX";
    public static final String SEND_CHEST = "kashika.jain.sjsu.edu.heartprediction.SEND_CHEST";
    public static final String SEND_BPS = "kashika.jain.sjsu.edu.heartprediction.SEND_BPS";
    public static final String SEND_CHOL = "kashika.jain.sjsu.edu.heartprediction.SEND_CHOL";
    public static final String SEND_FBS = "kashika.jain.sjsu.edu.heartprediction.SEND_FBS";
    public static final String SEND_ECG = "kashika.jain.sjsu.edu.heartprediction.SEND_ECG";
    public static final String SEND_HEART = "kashika.jain.sjsu.edu.heartprediction.SEND_HEART";
    public static final String SEND_EXANG = "kashika.jain.sjsu.edu.heartprediction.SEND_EXANG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        onBtnClicksubmit();
            addListOnSpin_age();
            addListOnSpin_sex();
            addListOnSpin_chestpain();
            addListOnSpin_restbps();
            addListOnSpin_cholesterol();
            addListOnSpin_fbs();
            addListOnSpin_restecg();
            addListOnSpin_heartrate();
            addListOnSpin_exang();
            txt_login = (TextView) findViewById(R.id.link_login);
            txt_login.setOnClickListener(this);
            display = (ImageView)findViewById(R.id.imageViewlogin);
            display.setOnClickListener(this);




    }


    public void addListOnSpin_age()
    {
            Spinner spin_age = (Spinner) findViewById(R.id.spin_age);
            spin_age.setOnItemSelectedListener(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(age_values));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_age.setAdapter(adapter);
    }

    public void addListOnSpin_sex(){
            Spinner spin_sex = (Spinner) findViewById(R.id.spin_sex);
            spin_sex.setOnItemSelectedListener(this);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.sex_values));
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin_sex.setAdapter(adapter1);
    }

    public void addListOnSpin_chestpain(){
        Spinner spin_chest = (Spinner) findViewById(R.id.spin_chest);
        spin_chest.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.chestpain_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_chest.setAdapter(adapter1);
    }
    public void addListOnSpin_restbps(){
        Spinner spin_restbps = (Spinner) findViewById(R.id.spin_restbp);
        spin_restbps.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.restbps_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_restbps.setAdapter(adapter1);
    }
    public void addListOnSpin_cholesterol(){
        Spinner spin_chol = (Spinner) findViewById(R.id.spin_chol);
        spin_chol.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cholesterol_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_chol.setAdapter(adapter1);
    }
    public void addListOnSpin_fbs(){
        Spinner spin_fbs = (Spinner) findViewById(R.id.spin_fbs);
        spin_fbs.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.fbs_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_fbs.setAdapter(adapter1);
    }
    public void addListOnSpin_restecg(){
        Spinner spin_restecg = (Spinner) findViewById(R.id.spin_resecg);
        spin_restecg.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.restecg_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_restecg.setAdapter(adapter1);
    }
    public void addListOnSpin_heartrate(){
        Spinner spin_heartrate = (Spinner) findViewById(R.id.spin_heartrate);
        spin_heartrate.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.heartrate_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_heartrate.setAdapter(adapter1);
    }
    public void addListOnSpin_exang(){
        Spinner spin_exang = (Spinner) findViewById(R.id.spin_exang);
        spin_exang.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Inquiry.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.exang_values));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_exang.setAdapter(adapter1);
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

        void showToast(CharSequence msg) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }


    public void onBtnClicksubmit() {
        btn_submit = (Button) findViewById(R.id.btn_inqsubmit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Spinner spin_age = (Spinner) findViewById(R.id.spin_age);
                Integer send_age1 = spin_age.getSelectedItemPosition();
                String send_age = Integer.toString(send_age1);
//                String send_age = spin_age.getSelectedItem().toString();

                Spinner spin_sex = (Spinner) findViewById(R.id.spin_sex);
                Integer send_sex1 = spin_sex.getSelectedItemPosition();
                String send_sex = Integer.toString(send_sex1);
//                String send_sex = spin_sex.getSelectedItem().toString();

                Spinner spin_chest = (Spinner) findViewById(R.id.spin_chest);
                Integer send_chest1 = spin_chest.getSelectedItemPosition();
                String send_chest = Integer.toString(send_chest1);
//                String send_chest = spin_chest.getSelectedItem().toString();

                Spinner spin_bps = (Spinner) findViewById(R.id.spin_restbp);
                Integer send_bps1 = spin_bps.getSelectedItemPosition();
                String send_bps = Integer.toString(send_bps1);
//                String send_bps = spin_bps.getSelectedItem().toString();

                Spinner spin_chol = (Spinner) findViewById(R.id.spin_chol);
                Integer send_chol1 = spin_chol.getSelectedItemPosition();
                String send_chol = Integer.toString(send_chol1);
//                String send_chol = spin_chol.getSelectedItem().toString();

                Spinner spin_fbs = (Spinner) findViewById(R.id.spin_fbs);
                Integer send_fbs1 = spin_fbs.getSelectedItemPosition();
                String send_fbs = Integer.toString(send_fbs1);
//                String send_fbs = spin_fbs.getSelectedItem().toString();

                Spinner spin_ecg = (Spinner) findViewById(R.id.spin_resecg);
                Integer send_ecg1 = spin_ecg.getSelectedItemPosition();
                String send_ecg = Integer.toString(send_ecg1);
//                String send_ecg = spin_ecg.getSelectedItem().toString();

                Spinner spin_heartrate = (Spinner) findViewById(R.id.spin_heartrate);
                Integer send_heartrate1 = spin_heartrate.getSelectedItemPosition();
                String send_heartrate = Integer.toString(send_heartrate1);
//                String send_heartrate = spin_heartrate.getSelectedItem().toString();

                Spinner spin_exang = (Spinner) findViewById(R.id.spin_exang);
                Integer send_exang1 = spin_exang.getSelectedItemPosition();
                String send_exang = Integer.toString(send_exang1);
//                String send_exang = spin_exang.getSelectedItem().toString();






                Intent i = new Intent(Inquiry.this, PredictInquiryActivity.class);
                i.putExtra(SEND_AGE,send_age);
                i.putExtra(SEND_SEX,send_sex);
                i.putExtra(SEND_CHEST,send_chest);
                i.putExtra(SEND_BPS,send_bps);
                i.putExtra(SEND_CHOL,send_chol);
                i.putExtra(SEND_FBS,send_fbs);
                i.putExtra(SEND_ECG,send_ecg);
                i.putExtra(SEND_HEART,send_heartrate);
                i.putExtra(SEND_EXANG,send_exang);
                startActivity(i);
            }
        });

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_login:
                Intent i = new Intent(Inquiry.this, SignIn.class);
                startActivity(i);
                break;

            case  R.id.imageViewlogin:
                Intent intent = new Intent(Inquiry.this, SignIn.class);
                startActivity(intent
                );
                break;
        }
    }
}



