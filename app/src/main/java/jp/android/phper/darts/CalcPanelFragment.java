package jp.android.phper.darts;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * テンキーパネルの処理を行うフラグメント
 */
public class CalcPanelFragment extends Fragment {

    /**
     * コールバック：数字キークリック
     */
    private View.OnClickListener numberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Activity parentActivity = getActivity();
            if (isAdded() && parentActivity instanceof GameActivityInterface) {
                Integer id = v.getId();
                ((GameActivityInterface)parentActivity).setKeyType(id);
            }
        }
    };

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
        View view = inflater.inflate(R.layout.fragment_calc_panel, container, false);

        // 数字キーのイベント設定
        int keyId[] = {
                R.id.key_0, R.id.key_1, R.id.key_2, R.id.key_3,
                R.id.key_4, R.id.key_5, R.id.key_6, R.id.key_7,
                R.id.key_8, R.id.key_9, R.id.key_next
        };
        for(int id : keyId) {
            Button key = (Button)view.findViewById(id);
            key.setOnClickListener(numberClickListener);
        }
        return view;
    }

}
