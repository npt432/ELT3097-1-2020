package uet.vnu.quizlet.Main.HomeTab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import uet.vnu.quizlet.ClassData.DataOfSet;

public class SetCardViewPagerAdapter extends FragmentPagerAdapter {
  private DataOfSet dataOfSet;

  public SetCardViewPagerAdapter(@NonNull FragmentManager fm) {
    super(fm);
  }

  //load list dataOfSet
  public void DataInput(DataOfSet mdataOfSet){
    this.dataOfSet = mdataOfSet;
  }

  @Override
  //số lượng trang trong viewpager
  public int getCount() {
    return dataOfSet.getDataList().size();
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return SetCardFragment.newInstance(dataOfSet.getDataList().get(position));
  }

}
