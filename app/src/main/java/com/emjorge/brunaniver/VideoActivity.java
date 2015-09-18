package com.emjorge.brunaniver;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;



public class VideoActivity extends Activity {
    protected  VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        this.getActionBar().setTitle(Html.fromHtml("<font font-family=Times New Roman' face=times, serif' size=5 color='#FFFFFF' ><i>15 Anos de Bruna Cardoso</i> </font>"));


        videoView = (VideoView)findViewById(R.id.VideoView);
        //MediaController mediaController = new MediaController(this);
        // mediaController.setAnchorView(videoView);
        //videoView.setMediaController(mediaController);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.makingoff);
        Log.i("uri", uri.getPath());
        videoView.setVideoURI(uri);

        videoView
                .setMediaController(new MediaController(VideoActivity.this));
       // videoView.setVisibility(1);
        videoView.bringToFront();
        videoView.requestFocus();
        videoView.setZOrderOnTop(true);
//
//ddd

        videoView.start();




    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
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
            //Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
            //Log.i("uri", uri.getPath());
           // videoView.setVideoURI(uri);
            videoView.setVideoPath( "http://www.ebookfrenzy.com/android_book/makingoff.mp4");
            videoView.start();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
