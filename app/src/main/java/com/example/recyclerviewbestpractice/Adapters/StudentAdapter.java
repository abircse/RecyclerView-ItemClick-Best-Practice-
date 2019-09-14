package com.example.recyclerviewbestpractice.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewbestpractice.Model.StudentModel;
import com.example.recyclerviewbestpractice.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Holder>{

    private List<StudentModel> list;

    // create object for Onitemclick interface
    private OnItemClickListener mListerner;


    public StudentAdapter(List<StudentModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new Holder(view, mListerner);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.phone.setText(list.get(position).getPhone());

    }

    @Override
    public int getItemCount() {

        if (list == null) {
            return 0;
        }
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name,phone;
        Holder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
            phone = itemView.findViewById(R.id.studentPhone);

            // add click on itemview
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener!= null)
                    {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }

    //interface
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    // this will call in mainactivity
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListerner = listener;
    }

}
