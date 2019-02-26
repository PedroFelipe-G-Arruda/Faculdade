#include <16F877A.h>
#device ADC=8
#use delay(crystal=20000000)

#define zero   0b11000000 //0b00111111
#define um     0b11111001 //0b00000110
#define dois   0b10100100 //0b01011011
#define tres   0b10110000 //0b01001111
#define quatro 0b10011001 //0b01100110
#define cinco  0b10010010 //0b01101101
#define seis   0b10000010 //0b01111101
#define sete   0b11111000 //0b00000111
#define oito   0b10000000 //0b01111111
#define nove   0b10011000 //0b01100111

void numeros(n){
   switch(n){
      case 0:{output_d(zero);break;}
      case 1:{output_d(um);break;}
      case 2:{output_d(dois);break;}
      case 3:{output_d(tres);break;}
      case 4:{output_d(quatro);break;}
      case 5:{output_d(cinco);break;}
      case 6:{output_d(seis);break;}
      case 7:{output_d(sete);break;}
      case 8:{output_d(oito);break;}
      case 9:{output_d(nove);break;}
      
      default:{break;}
      
   }
}

void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_DIV_64);
   
   int valor;
   int16 i;
   int U, D;
   
   while(TRUE)
   {
      i = read_adc();
      valor =(int) (99/255) * i;
      //valor =  i * 0.38823529411764705882352941176471;
      U = valor % 10;
      D = valor /10;
      
      output_high(PIN_C0);
      numeros(D);
      delay_ms(5);
      output_low(PIN_C0);
      
      output_high(PIN_C1);
      numeros(U);
      delay_ms(5);
      output_low(PIN_C1);
      
   }

}


