package com.example.wolverine.myapplication;

import android.app.ActionBar;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ListView lv;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lvPlaylist);
        ArrayList<File> mySongs=findSongs(Environment.getExternalStorageDirectory());
        items=new String[mySongs.size()];
        for(int i=0;i<mySongs.size();i++){
           toast(mySongs.get(i).getName().toString());
            Log.e("abc","abc"+mySongs.get(i).getName().toString());
            items[i]=mySongs.get(i).getName().toString();
        }
        ArrayAdapter<String> adp=new ArrayAdapter<String>(getApplicationContext(),R.layout.song_layout,R.id.textView);
        lv.setAdapter(adp);
    }
    public ArrayList<File> findSongs(File root){
        ArrayList<File> al=new ArrayList<File>();
        File[] files=root.listFiles();
        for(File singleFile:files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
                al.addAll(findSongs(singleFile));
            }
            else{
                if(singleFile.getName().endsWith(".mp3")){
                    al.add(singleFile);
                }
            }
        }
        return al;

    }
    public void toast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
