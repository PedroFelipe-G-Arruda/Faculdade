//#include <Comunicação_RX_TX_LCD_e_Potenciometro.h>

#include <16F877A.h>
#device ADC=10

#FUSES NOBROWNOUT               //No brownout reset
#FUSES NOLVP                    //No low voltage prgming, B3(PIC16) or B5(PIC18) used for I/O

#use delay(crystal=20000000)
#use rs232(baud=9600,parity=N,xmit=PIN_C6,rcv=PIN_C7,bits=8,stream=PORT1)

#define LCD_RS_PIN         pin_d0
#define LCD_RW_PIN         pin_d1
#define LCD_ENABLE_PIN     pin_d2
#define LCD_DATA4          pin_d3
#define LCD_DATA5          pin_d4
#define LCD_DATA6          pin_d5
#define LCD_DATA7          pin_d6

#include <lcd.c>

int16 potenciometro, n_valor, verifica = 0, led = 2000;
int t_valor1, t_valor2, r_valor1, r_valor2;

#INT_EXT
void  EXT_isr(void) 
{
   t_valor1 = make8(led,0);
   t_valor2 = make8(led,1);
   putc(t_valor1);
   putc(t_valor2);
   delay_ms(100);
}

#INT_RDA
void  RDA_isr(void) 
{
    r_valor1 = getc();
    r_valor2 = getc();
    n_valor = make16(r_valor2, r_valor1);
    if (n_valor == 2000){
      output_toggle(PIN_D7);
    } else{
    lcd_getc(6,1);
    printf(lcd_putc,"\fIFMT\nValor: %lu", n_valor);
    
    }
}

void main()
{
   setup_ADC(ADC_CLOCK_INTERNAL);  
   setup_adc_ports(AN0); 
   delay_us(10);
   
   ext_int_edge(L_TO_H);
   enable_interrupts(INT_EXT);
   enable_interrupts(INT_RDA);
   enable_interrupts(GLOBAL);
   
   lcd_init();
   
   while(TRUE)
   {
      potenciometro = read_adc();
      if(potenciometro != verifica)
      {
         t_valor1 = make8(potenciometro,0);
         t_valor2 = make8(potenciometro,1);
         putc(t_valor1);
         putc(t_valor2);
         verifica = potenciometro;
      }
      delay_ms(100);
   }
}
