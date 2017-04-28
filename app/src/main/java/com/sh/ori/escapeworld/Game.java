package com.sh.ori.escapeworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar gameToolbar = (Toolbar) findViewById(R.id.tb_joinMap);
        setSupportActionBar(gameToolbar);
        gameToolbar.setLogo(R.drawable.puzzle);
        gameToolbar.setLogoDescription("App logo");
        gameToolbar.setTitle("Title");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        if(id == R.id.action_refresh){
//            Toast.makeText(getApplicationContext(), "Refresh App", Toast.LENGTH_LONG).show();
//        }
//        if(id == R.id.action_new){
//            Toast.makeText(getApplicationContext(), "Create Text", Toast.LENGTH_LONG).show();
//        }
        return super.onOptionsItemSelected(item);
    }
}
