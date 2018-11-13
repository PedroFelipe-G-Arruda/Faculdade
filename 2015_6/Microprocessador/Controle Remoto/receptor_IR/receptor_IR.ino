/*
   IRremote: IRrecvDemo - demonstrates receiving IR codes with IRrecv
   An IR detector/demodulator must be connected to the input RECV_PIN.
   Version 0.1 July, 2009
   Copyright 2009 Ken Shirriff
   http://arcfn.com
*/

#include <IRremote.h>
/*
#define teclaDesliga 16751205
#define teclaVermelha 16728765
#define teclaVerde 16712445
#define teclaAzul 16760895

#define ledR 10
#define ledG 9
#define ledB 8

int RECV_PIN = 2;
int estado = 0;
int mudaCor = 0;
*/
IRrecv irrecv(RECV_PIN);

decode_results results;

void setup()
{
  /*
  pinMode(ledR, OUTPUT);
  pinMode(ledG, OUTPUT);
  pinMode(ledB, OUTPUT);
*/
  Serial.begin(115200);
  // In case the interrupt driver crashes on setup, give a clue
  // to the user what's going on.
  Serial.println("Enabling IRin");
  irrecv.enableIRIn(); // Start the receiver
  Serial.println("Enabled IRin");
}

void loop() {
  if (irrecv.decode(&results)) {
    Serial.println(results.value, DEC);
/*
    switch (results.value) {
      case teclaDesliga:
        if (estado == 0) {
          Serial.println("Liga");
          analogWrite(ledR, 255);
          analogWrite(ledG, 255);
          analogWrite(ledB, 255);
          estado = 1;
        } else {
          Serial.println("Desliga");
          analogWrite(ledR, 0);
          analogWrite(ledG, 0);
          analogWrite(ledB, 0);
          estado = 0;
        }
        break;
      case teclaVermelha:
        Serial.println("Vermelho");
        analogWrite(ledR, 255);
        analogWrite(ledG, 0);
        analogWrite(ledB, 0);
        estado = 1;
        break;
      case teclaVerde:
        Serial.println("Verde");
        analogWrite(ledR, 0);
        analogWrite(ledG, 255);
        analogWrite(ledB, 0);
        estado = 1;
        break;
      case teclaAzul:
        Serial.println("Azul");
        analogWrite(ledR, 0);
        analogWrite(ledG, 0);
        analogWrite(ledB, 255);
        estado = 1;
        break;
*/
    }

    irrecv.resume(); // Receive the next value
  }
  delay(100);
}
