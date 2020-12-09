package uet.vnu.quizlet;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import uet.vnu.quizlet.adapter.CardAdapter;
import uet.vnu.quizlet.model.Card;

public class CurrentSummaryActivity extends AppCompatActivity {
    RecyclerView mRecycleView;
    CardAdapter cardAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_crr_summary);

        mRecycleView = findViewById(R.id.rcv);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        cardAdapter = new CardAdapter(this, getList());
        mRecycleView.setAdapter(cardAdapter);
    }

    private List<Card> getList(){

        List<Card> mListCard = new List<Card>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Card> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] a) {
                return null;
            }

            @Override
            public boolean add(Card card) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Card> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends Card> c) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Card get(int index) {
                return null;
            }

            @Override
            public Card set(int index, Card element) {
                return null;
            }

            @Override
            public void add(int index, Card element) {

            }

            @Override
            public Card remove(int index) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Card> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Card> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<Card> subList(int fromIndex, int toIndex) {
                return null;
            }
        };


        Card m = new Card("an", "eat");
        m.setTv_mean("an");
        m.setTv_word("eat");
        mListCard.add(m);
        return mListCard;
    }

}
