package com.emjorge.brunaniver;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends Activity {



    private GridView gridView;
    private GridViewAdapter gridAdapter;

    private ImageButton  buttonWhatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);
        //envio


        //envio
        this.buttonWhatsApp = (ImageButton) findViewById(R.id.imageButton);




        this.getActionBar().setTitle(Html.fromHtml("<font font-family=Times New Roman' face=times, serif' size=5 color='#FFFFFF' ><i>15 Anos de Bruna Cardoso</i> </font>"));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent intent=null;
                if (position == 0) {

                     intent = new Intent(MainActivity.this, VideoActivity.class);

                }else {
                    ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                    //Create intent
                     intent = new Intent(MainActivity.this, DetailsActivity.class);

                    intent.putExtra("indexImage", position);

                    Log.i("index", "index=" + position);
                }
                //intent.putExtra("title", item.getTitle());

             //   ByteArrayOutputStream stream = new ByteArrayOutputStream();

               // item.getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
               // byte[] bytes = stream.toByteArray();
               // intent.putExtra("BMP", bytes);


                //intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        });

        this.buttonWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







                Uri uri = Uri.parse("smsto:" + "+55 719264-0800");
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.putExtra("sms_body", "smsText");
                i.setPackage("com.whatsapp");
                startActivity(i);

            }
        });


        // Uri uri = Uri.parse("smsto:" + "9742-2218");
     //   Uri uri = Uri.parse("smsto:" + "98*********7")
      //  Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
       // sendIntent.putExtra(Intent.EXTRA_TEXT, "Hai Good Morning");
       // sendIntent.setType("text/plain");
       // sendIntent.setPackage("com.whatsapp");
       // startActivity(sendIntent);

        /*Uri uri = Uri.parse("smsto:" + "9742-2218");
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
       // i.putExtra(Intent.EXTRA_TEXT, "Hai Good Morning");
        //i.setType("text/plain");
        i.setPackage("com.whatsapp");
         startActivity(i);
        startActivity(Intent.createChooser(i, "Hai Good Morning"));*/

/*

        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("content://com.android.contacts/data/" + "9742-2218"));
        i.setType("text/plain");
        i.setPackage("com.whatsapp");           // so that only Whatsapp reacts and not the chooser
        i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        i.putExtra(Intent.EXTRA_TEXT, "I'm the body.");
        startActivity(i);*/


    }

    // Prepare some dummy data for gridview
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<ImageItem>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "image" + i));
        }
        return imageItems;
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

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
