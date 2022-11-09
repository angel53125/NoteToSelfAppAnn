package com.hfad.notetoselfappann;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    private ArrayList<ClassInfo> classList;


    public  MyAdapter()
    {
        classList = DataBase.getData();
    }

    //inflate vacation row item
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false); //check this line


        System.out.println("Done Creating view");
        return new MyViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    //Index in list we want to show
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ClassInfo cl = classList.get(position);

        System.out.println("Done populating row: " + position+  cl.getStatus());
        holder.setData(cl,position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {


        private int currentPosition = -1;
        private ClassInfo getCurrentNote = null;
        private ClassInfo currentNote = null;
        private  TextView tvName;
        private  TextView tvStatus;
        private  TextView tvDesc;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_title);
            tvStatus = itemView.findViewById(R.id.txt_status);
            tvDesc = itemView.findViewById(R.id.txt_text);



            //classList.remove(currentPosition);
            System.out.println("Position" + currentPosition);

            //notifyItemRemoved(currentPosition);
            //notifyItemRangeChanged(currentPosition,classList.size());


        }

        public void setData(ClassInfo cl,int pos)
        {
            tvName.setText(cl.getTitle());
            tvStatus.setText(cl.getStatus());
            tvDesc.setText(cl.getDescription());
            currentPosition = pos;
            currentNote = cl;

        }

    }

}

