package com.example.skyscraper.dialogfragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyDialogFragment extends DialogFragment implements View.OnClickListener{

    Button yes,no;
    communicator comm;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        comm = (communicator) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog_fragment,container,false);
        yes =  view.findViewById(R.id.dialogYes);
        no  =  view.findViewById(R.id.dialogNo);
        setCancelable(false);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.dialogYes)
        {
            comm.passDialogData("Yes was clicked ");
            dismiss();

        }
        else{
            comm.passDialogData( "No was clicked ");
            dismiss();
        }
    }

    interface communicator{
        public void passDialogData(String s);
    }
}
