import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

//	Victoria Tran using interfaces 

Particle [] bob = new Particle[100];
public void setup()
{
	size(600,600);
	background(0);

	for(int i = 0; i < bob.length ; i++){
		bob[i] = new NormalParticle();  //(int)(Math.random()* 800),(int)(Math.random()*800)
	}
	bob[0] = new OddballParticle();
	bob[1] = new JumboParticle();
}
public void draw()
{
	for(int i =0; i < bob.length; i++){
	bob[i].move();
	bob[i].show();	
	}
	background(0);
}

interface Particle
{
	public void move();
	public void show();

} 
class NormalParticle implements Particle
{
	double x;
	double y;
	double dTheta;
	double speed;

	NormalParticle(){
		dTheta = Math.random()*6.5f; //should be random
		speed = Math.random()*10;
		x = 300; 
		y = 300; 
	}

	public void show(){ 
		fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		ellipse((float)x,(float)y,10,10);
		System.out.println(x + ", " + y);
	}

	public void move(){ 
		x = x + Math.cos(dTheta) * speed;
		y = y + Math.sin(dTheta) * speed;
	}
}

class OddballParticle implements Particle
{
	double x3;
	double y3;
	double dTheta2;
	double speed2;

	OddballParticle(){
		dTheta2 = Math.random()*9; 
		speed2 = Math.random()*5;
		x3 = 400;
		y3 = 400;
		}

	public void show(){
		fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		ellipse((float)x3,(float)y3,50,50);
	}

	public void move(){
 		x3 = x3 + Math.cos(dTheta2) * speed2;
		y3 = y3 + Math.sin(dTheta2) * speed2;
	}

}

class JumboParticle implements Particle{
  double x2;
	double y2;
	double dTheta3;
	double speed3;

	JumboParticle(){
		dTheta3 = Math.random()*30; 
		speed3 = Math.random()*30;
		x2 = 400;
		y2 = 400;			
	}

	public void show(){
		fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		ellipse((float)x2,(float)y2,100,100);
	}

	public void move(){
 		x2 = x2 + Math.cos(dTheta3) * speed3;
		y2 = y2 + Math.sin(dTheta3) * speed3;
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
