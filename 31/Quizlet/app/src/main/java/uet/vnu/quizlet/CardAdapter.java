package uet.vnu.quizlet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uet.vnu.quizlet.CrrSummaryActivity;
import uet.vnu.quizlet.R;
import uet.vnu.quizlet.SummaryActivity;
import uet.vnu.quizlet.model.Card;

public class CardAdapter  extends  RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    private Context mContext;
    private List<Card> mListCard;

    public CardAdapter(Context mContext, List<Card> list) {

        this.mContext = mContext;
    }

    public CardAdapter(CrrSummaryActivity crrSummaryActivity) {
    }


    public void setData(List<Card> list){
        this.mListCard = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = mListCard.get(position);
        if (card == null){
            return;
        }

        holder.tv_mean.setText(card.getTv_mean());
        holder.tv_word.setText(card.getTv_word());
    }

    @Override
    public int getItemCount() {
        if(mListCard != null){
            return  mListCard.size();
        }
        return 0;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_mean;
        private TextView tv_word;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_mean = itemView.findViewById(R.id.tv_mean);
            tv_word = itemView.findViewById(R.id.tv_word);
        }
    }


}
