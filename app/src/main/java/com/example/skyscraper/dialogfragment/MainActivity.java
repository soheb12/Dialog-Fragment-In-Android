package com.example.skyscraper.dialogfragment;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMyDialog(View v)
    {
        FragmentManager manager = getFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        //un comment this to use this style so that you can have title (For API > 23 its needed )
        //myDialogFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.CustomDialog);
        myDialogFragment.show(manager,"myDialog");
    }

    @Override
    public void passDialogData(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        if(s == "Yes was clicked ")
        finish();
    }
}
