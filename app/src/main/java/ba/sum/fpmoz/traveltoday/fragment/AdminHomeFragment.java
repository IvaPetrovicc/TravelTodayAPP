package ba.sum.fpmoz.traveltoday.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.adapter.DestinationAdapter;
import ba.sum.fpmoz.traveltoday.models.Destination;

public class AdminHomeFragment extends Fragment implements DestinationAdapter.OnItemClickListener {

    private RecyclerView destinationView;
    private ArrayList<Destination> list;
    private DestinationAdapter adapter;
    private FirebaseDatabase mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_home, container, false);

        destinationView = view.findViewById(R.id.destinationView);
        list = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance("https://traveltodayapp-fffaf-default-rtdb.europe-west1.firebasedatabase.app/");

        destinationView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DestinationAdapter(getActivity(), list, this);
        destinationView.setAdapter(adapter);

        DatabaseReference destinationDbRef = mDatabase.getInstance().getReference("destination");

        destinationDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot parentSnapshot : snapshot.getChildren()) {
                    for (DataSnapshot childSnapshot : parentSnapshot.getChildren()) {
                        Destination destination = childSnapshot.getValue(Destination.class);
                        list.add(destination);
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("FirebaseError", "Error fetching data: " + error.getMessage());
            }
        });

        return view;
    }

    @Override
    public void onItemClick(Destination destination) {
        Log.d("ItemClicked", "Subject: " + destination.getName());
        // Implementirajte logiku za prikaz detalja ili nešto drugo kada je stavka kliknuta
    }


}
