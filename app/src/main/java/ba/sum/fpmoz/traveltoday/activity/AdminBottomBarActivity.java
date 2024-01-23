package ba.sum.fpmoz.traveltoday.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ba.sum.fpmoz.traveltoday.R;
import ba.sum.fpmoz.traveltoday.fragment.AddDestinationFragment;
import ba.sum.fpmoz.traveltoday.fragment.AdminHomeFragment;
import ba.sum.fpmoz.traveltoday.fragment.HomeFragment;
import ba.sum.fpmoz.traveltoday.fragment.ProfileFragment;
import androidx.fragment.app.FragmentTransaction;

public class AdminBottomBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_bottom_bar);

        // Load the initial fragment
        loadFragment(new AdminHomeFragment());

        // Set up bottom navigation listener
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment;
            switch (item.getItemId()) {
                case R.id.admin_home:
                    selectedFragment = new AdminHomeFragment();
                    break;
                case R.id.create:
                    selectedFragment = new AddDestinationFragment();
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                    break;
                default:
                    selectedFragment = new AdminHomeFragment();
            }
            loadFragment(selectedFragment);
            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}