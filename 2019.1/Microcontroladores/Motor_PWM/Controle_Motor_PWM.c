//#include <Controle_Motor_PWM.h>

#include <16F877A.h>
#device ADC=10
#use delay(crystal=20000000)

int16 speed;

void main()
{
   setup_adc_ports(AN0);
   setup_adc(ADC_CLOCK_INTERNAL);
   setup_timer_2(T2_DIV_BY_16,255,1);      //819 us overflow, 819 us interrupt

   setup_ccp1(CCP_PWM);
   set_pwm1_duty((int16)1021);

   while(TRUE)
   {
      speed = read_adc();
      delay_us(50);
      set_pwm1_duty((int16)speed);
      delay_ms(100);

      //TODO: User Code
   }

}
