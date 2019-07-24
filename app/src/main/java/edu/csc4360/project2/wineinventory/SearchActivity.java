package edu.csc4360.project2.wineinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.csc4360.project2.wineinventory.Model.WineDatabaseHandler;

public class SearchActivity extends AppCompatActivity {
    WineDatabaseHandler db;

    private Button searchbtn;
    private EditText brandText;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setTitle("Search Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new WineDatabaseHandler(this);

        getSupportActionBar().setTitle("Search Item");

        constraintLayout = findViewById(R.id.view_activity_constraint);

        registerForContextMenu(constraintLayout);

        brandText =(EditText) findViewById(R.id.typeText);

        searchbtn = (Button) findViewById(R.id.searchbtn);
        search();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.view_all_extended:
                viewAll();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void viewAll(){
        Cursor result = db.getAllData();
        if (result.getCount() == 0) {
            //message
            showMessage("Error","no data");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (result.moveToNext()){
            buffer.append("wineId :"+ result.getString(0)+"\n");
            buffer.append("model :"+ result.getString(1)+"\n");
            buffer.append("brand :"+ result.getString(2)+"\n");
            buffer.append("type :"+ result.getString(3)+"\n");
            buffer.append("year :"+ result.getString(4)+"\n");
            buffer.append("cost :"+ result.getString(5)+"\n\n");
        }
        showMessage("data",buffer.toString());
    }

    public void search(){
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor result = db.search(brandText.getText().toString());
                if (result.getCount() == 0) {
                    //message
                    showMessage("Error","no data");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (result.moveToNext()){
                    buffer.append("wineId :"+ result.getString(0)+"\n");
                    buffer.append("model :"+ result.getString(1)+"\n");
                    buffer.append("brand :"+ result.getString(2)+"\n");
                    buffer.append("type :"+ result.getString(3)+"\n");
                    buffer.append("year :"+ result.getString(4)+"\n");
                    buffer.append("cost :"+ result.getString(5)+"\n\n");
                }
                showMessage("Item Information",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
