package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class EditDestinationActivity extends AppCompatActivity {

    EditText editTextDestinationName, editTextDescription;
    Button btnSaveChanges;
    TextView tvBack;
    ImageView imgBack;

    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://traveltodayapp-fffaf-default-rtdb.europe-west1.firebasedatabase.app/");

    String destinationId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_destination);

        editTextDestinationName = findViewById(R.id.editTextDestinationName);
        editTextDescription = findViewById(R.id.editTextDescription);
        btnSaveChanges = findViewById(R.id.btnSaveChanges);
        imgBack = findViewById(R.id.imgBack);
        tvBack = findViewById(R.id.tvBack);

        Intent intent = getIntent();
        String destinationName = intent.getStringExtra("destinationName");

        if (destinationName == null) {
            finish();
        }

        DatabaseReference destinationReference = mDatabase.getReference("destination");
        destinationReference.orderByChild("name").equalTo(destinationName)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                Destination destination = childSnapshot.getValue(Destination.class);
                                if (destination != null) {
                                    editTextDestinationName.setText(destination.getName());
                                    editTextDescription.setText(destination.getAbout());
                                }
                            }
                        } else {
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        finish();
                    }
                });

        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDestination(destinationName);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void updateDestination(String destinationName) {
        String name = editTextDestinationName.getText().toString();
        String about = editTextDescription.getText().toString();
        Log.d("EditDestinationActivity", "Querying for destination: " + destinationName);

        DatabaseReference destinationReference = mDatabase.getReference("destination");
        destinationReference.orderByChild("name").equalTo(destinationName)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                String key = childSnapshot.getKey();
                                destinationReference.child(key).child("name").setValue(name);
                                destinationReference.child(key).child("about").setValue(about);
                            }
                            Toast.makeText(getApplicationContext(), "Destination updated successfully!", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        finish();
                    }
                });
    }
}
