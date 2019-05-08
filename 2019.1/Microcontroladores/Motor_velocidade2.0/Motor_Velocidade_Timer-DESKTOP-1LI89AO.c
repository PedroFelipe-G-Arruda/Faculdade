//#include <Motor_Velocidade_Timer.h>

#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)

int16 tempo;
int16 cont=0;
int i = 0;
int passo[4] = {0b00000001, 0b0000100, 0b0000010, 0b00001000};

/*
long map(long var, long in_min, long in_max, long out_min, long out_max){
   return((var - in_min) * (out_max - out_min) / (in_max - in_min) + out_min);
}
*/

#INT_RTCC
void  RTCC_isr(void) 
{  
cont ++;
   if(cont == tempo){
      output_D(passo[i]);
      i++;
      if (i > 3) {
         i = 0;
      }  
        cont = 0;
   }
   
}

#INT_TIMER1
void  TIMER1_isr(void) 
{
   tempo = read_adc();
   tempo = (0.052734*tempo) + 6;
}
void main()
{
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_32|RTCC_8_BIT);      //51,2 us overflow 1,6 m
   setup_timer_1(T1_INTERNAL|T1_DIV_BY_8);      //13,1 ms overflow


   enable_interrupts(INT_RTCC);
   enable_interrupts(INT_TIMER1);
   enable_interrupts(GLOBAL);

   while(TRUE)
   {
   
      
}
