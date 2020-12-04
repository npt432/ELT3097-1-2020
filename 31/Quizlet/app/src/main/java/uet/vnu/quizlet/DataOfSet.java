package uet.vnu.quizlet;

import java.io.Serializable;
import java.util.ArrayList;

public class DataOfSet implements Serializable {
  private String title;
  private ArrayList<Data> dataList;
  private String uid;

  public DataOfSet(){

  }

  public DataOfSet(String title, ArrayList<Data> dataList, String uid) {
    this.title = title;
    this.dataList = dataList;
    this.uid = uid;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<Data> getDataList() {
    return dataList;
  }

  public String getUid() {
    return uid;
  }

}
