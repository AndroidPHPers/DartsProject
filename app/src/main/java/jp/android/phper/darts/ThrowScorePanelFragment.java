package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.BitSet;
import java.util.HashMap;

/**
 * スロー毎の得点の計算、表示を行うフラグメント
 */
public class ThrowScorePanelFragment extends Fragment {

    /**
     * 数字キーの対応
     */
    private HashMap<Integer,String> keyMap = new HashMap<>();

    /**
     * 投げたダーツのフラグ
     */
    private BitSet dartThrow = new BitSet(3);

    /**
     * スロースコアのリソースID
     */
    private int scoreTextId[] = {R.id.first_score, R.id.second_score, R.id.third_score};

    /**
     * Fragment生成時処理
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // キーIDとテンキーの値をマッピングしたHashMapを作成
        int numberKeys[] = {
                R.id.key_0, R.id.key_1, R.id.key_2, R.id.key_3,
                R.id.key_4, R.id.key_5, R.id.key_6, R.id.key_7,
                R.id.key_8, R.id.key_9
        };
        for(int i = 0; i < numberKeys.length; i++) {
            keyMap.put(numberKeys[i], Integer.toString(i));
        }
    }

    /**
     * View生成時処理
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_throw_score_panel, container, false);
        return view;
    }

    /**
     * テンキーをクリックした時にActivityから呼び出されるコールバックメソッド。
     * @param keyId
     */
    public void setKeyType(int keyId) {
        // 1スローの点数を格納する
        StringBuilder digits = new StringBuilder(2);
        View view = getView();
        for(int i = 0, len = scoreTextId.length; i < len; i++) {
            // スコアを確定していないスローの場合
            if(!dartThrow.get(i)) {
                TextView score = (TextView)view.findViewById(scoreTextId[i]);
                String nowNumber = (String)score.getText();
                digits.append(nowNumber);
                // リソースIDと対応する値があり、入力が1桁以下の場合は入力文字を結合
                if(keyMap.containsKey(keyId) && digits.length() < 2) {
                    digits.append(keyMap.get(keyId));
                }
                // 値が入力された場合は1スローのスコアに代入
                int scoreNumber = 0;
                if(0 < digits.length()) {
                    scoreNumber = Integer.parseInt(digits.toString());
                }
                // 例外値の場合は終了する
                int limit = 60;
                if(scoreNumber > limit) {
                    Toast toast = Toast.makeText(getActivity(), getString(R.string.number_limit_over, limit), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 500);
                    toast.show();
                    return;
                }
                // 値をTextViewにセットする
                score.setText(Integer.toString(scoreNumber));
                break;
            }
        }
        // 2桁入力またはNextボタン押下時に確定
        if(digits.length() == 2 || keyId == R.id.key_next) {
            for(int i = 0, len = dartThrow.size(); i < len; i++) {
                if(!dartThrow.get(i)) {
                    dartThrow.set(i, true);
                    break;
                }
            }
        }
    }
}
