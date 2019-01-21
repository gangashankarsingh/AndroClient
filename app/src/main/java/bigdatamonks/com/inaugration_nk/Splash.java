package bigdatamonks.com.inaugration_nk;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView logo =  findViewById(R.id.logo);
        int splashTimeout = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, splashTimeout);

        Animation animationn = AnimationUtils.loadAnimation(this,R.anim.blink_anim);
        logo.startAnimation(animationn);
        animationn.setStartOffset(500);
    }
}
