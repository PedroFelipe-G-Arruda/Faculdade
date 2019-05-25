//#include <Fita_LED.h>
#include <16F877A.h>
#device ADC=8

#include <stdlib.h>
#include <string.h>

#FUSES NOWDT                    //No Watch Dog Timer
#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)

int R, G, B;
char buffer[] = "", c;
//short liga = 0, teste;
int cont = 0, contb = 0;

#INT_RDA
void  RDA_isr(void) 
{
   for(int i = 0; i < 4; i++){
      c = getc();
      if (c != '.' && c != ')')
         buffer[i] = c;
      if(c == '.' ){
         if(cont == 0){
            R = atoi(buffer);
            cont++;
         }else{
            G = atoi(buffer);
            cont++;
         }
         break;
      }
      if(c == ')' ){
         B = atoi(buffer);
         cont = 0;
         break;

      }
   }

    printf("cor: %s",buffer);
    printf("R: %i G: %i B:%i ", R, G, B);
    for(int i = 0; i < 4; i++){
          buffer[i] ="";        
   }
   
   
}

#INT_TIMER2
void  TIMER2_isr(void) 
{


}

void main()
{
   setup_timer_2(T2_DIV_BY_16,255,1);      //819 us overflow, 819 us interrupt


   enable_interrupts(INT_RDA);
   enable_interrupts(INT_TIMER2);
   enable_interrupts(GLOBAL);

   while(TRUE)
   {

      ;
      //TODO: User Code
   }

}
