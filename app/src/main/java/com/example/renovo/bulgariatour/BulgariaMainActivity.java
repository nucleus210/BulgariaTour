package com.example.renovo.bulgariatour;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.renovo.bulgariatour.viewmodel.DataHolderModel;

import java.util.ArrayList;
import java.util.List;

public class BulgariaMainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PlacesListFragment.OnListFragmentInteractionListener,
        HistoryItemFragment.OnHistoryInteractionListener,
        TourItemGrid.OnGridFragmentListener {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulgaria_main);
        Context mContext = getApplicationContext();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mViewPager = findViewById(R.id.my_pager);
        TabLayout mTabLayout = findViewById(R.id.my_tab);
        mTabLayout.setupWithViewPager(mViewPager);
        SetUpViewPager(mViewPager);

        DataHolderModel.getInstance(mContext)
                .setHistoryImageDesc(CitesResourceDescriptor.historyDescriptorImage);
        DataHolderModel.getInstance(mContext)
                .setHistoryDataDesc(CitesResourceDescriptor.historyDescriptorDetail);
        DataHolderModel.getInstance(mContext)
                .setHistoryTitleDesc(CitesResourceDescriptor.historyDescriptorTitle);
        DataHolderModel.getInstance(mContext)
                .setHistoryLicenseDesc(CitesResourceDescriptor.historyImageLicense);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void SetUpViewPager(ViewPager viewPager) {
        TourPagerAdapter adapter = new TourPagerAdapter(getSupportFragmentManager());
        adapter.AddFragmentPage(new TourItemGrid(), "Cities");
        adapter.AddFragmentPage(new HistoryItemFragment(), "History");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back_button) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cities) {
            mViewPager.setCurrentItem(0);
        } else if (id == R.id.history_page) {
            mViewPager.setCurrentItem(1);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onGridFragmentListener() {
    }

    @Override
    public void onListFragmentInteraction(int position) {
    }

    @Override
    public void onHistoryInteractionListener() {
    }

    class TourPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mTitleList = new ArrayList<>();

        TourPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        void AddFragmentPage(Fragment mFragment, String mTitle) {
            mFragments.add(mFragment);
            mTitleList.add(mTitle);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}

