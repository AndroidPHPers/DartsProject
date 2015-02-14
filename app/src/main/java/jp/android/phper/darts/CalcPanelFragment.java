package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;

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
     * 数字キーの対応
     */
    private HashMap<Integer,String> keyMap = new HashMap<>();

    /**
     * コールバック：数字キークリック
     */
    private View.OnClickListener numberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String digit = null;
            Integer id = v.getId();
            if(keyMap.containsKey(id)) {
                digit = keyMap.get(id);
            }
        }
    };

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
        final View view = inflater.inflate(R.layout.fragment_calc_panel, container, false);
        // 数字キーのイベント設定
        for(int key : keyMap.keySet()) {
            Button numberButton = (Button)view.findViewById(key);
            numberButton.setOnClickListener(numberClickListener);
        }
        return view;
    }

}
