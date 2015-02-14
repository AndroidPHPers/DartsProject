package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScorePanelFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScorePanelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScorePanelFragment extends Fragment {
    final static int MAX_PLAYER_NUM = 4;
    Integer playerNum;
    TextView[] playerScore;
    ViewGroup container;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_score_panel, container, false);

        View view = inflater.inflate(R.layout.fragment_score_panel, container, false);

        playerScore = new TextView[MAX_PLAYER_NUM];
        playerScore[0] = (TextView)view.findViewById(R.id.first_player_score);
        playerScore[1] = (TextView)view.findViewById(R.id.second_player_score);
        playerScore[2] = (TextView)view.findViewById(R.id.third_player_score);
        playerScore[3] = (TextView)view.findViewById(R.id.fourth_player_score);

        this.container = container;

        return view;
    }

    public void setPlayerNum(int num) {
        int i;
        Log.v("numberPicker", "set PlayerNum");
        for (i = 0; i < MAX_PLAYER_NUM; i++) {
            playerScore[i].setVisibility(View.GONE);
        }
        for (i = 0; i < num; i++) {
            playerScore[i].setVisibility(View.VISIBLE);
        }

    }



    public void setPlayerScoreDisplay(int index, int flag) {
        playerScore[index].setVisibility(flag);
    }


}
