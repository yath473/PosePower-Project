package com.posep.isometricwellness;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.posep.isometricwellness.R;
import com.posep.isometricwellness.ui.ui.one.Workout1;
import com.posep.isometricwellness.ui.ui.two.Workout2;
import com.posep.isometricwellness.ui.ui.three.Workout3;
import com.posep.isometricwellness.ui.ui.four.Workout4;
import com.posep.isometricwellness.ui.ui.five.Workout5;
import com.posep.isometricwellness.ui.ui.six.Workout6;
import com.posep.isometricwellness.ui.ui.seven.Workout7;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    Button button;
    DrawerLayout drawerLayout;
    ImageButton imageButton;
    NavigationView navView;
    ImageView img;

    TextView title;
    boolean empty = false;

    MenuItem itemOne;
    MenuItem itemTwo;
    MenuItem itemThree;
    MenuItem itemFour;
    MenuItem itemFive;
    MenuItem itemSix;
    MenuItem itemSeven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        button = findViewById(R.id.id_summary);
        drawerLayout = findViewById(R.id.coordinatorLayout);
        imageButton = findViewById(R.id.buttonDrawerToggle);
        title = findViewById(R.id.textView);
        img = findViewById(R.id.imageView2);

        navView = findViewById(R.id.navView);
        Menu menu = navView.getMenu();

        itemOne = menu.findItem(R.id.navResult1);
        itemTwo = menu.findItem(R.id.navResult2);
        itemThree = menu.findItem(R.id.navResult3);
        itemFour = menu.findItem(R.id.navResult4);
        itemFive = menu.findItem(R.id.navResult5);
        itemSix = menu.findItem(R.id.navResult6);
        itemSeven = menu.findItem(R.id.navResult7);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empty = true;
            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.navHome){
                    CloseCurrentFragment();

                    title.setVisibility(View.VISIBLE);
                    button.setEnabled(true);
                    button.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }
                if(itemId == R.id.navCamera){
                    //empty = true;
                   replaceFragments(new com.posep.isometricwellness.CameraFragment());
                    ViewSettingsInvisible();
                    img.setVisibility(View.INVISIBLE);
                }
                if(itemId == R.id.navResult1){
                    if(!(com.posep.isometricwellness.CameraFragment.OpenWorkouts())){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemOne.setTitle("Workout 1 Results");
                      replaceFragments(new Workout1());
                      ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                if(itemId == R.id.navResult2){
                    if(!(com.posep.isometricwellness.CameraFragment.OpenWorkouts()) || com.posep.isometricwellness.CameraFragment.getCount() == 1){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First Select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemTwo.setTitle("Workout 2 Results");
                        replaceFragments(new Workout2());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                   }
                }
                if(itemId == R.id.navResult3){
                    if(!(com.posep.isometricwellness.CameraFragment.OpenWorkouts()) || CameraFragment.getCount() <= 2){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First Select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemThree.setTitle("Workout 3 Results");
                        replaceFragments(new Workout3());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                if(itemId == R.id.navResult4){
                    if(!(CameraFragment.OpenWorkouts()) || CameraFragment.getCount() <= 3){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First Select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemFour.setTitle("Workout 4 Results");
                        replaceFragments(new Workout4());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                if(itemId == R.id.navResult5){
                    if(!(CameraFragment.OpenWorkouts()) || CameraFragment.getCount() <= 4){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First Select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemFive.setTitle("Workout 5 Results");
                        replaceFragments(new Workout5());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                if(itemId == R.id.navResult6){
                    if(!(com.posep.isometricwellness.CameraFragment.OpenWorkouts()) || CameraFragment.getCount() <= 5){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First Select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemSix.setTitle("Workout 6 Results");
                        replaceFragments(new Workout6());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                if(itemId == R.id.navResult7){
                    if(!(com.posep.isometricwellness.CameraFragment.OpenWorkouts()) || com.posep.isometricwellness.CameraFragment.getCount() <= 6){
                        Toast.makeText(getApplicationContext(), "This results set is empty! First Select a photo!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        itemSeven.setTitle("Workout 7 Results");
                        replaceFragments(new Workout7());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                if(itemId == R.id.summary){
                    if(empty){
                        replaceFragments(new com.posep.isometricwellness.Summary());
                        ViewSettingsInvisible();
                        img.setVisibility(View.INVISIBLE);
                    }
                }

                drawerLayout.close();
                return false;
            }
        });
    }

    public void openDrawer() {
        drawerLayout.open();
    }
    public void CloseCurrentFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.remove(currentFragment); //removing frag
        transaction.commit();
    }
    public void ViewSettingsInvisible(){
        title.setVisibility(View.INVISIBLE);
        button.setEnabled(false);
        button.setVisibility(View.INVISIBLE);
    }
    private void replaceFragments(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}