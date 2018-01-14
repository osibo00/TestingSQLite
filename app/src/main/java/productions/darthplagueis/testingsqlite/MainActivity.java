package productions.darthplagueis.testingsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import productions.darthplagueis.testingsqlite.model.Fellow;
import productions.darthplagueis.testingsqlite.model.LaptopSighting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FellowsDatabaseHelper fellowsDatabaseHelper = new FellowsDatabaseHelper(getApplicationContext());

        fellowsDatabaseHelper.addFellow(new Fellow("Lin", "Lily", "Spotify"));
        fellowsDatabaseHelper.addFellow(new Fellow("Lin", "Lily", "Spotify"));
        fellowsDatabaseHelper.addFellow(new Fellow("Smith", "Jordan", "LinkedIn"));
        fellowsDatabaseHelper.addFellow(new Fellow("Li", "Rusi", "Weight Watchers"));
        fellowsDatabaseHelper.addFellow(new Fellow("Santos", "Derek", "Uber"));
        fellowsDatabaseHelper.addFellow(new Fellow("Lui", "Danny", "Max2"));

        List<Fellow> fellows = fellowsDatabaseHelper.getFellowList();

        for(Fellow f : fellows) {
            Log.d("Fellows? ", f.getFirstName() + " " + f.getLastName() + " - " + f.getCompany());
        }

        LaptopSightingDatabaseHelper databaseHelper = new LaptopSightingDatabaseHelper(getApplicationContext());

        databaseHelper.addSighting(new LaptopSighting("palpatine", "macbook", 1, 1, "ISD", 0, 36));

        List<LaptopSighting> sightings = databaseHelper.getSightingList();

        for (LaptopSighting s : sightings) {
            Log.d("Laptop Sightings", s.getName() + " " + s.getTimeStamp());
        }
    }
}
