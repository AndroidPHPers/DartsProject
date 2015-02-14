package jp.android.phper.darts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;


public class FirstSettingDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bunle){
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_first_setting_dialog, null, false);

        final NumberPicker numberPicker = (NumberPicker)view.findViewById(R.id.numberPicker);
        Resources res = getResources();
        numberPicker.setMinValue(res.getInteger(R.integer.min_player_num));
        numberPicker.setMaxValue(res.getInteger(R.integer.max_player_num));
        numberPicker.setValue(res.getInteger(R.integer.default_player_num));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Player Number");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ScorePanelFragment scorePanelFragment = (ScorePanelFragment)getFragmentManager().findFragmentById(R.id.ScorePanel);
                scorePanelFragment.setPlayerNum(numberPicker.getValue());
            }
        });

        builder.setView(view);
        return builder.create();
    }

}
