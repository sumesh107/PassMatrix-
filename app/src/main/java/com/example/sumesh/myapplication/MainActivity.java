package com.example.sumesh.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity{

   // Button split_image;
    // Button btnGallery;


    public static Bitmap bit;
    public static int i;
    public static int chunkHeight,chunkWidth;

    Uri selectedImage;                         //Uniform resource id - address of an image object
    private final int RESULT_LOAD_IMAGE = 1;
    public final int PERMISSIONS_REQUEST_CODE =123;
    int chunkNumbers = 36;
    ArrayList<Bitmap> chunkedImages;
    ArrayList<Bitmap> finalchunk;
    ImageView image;

    private GestureDetectorCompat mDetector;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.source_image);

        //alertDialogForCameraImage();
        gallerypermissionWrapper();

        mDetector = new GestureDetectorCompat(this,new MyGestureListener());

        image.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                mDetector.onTouchEvent(event);
                return true;
            }});
    }

    void pickImageFromGallery() {

        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//      startActivityForResult(pickPhoto , 0);
        startActivityForResult(pickPhoto, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){

            case RESULT_LOAD_IMAGE:
                if(resultCode== Activity.RESULT_OK) {
                    //  takenPictureData = handleResultFromChooser(data);

                    selectedImage = data.getData();
                    String[] filePathColumn = {  MediaStore.Images.Media.DATA };

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();

                    //  ImageView imageView = (ImageView) findViewById(R.id.imgView);
                    image.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                    // Function of split the image(divide the image into pieces)
                    splitImage(image, chunkNumbers);

                }
                else
                {
                    Log.i("error", "onActivityResult: ");
                }
                break;
        }

        //And show the result in the image view when take picture from camera.

    }


    public void gallerypermissionWrapper() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    PERMISSIONS_REQUEST_CODE);

           // Log.d("Per","sddssd");
            alertDialogForCameraImage();
            //PERMISSIONS_REQUEST_CODE is an
            // app-defined int constant. The callback method gets the
            // result of the request.

        }
        else
        {
            alertDialogForCameraImage();
        }
    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT)
                            .show();
                    alertDialogForCameraImage();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

         }
    }*/

        public void alertDialogForCameraImage() {

        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("Pick Image From Gallery: ");
        adb.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                pickImageFromGallery();

            } });
        adb.show();
    }



    /**
     * Splits the source image and show them all into a grid in a new activity
     *
     * @param image The source image to split
     * @param chunkNumbers The target number of small image chunks to be formed from the   source image
     */
    private void splitImage(ImageView image, int chunkNumbers) {

      //  Log.e("split","image");

        //For the number of rows and columns of the grid to be displayed
        int rows,cols;

        //For height and width of the small image chunks
        int chunkHeight,chunkWidth;

        //To store all the small image chunks in bitmap format in this list
        chunkedImages = new ArrayList<Bitmap>(chunkNumbers);

        //Getting the scaled bitmap of the source image
        BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        bit = bitmap;
    /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);*/
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        rows = cols = (int) Math.sqrt(chunkNumbers);
        chunkHeight = bitmap.getHeight()/rows;
        chunkWidth = bitmap.getWidth()/cols;
        /*chunkHeight = 300/rows;
        chunkWidth = 300/cols;*/

        //xCoord and yCoord are the pixel positions of the image chunks
        int yCoord = 0;
        for(int x=0; x<rows; x++){  
            int xCoord = 0;
            for(int y=0; y<cols; y++){
                chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight));
                xCoord += chunkWidth;
            }
            yCoord += chunkHeight;
        }

        mergeImage(chunkedImages);


    }

    void mergeImage(ArrayList<Bitmap> imageChunks) {

       Collections.shuffle(imageChunks);
       finalchunk = imageChunks;

        //Get the width and height of the smaller chunks
        chunkWidth = imageChunks.get(0).getWidth();
        chunkHeight = imageChunks.get(0).getHeight();


        //create a bitmap of a size which can hold the complete image after merging
        Bitmap bitmap = Bitmap.createBitmap(chunkWidth * 6, chunkHeight * 6,  Bitmap.Config.ARGB_4444);

        //create a canvas for drawing all those small images
        Canvas canvas = new Canvas(bitmap);
        int count = 0;
        for(int rows = 0; rows < 6; rows++){
            for(int cols = 0; cols < 6; cols++){
                canvas.drawBitmap(imageChunks.get(count), chunkWidth * cols, chunkHeight * rows, null);
                count++;
            }
        }

        bit = bitmap;
        image.setImageBitmap(bitmap);
    /*
     * The result image is shown in a new Activity
     */

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }



    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent event) {

            Toast.makeText(MainActivity.this, "Gesture Granted", Toast.LENGTH_SHORT)
                    .show();
            int chunkWidth = chunkedImages.get(0).getWidth();
            int chunkHeight = chunkedImages.get(0).getHeight();

           // boolean flag = false;
            float X = event.getX();
            float Y = event.getY();

            int col = (int) (X / chunkWidth);
            int row = (int) (Y / chunkHeight);

             i = ((row)*6)+(col);             //hardcode !!!

             Log.d(" Main ","Width:"+chunkWidth+"Hieght"+chunkHeight);
             Log.d("Main ","Y= "+Y+" X= "+X);
             Log.d(" Main ", "row "+row+" &col "+col);
             Log.i(" Main ", " value:" + i);
            /*do {

            try {
                Log.i("chunkis", " value:" + i);
                chunkedImages.get(i).getPixel(X,Y);
                flag = true;
            }
            catch(Exception e)
            {
                   e.printStackTrace();
                   if(i<25)
                   {
                       i++;
                       continue;
                   }
                   else
                       break;

            }
            }while(flag==false);*/
           findtouch(i);
            return true;
        }

    }

   /* public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }*/

    public void findtouch(int k)
    {

       Bitmap test = finalchunk.get(i);
        //Bitmap test = chunkedImages.get(i)

        Intent intent = new Intent(this,Display.class);
       // intent.putExtra("width",chunkWidth);
       // intent.putExtra("hieght",chunkHeight);
        intent.putExtra("split_image",test);

        startActivity(intent);
        finish();

    }

}