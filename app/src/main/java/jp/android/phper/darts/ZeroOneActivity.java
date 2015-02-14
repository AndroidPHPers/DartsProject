package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * ゼロワンゲーム
 */
public class ZeroOneActivity extends FragmentActivity implements GameActivityInterface {

    /**
     * Activity初期化時の処理
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero_one);
        // 初期設定ダイアログを表示
        FirstSettingDialogFragment firstSettingDialog = new FirstSettingDialogFragment();
        firstSettingDialog.show(getSupportFragmentManager(), "SetPlayerNumber");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_zero_one, menu);
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

    /**
     * クリックしたキーのIDをフラグメントにセットするコールバック関数
     * @param keyId
     */
    public void setKeyType(int keyId) {
        // スコアパネルフラグメントを取得
        ThrowScorePanelFragment throwScorePanel = (ThrowScorePanelFragment) getSupportFragmentManager().findFragmentById(R.id.ThrowScorePanel);
        throwScorePanel.setKeyType(keyId);
    }
}
