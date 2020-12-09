package uet.vnu.quizlet.ClassData;

public class User {
  private String uid;
  private String userName;
  private String email;
  private String urlImage;

  public User() {
  }

  public User(String uid, String userName, String email, String urlImage) {
    this.uid = uid;
    this.userName = userName;
    this.email = email;
    this.urlImage = urlImage;
  }

  public String getUid() {
    return uid;
  }

  public String getUserName() {
    return userName;
  }

  public String getEmail() {
    return email;
  }

  public String getUrlImage() {
    return urlImage;
  }

}
