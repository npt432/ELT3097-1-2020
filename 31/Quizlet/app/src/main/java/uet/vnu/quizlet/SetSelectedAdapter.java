package uet.vnu.quizlet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SetSelectedAdapter extends RecyclerView.Adapter<SetSelectedAdapter.SetSelectedViewHolder> {

  private ArrayList<Data> mdataList;

  @NonNull
  @Override
  public SetSelectedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_set_selected_card,parent, false);
    SetSelectedViewHolder setSelectedViewHolder = new SetSelectedViewHolder(view);
    return setSelectedViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull SetSelectedViewHolder holder, int position) {
    holder.termTextView.setText(mdataList.get(position).getWord());
    holder.definitionView.setText(mdataList.get(position).getMeaning());
  }

  @Override
  public int getItemCount() {
    return mdataList.size();
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public int getItemViewType(int position) {
    return position;
  }

  public static class SetSelectedViewHolder extends RecyclerView.ViewHolder {
    private TextView termTextView;
    private TextView definitionView;

    public SetSelectedViewHolder(@NonNull View itemView) {
      super(itemView);
      termTextView = (TextView) itemView.findViewById(R.id.termTextView);
      definitionView = (TextView) itemView.findViewById(R.id.definitionTextView);
    }
  }

  public void SetSelectedAdapter(ArrayList<Data> dataList){
    mdataList = dataList;
  }

}

