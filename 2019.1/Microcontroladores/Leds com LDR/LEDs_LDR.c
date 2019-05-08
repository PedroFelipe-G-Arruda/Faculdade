
#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)
   
   
   #define LCD_RS_PIN         pin_d0
   #define LCD_RW_PIN         pin_d1
   #define LCD_ENABLE_PIN     pin_d2
   #define LCD_DATA4          pin_d3
   #define LCD_DATA5          pin_d4
   #define LCD_DATA6          pin_d5
   #define LCD_DATA7          pin_d6
   
   /*
   #define lcd_enable      pin_d4      // pino enable do LCD
   #define lcd_rs          pin_d2      // pino rs do LCD
   //#define lcd_rw          pin_d3      // pino rw do LCD
   #define lcd_d4          pin_d5      // pino de dados d4 do LCD
   #define lcd_d5          pin_d6      // pino de dados d5 do LCD
   #define lcd_d6          pin_d7      // pino de dados d6 do LCD
   #define lcd_d7          pin_e0      // pino de dados d7 do LCD
   */
   
#include <lcd.c>
void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_DIV_64);

   float lux;
   int32 valor;
   
   lcd_init();
   
   
   while(TRUE)
   {
      
      
      lux = read_adc();
      //valor = (10/1023) * lux;
      valor = lux * 0.00988142292490118577075098814229;
      printf(lcd_putc,"\fIluminacao =  %lu ",valor);
      
      delay_ms(300);   
      
      switch(valor){
         case 0:  {output_c(0b00000000); output_d(0b00000000); break;}
         case 1:  {output_c(0b00000001); output_d(0b00000000); break;}
         case 2:  {output_c(0b00000011); output_d(0b00000000); break;}
         case 3:  {output_c(0b00000111); output_d(0b00000000); break;}
         case 4:  {output_c(0b00001111); output_d(0b00000000); break;}
         case 5:  {output_c(0b00011111); output_d(0b00000000); break;}
         case 6:  {output_c(0b00111111); output_d(0b00000000); break;}
         case 7:  {output_c(0b01111111); output_d(0b00000000); break;}
         case 8:  {output_c(0b11111111); output_d(0b00000000); break;}
         case 9:  {output_c(0b11111111); output_d(0b00000001); break;}
         case 10: {output_c(0b11111111); output_d(0b00000011); break;}
         
         default:{break;}
      }
      
      
   }

}
