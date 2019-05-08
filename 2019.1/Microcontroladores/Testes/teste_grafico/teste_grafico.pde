import processing.serial.*;
Serial Port;

float teste, xPos =21;

void setup(){
  size(800, 600);
  background (134);
  
  printArray(Serial.list());
  Port = new Serial(this,Serial.list()[0], 9600);
  Port.bufferUntil('\n');
}

void draw(){
  stroke(153);
  textSize(20);
  textAlign(CENTER, CENTER);
  text("Teste TTL com grafico",400,10);
  
  stroke(250);
  line(20,580,20,40); // eixo do valor
  triangle(15,40,20,30,25,40);
  
  line(20,580,780,580);// eixo tempo
  triangle(780,575,790,580,780,585);
  
  line(xPos,579,xPos,579 - teste);
  
  if(xPos >= 780){
    xPos = 21;
    background(134);
  }else{
    xPos++;
  }
  
}

void seriaEvent (Serial Port){
  teste = float(Port.readStringUntil('\n'));
}
