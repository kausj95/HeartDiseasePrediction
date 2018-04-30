package kashika.jain.sjsu.edu.heartprediction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class PredictInquiryActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txt_login;
    UserLocalStore userLocalStore;
    ImageView imageView;
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
        setContentView(R.layout.activity_predict_inquiry);
    // fetch value from inquiry

        Intent intent = getIntent();
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


        imageView = (ImageView)findViewById(R.id.imageViewlog);
        imageView.setOnClickListener(this);
        txt_login = (TextView) findViewById(R.id.link_login1);
        txt_login.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_login1:
                Intent i = new Intent(PredictInquiryActivity.this, SignIn.class);

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

                startActivity(i);
                break;
            case R.id.imageViewlog:
                Intent intent = new Intent(PredictInquiryActivity.this, SignIn.class);


                intent.putExtra(SEND_AGE,rec_age);
                intent.putExtra(SEND_SEX,rec_sex);
                intent.putExtra(SEND_CHEST,rec_chest);
                intent.putExtra(SEND_BPS,rec_bps);
                intent.putExtra(SEND_CHOL,rec_chol);
                intent.putExtra(SEND_FBS,rec_fbs);
                intent.putExtra(SEND_ECG,rec_ecg);
                intent.putExtra(SEND_HEART,rec_heart);
                intent.putExtra(SEND_EXANG,rec_exang);
                intent.putExtra(SENT_VALUE,set_value);
                startActivity(intent);
                break;
        }

    }
}
