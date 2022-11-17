package com.hfad.notetoselfappann;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    private  FragmentManager fragmentManager;
    private ArrayList<Note> classList;


    public  MyAdapter(FragmentManager man,ArrayList<Note> n)
    {
        fragmentManager = man;
        classList = n;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

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
        Note cl = classList.get(position);

        System.out.println("Done populating row: " + position+  cl.getStatus());
        holder.setData(cl,position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {


        private int currentPosition = -1;
        private Note getCurrentNote = null;
        private Note currentNote = null;
        private  TextView tvName;
        private  TextView tvStatus;
        private  TextView tvDesc;
        private ImageView imgDelete;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_title);
            tvStatus = itemView.findViewById(R.id.txt_status);
            tvDesc = itemView.findViewById(R.id.txt_text);
            imgDelete = itemView.findViewById(R.id.img_delete);




            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    classList.remove(currentPosition);
                    System.out.println("Position" + currentPosition);

                    notifyItemRemoved(currentPosition);
                    notifyItemRangeChanged(currentPosition,classList.size());
                }
            });





            itemView.setClickable(true);
            itemView.setOnClickListener(this);


        }

        public void setData(Note cl, int pos)
        {
            tvName.setText(cl.getTitle());
            tvStatus.setText(cl.getStatus());
            tvDesc.setText(cl.getDescription());
            currentPosition = pos;
            currentNote = cl;

        }

        @Override
        public void onClick(View view)
        {
            DialogShowNote dialog = new DialogShowNote(currentNote);
            dialog.show(fragmentManager,"");

        }

    }

}

