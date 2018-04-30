package kashika.jain.sjsu.edu.heartprediction;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SensorActivity extends AppCompatActivity implements View.OnClickListener{
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

    TextView txt_logout;
    public EditText sensor;
    UserLocalStore userLocalStore;
    Button btn_sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sensor);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        sensor = (EditText) findViewById(R.id.editText_sensor);
        txt_logout = (TextView) findViewById(R.id.link_logout);
        txt_logout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
        btn_sensor = (Button)findViewById(R.id.btn_sensor);
        btn_sensor.setOnClickListener(this);
        Intent intent = getIntent();
        String set_name = intent.getStringExtra(SensorActivity.SEND_NAME);
        TextView txt_name =(TextView)findViewById(R.id.sensor_username);
        txt_name.setText("Dear "+ set_name + ",");

            }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_logout:
//                User user = new User(null,null);
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                Intent i = new Intent(SensorActivity.this, SignIn.class);
                startActivity(i);
                break;

            case R.id.btn_sensor:
                userLocalStore.setUserLoggedIn(true);
                validateData();
                if(!validateData())
                {
                    Toast.makeText(getApplicationContext(), "Signup failed", Toast.LENGTH_LONG).show();
                    break;
                }
                else {
                    Intent intent = new Intent(SensorActivity.this, PredictionActivity.class);
                    startActivity(intent);
                    break;
                }
        }
    }

    public boolean validateData(){
        boolean valid = true;
        if (sensor.getText().toString().isEmpty()){
            sensor.setError("Please input the data from sensor");
            valid = false;
        }
        return  valid;
    }
}
