package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalcPanelFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalcPanelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalcPanelFragment extends Fragment {

    /**
     * 一投目スコア確定フラグ
     */
    private Boolean __fixFirst = false;

    /**
     * 二投目スコア確定フラグ
     */
    private Boolean __fixSecond = false;

    /**
     * 三投目スコア確定フラグ
     */
    private Boolean __fixThird = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = (ViewGroup)inflater.inflate(R.layout.fragment_calc_panel, container, false);
        View.OnClickListener onNumberClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) throws IllegalArgumentException {
                String scoreDigit = null;
                switch(v.getId()) {
                    case R.id.key_0:
                        scoreDigit = "0";
                        break;
                    case R.id.key_1:
                        scoreDigit = "1";
                        break;
                    case R.id.key_2:
                        scoreDigit = "2";
                        break;
                    case R.id.key_3:
                        scoreDigit = "3";
                        break;
                    case R.id.key_4:
                        scoreDigit = "4";
                        break;
                    case R.id.key_5:
                        scoreDigit = "5";
                        break;
                    case R.id.key_6:
                        scoreDigit = "6";
                        break;
                    case R.id.key_7:
                        scoreDigit = "7";
                        break;
                    case R.id.key_8:
                        scoreDigit = "8";
                        break;
                    case R.id.key_9:
                        scoreDigit = "9";
                        break;
                }
                StringBuilder buffer = new StringBuilder();
                // スコア表示TextView
                TextView scoreView = null;
                // 入力された文字列
                String inputScore = null;
                // 入力済みのスコア
                String scoreValue = null;
                // 一投目のスコアを取得する
                scoreView = (TextView)view.findViewById(R.id.first_score);
                scoreValue = scoreView.getText().toString();

                if(!__fixFirst && scoreValue != null && scoreValue.length() < 2) {
                    buffer.append(scoreValue);
                    buffer.append(scoreDigit);
                    inputScore = buffer.toString();
                    scoreView.setText(inputScore);
                    return;
                } else if(!__fixFirst) {
                    // 一投目を確定させる
                    __fixFirst = true;
                }

                scoreView = (TextView)view.findViewById(R.id.second_score);
                scoreValue = scoreView.getText().toString();
                if(!__fixSecond && scoreValue != null && scoreValue.length() < 2) {
                    buffer.append(scoreValue);
                    buffer.append(scoreDigit);
                    inputScore = buffer.toString();
                    scoreView.setText(inputScore);
                    return;
                } else if(!__fixSecond) {
                    // 二投目を確定させる
                    __fixSecond = true;
                }
                scoreView = (TextView)view.findViewById(R.id.third_score);
                scoreValue = scoreView.getText().toString();
                if(!__fixThird && scoreValue != null && scoreValue.length() < 2) {
                    buffer.append(scoreValue);
                    buffer.append(scoreDigit);
                    inputScore = buffer.toString();
                    scoreView.setText(inputScore);
                    return;
                } else if(!__fixThird) {
                    // 三投目を確定させる
                    __fixThird = true;
                }
            }
        };
        // 数字キーのイベント設定
        int numberKeys[] = {
                R.id.key_0, R.id.key_1, R.id.key_2, R.id.key_3,
                R.id.key_4, R.id.key_5, R.id.key_6, R.id.key_7,
                R.id.key_8, R.id.key_9
        };
        for(int key : numberKeys) {
            Button numberButton = (Button)view.findViewById(key);
            numberButton.setOnClickListener(onNumberClick);
        }
        // Nextボタン
        Button nextButton = (Button)view.findViewById(R.id.key_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView scoreView = null;
                String scoreValue = null;
                int scoreInt = -1;
                scoreView = (TextView)view.findViewById(R.id.first_score);
                scoreValue = scoreView.getText().toString();
                if(scoreValue != null && scoreValue != "") {
                    scoreInt = Integer.parseInt(scoreValue);
                    if(0 < scoreInt && scoreInt <= 60) {
                        __fixFirst = true;
                    }
                }
                scoreView = (TextView)view.findViewById(R.id.second_score);
                scoreValue = scoreView.getText().toString();
                if(scoreValue != null && scoreValue != "") {
                    scoreInt = Integer.parseInt(scoreValue);
                    if(0 < scoreInt && scoreInt <= 60) {
                        __fixSecond = true;
                    }
                }
                scoreView = (TextView)view.findViewById(R.id.third_score);
                scoreValue = scoreView.getText().toString();
                if(scoreValue != null && scoreValue != "") {
                    scoreInt = Integer.parseInt(scoreValue);
                    if(0 < scoreInt && scoreInt <= 60) {
                        __fixThird = true;
                    }
                }
            }
        });
        return view;
    }

}
