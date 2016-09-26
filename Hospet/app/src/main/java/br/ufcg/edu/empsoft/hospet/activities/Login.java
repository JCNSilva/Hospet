package br.ufcg.edu.empsoft.hospet.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

import br.ufcg.edu.empsoft.hospet.R;


/**
 * Created by Veruska on 23/09/2016.
 */
public class Login extends Activity {

    private static int INDEXDOG = 0;
    private static int INDEXCAT = 1;

    private int indexImage = INDEXDOG;
    private RelativeLayout rl;
    private Button btn1, btn2;
    private Image logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        rl = (RelativeLayout)findViewById(R.id.RelativeLayout1);
        rl.setBackgroundResource(R.drawable.login_dog);
        btn1 = (Button)findViewById(R.id.btn_buscar_hospedagem);
        btn2 = (Button)findViewById(R.id.btn_oferecer_hospedagem);

        final Timer timer = new Timer();
        ChangeImageTimer changeImageTimer = new ChangeImageTimer();
        timer.schedule(changeImageTimer, 4000, 4000);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("HI", "hi");
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                timer.cancel();

            }
        });

    }


    public class ChangeImageTimer extends TimerTask {

        public void run() {
            rl = (RelativeLayout)findViewById(R.id.RelativeLayout1);
            //This runs in a background thread.
            //We cannot call the UI from this thread, so we must call the main UI thread and pass a runnable
            runOnUiThread(new Runnable() {

                public void run() {
                    if (indexImage == INDEXCAT) {
                        rl.setBackgroundResource(R.drawable.login_dog);
                        indexImage = INDEXDOG;
                    } else {
                        rl.setBackgroundResource(R.drawable.login_cat);
                        indexImage = INDEXCAT;
                    }
                }
            });
        }
    }
}
