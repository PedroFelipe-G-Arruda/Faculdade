#include <teclado.h>

#include <KBD.C>

#define LCD_ENABLE_PIN  PIN_B0                                    ////
#define LCD_RS_PIN      PIN_B1                                    ////
#define LCD_RW_PIN      PIN_B2                                    ////
#define LCD_DATA4       PIN_B3                                    ////
#define LCD_DATA5       PIN_B4                                    ////
#define LCD_DATA6       PIN_B5                                    ////
#define LCD_DATA7       PIN_B6 

#include <lcd.c>


void main()
{

   setup_adc_ports(AN0);
   kbd_init();

   lcd_init();

   printf(lcd_putc, "\f-----DIGITE-----\n");
   delay_ms(50);
      
   char c;  
   
   while(true){
      c = kbd_getc();
      delay_ms(1);
      if(c!=0){
         printf(lcd_putc, "%c", c);
         delay_ms(300);
      }
   }
}
