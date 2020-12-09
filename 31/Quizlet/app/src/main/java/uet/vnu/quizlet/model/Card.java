package uet.vnu.quizlet.model;

public class Card {
    private String tv_mean;
    private String tv_word;

    public Card(String an, String eat) {
        this.tv_word = tv_word;
        this.tv_mean = tv_mean;
    }

    public String getTv_mean() {
        return tv_mean;
    }

    public void setTv_mean(String tv_mean) {
        this.tv_mean = tv_mean;
    }

    public String getTv_word() {
        return tv_word;
    }

    public void setTv_word(String tv_word) {
        this.tv_word = tv_word;
    }
}
