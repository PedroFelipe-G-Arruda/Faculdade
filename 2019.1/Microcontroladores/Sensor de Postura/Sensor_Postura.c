//#include <Sensor_Postura.h>
#include <16F877A.h>
#device ADC=10

#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)

#include <math.h>

#define BUZZER PIN_B4
#define BOTAO PIN_B5

// Numeros do amostras 
int amostra = 10;

// Os maximos e minimos de cada eixo
int16 xMinVal = 277, yMinVal = 271, zMinVal = 277;
int16 xMaxVal = 428, yMaxVal = 442, zMaxVal = 427;
int16 ref = 360;

//variavceis de leitura dos exios
int16 xRead = 0, yRead = 0, zRead = 0;
signed long xAng = 0, yAng = 0, zAng = 0;
long  x = 0, y = 0, z = 0;

//Conversao de radianos para graus
long val = 180/PI;

void main()
{
   setup_adc_ports(AN0_AN1_AN3);
   setup_adc(ADC_CLOCK_INTERNAL);

   while(TRUE)
   {  
      
      // leitura dos valores brutos
      for (int i = 0; i < amostra ; i++)
      {
      set_adc_channel(0); 
      delay_us(20);
      xRead += read_adc();
      set_adc_channel(1); 
      delay_us(20);
      yRead += read_adc();
      set_adc_channel(3); 
      delay_us(20);
      zRead += read_adc();
      }

      xRead = xRead / amostra;
      yRead = yRead / amostra;
      zRead = zRead / amostra;
      
     
      // conversao do angulo |max 90|min -90|
      
      xAng = (((180/(xMaxVal - xMinVal)) * (xRead - xMinVal)) -90);
      yAng = (((180/(yMaxVal - yMinVal)) * (yRead - yMinVal)) -90);
      zAng = (((180/(zMaxVal - zMinVal)) * (zRead - zMinVal)) -90);
   
      x = (atan2(-yAng, -zAng) + PI)*val;
      y = (atan2(-xAng, -zAng) + PI)*val;
      z = (atan2(-yAng, -xAng) + PI)*val;
      
      
      fprintf(PORT1,"x = %lu, y = %lu, z = %lu, referencia= %lu\n\r",xRead,yRead,zRead,ref);
      
      if(input(BOTAO)){
         ref = x;
      }else{
         if (x > ref + 6){
            output_high(BUZZER);
         }else{
            output_low(BUZZER);
            }
         }
            
      
      delay_ms(800);
     }
   
   
   
}

