package com.acadgild.weightlossmagic.question;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.acadgild.weightlossmagic.R;
/**
 * Created by DivyaVipin on 3/22/2017.
 */

public class Question extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    Toolbar toolbar;
    HashMap<String, List<String>> listDataChild;
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_listview);
       toolbar=(Toolbar)findViewById(R.id.toolbar) ;
       toolbar.setTitleTextColor(Color.WHITE);
       setSupportActionBar(toolbar);
       expListView = (ExpandableListView) findViewById(R.id.lvExp);
       prepareListData();
       listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataHeader.add("Q.What are Calories?");
        listDataHeader.add("Q.I'm on a diet to lose weight. Do I still need to exercise? ");
        listDataHeader.add("Q.How many calories do I need to burn to lose a pound of weight? ");
        listDataHeader.add("Q.When I eat more than I need what happens to the extra calories?  ");
        listDataHeader.add("Q.How can I get enough nutrients without consuming too many calories?  ");
        listDataHeader.add("Q.How can I burn off my stored body fat?");
        List<String>  calories = new ArrayList<String>();
        calories.add("A calorie is a unit of energy. In nutrition and everyday language, calories refer to energy consumption through eating and drinking, and energy usage through physical activity. For example, an apple may have 80 calories, while a 1 mile walk might use up about 100 calories.");
        List<String>  diet = new ArrayList<String>();
        diet.add("Physical activity is a key component of helping you move toward a healthier weight, as it can help you achieve the appropriate calorie balance. People who exercise regularly may be more likely to keep the weight from coming back after losing weight. Check out the following resources on physical activity:\n" +
                "Be Active Your Way: A Guide for Adults from the Physical Activity Guidelines\n" +
                "MyPlate Physical Activity\n" +
                "CDC's Physical Activity for a Healthy Weight ");
        List<String>  pound = new ArrayList<String>();
        pound.add("You need to burn off 3,500 calories more than you take in to lose 1 pound. This translates into a reduction of 500 calories per day to lose 1 pound in a week, or 1000 calories per day to lose 2 pounds in a week. (1-2 pounds per week is generally considered to be a safe rate of weight loss.) This can be achieved by eating fewer calories or using up more through physical activity. A combination of both is best. See CDC's Balancing Calories web page to learn more.");
        List<String>  e = new ArrayList<String>();
        e.add("Consuming extra calories results in an accumulation of stored body fat and weight gain. This is true whether the excess calories come from protein, fat, carbohydrate, or alcohol.");
        List<String>  f = new ArrayList<String>();
        f.add("The Dietary Guidelines for Americans encourages you to choose a variety of nutrient-dense foods and beverages to help achieve recommended nutrient intakes. Foods like vegetables, fruits, whole grains, low-fat dairy products, and lean protein foods can help you get the nutrients you need without excess calories. Avoid excess calories by limiting consumption of foods high in added sugars and solid fats, and alcoholic beverages; these provide calories but are poor sources of essential nutrients.");
        List<String>  belly = new ArrayList<String>();
        belly.add("We all need some body fat, but if stored fat is excessive it may increase risk of diet-related diseases such as heart disease, diabetes, and some cancers. This is particularly true if excess fat is in the abdominal area. Check out Ways to Be Active, a publication from Fitness.gov, to learn more. \n" +
                "According to the CDC, a body mass index, or BMI, of 25 or higher is an indication that your weight may be unhealthy. And a waist circumference of over 40 inches in men and over 35 inches in women indicates excessive abdominal fat if BMI is 25 or higher. Calculate your BMI and find information on measuring your waist size from CDC. ");


listDataChild.put(listDataHeader.get(0),calories); // Header, Child data
        listDataChild.put(listDataHeader.get(1),diet);
        listDataChild.put(listDataHeader.get(2),pound);
        listDataChild.put(listDataHeader.get(3),e);
        listDataChild.put(listDataHeader.get(4),f);
        listDataChild.put(listDataHeader.get(5),belly);

    }
}