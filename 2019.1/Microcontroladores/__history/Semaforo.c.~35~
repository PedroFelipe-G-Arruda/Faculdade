//#include <Semaforo.h>

#include <16F877A.h>
#device ADC=10

#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)

#define VERDE_C PIN_B0
#define AMARELO_C PIN_B1
#define VERMELHO_C PIN_B2
#define VERDE_P PIN_B3
#define VERMELHO_P PIN_B4
#define BOTAO PIN_A0

void main()
{
   int i;
   while(TRUE)
   {
      // inico
      output_high(VERDE_C);      //liga verde carro
      output_low(AMARELO_C);     //desliga amarelo carro
      output_low(VERMELHO_C);    //desliga vermelho carro
      output_low(VERDE_P);       //desliga verde pedestre
      output_high(VERMELHO_P);   //liga vermelho pedestre
   
      if(input(BOTAO)){
         delay_ms(1000);
         
         output_low(VERDE_C);
         output_high(AMARELO_C);
         delay_ms(500);
         
         output_low(AMARELO_C);
         output_high(VERMELHO_C);
         output_high(VERDE_P);
         output_low(VERMELHO_P);
         delay_ms(1500);
         
         for(i=1;i<=10;++i){
            output_high(VERMELHO_P);
            delay_ms(500);
            output_low(VERMELHO_P);
            delay_ms(500);
         }
      }
   }
}
