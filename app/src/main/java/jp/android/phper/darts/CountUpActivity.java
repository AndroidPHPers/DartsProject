package jp.android.phper.darts;

import android.annotation.TargetApi;
import android.app.Activity;
//import android.app.FragmentManager;
//import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
//import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class CountUpActivity extends FragmentActivity {
    private ScorePanelFragment scorePanelFragment;
    private CalcPanelFragment calcPanelFragment;



//public class CountUpActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_up);

//        // 渡すデータ
//        String[] testStr = { "test1", "test2 };
//        Bundle bundle = new Bundle();
//        bundle.putStringArray("test", testStr);
//
//        // フラグメントを生成
//        ScorePanelFragment scorePanelFragment = new ScorePanelFragment();
//        CalcPanelFragment calcPanelFragment = new CalcPanelFragment();
//        scorePanelFragment.setArguments(bundle);
//
//        // フラグメントをアクティビティに追加する
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.fragment_container, scorePanelFragment, "scorePanelFragment");
//        transaction.add(R.id.fragment_container, calcPanelFragment , "calcPanelFragment");
//        transaction.commit();

        //final ScorePanelFragment scorePanelFragment = (ScorePanelFragment) getSupportFragmentManager().findFragmentById(R.id.ScorePanel);
        scorePanelFragment = (ScorePanelFragment) getSupportFragmentManager().findFragmentById(R.id.ScorePanel);

        FirstSettingDialogFragment firstSettingDialog = new FirstSettingDialogFragment();
        firstSettingDialog.show(getSupportFragmentManager(), "SetPlayerNumber");

        // FIXME 動作テスト
        Button btn1 = (Button)findViewById(R.id.key_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePanelFragment.setPlayerScoreDisplay(0, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(1, View.GONE);
                scorePanelFragment.setPlayerScoreDisplay(2, View.GONE);
                scorePanelFragment.setPlayerScoreDisplay(3, View.GONE);
            }
        });

        Button btn2 = (Button)findViewById(R.id.key_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePanelFragment.setPlayerScoreDisplay(0, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(1, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(2, View.GONE);
                scorePanelFragment.setPlayerScoreDisplay(3, View.GONE);
            }
        });

        Button btn3 = (Button)findViewById(R.id.key_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePanelFragment.setPlayerScoreDisplay(0, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(1, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(2, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(3, View.GONE);
            }
        });

        Button btn4 = (Button)findViewById(R.id.key_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scorePanelFragment.setPlayerScoreDisplay(0, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(1, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(2, View.VISIBLE);
                scorePanelFragment.setPlayerScoreDisplay(3, View.VISIBLE);
            }
        });



    }

    public void firstSettingDialogClick(int value) {
        scorePanelFragment.setPlayerNum(value);
        Log.v("numberPicker", "call firstSettingDialogClick");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_count_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
