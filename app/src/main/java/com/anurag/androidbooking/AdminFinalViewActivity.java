package com.anurag.androidbooking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AdminFinalViewActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private List<String> slotsList;
    private ArrayAdapter<String> slotsAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_final_view);

        db = FirebaseFirestore.getInstance();
        slotsList = new ArrayList<>();
        listView = findViewById(R.id.listViewSlots);
        Button deleteButton = findViewById(R.id.deleteButton);

        // Fetch slots data from Firestore
        fetchSlotsData();

        // Set up the adapter for the ListView
        slotsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, slotsList);
        listView.setAdapter(slotsAdapter);

        // Set onClickListener for the delete button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call function to delete all slots
                deleteAllSlots();
            }
        });

        // Set onClickListener for each item in the ListView (optional)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Here you can perform any action when an item is clicked, if needed
            }
        });
    }

    private void fetchSlotsData() {
        CollectionReference slotsRef = db.collection("Slots");
        slotsRef.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null) {
                            slotsList.clear();
                            for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                                String slotTime = document.getString("name");
                                slotsList.add(slotTime);
                            }
                            slotsAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    private void deleteAllSlots() {
        CollectionReference slotsRef = db.collection("Slots");
        slotsRef.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        QuerySnapshot querySnapshot = task.getResult();
                        if (querySnapshot != null) {
                            for (DocumentSnapshot document : querySnapshot.getDocuments()) {
                                document.getReference().delete();
                            }
                            slotsList.clear();
                            slotsAdapter.notifyDataSetChanged();
                            Toast.makeText(AdminFinalViewActivity.this, "All slots deleted successfully.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
