//#include <Pic_Keyboard_Zoom.h>

#include <16F877A.h>
#device ADC=10

#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)



#INT_RB
void  RB_isr(void) 
{

}

void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_INTERNAL);

   enable_interrupts(INT_RB);
   enable_interrupts(GLOBAL);

   while(TRUE)
   {


      //TODO: User Code
   }

}
