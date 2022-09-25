package com.chetu.demotp8.javaConcepts.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.chetu.demotp8.R;
import com.chetu.demotp8.databinding.CustomDialogBinding;
import com.google.android.material.button.MaterialButton;

public class DialogDemoActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo);

        btn = findViewById(R.id.btn_for_multiple_task);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (btn.getText().toString().equals("Alert Dialog")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(getResources().getDrawable(R.drawable.alert_warning));
            builder.setTitle("Warning");
            builder.setMessage("Do You Want To Exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(DialogDemoActivity.this, "I am Ok.", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            //TODO: We can also use this code above two code: -
//            builder.create().show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setAllCaps(false);
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.purple_200));
            btn.setText("Custom Dialog");
        } else if (btn.getText().toString().equals("Custom Dialog")) {
            //TODO: 1st method to make custom dilaog: -
            Dialog dialog = new Dialog(this);
//            dialog.setContentView(R.layout.custom_dialog);
//            dialog.setCancelable(false);
//            dialog.show();
////            Window window = dialog.getWindow();
////            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//            TextInputEditText etFname = dialog.findViewById(R.id.first_name);
//            TextInputEditText etLname = dialog.findViewById(R.id.last_name);
//            MaterialButton btnSubmit = dialog.findViewById(R.id.submit_btn);
//
//
//            btnSubmit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(DialogDemoActivity.this, etFname.getText().toString()+" "+
//                            etLname.getText().toString(), Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
//                }
//            });

            //TODO: 2nd method to make custom dialog with viewBinding: -
            CustomDialogBinding dialogBinding = CustomDialogBinding.inflate(getLayoutInflater());
            dialog.setContentView(dialogBinding.getRoot());
            dialog.show();
            Window window = dialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialogBinding.submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(DialogDemoActivity.this, dialogBinding.firstName.getText().toString()+" "+
                            dialogBinding.lastName.getText().toString(), Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

            btn.setText("Progress Dialog");
        } else if (btn.getText().toString().equals("Progress Dialog")) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("Please Wait");
            progressDialog.show();
            btn.setText("Alert Dialog");
        }
    }
}