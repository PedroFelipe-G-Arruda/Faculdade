PImage imagem;
PFont fonte;
void setup(){
  background(0);
  size(700,700);
  //background(143,184,111);
  fonte = createFont("Sketch Gothic School.ttf",100);
}

void draw(){
  textFont(fonte);
  text("Ola Mundo!!",30,100);
  
}
