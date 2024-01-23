package ba.sum.fpmoz.traveltoday.activity;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import ba.sum.fpmoz.traveltoday.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        addMarker("London Eye", 51.503324, -0.119543, "London");
        addMarker("Buckingham Palace", 51.501364, -0.141890, "London");
        addMarker("The British Museum", 51.519413, -0.127042, "London");
        addMarker("Tower of London", 51.508112, -0.075949, "London");
        addMarker("Big Ben", 51.500729, -0.124625, "London");
        addMarker("Natural History Museum", 51.496840, -0.176581, "London");
        addMarker("Tate Modern", 51.507595, -0.099356, "London");
        addMarker("Science Museum", 51.497834, -0.174665, "London");


        addMarker("Sagrada Familia", 41.403633, 2.174480, "Barcelona");
        addMarker("Park Güell", 41.414153, 2.152837, "Barcelona");
        addMarker("La Rambla", 41.380918, 2.173076, "Barcelona");
        addMarker("Barri Gòtic (Gothic Quarter)", 41.383740, 2.177847, "Barcelona");
        addMarker("Park Ciutadella", 41.388820, 2.187081, "Barcelona");
        addMarker("Magic Fountain of Montjuïc", 41.370534, 2.151548, "Barcelona");
        addMarker("Camp Nou", 41.380894, 2.122825, "Barcelona");
        addMarker("Barcelona Zoo", 41.386926, 2.189830, "Barcelona");

        addMarker("Hagia Sophia", 41.008440, 28.979530, "Istanbul");
        addMarker("Topkapi Palace", 41.011052, 28.983815, "Istanbul");
        addMarker("Blue Mosque", 41.005267, 28.976666, "Istanbul");
        addMarker("Grand Bazaar", 41.010626, 28.968444, "Istanbul");
        addMarker("Bosphorus Bridge", 41.042983, 29.027625, "Istanbul");
        addMarker("Dolmabahçe Palace", 41.038775, 28.998315, "Istanbul");
        addMarker("Istiklal Avenue", 41.034239, 28.979424, "Istanbul");
        addMarker("Miniaturk", 41.064485, 28.948275, "Istanbul");

        addMarker("Statue of Liberty", 40.689247, -74.044502, "New York");
        addMarker("Central Park", 40.785091, -73.968285, "New York");
        addMarker("Times Square", 40.758896, -73.985130, "New York");
        addMarker("Empire State Building", 40.748817, -73.985428, "New York");
        addMarker("Brooklyn Bridge", 40.706086, -73.996864, "New York");
        addMarker("Grand Central Terminal", 40.752726, -73.977229, "New York");
        addMarker("High Line", 40.748817, -74.004729, "New York");
        addMarker("Metropolitan Museum of Art", 40.779437, -73.963244, "New York");


        addMarker("Eiffel Tower", 48.858844, 2.294350, "Paris");
        addMarker("Louvre Museum", 48.860611, 2.337644, "Paris");
        addMarker("Notre-Dame Cathedral", 48.852968, 2.349902, "Paris");
        addMarker("Montmartre", 48.886704, 2.343104, "Paris");
        addMarker("Musée d'Orsay", 48.860518, 2.325652, "Paris");
        addMarker("Sainte-Chapelle", 48.855572, 2.345920, "Paris");
        addMarker("Montparnasse Tower", 48.841341, 2.319618, "Paris");
        addMarker("Seine River Cruise", 48.856771, 2.343060, "Paris");

        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.509865, -0.118092), 5));
    }

    private void addMarker(String title, double latitude, double longitude, String city) {
        LatLng location = new LatLng(latitude, longitude);
        gMap.addMarker(new MarkerOptions().position(location).title(title).snippet("City: " + city));
    }
}
