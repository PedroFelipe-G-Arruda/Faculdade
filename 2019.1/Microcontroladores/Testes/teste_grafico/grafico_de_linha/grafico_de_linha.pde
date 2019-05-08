import processing.serial.*;
Serial portaSerial;

float teste = 0, xPos = 21, xantigo = 21, tantigo = 579;

void setup(){
  size(800, 600);
  background (100);
  
  portaSerial = new Serial(this,"COM11", 115200);
  portaSerial.bufferUntil('\n');
}

void draw(){
  
  stroke(153);
  textSize(20);
  textAlign(CENTER, CENTER);
  text("Teste TTL com grafico",400,20);
  stroke(250);
  line(20,580,20,40); // eixo do valor (eixo x)
  triangle(15,40,20,30,25,40);
  
  line(20,580,780,580);// eixo tempo (eixo y)
  triangle(780,575,790,580,780,585);
  
   stroke(10,200,100); 
   line(xPos, 579 - teste, xantigo, tantigo);
   
   seriaEvent(portaSerial);
   
   if (xPos >= 780) {
    xPos = 21;
    xantigo = 21;
    background(100);
  } else {
    // increment the horizontal position:
    
    xantigo = xPos;
    xPos++;
  }
  
  delay(5);
}

void seriaEvent (Serial portaSerial){
  String inString = portaSerial.readStringUntil('\n');
   if (inString != null) {
     inString = trim(inString);
     tantigo = 579 - teste;
     teste = float(inString);
     println(teste);
     teste = map(teste, 0, 1023, 0, 530);
   }
}
