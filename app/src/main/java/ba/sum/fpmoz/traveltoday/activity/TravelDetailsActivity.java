package ba.sum.fpmoz.traveltoday.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class TravelDetailsActivity extends AppCompatActivity {

    ConstraintLayout clBack;
    TextView textViewTown, textViewDescription;
    ImageView imageView;
    Button openMapsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_details);

        clBack = findViewById(R.id.clBack);
        textViewTown = findViewById(R.id.textViewTown);
        textViewDescription = findViewById(R.id.textViewDescription);
        imageView = findViewById(R.id.imageView);
        openMapsButton = findViewById(R.id.openMapsButton);

        clBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), BottomBarActivity.class);
            startActivity(intent);
        });

        openMapsButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(intent);
        });
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("selected_destination")) {
            Destination selectedDestination = intent.getParcelableExtra("selected_destination");

            textViewTown.setText(selectedDestination.getName());
            textViewDescription.setText(selectedDestination.getAbout());
            Glide.with(this)
                    .load(selectedDestination.getImage())
                    .placeholder(R.drawable.picture)
                    .into(imageView);
        }
    }
}
