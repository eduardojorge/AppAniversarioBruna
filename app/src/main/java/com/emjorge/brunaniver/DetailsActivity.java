package com.emjorge.brunaniver;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class DetailsActivity extends Activity{

    private ViewFlipper myViewFlipper;
    private float initialXPoint;
    TypedArray imgs=null;
    int[] image = { R.drawable.image0, R.drawable.image1,
            R.drawable.image10 };
     /*   @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);



            setContentView(R.layout.activity_details);


            this.getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF' ><i>15 Anos de Bruna Cardoso</i> </font>"));

            String title = getIntent().getStringExtra("title");

            String positionS = getIntent().getStringExtra("indexImage");
            int p = getIntent().getIntExtra("indexImage",0);
            Log.i("index","index="+p);
            //Bitmap bitmap = getIntent().getParcelableExtra("image");

            //byte[] bytes = getIntent().getByteArrayExtra("BMP");
            //Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
           // Log.i("image", getIntent().getParcelableExtra("image").toString());

            //TextView titleTextView = (TextView) findViewById(R.id.title);
           // titleTextView.setText(title);

            ViewFlipper imageView = (ViewFlipper) findViewById(R.id.image);
             //imageView.setImageBitmap(bmp);
            // imageView.setImageBitmap();

            //ImageView imgView=new ImageView(this);
            TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

           // int position = new Integer(positionS).intValue();

             imageView.setBackgroundResource(imgs.getResourceId(p, -1));

           // imageView.setBackgroundResource("@drawable/image0");


            ///1

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






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        myViewFlipper = (ViewFlipper) findViewById(R.id.image);
        //ImageView imgView=new ImageView(this);
        //TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        // int position = new Integer(positionS).intValue();

      //  imageView.setBackgroundResource(imgs.getResourceId(p, -1));
         imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 1; i < imgs.length(); i++) {
            ImageView imageView = new ImageView(DetailsActivity.this);
            imageView.setImageResource(imgs.getResourceId(i, -1));



            // int position = new Integer(positionS).intValue();


            myViewFlipper.addView(imageView);

        }

        //String positionS = getIntent().getStringExtra("indexImage");
        int p = getIntent().getIntExtra("indexImage", 0);
        for(int x=1;x<=p;x++){
            myViewFlipper.showNext();
        }




        // int position = new Integer(positionS).intValue();


// dhfjdhfjds





    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialXPoint = event.getX()+1;
                break;
            case MotionEvent.ACTION_UP:
                float finalx = event.getX();
                if (initialXPoint > finalx) {
                    if (myViewFlipper.getDisplayedChild() == imgs.length())
                        break;
                    myViewFlipper.showNext();
                } else {
                    if (myViewFlipper.getDisplayedChild() == 0)
                        break;
                    myViewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }

}

