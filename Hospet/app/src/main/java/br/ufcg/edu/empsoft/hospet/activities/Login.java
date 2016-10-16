package br.ufcg.edu.empsoft.hospet.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import br.ufcg.edu.empsoft.hospet.R;

/**
 * Created by Veruska on 23/09/2016.
 */
public class Login extends Activity {

    private RelativeLayout rl;
    private LinearLayout linlaHeaderProgress;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        rl = (RelativeLayout)findViewById(R.id.RelativeLayout1);
        rl.setBackgroundResource(R.drawable.login_cat);
        linlaHeaderProgress = (LinearLayout) findViewById(R.id.progress_layout);
        linlaHeaderProgress.setVisibility(View.VISIBLE);

        // Start lengthy operation in a background thread
        mProgress = (ProgressBar) findViewById(R.id.pbHeaderProgress);

        Thread thread = new Thread(){
            public void run() {
                try{
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        };
        thread.start();

    }
}
