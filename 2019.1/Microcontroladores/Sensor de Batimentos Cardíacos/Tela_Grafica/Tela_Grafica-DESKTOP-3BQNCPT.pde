import processing.serial.*;
Serial portaSerial;

float teste = 0, xPos = 21, xantigo = 21, tantigo = 579; // meio 540 -- 2/3 = 720


void setup() {
  size(displayWidth, displayHeight);
  //size(800, 600);
  background (100);

  portaSerial = new Serial(this, "COM11", 9600);
  portaSerial.bufferUntil('\n');
  
  drawBPMWindow();
}

void draw() {

  

  stroke(153);
  //textSize(20);
  //textAlign(CENTER, CENTER);
  //text("Teste TTL com grafico",400,20);
  stroke(250);
  line(20, 580, 20, 40); // eixo do valor (eixo x)
  triangle(15, 40, 20, 30, 25, 40);

  line(20, 580, 780, 580);// eixo tempo (eixo y)s
  triangle(780, 575, 790, 580, 780, 585);

  seriaEvent(portaSerial);

  stroke(10, 200, 100);
  strokeWeight(2);
  line(xPos, 579 - teste, xantigo, tantigo);



  if (xPos >= 780) {
    xPos = 21;
    xantigo = 21;
    background(100);
  } else {

    xantigo = xPos;
    xPos = xPos + 2;
  }

  delay(50);
}

void drawBPMWindow() {
  noStroke();
  fill(255);  // color for the window background
  rect(0, height * 0.66, 300, 300);
}

/*

 void seriaEvent (Serial portaSerial){
 String inString = portaSerial.readStringUntil('\n');
 if (inString != null) {
 inString = trim(inString);
 tantigo = 579 - teste;
 teste = float(inString);
 
 
 if(teste>= 600){
 teste = 750;
 }else{
 if (teste <= 400){
 teste = 300;
 }else{
 teste = 512;
 }
 }
 
 
 
 println(teste);
 teste = map(teste, 0, 1023, 0, 530);
 }
 }
 
 */
