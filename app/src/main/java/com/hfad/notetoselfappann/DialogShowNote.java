package com.hfad.notetoselfappann;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogShowNote extends DialogFragment {

    private ClassInfo note;

    public DialogShowNote(ClassInfo n)
    {
        note = n;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater inflator = getActivity().getLayoutInflater();
        View dialogView = inflator.inflate(R.layout.dialog_show_note,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        TextView tvStatus = dialogView.findViewById(R.id.tvStatus);
        TextView tvTitle = dialogView.findViewById(R.id.tvTitle);
        TextView tvDescription = dialogView.findViewById(R.id.tvDescription);
        Button btnDone = dialogView.findViewById(R.id.btnDoneShowingNote);

        tvTitle.setText(note.getTitle());
        tvStatus.setText(note.getStatus());
        tvDescription.setText(note.getDescription());

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss(); //Closes fragment and goes away
            }
        });

        builder.setView(dialogView);

        return builder.create();
    }
}
