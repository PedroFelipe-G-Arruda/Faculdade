//#include <main.h>

#include <16F877A.h>
#device ADC=10

#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)

#define PIN_DS18B20_DATA PIN_B5 
#include <ds18b20.c>

signed int16 raw_temp;
float temp;
char buffer[2] = "";
int i = 0, s = 0;
int cont_zero = 0;
int tempo_on = 0;


unsigned int setpoint = 45;
/*
float Kp = 55.2;
float Ti = 6;
float T = 1.5;
*/

float Kp = 108.0;
float Ti = 800.0;
float T = 2.0;

float ultimo_erro = 0;
double PID = 0;
float erro_atual = 0;
float ultimo_controle = 0;

#INT_EXT
void  EXT_isr(void) 
{
   cont_zero++;
   
    if (cont_zero > 10) {
      cont_zero = 0;
      output_low(PIN_B1);
   }
   
   if (cont_zero == tempo_on){
      output_high(PIN_B1);
   }
   
   
}

void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_DIV_16);

   enable_interrupts(INT_EXT);
   enable_interrupts(GLOBAL);

   while(TRUE)
   {
      if(ds18b20_read(&raw_temp)) {
      temp = (float)raw_temp / 16;               // Convert temperature raw value into degree Celsius (temp in °C = raw/16)             // Go to column 5 row 2
      fprintf(PORT1,"Temp: %f", temp);
    }
    else {
      fprintf(PORT1," Error! ");
    }
    //setpoint = atoi(buffer);
    
    erro_atual = setpoint - temp;
    
    PID = ultimo_controle+(Kp*((erro_atual-ultimo_erro)+(ultimo_erro*T/Ti)));
    
    
    if (PID > 100) {
      tempo_on = 0;
    } 

    else if (PID < -100) {
      tempo_on = 11;
    }
     
    else
      tempo_on = 10 - (PID/10);
      
      
      
    ultimo_erro = erro_atual;
    ultimo_controle = PID;
      
      //fprintf(PORT1,"%f ", ultimo_erro);
      
    fprintf(PORT1,"tempo_On:%i ", tempo_on);
      
    fprintf(PORT1,"PID: %f ", PID);
      
    fprintf(PORT1,"set: %i ", setpoint);
      
    fprintf(PORT1,"zero: %i\n\r", cont_zero);
      
    delay_ms(50);
   }

}
