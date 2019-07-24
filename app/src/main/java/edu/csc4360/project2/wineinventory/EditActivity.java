package edu.csc4360.project2.wineinventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.csc4360.project2.wineinventory.Model.WineDatabaseHandler;

public class EditActivity extends AppCompatActivity {

    private Button searchbtn;
    private EditText idText;
    private WineDatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        db = new WineDatabaseHandler(this);

        getSupportActionBar().setTitle("Edit/Delete Item");

        idText = (EditText) findViewById(R.id.idText);
        searchbtn =  (Button) findViewById(R.id.searchbtn);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


        // delete button will have an alert dialog for user to confirm.
        // if yes then entire row from database will be removed and updated
        // then will be redirected to main menu
//        delete = (Button) findViewById(R.id.deletebtn);
//        delete.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                deleteData();
//                startActivity(new Intent(EditActivity.this, MainActivity.class));
//
//            }
//        });
//
//        // save button will update database with changes, toast messsage will present
//        //then redirected to viewactivity where the updated content ill be shown
//        save = (Button) findViewById(R.id.savebtn);
//        save.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                updateData();
//                startActivity(new Intent(EditActivity.this, ViewActivity.class));
//            }
//        });


    }

    public void openDialog() {
        EditDialog exampleDialog = new EditDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}
