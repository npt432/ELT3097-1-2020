package uet.vnu.quizlet;

import java.util.Calendar;

public class User {
  private String uid;
  private String userName;
  private String email;
  private String password;
  private String urlImage;
  private Calendar dateOfBirth;

  public User() {
  }

  public User(String uid, String userName, String email, String password, String urlImage, Calendar dateOfBirth) {
    this.uid = uid;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.urlImage = urlImage;
    this.dateOfBirth = dateOfBirth;
  }

}
