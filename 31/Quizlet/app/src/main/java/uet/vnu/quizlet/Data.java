package uet.vnu.quizlet;

public class Data {
  private  String word;
  private String meaning;

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
