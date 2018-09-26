 //Pedro Felipe Gonçalves de Arruda
 
 void setup() {
  // put your setup code here, to run once:
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  int i, n, t, m;
  int led[10] = {2,3,4,5,6,7,8,9,10,11};

  m = 0;
  
  //Efeito 1

  for (t = 0; t <= m; t++){
    for(n = 0; n <= 9; n++){
      for(i = 2; i <= 11 - n; i++){
        digitalWrite(i, HIGH);
        digitalWrite(i - 1, LOW);
        delay(100);
      }
    }
    delay(100);
    for(n = 0; n <= 9; n++){
      for(i = 11 - n; i <= 11; i++){
        digitalWrite(i, LOW);
        digitalWrite(i + 1, HIGH);
        delay(100);
      }
    }
    
    delay(100);
  }
  
//Efeito 2

  for(i = 11; i >= 2; i--){
      digitalWrite(i,HIGH);
      digitalWrite(i+1, LOW);
      delay(100);
    }
  delay(100);

  for (t = 0; t <= m; t++){
    for(i = 2; i <= 11; i++){
      digitalWrite(i,HIGH);
      digitalWrite(i-1, LOW);
      delay(100);
    }
    delay(100);

    for(i = 11; i >= 2; i--){
      digitalWrite(i,HIGH);
      digitalWrite(i+1, LOW);
      delay(100);
    }
  delay(100);
  }

  //Efeito 3

  for (t = 0; t <= m; t++){
    for(i = 2; i <= 11; i++){
      digitalWrite(led[i],HIGH);
      delay(100);
    }
    delay(100);
    for(i = 11; i >= 2; i--){
      digitalWrite(i, LOW);
      delay(100);
    }
    delay(100);
  }


  //Efeito 4

  for (t = 0; t <= m; t++){
    for(n = 0; n <= 3; n++){
     digitalWrite(led[0],
    }
  }


  
}
