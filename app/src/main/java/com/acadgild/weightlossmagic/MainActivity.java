package com.acadgild.weightlossmagic;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.TextView;

import com.acadgild.weightlossmagic.calorietracker.CalorieTracker;

import com.acadgild.weightlossmagic.fitness.HomeExcercise;
import com.acadgild.weightlossmagic.question.Question;
import com.acadgild.weightlossmagic.reminder.AlarmActivity;

import com.acadgild.weightlossmagic.weeklytracker.WeeklyTracker;
import com.acadgild.weightlossmagic.weighttips.WeightLossTips;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ListView listView;
    DrawerLayout drawer;
    TextView homeText;
    String[] names={"Weight Loss Foods","BMI Calculator","GM Diet Plan",
            "Calorie Calculator","Weight Loss Tips","Calorie List","Set Reminder","Enjoy Excercise","Daily Calorie Tracker",
            "Weekly Tracker","Calender","Fat Burning Drink","Questions and Answers"};

    int[] images={R.drawable.green_tea,R.drawable.bmi_image,R.drawable.gmdiet,R.drawable.calculator,
            R.drawable.w_loss,R.drawable.calorie,R.drawable.reminder,R.drawable.fitness,R.drawable.calorie_tracker,
            R.drawable.calorietracker,R.drawable.calender,R.drawable.bellyfat,R.drawable.question};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeText=(TextView)findViewById(R.id.txtViewHappy) ;
        Typeface font_content = Typeface.createFromAsset(getAssets(), "Gyn Toons.ttf");
        homeText.setTypeface(font_content);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=(ListView)findViewById(R.id.listViewNavigation);
        NavigationAdapter adapter=new NavigationAdapter(this,names,images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new DrawerItemClickListener());


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {

            // Highlight the selected item, update the title, and close the drawer
            // update selected item and title, then close the drawer
            listView.setItemChecked(position, true);
            selectItem(position);

        }
    }
    private void selectItem(int position) {

        // update the main content by replacing fragments
        if(position ==0)
        {
            Intent weight=new Intent(MainActivity.this,WeightLossFoods.class);
            startActivity(weight);
        }
        else if(position ==1)
        {
            Intent bmi=new Intent(MainActivity.this,BMICalculator.class);
            startActivity(bmi);
        }
        else if(position ==2)
        {
            Intent gm=new Intent(MainActivity.this,GMDiet.class);
            startActivity(gm);
        }
        else if(position ==3)
        {
            Intent cal=new Intent(MainActivity.this,CalorieCalculator.class);
            startActivity(cal);
        }
        else if(position==4)
        {
            Intent weighttip=new Intent(MainActivity.this,WeightLossTips.class);
            startActivity(weighttip);
        }
        else if(position==5)
        {
            Intent calorieList=new Intent(MainActivity.this,CalorieList.class);
            startActivity(calorieList);
        }
        else if(position==6)
        {
            Intent reminder=new Intent(MainActivity.this,AlarmActivity.class);
            startActivity(reminder);
        }

        else if(position == 7)
        {
            Intent homeexcercise=new Intent(MainActivity.this,HomeExcercise.class);
            startActivity(homeexcercise);
        }
        else if(position == 8)
        {
            Intent calorie_tracker=new Intent(MainActivity.this,CalorieTracker.class);
            startActivity(calorie_tracker);
        }
        else if(position == 9)
        {
            Intent weekily_tracker=new Intent(MainActivity.this,WeeklyTracker.class);
            startActivity(weekily_tracker);
        }
        else if(position == 10)
        {
            Intent calender=new Intent(MainActivity.this,Calender.class);
            startActivity(calender);
        }
        else if(position == 11)
        {
            Intent drink=new Intent(MainActivity.this,MagicDrink.class);
            startActivity(drink);
        }
        else
        {
            Intent question=new Intent(MainActivity.this,Question.class);
            startActivity(question);
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id==R.id.action_shareus)
        {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));

            return true;
        }

        else
            return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
