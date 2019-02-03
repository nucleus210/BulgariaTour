package com.example.renovo.bulgariatour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.renovo.bulgariatour.viewmodel.DataHolderModel;

public class PlacesListActivity extends BulgariaMainActivity implements
        PlacesListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        Toolbar toolbar = findViewById(R.id.toolbar_places);
        setSupportActionBar(toolbar);

        if (findViewById(R.id.list_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            PlacesListFragment placesListFragment = new PlacesListFragment();
            placesListFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.list_fragment_container,
                            placesListFragment,
                            "PLACES_FRAGMENT")
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onListFragmentInteraction(int position) {
        DataHolderModel.getInstance(this).setPos(position);
        Intent detailIntent = new Intent(this, DetailActivity.class);
        startActivity(detailIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.back_button:
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
