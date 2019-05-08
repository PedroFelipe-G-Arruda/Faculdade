//#include <Controle_Velocidade_Motor.h>

#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)



void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_DIV_16);
   int32 tempo = 10;

   while(TRUE)
   {
   
   //tempo = read_adc();
   //tempo = (int) ((100/1023)*tempo) + 20;
   output_D(0b00000101);
   delay_ms(tempo);
   output_D(0b00001101);
   delay_ms(tempo);
   output_D(0b00001001);
   delay_ms(tempo);
   output_D(0b00001011);
   delay_ms(tempo);
   output_D(0b00001010);
   delay_ms(tempo);
   output_D(0b00001110);
   delay_ms(tempo);
   output_D(0b00000110);
   delay_ms(tempo);
   output_D(0b00000111);
   delay_ms(tempo);
   
   }

}
