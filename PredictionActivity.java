package kashika.jain.sjsu.edu.heartprediction;

import android.content.Intent;
import android.gesture.Prediction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.view.View.Z;

public class PredictionActivity extends AppCompatActivity implements View.OnClickListener{
private BarChart barchart;
    TextView txt_logout;
    UserLocalStore userLocalStore;


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
    String zero ="0";
    String one ="1";
    String two ="2";
    String three = "3";
    String four ="4";
    String five ="5";
    String six ="6";
    String seven = "7";
    String eight ="8";
    String nine ="9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

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



        barchart = (BarChart)findViewById(R.id.bargraph);
//        barchart.setMaxVisibleValueCount(40);
        txt_logout = (TextView) findViewById(R.id.link_logout1);
        txt_logout.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
        User user = userLocalStore.getLoggedInUser();




        BarDataSet set1;
        set1 = new BarDataSet(getDataSet(), "Recommended Values");
        set1.setColors(Color.RED);

        BarDataSet set2;
        set2 = new BarDataSet((getDataSet1()), "Actual Values");
//        set2.setColors(Color.BLUE);
        set2.setColors(new int[] {Color.parseColor("#514d4a"), Color.parseColor("#630947"), Color.parseColor("#883b2e"), Color.parseColor("#4f5fb7")});



        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        BarData data = new BarData(dataSets);

//        String[] lables = new String[] { "Blood Pressure", "Cholesterol", "Fasting Blood Sugar", "Heart Rate"};
//        Integer[] color = new Integer[]{Color.parseColor("#514d4a"), Color.parseColor("#630947"), Color.parseColor("#883b2e"), Color.parseColor("#4f5fb7")};
;


        XAxis xAxis = barchart.getXAxis();

//        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));
        xAxis.setGranularity(1f); // restrict interval to 1 (minimum)

//        Legend legend = barchart.getLegend();
//        legend.setEnabled(true);
//        legend.setForm(Legend.LegendForm.SQUARE);
        barchart.setData(data);
        Description description = new Description();
        description.setText("Health Data");
        barchart.setDescription(description);
        barchart.getLegend().setEnabled(true);
        barchart.animateY(1000);
        barchart.invalidate();

    }

    private ArrayList<BarEntry> getDataSet() {
        Float bp1;
        Float chol1;
        Float fbs1;
        Float hrate1;

        if(set_value !=null){

            if(rec_bps.equals(zero)){
                bp1 = 50.00f;
            }
            else if(rec_bps.equals(one)){
                bp1 = 65.00f;
            }
            else if(rec_bps.equals(two)){
                bp1 = 75.00f;
            }
            else if(rec_bps.equals(three)){
                bp1 = 85.00f;
            }
            if(rec_bps.equals(four)){
                bp1 = 105.00f;
            }
            else if(rec_bps.equals(five)){
                bp1 = 125.00f;
            }
            else if(rec_bps.equals(six)){
                bp1 = 135.00f;
            }
            else if(rec_bps.equals(seven)){
                bp1 = 150.00f;
            }
            else if(rec_bps.equals(eight)){
                bp1 = 170.00f;
            }
            else{
                bp1 = 200.00f;
            }



            if(rec_fbs.equals(zero)){
                fbs1 = 70.00f;
            }
            else if(rec_fbs.equals(one)){
                fbs1 = 90.00f;
            }
            else if(rec_fbs.equals(two)){
                fbs1 = 120.00f;
            }
            else{
                fbs1 = 130.00f;
            }


                if(rec_chol.equals(zero)){
                    chol1 = 180.00f;
                }
                else if(rec_chol.equals(one)){
                    chol1 = 215.00f;
                }
                else {
                    chol1 = 255.00f;
                }



            if(rec_heart.equals(zero)){
                hrate1 = 50.00f;
            }
            else if(rec_heart.equals(one)){
                hrate1 = 70.00f;
            }
            else if(rec_heart.equals(two)){
                hrate1 = 90.00f;
            }
            else if(rec_heart.equals(three)){
                hrate1 = 110.00f;
            }
            if(rec_heart.equals(four)){
                hrate1 = 150.00f;
            }
            else{
                hrate1 = 125.00f;
            }

        }
        else{
        bp1 = 133.00f;
        chol1 = 250.00f;
        fbs1 = 125.00f;
        hrate1 = 50.00f;
        }



        Float r_bp = 120.00f;
        Float r_chol = 190.00f;
        Float r_fbs = 100.00f;
        Float r_hrate = 80.00f;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry v1e2 = new BarEntry(1, bp1);
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(2, chol1);
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(3, fbs1);
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(4, hrate1);
        valueSet1.add(v1e5);

        return valueSet1;
    }


    private ArrayList<BarEntry> getDataSet1() {
        Float r_bp = 120.00f;
        Float r_chol = 190.00f;
        Float r_fbs = 100.00f;
        Float r_hrate = 80.00f;
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();

        BarEntry v1e2 = new BarEntry(1, r_bp);
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(2, r_chol);
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(3, r_fbs);
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(4, r_hrate);
        valueSet1.add(v1e5);
        return valueSet1;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.link_logout1:
                if(txt_logout.getText().toString() == "Logout"){
                    userLocalStore.clearUserData();
                }
                else {

                }
                Intent i = new Intent(PredictionActivity.this, SignIn.class);
                startActivity(i);
                break;
        }
    }
}
