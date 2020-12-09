package uet.vnu.quizlet.ClassData;

import java.io.Serializable;
import java.util.ArrayList;

public class DataOfSet implements Serializable {
  private transient String title;
  private transient ArrayList<Data> dataList;
  private transient String uid;
  private transient String dataID;

  public DataOfSet(){

  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDataList(ArrayList<Data> dataList) {
    this.dataList = dataList;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public void setDataID(String dataID) {
    this.dataID = dataID;
  }

  public DataOfSet(String title, ArrayList<Data> dataList, String uid, String dataID) {
    this.title = title;
    this.dataList = dataList;
    this.uid = uid;
    this.dataID = dataID;
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

  public String getDataID() {
    return dataID;
  }

}
