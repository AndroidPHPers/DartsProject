package jp.android.phper.darts.test;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;

import jp.android.phper.darts.CountUpActivity;
import jp.android.phper.darts.MainActivity;
import jp.android.phper.darts.R;
import jp.android.phper.darts.ZeroOneActivity;

import static android.app.Instrumentation.ActivityMonitor;
import static android.test.TouchUtils.clickView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    MainActivity activity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testSample() {
        assertEquals(1,1);
    }

    public void testMainActivityTransition() {
        ActivityMonitor main_activity_monitor = new ActivityMonitor(MainActivity.class.getCanonicalName(), null, false);
        ActivityMonitor count_up_activity_monitor = new ActivityMonitor(CountUpActivity.class.getCanonicalName(), null, false);
        ActivityMonitor zero_one_activity_monitor = new ActivityMonitor(ZeroOneActivity.class.getCanonicalName(), null, false);
        //ActivityMonitor count_up_activity_monitor = new ActivityMonitor(CountUpActivity.class.getCanonicalName(), null, false);
        //ActivityMonitor count_up_activity_monitor = new ActivityMonitor(CountUpActivity.class.getCanonicalName(), null, false);



        getInstrumentation().addMonitor(main_activity_monitor);
        getInstrumentation().addMonitor(count_up_activity_monitor);
        getInstrumentation().addMonitor(zero_one_activity_monitor);

        Button count_up_button = (Button)activity.findViewById(R.id.countUpMenu);
        Button zero_one_button = (Button)activity.findViewById(R.id.zeroOneMenu);
        //Button count_up_button = (Button)activity.findViewById(R.id.countUpMenu);

        // ボタンが押せる状態であることをテスト
        assertTrue(count_up_button.isEnabled());
        assertTrue(zero_one_button.isEnabled());

        // MainActivity画面であることをテスト
//        assertEquals(0, main_activity_monitor.getHits());

        // カウントアップボタンをクリック
        clickView(this, count_up_button);

        // 遷移が完了するまで待つ
        getInstrumentation().waitForMonitorWithTimeout(main_activity_monitor, 2000);

        // CountUpActvityに遷移したことをテスト
        assertEquals(1, count_up_activity_monitor.getHits());

        // バックボタンを押してMainActivityに戻る
        this.sendKeys(KeyEvent.KEYCODE_BACK);
        getInstrumentation().waitForIdleSync();


        // ゼロワンボタンをクリック
        clickView(this, zero_one_button);

        // 遷移が完了するまで待つ
        getInstrumentation().waitForMonitorWithTimeout(main_activity_monitor, 2000);

        // CountUpActvityに遷移したことをテスト
        assertEquals(1, zero_one_activity_monitor.getHits());

        // バックボタンを押してMainActivityに戻る
        this.sendKeys(KeyEvent.KEYCODE_BACK);
        getInstrumentation().waitForIdleSync();


    }
}
