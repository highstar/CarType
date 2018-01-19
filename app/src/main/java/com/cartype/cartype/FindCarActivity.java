package com.cartype.cartype;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindCarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_car);
    }

    private CarExpert expert = new CarExpert();

    //Called when the user clicks the button
    public void onClickFindCar(View view){
        //Get a reference to the TextView
        TextView types = (TextView) findViewById(R.id.types);

        //Get a reference to the Spinner
        Spinner brands = (Spinner) findViewById(R.id.brands);

        //Get the selected item in the Spinner
        String carBrands = String.valueOf(brands.getSelectedItem());

        //Get recommendations from the CarExpert class
        List<String> typeList = expert.getTypes(carBrands);
        StringBuilder typesFormatted = new StringBuilder();
        for(String type:typeList) {
            typesFormatted.append(type).append('\n');
        }

        //Display the cars
        types.setText(typesFormatted);
    }
}
