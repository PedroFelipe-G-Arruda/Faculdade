#include <12F675.h>
#device ADC=10

#FUSES NOMCLR                	//Master Clear pin used for I/O
#FUSES NOBROWNOUT            	//No brownout reset

#use delay(internal=4MHz)
#use rs232(baud=9600,parity=N,xmit=PIN_A1,rcv=PIN_A2,bits=8,stream=PORT1)

#define LED PIN_A3
#define DELAY 500


