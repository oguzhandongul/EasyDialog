package com.oguzhandongul.dialogsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.oguzhandongul.easydialog.EasyDialog;
import com.oguzhandongul.easydialog.callbacks.DialogButtonCallback;
import com.oguzhandongul.easydialog.customviews.CVSelectionItem;
import com.oguzhandongul.easydialog.dialogs.BaseDialogFragment;
import com.oguzhandongul.easydialog.models.SelectionModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.buttonS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<SelectionModel> selectionItem = new ArrayList<SelectionModel>();
                for (int i = 0; i < 20; i++) {
                    selectionItem.add(new SelectionModel(i, R.drawable.icon_checked, getString(R.string.app_name)));

                }

                new EasyDialog.Builder(MainActivity.this)
                        .type(EasyDialog.Builder.DIALOG_SELECTION)
                        .title(R.string.ok_button)
                        .cancelTouchOutside(true)
                        .selectionList(selectionItem)
                        .addSelectionCallback(new CVSelectionItem.OnItemClickListener() {
                            @Override
                            public void onSelectionClick(int id, BaseDialogFragment dialogFragment) {
                                Toast.makeText(MainActivity.this, "" + id, Toast.LENGTH_SHORT).show();
                                dialogFragment.dismiss();
                            }
                        })
                        .addPositiveButton("CLOSE", new DialogButtonCallback() {
                            @Override
                            public void onClick(BaseDialogFragment dialog) {
                                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .build();
            }
        });

//        findViewById(R.id.buttonS).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                new EasyDialog.Builder(MainActivity.this)
//                        .type(EasyDialog.Builder.DIALOG_SUCCESS)
//                        .content("Content")
//                        .title(R.string.ok_button)
//                        .dialogFont("Conformity.ttf")
//                        .cancelTouchOutside(true)
//                        .addPositiveButton("OK", new DialogButtonCallback() {
//                            @Override
//                            public void onClick(BaseDialogFragment dialog) {
//                                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();
//                            }
//                        })
//                        .build();
//            }
//        });

        findViewById(R.id.buttonE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new EasyDialog.Builder(MainActivity.this)
                        .type(EasyDialog.Builder.DIALOG_ERROR)
                        .content("Content")
                        .title("Error!")
                        .addPositiveButton("Ok", new DialogButtonCallback() {
                            @Override
                            public void onClick(BaseDialogFragment dialog) {
                                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .addNegativeButton("Close", new DialogButtonCallback() {
                            @Override
                            public void onClick(BaseDialogFragment dialog) {
                                Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .build();
            }
        });

        findViewById(R.id.buttonC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new EasyDialog.Builder(MainActivity.this)
                        .type(EasyDialog.Builder.DIALOG_CUSTOM)
                        .content("Content")
                        .addPositiveButton("Positive", new DialogButtonCallback() {
                            @Override
                            public void onClick(BaseDialogFragment dialog) {
                                Toast.makeText(MainActivity.this, "POS", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .iconColor(R.color.white)
                        .iconBgColor(R.color.red)
                        .addNegativeButton("Negative")
                        .build();
            }
        });

        findViewById(R.id.buttonP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new EasyDialog.Builder(MainActivity.this)
                        .type(EasyDialog.Builder.DIALOG_PROGRESS)
                        .title("Loading!")
                        .build();
            }
        });
    }
}
