package jp.android.phper.darts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstSettingDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstSettingDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstSettingDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bunle){
        //Bundle budle = new this.getArguments();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_first_setting_dialog, null, false);

        final NumberPicker numberPicker = (NumberPicker)view.findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(4);
        numberPicker.setValue(2);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Player Number");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (isAdded() && getActivity() instanceof CountUpActivity) {
                    ((CountUpActivity) getActivity()).firstSettingDialogClick(numberPicker.getValue());
                    Log.v("numberPicker", (String.valueOf(numberPicker.getValue())));
                }
            }
        });

        builder.setView(view);
        return builder.create();
    }

}
