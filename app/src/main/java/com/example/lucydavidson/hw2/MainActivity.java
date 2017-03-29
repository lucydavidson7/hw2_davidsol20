package com.example.lucydavidson.hw2;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.SurfaceView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.Menu;

/**
 * Created by lucydavidson on 3/26/17.
 */

public class MainActivity extends Activity
        implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    //Initialize variables for the seek bars, text views, and image.
    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private TextView redText;
    private TextView greenText;
    private TextView blueText;
    private TextView elementText;
    private ImageCreation myImage;

    //Variable to identify the last shape on the screen that was selected.
    private int selectedShape;

    @Override
    public void onCreate(Bundle SavedInstanceState){

        super.onCreate(SavedInstanceState);
        setContentView(R.layout.layout_main);

        myImage = (ImageCreation)this.findViewById(R.id.theImage);
        myImage.invalidate();

        redSeek = (SeekBar)findViewById(R.id.red_seekBar);
        greenSeek = (SeekBar)findViewById(R.id.green_seekBar);
        blueSeek = (SeekBar)findViewById(R.id.blue_seekBar);

        redText = (TextView)findViewById(R.id.red_text);
        greenText = (TextView)findViewById(R.id.green_text);
        blueText = (TextView)findViewById(R.id.blue_text);
        elementText = (TextView)findViewById(R.id.element_text);

        myImage.setOnTouchListener(this);
        redSeek.setOnSeekBarChangeListener(this);
        greenSeek.setOnSeekBarChangeListener(this);
        blueSeek.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Variables for identifying the seekBar and its new value.
        int select = seekBar.getId();
        int prog = progress;

        //Get rgb values from the color of the selected seekbar.
        int r = Color.red(myImage.shapes.get(selectedShape).getColor());
        int g = Color.green(myImage.shapes.get(selectedShape).getColor());
        int b = Color.blue(myImage.shapes.get(selectedShape).getColor());


        //Identify which seekbar is pressed.
        if(select == R.id.red_seekBar){
            //Get the progress of the seekbar and then set it to the selected shape's
            //color value.
            prog = redSeek.getProgress();
            //Set the image to the new red value.
            myImage.shapes.get(selectedShape).setColor(Color.rgb(prog, g, b));
            //Set the text that is above the seekbar.
            redText.setText("" + prog);
            //Reload the surfaceView so that it shows the current color.
            myImage.invalidate();
        }
        if(select == R.id.green_seekBar){
            prog = greenSeek.getProgress();
            myImage.shapes.get(selectedShape).setColor(Color.rgb(r, prog, b));
            greenText.setText("" + prog);
            myImage.invalidate();
        }
        if(select == R.id.blue_seekBar){
            prog = blueSeek.getProgress();
            myImage.shapes.get(selectedShape).setColor(Color.rgb(r, g, prog));
            blueText.setText("" + prog);
            myImage.invalidate();
        }

        /**
         External Citation
         Date: 27 March 2017
         Problem: Wasn't sure how to easily convert a rgb color value to
         a hexadecimal value.
         Resource:
         https://developer.android.com/reference/android/graphics/
         Color.html#argb(int, int, int, int)
         Solution: Use Color.rgb(int, int, int).
         */
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //Variables for the x and y values that were pressed.
        int x = (int)event.getX();
        int y = (int)event.getY();

        /**
         External Citation
         Date: 26 March 2017
         Problem: Needed to access the x and y coordinates on the image.
         Resource:
         https://developer.android.com/reference/android/graphics/
         Color.html#argb(int, int, int, int)
         Solution: Use Color.rgb(int, int, int).
         */

        //Loop through all the shapes in the image to find if it contains the
        //the point that is associated with the touch event.
        for(int i = 0; i < (myImage.shapes.size() - 6); i++) {
            //If the shapes contains the point the do what is in the statement.
            if (myImage.shapes.get(i).containsPoint(x,y)) {
                //Set text to given shape and identify the selected shape.
                elementText.setText(myImage.shapes.get(i).getName());
                selectedShape = i; //Set selectedShape for use in seek bars.

                //Set all the text fields to the given shape.
                redText.setText("" + Color.red(myImage.shapes.get(i).getColor()));
                greenText.setText("" + Color.green(myImage.shapes.get(i).getColor()));
                blueText.setText("" + Color.blue(myImage.shapes.get(i).getColor()));

                //Set all the seek fields to the given shape.
                redSeek.setProgress(Color.red(myImage.shapes.get(i).getColor()));
                greenSeek.setProgress(Color.green(myImage.shapes.get(i).getColor()));
                blueSeek.setProgress(Color.blue(myImage.shapes.get(i).getColor()));
            }
        }

        return false;
    }
    /**
     External Citation
     Date: 27 March 2017
     Problem: Wasn't sure how to easily convert a hexadecimal color value to
      its individual red, green and blue values.
     Resource:
      https://developer.android.com/reference/android/graphics/
      Color.html#argb(int, int, int, int)
     Solution: Use Color.red(); Color.green(); Color.blue();
    */

    /**
     External Citation
     Date: 27 March 2017
     Problem: Wasn't sure how to easily convert a hexadecimal color value to
     its individual red, green and blue values.
     Resource:
     https://developer.android.com/reference/android/graphics/
     Color.html#argb(int, int, int, int)
     Solution: Use Color.red(); Color.green(); Color.blue();
     */

    /**
     External Citation
     Date: 26 March 2017
     Problem: Examples of events in Android.
     Resource: referenced ExampleCodeForAndroidEvents on the Moodle page.
     */
}
