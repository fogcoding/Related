package andrew.com.related.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import andrew.com.related.R;
import andrew.com.related.adapter.ChattingAdapter;
import andrew.com.related.toolClass.DividerItemDecoration;

public class ChattingView extends AppCompatActivity {

    private RecyclerView chattingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_view);

        chattingView = (RecyclerView) findViewById(R.id.rv_chatting_view);

        chattingView.setLayoutManager(new LinearLayoutManager(ChattingView.this));
        chattingView.addItemDecoration(new DividerItemDecoration(ChattingView.this,DividerItemDecoration.VERTICAL_LIST));
        chattingView.setAdapter(new ChattingAdapter());


    }
}
