package com.clarks.expandablelistviewtest;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public ObservableArrayList<Entity> list = new ObservableArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ExpandableListView view = findViewById(R.id.listView);

        for (int i = 0; i < 10; i++) {

            Entity entity = new Entity();
            entity.name = "Entity " + i;
            entity.bits = new ObservableArrayList<>();
            for (int j = 0; j < 10; j++) {

                Bits bit = new Bits();
                bit.setTitle("Bit " + j);

                entity.bits.add(bit);
            }

            list.add(entity);
        }

        adapter = new MyAdapter(list);
        view.setAdapter(adapter);
    }

    @OnClick(R.id.btn_test)
    public void onClick() {

        list.get(1).setName("Updated!");
        list.get(1).bits.get(1).setTitle("Updated title!");

        adapter.notifyDataSetChanged();
    }
}
