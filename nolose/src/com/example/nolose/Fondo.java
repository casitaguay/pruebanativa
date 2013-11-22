package com.example.nolose;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Fondo {


       private GameView gameView;
       private Bitmap bmp;
       private int width;
       private int height;

   
       public Fondo(GameView gameView, Bitmap bmp) {
             this.gameView=gameView;
             this.bmp=bmp;
             this.width = 0;
             this.height = 0; 
             
       }

       private void update() {
     
       }


       public void onDraw(Canvas canvas) {
             update();
             canvas.drawBitmap(bmp, this.width, this.height, null);
       }

}   