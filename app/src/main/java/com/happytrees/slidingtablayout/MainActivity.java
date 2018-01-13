package com.happytrees.slidingtablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private SampleAdapter adapter;
    private TabLayout tabs;
    private ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pager=(ViewPager)findViewById(R.id.pager);
        adapter=new SampleAdapter(this, getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabs=(TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);

        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.fixed) {
            item.setChecked(!item.isChecked());

            if (item.isChecked()) {
                adapter.setPageCount(3);
                tabs.setTabMode(TabLayout.MODE_FIXED);
            }
            else {
                adapter.setPageCount(10);
                tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
            }

            adapter.notifyDataSetChanged();

            if (pager.getCurrentItem()>=3) {
                pager.setCurrentItem(2);
            }

            return(true);
        }

        return(super.onOptionsItemSelected(item));
    }
}