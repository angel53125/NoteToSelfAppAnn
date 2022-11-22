package com.hfad.notetoselfappann;



import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class NewDialogShowNote extends DialogFragment{
    private Note ci;
    private MyAdapter myAdapter;
    public NewDialogShowNote()
    {
    }





    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflator = getActivity().getLayoutInflater();
        View dialogView = inflator.inflate(R.layout.dialog_new_note,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        EditText edTitle = dialogView.findViewById(R.id.et_Title);
        EditText edDesc = dialogView.findViewById(R.id.etNote);
        RadioButton rbIdea = dialogView.findViewById(R.id.radioButton_idea);
        RadioButton rbRem = dialogView.findViewById(R.id.radioButton_reminder);
        RadioButton rbList = dialogView.findViewById(R.id.radioButton_list);
        Button btnAdd = dialogView.findViewById(R.id.buttonAdd);
        RadioButton rb[] = {rbIdea,rbList,rbRem};
        //allNotes.add(new ClassInfo(status.get(i),title.get(i),desc.get(i)));




        System.out.println("Data before"+ DataBase.getData().size());
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < rb.length;i++) {
                    if(rb[i].isChecked()) {
                        DataBase.addNote(edTitle.getText().toString(), rb[i].getText().toString(), edDesc.getText().toString());
                    }
                    }
                System.out.println("Data After"+ DataBase.getData().size());
               // myAdapter.notifyDataSetChanged();
                //myAdapter.notifyItemRangeChanged(0,DataBase.getData().size());
                dismiss();
            }
        });

        builder.setView(dialogView);

        return builder.create();
    }
}
