package uet.vnu.quizlet;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CreateSetAdapter extends RecyclerView.Adapter<CreateSetAdapter.CreateSetViewHolder> {
  private ArrayList<Data> mdataList;

  public static class CreateSetViewHolder extends RecyclerView.ViewHolder{
    private EditText termEditText;
    private EditText definitionEditText;

    public CreateSetViewHolder(@NonNull View itemView) {
      super(itemView);
      termEditText = (EditText) itemView.findViewById((R.id.termEditText));
      definitionEditText = (EditText) itemView.findViewById(R.id.definitionEditText);
    }
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public int getItemViewType(int position) {
    return position;
  }

  public CreateSetAdapter (ArrayList<Data> dataList){
    mdataList = dataList;
  }

  @NonNull
  @Override
  public CreateSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_create_set,parent, false);
    CreateSetViewHolder createSetViewHolder = new CreateSetViewHolder(view);
    return createSetViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull final CreateSetViewHolder holder, final int position) {
    Data currentItem = mdataList.get(position);
    holder.termEditText.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        String word = holder.termEditText.getText().toString();
        String meaning = holder.definitionEditText.getText().toString();
        Log.e("data", ""+word+" "+meaning);
        if((word != null) && (meaning !=null)) {
          mdataList.get(position).setData(word, meaning);
        }
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });

    holder.definitionEditText.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        String word = holder.termEditText.getText().toString();
        String meaning = holder.definitionEditText.getText().toString();
        Data data = new Data();
        data.setData(word,meaning);
        for(int i=0; i<mdataList.size(); i++){
          Log.e("preData", ""+mdataList.get(i).getWord()+" "+mdataList.get(i).getMeaning()+" "+ i);
        }
        Log.e("data", ""+word+" "+meaning+" "+ position);
        if((word != null) && (meaning !=null)) {
          mdataList.set(position, data);
          for(int i=0; i<mdataList.size(); i++){
            Log.e("after", ""+mdataList.get(i).getWord()+" "+mdataList.get(i).getMeaning()+" "+ i);
          }
        }
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
  }

  @Override
  public int getItemCount() {
    return mdataList.size();
  }
}
