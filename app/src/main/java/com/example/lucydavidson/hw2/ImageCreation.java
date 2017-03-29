package com.example.lucydavidson.hw2;

 /**
 * Created by lucydavidson on 3/26/17.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.ArrayList;

public class ImageCreation extends SurfaceView {

    //Array to store all the shapes that make up the image.
    public ArrayList<CustomElement> shapes = new ArrayList<CustomElement>();

    /**
     External Citation
     Date: 27 March 2017
     Problem: How to add a custom element to the shapes array.
     Resource:
     https://developer.android.com/reference/java/util/ArrayList.html
     Solution: Use add(CustomElement) methods.
     */

    //The initialized colors of all the shapes.
    int headColor = 0xFFFFFF00; //sets the color of the head to yellow
    int leftEyeColor = 0xFFFFFFFF; //sets the color of the head to yellow
    int rightEyeColor = 0xFF0F0F00; //sets the color of the head to yellow
    int mouthColor = 0xFF00FF00; //sets the color of the head to yellow
    int hatBrimColor = 0xFF0000FF; //sets the color of the head to yellow
    int hatTopColor = 0xFFADD8E6; //sets the color of the head to yellow

    //Initialize each shape.
    CustomCircle head = new CustomCircle("HEAD", headColor, 650, 800, 500);
    CustomCircle leftEye = new CustomCircle("LEFT EYE", leftEyeColor, 450, 650, 100);
    CustomCircle rightEye = new CustomCircle("RIGHT EYE", rightEyeColor, 850, 650, 100);
    CustomRect mouth = new CustomRect("MOUTH", mouthColor, 400, 950, 900, 1050);
    CustomRect hatBrim = new CustomRect("BRIM OF HAT", hatBrimColor, 200, 250, 1100, 400);
    CustomRect hatTop = new CustomRect("TOP OF HAT", hatTopColor, 400, 50, 900, 250);


    //Constructor.
    public ImageCreation(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    //Constructor.
    public ImageCreation(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    //Constructor.
    public ImageCreation(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //Draw the image.
    @Override
    protected void onDraw(Canvas canvas) {
        //Add each shapes to array.
        shapes.add(0, head);
        shapes.add(1, leftEye);
        shapes.add(2, rightEye);
        shapes.add(3, mouth);
        shapes.add(4, hatBrim);
        shapes.add(5, hatTop);

        //Draw each shape in the shapes array to the surface view.
        for(int num = 0; num < shapes.size(); num++) {
            shapes.get(num).drawMe(canvas);
        }

    }

    /**
     External Citation
     Date: 26 March 2017
     Problem: Examples of surface view in Android.
     Resource: referenced SourceCodeExamplesForSurfaceView on the Moodle page.
     */
}
