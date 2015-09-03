package com.example.saba.brunaniver;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends Activity{



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details);

            String title = getIntent().getStringExtra("title");
            //Bitmap bitmap = getIntent().getParcelableExtra("image");

            //byte[] bytes = getIntent().getByteArrayExtra("BMP");
            //Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
           // Log.i("image", getIntent().getParcelableExtra("image").toString());

            //TextView titleTextView = (TextView) findViewById(R.id.title);
           // titleTextView.setText(title);

             ImageView imageView = (ImageView) findViewById(R.id.image);
             //imageView.setImageBitmap(bmp);
            // imageView.setImageBitmap();

            //ImageView imgView=new ImageView(this);
            TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

          //  imageView.setBackgroundResource(imgs.getResourceId(2, -1));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
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
