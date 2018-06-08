package kashika.jain.sjsu.edu.heartprediction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    public Button btn_inquiry;
    private Spinner spin_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onBtnCLick();
    }

        public void onBtnCLick()
        {
            btn_inquiry = (Button) findViewById(R.id.btn_inquiry);
            btn_inquiry.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(MainActivity.this, Inquiry.class);
                    startActivity(i);
                }
            });
        }

}
