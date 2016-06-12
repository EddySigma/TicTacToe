package com.garcia.e.juan.tictactoe;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class MainFragment extends Fragment {
    private AlertDialog mDialog;

    // ======================================================== //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        View aboutButton = rootView.findViewById(R.id.about_button);    // this is the about button
        aboutButton.setOnClickListener(new View.OnClickListener(){      // onclick listener for the about button
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());       // alert screen
                builder.setTitle(R.string.about_title);                                     // alert title
                builder.setMessage(R.string.about_text);                                    // alert internal text
                builder.setCancelable(false);                                               // to cancel or not to cancel?
                builder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {    // only use ok button to accept
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {                        // onclick for alert screen
                        // stuff will go in here
                    }
                });
                mDialog = builder.show();       // display the alert screen
            }

        });

        View newButton = rootView.findViewById(R.id.new_button);
        View continueButton = rootView.findViewById(R.id.continue_button);
        newButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), GameActivity.class);
                getActivity().startActivity(intent);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), GameActivity.class);
                intent.putExtra(GameActivity.KEY_RESTORE, true);
                getActivity().startActivity(intent);
            }
        });


        return rootView;
    }

    // ======================================================== //

    @Override
    public void onPause(){
        super.onPause();

        // get rid of the about dialog if it's still up

        if(mDialog != null){
            mDialog.dismiss();
        }
    }

    // ======================================================== //


}
