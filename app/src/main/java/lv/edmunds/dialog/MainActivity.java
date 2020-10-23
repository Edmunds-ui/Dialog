package lv.edmunds.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static lv.edmunds.dialog.R.layout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }

    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void onClick(View v) {
        showAlertDialog();
    }

    private void showAlertDialog() {
        final CharSequence[] items = {"Edmunds Matusevics", "Name Surname 1", "Name Surname 2"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("No.00 Group’s Dialog");
        final ArrayList seletedItems = new ArrayList();

        builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            // indexSelected contains the index of item (of which checkbox checked)
            @Override
            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, items[indexSelected] + " checked", Toast.LENGTH_SHORT).show();
                    seletedItems.add(indexSelected);
                } else {
                    Toast.makeText(MainActivity.this, items[indexSelected] + " unchecked", Toast.LENGTH_SHORT).show();
                    seletedItems.remove(Integer.valueOf(indexSelected));
                }
            }
        })
        .setPositiveButton(android.R.string.ok, null) //Set to null. We override the onclick
        .setNegativeButton(android.R.string.cancel, null);
        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialogInterface) {

                Button button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        // TODO Do nothing
                        Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });

                button = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "You closed dialog", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });

        dialog.show();
    }
}