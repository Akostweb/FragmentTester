package com.gmail.akostweb.fragmenttester;
import android.app.Activity;
import android.app.DialogFragment;;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvChange;

    DialogFragment dlg1;
    DialogFragment dlg2;
    String text = "eggs";
    int zadnica;
    TextView tvText;
    Button btnYes, btnNo, btnMaybe;
    final String LOG_TAG = "myLogs";
    String assho = " nigger is here";
    int frData;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvChange = (TextView) findViewById(R.id.TVCHange);
        tvText = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        dlg1 = new Dialog1();
        dlg2 = new Dialog2();
        btnYes = (Button) findViewById(R.id.btnYes);






    }

    public void write(int string){
        frData = string;

    }

    public void number(int number){
        zadnica = number;

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDlg1:
//                Bundle bundle = new Bundle();
//                bundle.putString("TEXT_TO_SET", text);
//                dlg1.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                Dialog1 fragment1 = (Dialog1) fragmentManager.findFragmentById(R.id.dialog1id);

                dlg1.show(getFragmentManager(), "dlg1");
                break;
            case R.id.btnDlg2:
                dlg2.show(getFragmentManager(), "dlg2");
                break;
            case R.id.button:
                tvText.setText(Integer.toString(frData));
            default:
                break;
        }
    }

}