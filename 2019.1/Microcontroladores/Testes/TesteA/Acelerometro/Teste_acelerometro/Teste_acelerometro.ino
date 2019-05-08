#include <math.h>

int zx0=335;
int zy0=335;
int zz0=335;
int ax,ay,az;

void setup(){
 Serial.begin(9600);
}

void loop(){

 // read accelerometer output
 ax=analogRead(3);
 ay=analogRead(4);
 az=analogRead(5);

 // arduino analog maps 0v-5v into 0-1023
 // most accelerometers work at ~3v
 // skip this part if:
 // 1.you connected 3.3v to arduino pin AREF
 // 2.your acelerometer is working at 5v
 // - remember, most of units doesnt work with 5v


 // calculate voltage
 float vx = ax*5/1023;
 float vy = ay*5/1023;
 float vz = az*5/1023; 

 //from accelerometer's datasheet, get zero g voltage value.
 //most of the time value is for 3v power supply.
 //we can easly calculate for 3.3v
 // since the output typically is ratiometric (proportional)
 // in this case, datasheet shows Zg=1.5v for Vs=3
 float z= 1.5*5/3; //z=1.65

 // set the origin to Zero-g voltage level
 vx-=z;
 vy-=z;
 vz-=z; 

 // now we can convert voltage to force g (for instance gravity: 9.8 m/s^2)
 // find in the datasheet sensitivy, usually expressed in mV/g.
 // for our case sensitivity equals 300/g for Vs=3V.
 // again the former is ratiometric to power supply (Vs=3.3V)
 // so we need to transform this number first
 float sensitivity = 300*5/3; //sensitivity=330

 // and convert it from milli-voltage to Voltage
 // since our readings are in voltage
 sensitivity=sensitivity/1000;

 // now we can aply the formula to our readings
 // and get force (g)

 float gx = vx*sensitivity;
 float gy = vy*sensitivity;
 float gz = vz*sensitivity;

 // Determine the angle between the accelerometer and axis xyz
 // using the formula
 // angleX = arccos(gx/m)
 // where m (magnitude or length) is
 // m = Sq.root(x*x + y*y + z*z)

 float m=sqrt(gx*gx+gy*gy+gz*gz);
 float angleX=acos(gx/m);
 float angleY=acos(gy/m);
 float angleZ=acos(gz/m);

 // convert angles from radians to degrees

 angleX=angleX*180/3.14;
 angleY=angleY*180/3.14;
 angleZ=angleZ*180/3.14;

 Serial.print(int(angleX));Serial.print(",");
 Serial.print(int(angleY));Serial.print(",");
 Serial.print(int(angleZ));Serial.print(",");
 Serial.println(); 

 delay(500);
}
