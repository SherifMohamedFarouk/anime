package com.veirn.animee;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;


import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import br.liveo.model.HelpLiveo;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar ;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawerb();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }


    private void setupViewPager ( ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag( new OneFragment() , "Characters");
        adapter.addFrag(new TwoFragment() , "Top Animes");
        viewPager.setAdapter(adapter);
    }

    public void  Drawerb(){
     new DrawerBuilder().withActivity(this).build();
     PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home");
     SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("inbox");

//create the drawer and remember the `Drawer` result object
      final Drawer result = new DrawerBuilder()
             .withActivity(this)
             .withToolbar(null)
             .addDrawerItems(
                     item1,
                     new DividerDrawerItem(),
                     item2,
                     new SecondaryDrawerItem().withName("Settings")
             )
             .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                 @Override
                 public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                     if (drawerItem instanceof Nameable) {
                         Toast.makeText(MainActivity.this, ((Nameable) drawerItem).getName().getText(MainActivity.this), Toast.LENGTH_SHORT).show();
                     }
                     return false;

                 }
             })
             .build();

 }
}
