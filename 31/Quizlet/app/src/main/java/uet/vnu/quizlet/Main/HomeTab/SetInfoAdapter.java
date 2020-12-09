package uet.vnu.quizlet.Main.HomeTab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import uet.vnu.quizlet.ClassData.DataOfSet;

public class SetInfoAdapter extends FragmentPagerAdapter {
  private ArrayList<DataOfSet> dataOfSetArrayList;

  //load list dataOfSet
  public void DataInput(ArrayList<DataOfSet> dataList){
    this.dataOfSetArrayList = dataList;
  }

  public SetInfoAdapter(@NonNull FragmentManager fm) {
    super(fm);
  }

  @Override
  //số lượng trang trong viewpager
  public int getCount() {
    return dataOfSetArrayList.size();
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return SetInfoFragment.newInstance(dataOfSetArrayList.get(position)); //thực hiện khởi tạo một SetInfoFragment với dữ liệu truyền vào
    //là phần tử thứ position của dataOfSetArrayList (tức 1 dataOfSet)
    //position được trả về tương ứng với view đang hiển thị trên màn hình (0,1,2,...)
    //hàm newInstance trong SetSetInfoFragment.java
  }

}
