//#include <Programa_Pic12f675.h>

#include <12F675.h>
#device ADC=10

#FUSES NOMCLR                   //Master Clear pin used for I/O
#FUSES NOBROWNOUT               //No brownout reset

#use delay(internal=4MHz)
#use rs232(baud=9600,parity=N,xmit=PIN_A1,rcv=PIN_A2,bits=8,stream=PORT1)

#define BUZZER PIN_A3



void main()
{
   setup_adc_ports(sAN0);
   setup_adc(ADC_CLOCK_DIV_2);

 int16 pulse;
  
   while(TRUE)
   {
   pulse = read_adc();
   fprintf(PORT1,"%lu\n\r",pulse); // tirar \r -- teste
   delay_ms(20);
   
      //TODO: User Code
   }

}
