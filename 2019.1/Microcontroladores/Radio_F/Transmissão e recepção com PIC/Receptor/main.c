#include <16F877A.h>
#device ADC=10

#include <stdint.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)

int16 rgb_map[3] = {0, 0, 0};
int counter = 0;

char string[12];
char *part;
char ponto[] = ".";
char zero = "255";

#INT_RDA
void  RDA_isr(void) 
{
   gets(string);
   part = strtok(string, ponto);
   if (strcmp(part, zero)){
      puts("Zero");
   }else {
   puts(part);
   }
   
   
}

#INT_TIMER2
void  TIMER2_isr(void) 
{
   // it checks if the color value is greater than the pulse
   // ex: if 127, when counter < 127 it is on, if >= 127 it is off
   // do this for all leds and output_d
   output_d(0b0000000 | ((rgb_map[1]>counter)<<2) | ((rgb_map[0]>counter)<<1) | ((rgb_map[2]>counter)));
   counter++;
}

void main()
{
   
   enable_interrupts(INT_RDA);
   setup_timer_2(T2_DIV_BY_4,5,13);      // 4,8 us overflow, 62,4 us interrupt
   enable_interrupts(INT_TIMER2);
   enable_interrupts(GLOBAL);

   while(TRUE)
   {
      //TODO: User Code
   }

}
