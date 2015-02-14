package jp.android.phper.darts;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ScorePanelFragment extends Fragment {
    TextView[] playerScore;
    ViewGroup container;
    Resources res;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        res = getResources();

        View view = inflater.inflate(R.layout.fragment_score_panel, container, false);

        playerScore = new TextView[res.getInteger(R.integer.max_player_num)];
        playerScore[0] = (TextView)view.findViewById(R.id.first_player_score);
        playerScore[1] = (TextView)view.findViewById(R.id.second_player_score);
        playerScore[2] = (TextView)view.findViewById(R.id.third_player_score);
        playerScore[3] = (TextView)view.findViewById(R.id.fourth_player_score);

        this.container = container;

        return view;
    }

    /**
     * プレイヤー数変更メソッド
     * スコアパネルに表示するプレイヤーの数を変更する
     *
     * @param num セットする数
     */
    public void setPlayerNum(int num) {
        int i;
        for (i = 0; i < res.getInteger(R.integer.max_player_num); i++) {
            playerScore[i].setVisibility(View.GONE);
        }
        for (i = 0; i < num; i++) {
            playerScore[i].setVisibility(View.VISIBLE);
        }
    }

    /**
     * プレイヤー数変更ダイアログ表示メソッド
     */
    public void showPlayerNumberSettingDialog() {
        FirstSettingDialogFragment firstSettingDialog = new FirstSettingDialogFragment();
        firstSettingDialog.show(getFragmentManager(), "setPlayerNumber");
    }

}
