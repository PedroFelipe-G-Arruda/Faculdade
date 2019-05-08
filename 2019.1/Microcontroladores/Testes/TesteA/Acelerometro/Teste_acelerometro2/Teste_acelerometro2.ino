#include <math.h>

void setup()
{

  Serial.begin(9600);

}

void loop()
{

  
  // Start reading and calculating angles
  float VREF = 5.0;

  // To get those values, play with your accelerometer and put the min and max you find on every x,y,z position
  int xMinVal = 279; int yMinVal = 281; int zMinVal = 278;
  int xMaxVal = 415; int yMaxVal = 419; int zMaxVal = 413;

  int xRead = 0, yRead = 0, zRead = 0;

  int xAng = 0, yAng = 0, zAng = 0;
  double x = 0, y = 0, z = 0;
  double val = 180/PI;

  int amostra = 10;

  // read raw values
  for (int i = 0; i < amostra ; i++)
  {
    xRead += analogRead(A0);
    yRead += analogRead(A1);
    zRead += analogRead(A2);
  }

  xRead = xRead / amostra;
  yRead = yRead / amostra;
  zRead = zRead / amostra;

  // convert to angles
  /*
  xAng = map(xRead, xMinVal, xMaxVal, -90, 90);
  yAng = map(yRead, yMinVal, yMaxVal, -90, 90);
  zAng = map(zRead, zMinVal, zMaxVal, -90, 90);
  */
  xAng = map(xRead, xMinVal, xMaxVal, -90, 90);
  yAng = map(yRead, yMinVal, yMaxVal, -90, 90);
  zAng = map(zRead, zMinVal, zMaxVal, -90, 90);
  
  //x = 57.2957795 * (atan2(-yAng, -zAng) + 3.14159265359);
  //y = 57.2957795 * (atan2(-xAng, -zAng) + 3.14159265359);
  //z = 57.2957795 * (atan2(-yAng, -xAng) + 3.14159265359);

  x = (atan2(-yAng, -zAng) + PI)*val;
  y = (atan2(-xAng, -zAng) + PI)*val;
  z = (atan2(-yAng, -xAng) + PI)*val;

  char xTempString[10];  //  Hold The Convert Data

  // convert position in string to display it
  dtostrf(x, 3, 2, xTempString); // dtostrf( [doubleVar] , [sizeBeforePoint] , [sizeAfterPoint] , [WhereToStoreIt] )
  String xString = String(xTempString);  // cast it to string from char

  // wrtie value that will be read on the mobile device

  Serial.println(x);
  
  /*
  Serial.print("X = ");
  Serial.print(x);
  Serial.print(" Y = ");
  Serial.print(y);
  Serial.print(" Z = ");
  Serial.println(z);
  */
  

  
  
  delay(1000);

}
