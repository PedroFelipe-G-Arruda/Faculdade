#include <Pic_Keyboard_Zoom.h>

#INT_RB
void  RB_isr(void) 
{

}

void main()
{
   port_b_pullups(0xFF);
	setup_adc_ports(AN0);
	setup_adc(ADC_CLOCK_INTERNAL);

	enable_interrupts(INT_RB);
	enable_interrupts(GLOBAL);

	while(TRUE)
	{


		//TODO: User Code
	}

}
