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

import com.google.android.gms.maps.model.BitmapDescriptorFactory;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;

    private static final float MARKER_COLOR_RED = BitmapDescriptorFactory.HUE_RED;
    private static final float MARKER_COLOR_BLUE = BitmapDescriptorFactory.HUE_BLUE;
    private static final float MARKER_COLOR_GREEN = BitmapDescriptorFactory.HUE_GREEN;
    private static final float MARKER_COLOR_ROSE = BitmapDescriptorFactory.HUE_ROSE;
    private static final float MARKER_COLOR_YELLOW = BitmapDescriptorFactory.HUE_YELLOW;
    private static final float MARKER_COLOR_AZURE = BitmapDescriptorFactory.HUE_AZURE;
    private static final float MARKER_COLOR_VIOLET = BitmapDescriptorFactory.HUE_VIOLET;
    private static final float MARKER_COLOR_MAGENTA = BitmapDescriptorFactory.HUE_MAGENTA;
    private static final float MARKER_COLOR_ORANGE = BitmapDescriptorFactory.HUE_ORANGE;
    private static final float MARKER_COLOR_CYAN = BitmapDescriptorFactory.HUE_CYAN;


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

        addMarker("London Eye", 51.503324, -0.119543, "London", MARKER_COLOR_RED);
        addMarker("Buckingham Palace", 51.501364, -0.141890, "London", MARKER_COLOR_RED);
        addMarker("The British Museum", 51.519413, -0.127042, "London", MARKER_COLOR_RED);
        addMarker("Tower of London", 51.508112, -0.075949, "London", MARKER_COLOR_RED);
        addMarker("Big Ben", 51.500729, -0.124625, "London", MARKER_COLOR_RED);
        addMarker("Natural History Museum", 51.496840, -0.176581, "London", MARKER_COLOR_RED);
        addMarker("Tate Modern", 51.507595, -0.099356, "London", MARKER_COLOR_RED);
        addMarker("Science Museum", 51.497834, -0.174665, "London", MARKER_COLOR_RED);


        addMarker("Sagrada Familia", 41.403633, 2.174480, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("Park Güell", 41.414153, 2.152837, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("La Rambla", 41.380918, 2.173076, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("Barri Gòtic (Gothic Quarter)", 41.383740, 2.177847, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("Park Ciutadella", 41.388820, 2.187081, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("Magic Fountain of Montjuïc", 41.370534, 2.151548, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("Camp Nou", 41.380894, 2.122825, "Barcelona", MARKER_COLOR_BLUE);
        addMarker("Barcelona Zoo", 41.386926, 2.189830, "Barcelona", MARKER_COLOR_BLUE);

        addMarker("Hagia Sophia", 41.008440, 28.979530, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Topkapi Palace", 41.011052, 28.983815, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Blue Mosque", 41.005267, 28.976666, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Grand Bazaar", 41.010626, 28.968444, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Bosphorus Bridge", 41.042983, 29.027625, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Dolmabahçe Palace", 41.038775, 28.998315, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Istiklal Avenue", 41.034239, 28.979424, "Istanbul", MARKER_COLOR_GREEN);
        addMarker("Miniaturk", 41.064485, 28.948275, "Istanbul", MARKER_COLOR_GREEN);

        addMarker("Statue of Liberty", 40.689247, -74.044502, "New York", MARKER_COLOR_ROSE);
        addMarker("Central Park", 40.785091, -73.968285, "New York", MARKER_COLOR_ROSE);
        addMarker("Times Square", 40.758896, -73.985130, "New York", MARKER_COLOR_ROSE);
        addMarker("Empire State Building", 40.748817, -73.985428, "New York", MARKER_COLOR_ROSE);
        addMarker("Brooklyn Bridge", 40.706086, -73.996864, "New York", MARKER_COLOR_ROSE);
        addMarker("Grand Central Terminal", 40.752726, -73.977229, "New York", MARKER_COLOR_ROSE);
        addMarker("High Line", 40.748817, -74.004729, "New York", MARKER_COLOR_ROSE);
        addMarker("Metropolitan Museum of Art", 40.779437, -73.963244, "New York", MARKER_COLOR_ROSE);


        addMarker("Eiffel Tower", 48.858844, 2.294350, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Louvre Museum", 48.860611, 2.337644, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Notre-Dame Cathedral", 48.852968, 2.349902, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Montmartre", 48.886704, 2.343104, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Musée d'Orsay", 48.860518, 2.325652, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Sainte-Chapelle", 48.855572, 2.345920, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Montparnasse Tower", 48.841341, 2.319618, "Paris", MARKER_COLOR_YELLOW);
        addMarker("Seine River Cruise", 48.856771, 2.343060, "Paris", MARKER_COLOR_YELLOW);

        addMarker("Fisherman's Bastion", 47.502429, 19.034719, "Budapest", MARKER_COLOR_AZURE);
        addMarker("Parliament", 47.507131, 19.045239, "Budapest", MARKER_COLOR_AZURE);
        addMarker("Buda Castle", 47.496198, 19.039261, "Budapest", MARKER_COLOR_AZURE);
        addMarker("Tropicarium", 47.526743, 19.049655, "Budapest", MARKER_COLOR_AZURE);
        addMarker("Heroes' Square", 47.514288, 19.077498, "Budapest", MARKER_COLOR_AZURE);
        addMarker("Citadel", 47.481526, 19.046814, "Budapest", MARKER_COLOR_AZURE);
        addMarker("Budapest Castle Hill Funicular", 47.498080, 19.039703, "Budapest", MARKER_COLOR_AZURE);

        addMarker("St. Mark's Square", 45.434978, 12.339699, "Venice", MARKER_COLOR_VIOLET);
        addMarker("Rialto Bridge", 45.438532, 12.335149, "Venice", MARKER_COLOR_VIOLET);
        addMarker("Doge's Palace", 45.434473, 12.339453, "Venice", MARKER_COLOR_VIOLET);
        addMarker("Grand Canal", 45.438356, 12.335577, "Venice", MARKER_COLOR_VIOLET);
        addMarker("Bridge of Sighs", 45.433717, 12.339198, "Venice", MARKER_COLOR_VIOLET);
        addMarker("Murano Island", 45.458079, 12.356222, "Venice", MARKER_COLOR_VIOLET);
        addMarker("Burano Island", 45.485474, 12.416668, "Venice", MARKER_COLOR_VIOLET);

        addMarker("Valletta", 35.8984, 14.5146, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("Mdina", 35.8869, 14.4034, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("Gozo", 36.0443, 14.2516, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("Blue Lagoon", 36.0167, 14.3267, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("Marsaxlokk", 35.8419, 14.5431, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("Hagar Qim and Mnajdra Temples", 35.8345, 14.4244, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("The Three Cities", 35.8892, 14.5291, "Malta", MARKER_COLOR_MAGENTA);
        addMarker("Popeye Village", 35.9484, 14.4083, "Malta", MARKER_COLOR_MAGENTA);

        addMarker("Burj Khalifa", 25.1972, 55.2744, "Dubai", MARKER_COLOR_ORANGE);
        addMarker("Palm Jumeirah", 25.1123, 55.1380, "Dubai", MARKER_COLOR_ORANGE);
        addMarker("Dubai Mall", 25.1972, 55.2794, "Dubai", MARKER_COLOR_ORANGE);
        addMarker("Burj Al Arab", 25.1413, 55.1852, "Dubai", MARKER_COLOR_ORANGE);
        addMarker("Dubai Marina", 25.0673, 55.1401, "Dubai", MARKER_COLOR_ORANGE);
        addMarker("Dubai Creek", 25.2452, 55.3095, "Dubai", MARKER_COLOR_ORANGE);
        addMarker("Global Village", 25.0673, 55.3020, "Dubai", MARKER_COLOR_ORANGE);

        addMarker("Old Town Dubrovnik", 42.6403, 18.1102, "Dubrovnik", MARKER_COLOR_CYAN);
        addMarker("City Walls", 42.6411, 18.1082, "Dubrovnik", MARKER_COLOR_CYAN);
        addMarker("Stradun", 42.6411, 18.1098, "Dubrovnik", MARKER_COLOR_CYAN);
        addMarker("Dubrovnik Cable Car", 42.6407, 18.1067, "Dubrovnik", MARKER_COLOR_CYAN);
        addMarker("Lokrum Island", 42.6184, 18.1153, "Dubrovnik", MARKER_COLOR_CYAN);
        addMarker("Fort Lovrijenac", 42.6419, 18.1081, "Dubrovnik", MARKER_COLOR_CYAN);
        addMarker("Banje Beach", 42.6347, 18.1108, "Dubrovnik", MARKER_COLOR_CYAN);

        addMarker("Wat Arun", 13.7437, 100.4762, "Bangkok", MARKER_COLOR_YELLOW);
        addMarker("Grand Palace", 13.7510, 100.4927, "Bangkok", MARKER_COLOR_YELLOW);
        addMarker("Chatuchak Weekend Market", 13.7991, 100.5486, "Bangkok", MARKER_COLOR_YELLOW);
        addMarker("Lumphini Park", 13.7291, 100.5423, "Bangkok", MARKER_COLOR_YELLOW);
        addMarker("Chao Phraya River", 13.7538, 100.5130, "Bangkok", MARKER_COLOR_YELLOW);
        addMarker("Jim Thompson House", 13.7515, 100.5428, "Bangkok", MARKER_COLOR_YELLOW);
        addMarker("Asiatique The Riverfront", 13.7061, 100.5088, "Bangkok", MARKER_COLOR_YELLOW);


        addMarker("Golden Gate Bridge", 37.8199, -122.4783, "San Francisco", MARKER_COLOR_ROSE);
        addMarker("Alcatraz Island", 37.8267, -122.4230, "San Francisco", MARKER_COLOR_ROSE);
        addMarker("Fisherman's Wharf", 37.8080, -122.4177, "San Francisco", MARKER_COLOR_ROSE);
        addMarker("Lombard Street", 37.8021, -122.4187, "San Francisco", MARKER_COLOR_ROSE);
        addMarker("Golden Gate Park", 37.7694, -122.4862, "San Francisco", MARKER_COLOR_ROSE);
        addMarker("Palace of Fine Arts", 37.8024, -122.4487, "San Francisco", MARKER_COLOR_ROSE);
        addMarker("Coit Tower", 37.8024, -122.4058, "San Francisco", MARKER_COLOR_ROSE);


        addMarker("Sydney Opera House", -33.8568, 151.2153, "Sydney", MARKER_COLOR_GREEN);
        addMarker("Sydney Harbour Bridge", -33.8523, 151.2108, "Sydney", MARKER_COLOR_GREEN);
        addMarker("Bondi Beach", -33.8910, 151.2747, "Sydney", MARKER_COLOR_GREEN);
        addMarker("Darling Harbour", -33.8750, 151.1986, "Sydney", MARKER_COLOR_GREEN);
        addMarker("The Rocks", -33.8587, 151.2080, "Sydney", MARKER_COLOR_GREEN);
        addMarker("Royal Botanic Garden", -33.8640, 151.2180, "Sydney", MARKER_COLOR_GREEN);
        addMarker("Manly Beach", -33.7980, 151.2874, "Sydney", MARKER_COLOR_GREEN);


        addMarker("Christ the Redeemer", -22.9519, -43.2105, "Rio de Janeiro", MARKER_COLOR_BLUE);
        addMarker("Copacabana Beach", -22.9717, -43.1825, "Rio de Janeiro", MARKER_COLOR_BLUE);
        addMarker("Sugarloaf Mountain", -22.9486, -43.1549, "Rio de Janeiro", MARKER_COLOR_BLUE);
        addMarker("Ipanema Beach", -22.9868, -43.2057, "Rio de Janeiro", MARKER_COLOR_BLUE);
        addMarker("Tijuca National Park", -22.9475, -43.2793, "Rio de Janeiro", MARKER_COLOR_BLUE);
        addMarker("Lapa Arches", -22.9110, -43.1825, "Rio de Janeiro", MARKER_COLOR_BLUE);
        addMarker("Maracanã Stadium", -22.9122, -43.2302, "Rio de Janeiro", MARKER_COLOR_BLUE);


        addMarker("Colosseum", 41.8902, 12.4922, "Rome", MARKER_COLOR_RED);
        addMarker("Vatican City", 41.9022, 12.4539, "Rome", MARKER_COLOR_RED);
        addMarker("Trevi Fountain", 41.9009, 12.4833, "Rome", MARKER_COLOR_RED);
        addMarker("Pantheon", 41.8986, 12.4768, "Rome", MARKER_COLOR_RED);
        addMarker("Roman Forum", 41.8925, 12.4853, "Rome", MARKER_COLOR_RED);
        addMarker("Spanish Steps", 41.9057, 12.4823, "Rome", MARKER_COLOR_RED);
        addMarker("Piazza Navona", 41.8992, 12.4733, "Rome", MARKER_COLOR_RED);

        addMarker("Stari Most", 43.3378, 17.8129, "Mostar", MARKER_COLOR_YELLOW);
        addMarker("Old Bazaar", 43.3371, 17.8147, "Mostar", MARKER_COLOR_YELLOW);
        addMarker("Kriva Cuprija", 43.3428, 17.8145, "Mostar", MARKER_COLOR_YELLOW);
        addMarker("Skywalk", 43.3261, 17.8267, "Mostar", MARKER_COLOR_YELLOW);
        addMarker("Blagaj Tekke", 43.2510, 17.8924, "Mostar", MARKER_COLOR_YELLOW);

        addMarker("Marina Bay Sands", 1.2836, 103.8606, "Singapore", MARKER_COLOR_GREEN);
        addMarker("Gardens by the Bay", 1.2815, 103.8636, "Singapore", MARKER_COLOR_GREEN);
        addMarker("Chinatown", 1.2812, 103.8449, "Singapore", MARKER_COLOR_GREEN);
        addMarker("Sentosa Island", 1.2494, 103.8303, "Singapore", MARKER_COLOR_GREEN);
        addMarker("Singapore Zoo", 1.4043, 103.7930, "Singapore", MARKER_COLOR_GREEN);
        addMarker("Universal Studios Singapore", 1.2540, 103.8238, "Singapore", MARKER_COLOR_GREEN);
        addMarker("Merlion Park", 1.2868, 103.8545, "Singapore", MARKER_COLOR_GREEN);

        addMarker("Charles Bridge", 50.0865, 14.4115, "Prague", MARKER_COLOR_BLUE);
        addMarker("Prague Castle", 50.0901, 14.3998, "Prague", MARKER_COLOR_BLUE);
        addMarker("Old Town Square", 50.0875, 14.4214, "Prague", MARKER_COLOR_BLUE);
        addMarker("Wenceslas Square", 50.0791, 14.4295, "Prague", MARKER_COLOR_BLUE);
        addMarker("Prague Zoo", 50.1187, 14.4144, "Prague", MARKER_COLOR_BLUE);
        addMarker("Vyšehrad", 50.0647, 14.4185, "Prague", MARKER_COLOR_BLUE);
        addMarker("Josefov (Jewish Quarter)", 50.0908, 14.4195, "Prague", MARKER_COLOR_BLUE);

        addMarker("Rijksmuseum", 52.3599, 4.8851, "Amsterdam", MARKER_COLOR_YELLOW);
        addMarker("Van Gogh Museum", 52.3584, 4.8810, "Amsterdam", MARKER_COLOR_YELLOW);
        addMarker("Anne Frank House", 52.3752, 4.8837, "Amsterdam", MARKER_COLOR_YELLOW);
        addMarker("Dam Square", 52.3726, 4.8931, "Amsterdam", MARKER_COLOR_YELLOW);
        addMarker("Vondelpark", 52.3580, 4.8683, "Amsterdam", MARKER_COLOR_YELLOW);
        addMarker("Jordaan", 52.3779, 4.8818, "Amsterdam", MARKER_COLOR_YELLOW);
        addMarker("De Pijp", 52.3564, 4.8945, "Amsterdam", MARKER_COLOR_YELLOW);

        addMarker("South Beach", 25.7824, -80.1341, "Miami", MARKER_COLOR_CYAN);
        addMarker("Wynwood Walls", 25.8010, -80.1997, "Miami", MARKER_COLOR_CYAN);
        addMarker("Little Havana", 25.7665, -80.2097, "Miami", MARKER_COLOR_CYAN);
        addMarker("Vizcaya Museum and Gardens", 25.7449, -80.2103, "Miami", MARKER_COLOR_CYAN);
        addMarker("Everglades National Park", 25.2866, -80.8987, "Miami", MARKER_COLOR_CYAN);
        addMarker("Bayside Marketplace", 25.7776, -80.1866, "Miami", MARKER_COLOR_CYAN);

        addMarker("Millennium Park", 41.8825, -87.6233, "Chicago", MARKER_COLOR_GREEN);
        addMarker("Art Institute of Chicago", 41.8796, -87.6237, "Chicago", MARKER_COLOR_GREEN);
        addMarker("Navy Pier", 41.8917, -87.6094, "Chicago", MARKER_COLOR_GREEN);
        addMarker("The Magnificent Mile", 41.8915, -87.6244, "Chicago", MARKER_COLOR_GREEN);
        addMarker("Willis Tower", 41.8789, -87.6359, "Chicago", MARKER_COLOR_GREEN);
        addMarker("Lincoln Park Zoo", 41.9235, -87.6354, "Chicago", MARKER_COLOR_GREEN);

        addMarker("Maid of the Mist", 43.0864, -79.0712, "Niagara Falls", MARKER_COLOR_ORANGE);
        addMarker("Cave of the Winds", 43.0836, -79.0647, "Niagara Falls", MARKER_COLOR_ORANGE);
        addMarker("Niagara Falls State Park", 43.0812, -79.0663, "Niagara Falls", MARKER_COLOR_ORANGE);
        addMarker("Journey Behind the Falls", 43.0834, -79.0780, "Niagara Falls", MARKER_COLOR_ORANGE);
        addMarker("Niagara SkyWheel", 43.0844, -79.0780, "Niagara Falls", MARKER_COLOR_ORANGE);
        addMarker("Niagara Parkway", 43.1550, -79.0703, "Niagara Falls", MARKER_COLOR_ORANGE);

        addMarker("Hollywood Walk of Fame", 34.1015, -118.3414, "Los Angeles", MARKER_COLOR_YELLOW);
        addMarker("Getty Center", 34.0776, -118.4740, "Los Angeles", MARKER_COLOR_YELLOW);
        addMarker("Santa Monica Pier", 34.0080, -118.4975, "Los Angeles", MARKER_COLOR_YELLOW);
        addMarker("Griffith Observatory", 34.1184, -118.3004, "Los Angeles", MARKER_COLOR_YELLOW);
        addMarker("Universal Studios Hollywood", 34.1381, -118.3534, "Los Angeles", MARKER_COLOR_YELLOW);
        addMarker("Venice Beach", 33.9850, -118.4695, "Los Angeles", MARKER_COLOR_YELLOW);

        addMarker("The Strip", 36.1147, -115.1728, "Las Vegas", MARKER_COLOR_BLUE);
        addMarker("Bellagio Fountains", 36.1129, -115.1743, "Las Vegas", MARKER_COLOR_BLUE);
        addMarker("High Roller Observation Wheel", 36.1184, -115.1717, "Las Vegas", MARKER_COLOR_BLUE);
        addMarker("Fremont Street Experience", 36.1700, -115.1443, "Las Vegas", MARKER_COLOR_BLUE);
        addMarker("Stratosphere Tower", 36.1473, -115.1550, "Las Vegas", MARKER_COLOR_BLUE);
        addMarker("Neon Museum", 36.1772, -115.1356, "Las Vegas", MARKER_COLOR_BLUE);



        addMarker("Hallgrímskirkja", 64.1417, -21.9266, "Reykjavik", MARKER_COLOR_CYAN);
        addMarker("Blue Lagoon", 63.8804, -22.4494, "Reykjavik", MARKER_COLOR_CYAN);
        addMarker("Perlan", 64.1184, -21.8475, "Reykjavik", MARKER_COLOR_CYAN);
        addMarker("Harpa Concert Hall", 64.1503, -21.9328, "Reykjavik", MARKER_COLOR_CYAN);
        addMarker("Gullfoss Waterfall", 64.3279, -20.1216, "Reykjavik", MARKER_COLOR_CYAN);
        addMarker("Geysir Geothermal Area", 64.3104, -20.3024, "Reykjavik", MARKER_COLOR_CYAN);



        addMarker("Acropolis", 37.9715, 23.7263, "Athens", MARKER_COLOR_AZURE);
        addMarker("Plaka", 37.9714, 23.7261, "Athens", MARKER_COLOR_AZURE);
        addMarker("Parthenon", 37.9715, 23.7263, "Athens", MARKER_COLOR_AZURE);
        addMarker("National Archaeological Museum", 37.9899, 23.7325, "Athens", MARKER_COLOR_AZURE);
        addMarker("Syntagma Square", 37.9753, 23.7344, "Athens", MARKER_COLOR_AZURE);



        addMarker("Teatro Colon", -34.5981, -58.3837, "Buenos Aires", MARKER_COLOR_MAGENTA);
        addMarker("La Boca", -34.6345, -58.3630, "Buenos Aires", MARKER_COLOR_MAGENTA);
        addMarker("Recoleta Cemetery", -34.5883, -58.3923, "Buenos Aires", MARKER_COLOR_MAGENTA);
        addMarker("Plaza de Mayo", -34.6083, -58.3724, "Buenos Aires", MARKER_COLOR_MAGENTA);
        addMarker("Palermo Soho", -34.5898, -58.4325, "Buenos Aires", MARKER_COLOR_MAGENTA);


        addMarker("Shibuya Crossing", 35.6590, 139.7006, "Tokyo", MARKER_COLOR_MAGENTA);
        addMarker("Meiji Shrine", 35.6763, 139.6994, "Tokyo", MARKER_COLOR_MAGENTA);
        addMarker("Tokyo Tower", 35.6586, 139.7454, "Tokyo", MARKER_COLOR_MAGENTA);
        addMarker("Tsukiji Fish Market", 35.6604, 139.7694, "Tokyo", MARKER_COLOR_MAGENTA);
        addMarker("Akihabara Electric Town", 35.6995, 139.7710, "Tokyo", MARKER_COLOR_MAGENTA);
        addMarker("Senso-ji Temple", 35.7146, 139.7967, "Tokyo", MARKER_COLOR_MAGENTA);


        addMarker("Waikiki Beach", 21.2810, -157.8375, "Honolulu", MARKER_COLOR_RED);
        addMarker("Diamond Head Crater", 21.2612, -157.8009, "Honolulu", MARKER_COLOR_RED);
        addMarker("Pearl Harbor", 21.3645, -157.9493, "Honolulu", MARKER_COLOR_RED);
        addMarker("Hanauma Bay", 21.2716, -157.6937, "Honolulu", MARKER_COLOR_RED);
        addMarker("Iolani Palace", 21.3069, -157.8583, "Honolulu", MARKER_COLOR_RED);


        addMarker("Adelaide Oval", -34.9151, 138.5954, "Adelaide", MARKER_COLOR_YELLOW);
        addMarker("Barossa Valley", -34.5333, 139.0506, "Adelaide", MARKER_COLOR_YELLOW);
        addMarker("Glenelg Beach", -34.9813, 138.5154, "Adelaide", MARKER_COLOR_YELLOW);
        addMarker("Adelaide Botanic Garden", -34.9210, 138.6031, "Adelaide", MARKER_COLOR_YELLOW);
        addMarker("Art Gallery of South Australia", -34.9218, 138.6036, "Adelaide", MARKER_COLOR_YELLOW);



        addMarker("Monserrate", 4.6071, -74.0533, "Bogota", MARKER_COLOR_AZURE);
        addMarker("Gold Museum", 4.5981, -74.0710, "Bogota", MARKER_COLOR_AZURE);
        addMarker("La Candelaria", 4.5949, -74.0721, "Bogota", MARKER_COLOR_AZURE);
        addMarker("Botero Museum", 4.5941, -74.0712, "Bogota", MARKER_COLOR_AZURE);
        addMarker("Usaquén District", 4.6965, -74.0315, "Bogota", MARKER_COLOR_AZURE);


        addMarker("Pyramids of Giza", 29.9792, 31.1342, "Cairo", MARKER_COLOR_GREEN);
        addMarker("Egyptian Museum", 30.0478, 31.2336, "Cairo", MARKER_COLOR_GREEN);
        addMarker("Khan El Khalili Market", 30.0475, 31.2621, "Cairo", MARKER_COLOR_GREEN);
        addMarker("Cairo Citadel", 30.0295, 31.2614, "Cairo", MARKER_COLOR_GREEN);
        addMarker("Old Cairo", 30.0121, 31.2317, "Cairo", MARKER_COLOR_GREEN);


        addMarker("Table Mountain", -33.9626, 18.4090, "Cape Town", MARKER_COLOR_BLUE);
        addMarker("V&A Waterfront", -33.9078, 18.4227, "Cape Town", MARKER_COLOR_BLUE);
        addMarker("Robben Island", -33.8053, 18.3584, "Cape Town", MARKER_COLOR_BLUE);
        addMarker("Kirstenbosch Botanical Garden", -33.9889, 18.4328, "Cape Town", MARKER_COLOR_BLUE);
        addMarker("Boulders Beach", -34.1973, 18.4514, "Cape Town", MARKER_COLOR_BLUE);
        addMarker("District Six Museum", -33.9276, 18.4214, "Cape Town", MARKER_COLOR_BLUE);
        addMarker("Castle of Good Hope", -33.9260, 18.4256, "Cape Town", MARKER_COLOR_BLUE);


        addMarker("Mount Kilimanjaro", -3.0674, 37.3556, "Kilimanjaro", MARKER_COLOR_CYAN);
        addMarker("Ngorongoro Crater", -3.1615, 35.5876, "Kilimanjaro", MARKER_COLOR_CYAN);
        addMarker("Serengeti National Park", -2.1540, 34.6857, "Kilimanjaro", MARKER_COLOR_CYAN);
        addMarker("Amboseli National Park", -2.6528, 37.2579, "Kilimanjaro", MARKER_COLOR_CYAN);
        addMarker("Lake Manyara National Park", -3.3870, 35.8292, "Kilimanjaro", MARKER_COLOR_CYAN);


        addMarker("Milford Sound", -44.6717, 167.9252, "New Zealand", MARKER_COLOR_VIOLET);
        addMarker("Queenstown", -45.0312, 168.6626, "New Zealand", MARKER_COLOR_VIOLET);
        addMarker("Rotorua", -38.1368, 176.2497, "New Zealand", MARKER_COLOR_VIOLET);
        addMarker("Mount Cook", -43.7348, 170.0965, "New Zealand", MARKER_COLOR_VIOLET);
        addMarker("Waitomo Caves", -38.2619, 175.1140, "New Zealand", MARKER_COLOR_VIOLET);
        addMarker("Franz Josef Glacier", -43.4644, 170.1836, "New Zealand", MARKER_COLOR_VIOLET);
        addMarker("Tongariro National Park", -39.2904, 175.5710, "New Zealand", MARKER_COLOR_VIOLET);


        addMarker("Old Havana", 23.1330, -82.3830, "Havana", MARKER_COLOR_ORANGE);
        addMarker("Malecón", 23.1398, -82.3615, "Havana", MARKER_COLOR_ORANGE);
        addMarker("El Capitolio", 23.1362, -82.3587, "Havana", MARKER_COLOR_ORANGE);
        addMarker("Revolution Square", 23.1246, -82.3866, "Havana", MARKER_COLOR_ORANGE);
        addMarker("Fortaleza San Carlos de la Cabaña", 23.1399, -82.3526, "Havana", MARKER_COLOR_ORANGE);
        addMarker("Museum of the Revolution", 23.1415, -82.3562, "Havana", MARKER_COLOR_ORANGE);


        addMarker("Plaza de Armas", -12.0464, -77.0428, "Lima", MARKER_COLOR_RED);
        addMarker("Larcomar", -12.1328, -77.0305, "Lima", MARKER_COLOR_RED);
        addMarker("San Francisco Church", -12.0459, -77.0299, "Lima", MARKER_COLOR_RED);
        addMarker("Barranco District", -12.1442, -77.0206, "Lima", MARKER_COLOR_RED);
        addMarker("Huaca Pucllana", -12.0951, -77.0363, "Lima", MARKER_COLOR_RED);
        addMarker("Magic Water Circuit", -12.0683, -77.0338, "Lima", MARKER_COLOR_RED);


        addMarker("Mount Everest Base Camp", 27.9881, 86.9250, "Kathmandu", MARKER_COLOR_RED);
        addMarker("Kathmandu Durbar Square", 27.7030, 85.3155, "Kathmandu", MARKER_COLOR_GREEN);
        addMarker("Phewa Lake, Pokhara", 28.2096, 83.9856, "Kathmandu", MARKER_COLOR_BLUE);
        addMarker("Lumbini", 27.4500, 83.2717, "Kathmandu", MARKER_COLOR_YELLOW);
        addMarker("Annapurna Circuit", 28.5915, 83.8207, "Kathmandu", MARKER_COLOR_ORANGE);


        addMarker("Gandantegchinlen Monastery", 47.9131, 106.9240, "Ulaanbaatar", MARKER_COLOR_RED);
        addMarker("Sukhbaatar Square", 47.9176, 106.9174, "Ulaanbaatar", MARKER_COLOR_GREEN);
        addMarker("National Museum of Mongolia", 47.9222, 106.9186, "Ulaanbaatar", MARKER_COLOR_BLUE);
        addMarker("Zaisan Memorial", 47.8914, 106.8843, "Ulaanbaatar", MARKER_COLOR_YELLOW);
        addMarker("Bogd Khan Palace Museum", 47.9139, 106.8942, "Ulaanbaatar", MARKER_COLOR_ORANGE);


        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.509865, -0.118092), 5));
    }

    private void addMarker(String title, double latitude, double longitude, String city, float markerColor) {
        LatLng location = new LatLng(latitude, longitude);
        gMap.addMarker(new MarkerOptions()
                .position(location)
                .title(title)
                .snippet("City: " + city)
                .icon(BitmapDescriptorFactory.defaultMarker(markerColor)));
    }
}
