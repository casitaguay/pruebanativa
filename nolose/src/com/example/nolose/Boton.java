package com.example.nolose;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;


public class Boton {


       private GameView gameView;
       private Bitmap bmp;
       private int width;
       private int height;

   
       public Boton(GameView gameView, Bitmap bmp, int pHeight) {
             this.gameView=gameView;
             this.bmp=bmp;
             this.width = 0;
             this.height = pHeight; 
             
       }

       private void update() {
     
       }


       public void onDraw(Canvas canvas) {
             update();
             canvas.drawBitmap(bmp, this.width, this.height, null);
       }

}   