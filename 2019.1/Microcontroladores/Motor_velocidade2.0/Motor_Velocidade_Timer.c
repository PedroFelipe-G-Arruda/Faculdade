//#include <Motor_Velocidade_Timer.h>

#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)

int32 tempo, velocidade;
int32 cont=0;
int i = 0;
int passo[4] = {0b00000001, 0b00000100, 0b00000010, 0b00001000};

long map(long var, long in_min, long in_max, long out_min, long out_max){
   return((var - in_min) * (out_max - out_min) / (in_max - in_min) + out_min);
}

#INT_RTCC
void  RTCC_isr(void) 
{  
   if(cont == velocidade){
      output_D(passo[i]);
      i++;
      if (i > 3) {
         i = 0;
      }  
      cont = 0;
   } else {
   cont++;
   }
}

#INT_TIMER1
void  TIMER1_isr(void) 
{
   tempo = read_adc();
   velocidade = (int) map(tempo,0,1023,100,1000);
}
void main()
{
   setup_timer_0(RTCC_INTERNAL|RTCC_DIV_1|RTCC_8_BIT);      //51,2 us overflow
   setup_timer_1(T1_INTERNAL|T1_DIV_BY_1);      //13,1 ms overflow


   enable_interrupts(INT_RTCC);
   enable_interrupts(INT_TIMER1);
   enable_interrupts(GLOBAL);

   while(TRUE)
   {
      output_high(PIN_B0);
      delay_ms(100);
      output_low(PIN_B0);

      //TODO: User Code
   }

}
