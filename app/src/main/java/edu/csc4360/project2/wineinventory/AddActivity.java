package edu.csc4360.project2.wineinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import edu.csc4360.project2.wineinventory.Model.WineDatabaseHandler;

public class AddActivity extends AppCompatActivity {
    WineDatabaseHandler db;

    ImageButton addbtn;
    EditText wineText, brandText, yearText, costText, quantityText, typeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        db = new WineDatabaseHandler(this);

        getSupportActionBar().setTitle("Add Item");

        wineText = (EditText) findViewById(R.id.nameText);
        brandText = (EditText) findViewById(R.id.brandText);
        yearText = (EditText) findViewById(R.id.yearText);
        costText = (EditText) findViewById(R.id.priceText);
        quantityText = (EditText) findViewById(R.id.quantityText);
        typeText = (EditText) findViewById(R.id.typeText);

        addbtn = (ImageButton) findViewById(R.id.add_item_btn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    public void openDialog() {
        AddDialog exampleDialog = new AddDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}
