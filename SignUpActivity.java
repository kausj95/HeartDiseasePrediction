package kashika.jain.sjsu.edu.heartprediction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.signUp)
        {
            EditText name = (EditText)findViewById(R.id.edittxt_name);
            EditText email = (EditText)findViewById(R.id.edittxt_email);
            EditText password = (EditText)findViewById(R.id.edittxt_password);
            EditText confirmpassword = (EditText)findViewById(R.id.edittxt_confirmpass);

            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String passwordStr = password.getText().toString();
            String confirmpasswordStr = confirmpassword.getText().toString();

            if(!passwordStr.equals(confirmpasswordStr))
            {
                Toast
            }
    }
}
