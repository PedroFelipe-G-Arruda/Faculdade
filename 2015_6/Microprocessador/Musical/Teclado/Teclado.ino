#define NOTA_DO 262
#define NOTA_RE 294
#define NOTA_MI 330
#define NOTA_FA 349
#define NOTA_SOL 392
#define NOTA_LA 440
#define NOTA_SI 494

int pinoAudio = 2;
int nota;

void setup() {
  Serial.begin(9600);
  Serial.flush();
  pinMode(pinoAudio, OUTPUT);

}

void loop() {
  if (Serial.available() > 0) {
    nota = Serial.read();
    Serial.println(nota);
    if (nota == 49) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_DO);
      delay(500);
      noTone(pinoAudio);
    }
    if (nota == 50) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_RE);
      delay(500);
      noTone(pinoAudio);
    }
    if (nota == 51) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_MI);
      delay(500);
      noTone(pinoAudio);
    }
    if (nota == 52) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_FA);
      delay(500);
      noTone(pinoAudio);
    }
    if (nota == 53) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_SOL);
      delay(500);
      noTone(pinoAudio);
    }
    if (nota == 54) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_LA);
      delay(500);
      noTone(pinoAudio);
    }
    if (nota == 55) { /* nota sera emitida quando a tecla 1 for apertada */
      tone(pinoAudio, NOTA_SI);
      delay(500);
      noTone(pinoAudio);
    }
    Serial.flush();
  }
}
