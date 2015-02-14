package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
     * 入力回数
     */
    private int inputKeyNum = 0;

    /**
     * スロースコアのリソースID
     */
    private int scoreBoxId[] = {R.id.first_score, R.id.second_score, R.id.third_score};

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
        dartThrow.set(0, false);
        dartThrow.set(1, false);
        dartThrow.set(2, false);

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
     * クリックしたキーのIDをセットするコールバック関数
     * @param keyId
     */
    public void setKeyType(int keyId) {
        // 数字キーの判定
        String number = "";
        if(keyMap.containsKey(keyId)) {
            number = keyMap.get(keyId);
        }
        // 数字キーの場合のみ加算処理
        View view = getView();
        if(R.id.key_next != keyId) {
            for(int i = 0, len = scoreBoxId.length; i < len; i++) {
                // スコアを確定していないスローの場合
                if(!dartThrow.get(i)) {
                    TextView score = (TextView)view.findViewById(scoreBoxId[i]);
                    String nowNumber = (String)score.getText();
                    int scoreNumber = Integer.parseInt(nowNumber + number);
                    // 文字を結合してTextViewに反映
                    score.setText(Integer.toString(scoreNumber));
                    break;
                }
            }
        }
        // 2桁入力またはNextボタン押下時に確定
        if(1 < ++inputKeyNum || keyId == R.id.key_next) {
            inputKeyNum = 0;
            for(int i = 0, len = dartThrow.size(); i < len; i++) {
                if(!dartThrow.get(i)) {
                    dartThrow.set(i, true);
                    break;
                }
            }
        }
    }
}
