package com.example.nolose;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {

	private Bitmap bmp;
    private SurfaceHolder holder;
    private GameLoop gameLoopThread;
    private int x = 0; 
    private int xSpeed = 1;
    private List<Boton> botonero = new ArrayList<Boton>();
    
    private Boton login;
    private Boton registro;
    private Fondo miFondo;

    public GameView(Context context) {
         super(context);
         gameLoopThread = new GameLoop(this);
         holder = getHolder();
         holder.addCallback(new SurfaceHolder.Callback() {

        	 @Override
             public void surfaceDestroyed(SurfaceHolder holder) {
             		boolean retry = true;
             		gameLoopThread.setRunning(false);
                    while (retry) {
                    	try {
                    		gameLoopThread.join();
                            retry = false;
                        } catch (InterruptedException e) {
                        
                        }
                    }
             }


            @Override
            public void surfaceCreated(SurfaceHolder holder) {
            	
            	createBotones();
            	
            	gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }
            
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                int width, int height) {

            }
            });
         //bmp = BitmapFactory.decodeResource(getResources(), R.drawable.botonlogin);
         //login = new Boton(this,bmp,100);
         
    }

    private Fondo createFondo() {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.fondode);
        return new Fondo(this,bmp);

  }
    
    private Boton createBoton(int resouce, int pheight) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
        return new Boton(this,bmp,pheight);

  }
    
    private void createBotones() {
        botonero.add(createBoton(R.drawable.botonlogin,150));
        botonero.add(createBoton(R.drawable.botonregistrarse,250));
        
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
//    	if (x == getWidth() - bmp.getWidth()) {
//    		xSpeed = -1;
//        }
//        if (x == 0) {
//            xSpeed = 1;
//        }
//        x = x + xSpeed;
        //canvas.drawColor(Color.BLACK);  
    	miFondo=createFondo();
    	miFondo.onDraw(canvas);
        for (Boton boton : botonero) {
            boton.onDraw(canvas);

     }
    }

}