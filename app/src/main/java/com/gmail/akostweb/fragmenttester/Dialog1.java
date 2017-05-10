package com.gmail.akostweb.fragmenttester;

        import android.app.Activity;
        import android.app.Dialog;
        import android.app.DialogFragment;
        import android.content.DialogInterface;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;
        import android.text.Html;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.view.ViewParent;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class Dialog1 extends DialogFragment implements OnClickListener {

    OnSelectedAnswer mCallback;

    // Container Activity must implement this interface
    public interface OnSelectedAnswer {
        public void onAnswerSelected(int position);
    }

    final String LOG_TAG = "myLogs";



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle args = getArguments();
        String text = args.getString("TEXT_TO_SET");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog1,null);
        TextView txt = (TextView) view.findViewById(R.id.textView);
        txt.setText(text);



        return super.onCreateDialog(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View titleView = getDialog().findViewById(android.R.id.title);
        if (titleView != null) {
            ViewParent parent = titleView.getParent();
            if (parent != null && (parent instanceof View)) {
                View parentView = (View) parent;
                parentView.setBackgroundColor(Color.RED);
            }
        }
        getDialog().setTitle(Html.fromHtml("<font color='#000000'>ActionBarTitle </font>"));
        View v = inflater.inflate(R.layout.dialog1, null);
        v.findViewById(R.id.btnYes).setOnClickListener(this);
        v.findViewById(R.id.btnNo).setOnClickListener(this);
        v.findViewById(R.id.btnMaybe).setOnClickListener(this);
        return v;
    }

    public void textChanger(String text){
        getDialog().setTitle(text);
    }

    public void onClick(View v) {
        Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());
       ((MainActivity)getActivity()).write(1);
        dismiss();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        ((MainActivity)getActivity()).write(2);
        Log.d(LOG_TAG, "Dialog 1: onDismiss ondismiss");
    }

    public void onCancel(DialogInterface dialog) {
        ((MainActivity)getActivity()).write(3);
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }


}