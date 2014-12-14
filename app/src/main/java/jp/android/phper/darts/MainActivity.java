package jp.android.phper.darts;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// タイトルバー非表示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    /**
     * カウントアップボタンを押した時コールバック関数
     * CountUpActivityに遷移する。
     * @param v Viewインスタンス
     */
    public void onClickCountUp(View v) {
        Intent intent = new Intent(this, CountUpActivity.class);
        startActivity(intent);
    }

}
