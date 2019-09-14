package com.example.recyclerviewbestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewbestpractice.Adapters.StudentAdapter;
import com.example.recyclerviewbestpractice.Model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<StudentModel> list;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadData();
        adapter = new StudentAdapter(list);
        recyclerView.setAdapter(adapter);
        // get postion finally in adapter from callback of adapter
        adapter.setOnItemClickListener(new StudentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(getApplicationContext(), "Click on"+position, Toast.LENGTH_LONG).show();
            }
        });


    }

    private void loadData()
    {
        list.add(new StudentModel("Nayeem Shiddiki Abir", "01682148802"));
    }

}
