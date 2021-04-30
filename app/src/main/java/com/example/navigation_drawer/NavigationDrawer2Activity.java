package com.example.navigation_drawer;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavigationDrawer2Activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    /*private TextView Email;
    private TextView dp1;
    GlobalClass globalClass = new GlobalClass(); */ //GlobalClass's Gradient_function parameter passing flow(view,orientation,colors,corner_radius,stroke_width,stroke_color

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer2);

        /*init();
        emailset();
        dp_shape();*/
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        /*View inflatedView = getLayoutInflater().inflate(R.layout.nav_header_main, null);
        TextView Email = (TextView) inflatedView.findViewById(R.id.textView);
        Email.setText(str);*/

      /*  View header = mNavigationView.getHeaderView(0);
        mNameTextView = (TextView) header.findViewById(R.id.nameTextView);
        mNameTextView.setText("XYZ");*/

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView Email = (TextView) headerView.findViewById(R.id.textView);
        Email.setText("Your Text Here");*/


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_recent)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        BottomNavigationView bottom_nav_view = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottom_nav_view, navController);


       /* View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        TextView navUsername = (TextView) headerView.findViewById(R.id.textView);
        navUsername.setText("Hello");*/
        View headerView = navigationView.getHeaderView(0);
        TextView Email = (TextView) headerView.findViewById(R.id.textView);
        Email.setText(str);
    }


    /*private void init() {
        Email = (TextView) findViewById(R.id.textView);
        dp1 = (TextView) findViewById(R.id.dp1);
    }
    private void dp_shape() {
        int[] colors = {Color.parseColor("#f8f8f8"), Color.parseColor("#f8f8f8")};
        globalClass.Gradient_function(dp1, 1, colors, 200, 1, "#dddddd");
    }
    private void emailset() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        Email.setText(str);
    }*/


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.navigation_drawer2, menu);
            return true;
        }

        @Override
        public boolean onSupportNavigateUp () {
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                    || super.onSupportNavigateUp();
        }

       /* public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.nav_header_main, container, false);

            return rootView;
        }

    }*/
}
