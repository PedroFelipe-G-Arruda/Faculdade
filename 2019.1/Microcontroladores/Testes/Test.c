//#include <Test.h>

//#include <pid.h>
#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_D0,bits=8,stream=PORT1)

#include <stdint.h>
#include <string.h>
#include <stdlib.h>

#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#define PIN_DS18B20_DATA PIN_B5
#include <ds18b20.c>
signed int16 raw_temp, i = 0;
float temp;
char buffer[4] = "";

int count_zero = 0;
int count_on = 0;

#INT_EXT 
void int_isr(){ 
   count_zero++;
    
   if (count_zero > 10) {
      count_zero = 0;
      output_low(PIN_B1);
   }
   
   if (count_zero == count_on)
      output_high(PIN_B1);
}


#INT_RDA
void  RDA_isr(void) 
{
   //putc(getc());
   ;
   buffer[i] = getc();
   i++;
   if (buffer[i-1] == 'C'){
      //s = i;
      i = 0;
   }
}

unsigned int setpoint = 30;

float Kp = 55.2;
float Ti = 6;
float T = 1.5;
float last_error = 0;
double PID = 0;
float current_error = 0;
float last_control = 0;

void main()
{
EXT_INT_EDGE(L_TO_H);

enable_interrupts(INT_RDA);
enable_interrupts(INT_EXT);
enable_interrupts(GLOBAL);
 
 while(TRUE) {
    fprintf(PORT1,"%s ", buffer);
 }
    
}

