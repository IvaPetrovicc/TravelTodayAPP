package ba.sum.fpmoz.traveltoday.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.activity.TravelDetailsActivity;
import ba.sum.fpmoz.traveltoday.adapter.DestinationAdapter;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class HomeFragment extends Fragment implements DestinationAdapter.OnDestinationClickListener {

    private RecyclerView recyclerViewDestination;
    private ArrayList<Destination> destinationList;
    private DestinationAdapter adapter;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance("https://traveltodayapp-fffaf-default-rtdb.europe-west1.firebasedatabase.app/");


        recyclerViewDestination = view.findViewById(R.id.recyclerViewDestination);
        destinationList = new ArrayList<>();
        adapter = new DestinationAdapter(getContext(), destinationList, this, "user");
        recyclerViewDestination.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewDestination.setAdapter(adapter);

        loadDestinations();

        return view;
    }

    private void loadDestinations() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userType = currentUser.getDisplayName();
            DatabaseReference destinationDbRef = mDatabase.getReference("destination");

            destinationDbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    destinationList.clear();

                    for (DataSnapshot parentSnapshot : snapshot.getChildren()) {
                        for (DataSnapshot childSnapshot : parentSnapshot.getChildren()) {
                            Destination destination = childSnapshot.getValue(Destination.class);

                            if ("user".equals(userType) && destination != null) {
                                Destination simplifiedDestination = new Destination(destination.getName(), "", destination.getImage());
                                destinationList.add(simplifiedDestination);
                            } else {
                                destinationList.add(destination);
                            }
                        }
                    }

                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }

    @Override
    public void onDestinationClick(Destination destination) {
        Intent intent = new Intent(getContext(), TravelDetailsActivity.class);
        intent.putExtra("destination_name", destination.getName());
        intent.putExtra("destination_image", destination.getImage());
        startActivity(intent);
    }
}
