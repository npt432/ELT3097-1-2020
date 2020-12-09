package uet.vnu.quizlet.ClassData;

import java.io.Serializable;

public class Data implements Serializable {
  private transient String word;
  private transient String meaning;

  public void setWord(String word) {
    this.word = word;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }

  public Data(){

  }

  public void setData(String word, String meaning){
    this.word = word;
    this.meaning = meaning;
  }

  public String getWord(){
    return this.word;
  }
  public String getMeaning(){
    return this.meaning;
  }


}
