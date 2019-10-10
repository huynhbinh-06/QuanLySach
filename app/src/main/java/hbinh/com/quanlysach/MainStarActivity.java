package hbinh.com.quanlysach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainStarActivity extends AppCompatActivity {

    Button btnstarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstarted = findViewById(R.id.btngetstarted);

        btnstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = AnimationUtils.loadAnimation(MainStarActivity.this,R.anim.fade);
                btnstarted.startAnimation(animation);

                Intent intent = new Intent(MainStarActivity.this, MainLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
