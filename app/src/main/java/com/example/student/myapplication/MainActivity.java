package com.example.student.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view){
        int id = view.getId();
        switch (id){
            case R.id.button1:
                Toast.makeText(MainActivity.this, "Simple Toast1 Message!", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Toast toast = Toast.makeText(MainActivity.this, "Another Toast2", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            case R.id.button3:
                SuperActivityToast.create(MainActivity.this, new Style(), Style.TYPE_STANDARD)
                        .setText("Coloring Toast")
                        .setDuration(Style.DURATION_LONG)
                        .setFrame(Style.FRAME_STANDARD)
                        .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE))
                        .setAnimations(Style.ANIMATIONS_POP).show();
                break;
            case R.id.button4:
                SuperActivityToast.create(MainActivity.this, new Style(), Style.TYPE_PROGRESS_CIRCLE)
                        .setProgressIndeterminate(true)
                        .setText("A loading Toast4")
                        .setDuration(Style.DURATION_LONG)
                        .setFrame(Style.FRAME_STANDARD)
                        .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_ORANGE))
                        .setAnimations(Style.ANIMATIONS_FADE)
                        .show();
                break;
            case R.id.button5:
                SuperActivityToast.create(MainActivity.this, new Style(), Style.TYPE_BUTTON)
                        .setButtonText("Button")
                        .setButtonIconResource(android.R.drawable.btn_star_big_off)
                        .setOnButtonClickListener("good_tag_name", null, new SuperActivityToast.OnButtonClickListener() {
                            @Override
                            public void onClick(View view, Parcelable token) {
                                //DO nothing
                            }
                        })
                        .setProgressBarColor(Color.WHITE)
                        .setText("Toast5")
                        .setDuration(Style.DURATION_LONG)
                        .setFrame(Style.FRAME_LOLLIPOP)
                        .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
                        .setAnimations(Style.ANIMATIONS_POP).show();
        }
    }
}
