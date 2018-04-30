package kashika.jain.sjsu.edu.heartprediction;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class MyValueFormatter implements IValueFormatter{
private DecimalFormat mformat;
public MyValueFormatter(){
    mformat = new DecimalFormat("A");

}

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return mformat.format(value)+ "A";
    }

}
