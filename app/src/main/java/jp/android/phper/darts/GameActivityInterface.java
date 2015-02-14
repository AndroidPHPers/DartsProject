package jp.android.phper.darts;

/**
 * Created by mintsu on 2015/02/14.
 */
public interface GameActivityInterface {
    CalcPanelFragment calcPanelFragment = null;
    ScorePanelFragment scorePanelFragment = null;
    ThrowScorePanelFragment throwScorePanelFragment = null;
    FirstSettingDialogFragment firstSettingDialogFragment = null;

    public void firstSettingDialogClick(int value);

}
