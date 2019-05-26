//#include <Fita_LED.h>
#include <16F877A.h>
#device ADC=8

#include <stdint.h>
#include <stdlib.h>
#include <string.h>

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)

unsigned int R = 0, G = 0, B = 0, i = 0, s = 0;
char buffer[12] = "", ponto[] = ".", chave[] = ")", *cor;
uint8_t cont = 0;

#INT_RDA
void  RDA_isr(void) 
{
   //putc(getc());
   
   buffer[i] = getc();
   i++;
   if (buffer[i-1] == ')'){
      s = i;
      i = 0;
   } 
}

#INT_TIMER2
void  TIMER2_isr(void) 
{

   output_d(0b00000000 | ((B>cont)<<2) | ((G>cont)<<1) | ((R>cont)));
   cont++;
}

void main()
{
   setup_timer_2(T2_DIV_BY_1,255,1);      //819 us overflow, 819 us interrupt


   enable_interrupts(INT_RDA);
   enable_interrupts(INT_TIMER2);
   enable_interrupts(GLOBAL);
      
   while(TRUE)
   {
      if(s != 0){
         if(s == 3){
            R = 255;
            G = 255;
            B = 255;
         }else{
            if(s == 4){
               R = 0;
               G = 0;
               B = 0;
            }else{
               cor = strtok(buffer, ponto);
               R = atoi(cor);
               cor = strtok(NULL , ponto);
               G =  atoi(cor);
               cor = strtok(NULL , chave);
               B = atoi(cor);
            }
         }
         s = 0;
      }
   }
}
   
