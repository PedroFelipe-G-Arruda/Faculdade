//#include <Blink.h>

#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)
//#use FIXED_IO( A_outputs=PIN_A0 )


void main()
{

   while(TRUE)
   {
   output_A(0b11111111);
   output_C(0b11111111);
   output_B (0b11111111);
   output_high(PIN_A0);
   delay_ms(500);
   output_low(PIN_A0);
   delay_ms(500);

      //TODO: User Code
   }

}
