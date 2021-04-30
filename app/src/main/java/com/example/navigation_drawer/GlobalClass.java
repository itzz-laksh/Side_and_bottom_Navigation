package com.example.navigation_drawer;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.OrientationEventListener;
import android.view.View;

public class GlobalClass {
    /**
     *
     * @param view                for getting view
     * @param orientation         for setting orientation of view
     * @param colors              for setting color of view
     * @param corner_radius       for setting corner_radius of view
     * @param stroke_width        for setting stroke_width of view
     * @param stroke_color        for setting stroke_color of view
     */

    public void Gradient_function(View view,int orientation,int[] colors,int corner_radius,int stroke_width, String stroke_color){

        GradientDrawable shape = new GradientDrawable();
        if(orientation==1)
            shape.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        if(orientation==2)
            shape.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        if(stroke_width!=0)
            shape.setStroke(stroke_width,Color.parseColor(stroke_color));
        shape.setColors(colors);
        shape.setCornerRadius(corner_radius);
        view.setBackground(shape);
    }
}
