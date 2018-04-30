package kashika.jain.sjsu.edu.heartprediction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Inquiry extends AppCompatActivity {
    public Button btn_login;
    public Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        onBtnCLick();
        onBtnClicksubmit();
//        addListOnSpin_age();
    }


//    public void addListOnSpin_age(){
//        Spinner spin_age = (Spinner) findViewById(R.id.spin_age);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin_age.setAdapter(adapter);
//    }

    public void onBtnCLick() {
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Inquiry.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    public void onBtnClicksubmit() {
        btn_submit = (Button) findViewById(R.id.btn_inqsubmit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Inquiry.this, PredictionActivity.class);
                startActivity(i);
            }
        });

    }
}
