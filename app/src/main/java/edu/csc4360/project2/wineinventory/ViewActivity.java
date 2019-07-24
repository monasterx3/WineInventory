package edu.csc4360.project2.wineinventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

import edu.csc4360.project2.wineinventory.Model.WineDatabaseHandler;

public class ViewActivity extends AppCompatActivity {

    private ArrayList<String> wineNames = new ArrayList<>();
    private WineDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        getSupportActionBar().setTitle("View All Items");

        db = new WineDatabaseHandler(this);

        this.wineNames = getWineNames();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(wineNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private ArrayList<String> getWineNames() {
        WineDatabaseHandler db = new WineDatabaseHandler(this);
        ArrayList<String> wineNames = new ArrayList<>();

        Cursor cursor = db.getAllData();
        while(cursor.moveToNext()) {
            wineNames.add(cursor.getString(1));
        }

        return wineNames;
    }



}
