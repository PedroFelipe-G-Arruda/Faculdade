//#include <Programa_Pic16f877a.h>

#include <16F877A.h>
#device ADC=10

#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=115200,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)


int16 pulse;

void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_DIV_2);

   
   while(TRUE)
   {
   pulse = read_adc();
   fprintf(PORT1,"%lu\n\r",pulse);
   delay_ms(20);

      //TODO: User Code
   }

}
