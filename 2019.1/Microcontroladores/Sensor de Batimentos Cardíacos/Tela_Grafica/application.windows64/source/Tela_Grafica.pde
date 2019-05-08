import processing.serial.*;
Serial portaSerial;

int cont = 0, bpm = 0, bpmPre = 100;
float xPos, xPre, pulse, prePulse, teste, yy_old, uu_old, b1=0, b2=0;
void setup() {
  fullScreen();
  background (100);

  xPos = height*0.4;
  xPre = height*0.4;
  pulse = height*0.3;
  prePulse = height*0.7+0.05;
  drawBPMWindow();
  drawPulseWindow();
  portaSerial = new Serial(this, "COM4", 9600);
  portaSerial.bufferUntil('\n');

  thread("batimentos");
}


void draw() {

  stroke(25);
  textSize(120);
  textAlign(CENTER, CENTER);
  text("BPM", height*0.2, height*0.6);
  stroke(25);
  textSize(145);
  textAlign(CENTER, CENTER);
  text(bpm*4, height*0.2, height*0.4);
  //stroke(15, 244, 80);
  //line(height*0.4+23, height*0.7, height*0.4+23, height*0.3+15);
  //triangle(height*0.4+15, height*0.3+15, height*0.4+30, height*0.3+15, height*0.4+22.5, height*0.3);
  //triangle(700, 700, 715, 700, 707.5, 715);

  //line(20, 580, 780, 580);// eixo tempo (eixo y)s
  //triangle(width-15, height*0.7-15, width-15, height*0.7, width, height*0.7-7.5);
  //triangle(700, 700, 700, 715, 715, 707.5);

  //serialEvent(portaSerial);

  stroke(255, 12, 100);
  strokeWeight(2);
  line(xPos, height - pulse, xPre, prePulse);



  if (xPos >= width) {
    xPos = height*0.4;
    xPre = height*0.4;
    background(100);
    drawBPMWindow();
    drawPulseWindow();
    bpm = bpmPre;
    thread("batimentos");
  } else {
    xPre = xPos;
    xPos = xPos + 1;
  }
  
}

void drawBPMWindow() {
  noStroke();
  fill(159);  // color for the window background
  rect(0, height * 0.3, height*0.4, height*0.4);
}

void drawPulseWindow() {
  noStroke();
  fill(25);
  rect(height*0.4+1, height*0.3, width, height*0.4);
}

void batimentos() {
  bpmPre = 0;
  while (second()<= 15) {
    if (teste > 790 && b1 <= teste) {
      b1 = teste;
    } else {
      if (teste< 450 && b2 >= teste) {
        b2 = teste;
      }
    }
    if (b1 >= teste && b2 <=teste) {
      bpmPre++;
      b1 = 0;
      b2 = 0;
    }
  }


  for (int i = 0; i < 10; i++) {
    //println("Teste:", teste);
  }
}

float filtro(float Tal, float T, float u_old, float y_old) {
  float y;
  y = (T/Tal)*u_old + ((Tal-T)/Tal)*y_old;
  return y;
}

void serialEvent (Serial portaSerial) {
  String inString = portaSerial.readStringUntil('\n');
  if (inString != null) {
    inString = trim(inString);
    prePulse = height - pulse;
    pulse = float(inString);
    teste = pulse;

    println(pulse);
    if (pulse < 1023 || pulse > 0 ) {
      pulse = map(pulse, 0, 1023, height * 0.333, height * 0.666);
    } else {
      pulse = prePulse;
    }
  }
}
