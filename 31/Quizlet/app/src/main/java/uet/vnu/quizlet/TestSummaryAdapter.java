package uet.vnu.quizlet;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TestSummaryAdapter extends FragmentPagerAdapter {
    public DataOfSet dataOfSet;
    public TestSummaryAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return TestSummaryFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 0;
    }

    public void DataInput(DataOfSet mdataOfSet) {
        this.dataOfSet = mdataOfSet;
    }
}
