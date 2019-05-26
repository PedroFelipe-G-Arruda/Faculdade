#include <16F877A.h>
#device ADC=10

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=2400,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)


void main()
{
   setup_adc_ports(AN0_AN1_AN3);
   setup_adc(ADC_CLOCK_INTERNAL);
   set_tris_b(0b11111110);
   while(TRUE)
   {
      set_adc_channel(0);
      delay_us(100);
      printf("%lu ",read_adc());
      set_adc_channel(1);
      delay_us(100);
      printf("%lu\n\r",read_adc());
      output_b(0b00100000);
      delay_us(100);
      output_b(0b00000000);
   }

}
