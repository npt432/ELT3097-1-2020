package uet.vnu.quizlet;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uet.vnu.quizlet.adapter.CardAdapter;
import uet.vnu.quizlet.model.Card;

public class CrrSummaryActivity extends AppCompatActivity {
    private RecyclerView rcvCard;
    private CardAdapter cardAdapter;
    private ProgressBar pbRegister;
    private TextView tv_setText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crr_summary);

        rcvCard = findViewById(R.id.rcv);
        pbRegister = (ProgressBar) findViewById(R.id.pbRegister);
        tv_setText = (TextView) findViewById(R.id.tv_setText);
        cardAdapter = new CardAdapter(this);

        int numberwrong = getListCard().size();
        tv_setText.setText(numberwrong+ " sai");



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCard.setLayoutManager(linearLayoutManager);

        cardAdapter.setData(getListCard());
        rcvCard.setAdapter(cardAdapter);
    }

    private List<Card> getListCard(){
        List<Card> list = new ArrayList<>();

        Card m = new Card("jahfjdhfjha", "sfhs hcjsh sa");
        m.setTv_mean("an");
        m.setTv_word("eat");
        list.add(m);

        Card m1 = new Card("hfjahjhafhajsda", "sahsjfhsdjhf");
        m1.setTv_mean("an");
        m1.setTv_word("eat");
        list.add(m1);

        Card m2 = new Card("an", "eat");
        m2.setTv_mean("an");
        m2.setTv_word("eat");
        list.add(m2);

        Card m3 = new Card("an", "eat");
        m.setTv_mean("an");
        m.setTv_word("eat");
        list.add(m3);

        Card m4 = new Card("an", "eat");
        m4.setTv_mean("an");
        m4.setTv_word("eat");
        list.add(m4);
        Card m5 = new Card("an", "eat");
        m5.setTv_mean("an");
        m5.setTv_word("eat");
        list.add(m5);

        return list;
    }
}



