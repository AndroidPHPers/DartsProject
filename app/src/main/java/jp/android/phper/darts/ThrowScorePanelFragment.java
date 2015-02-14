package jp.android.phper.darts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link jp.android.phper.darts.ThrowScorePanelFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link jp.android.phper.darts.ThrowScorePanelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThrowScorePanelFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_throw_score_panel, container, false);
        return rootView;
    }
}
