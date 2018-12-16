section .data
	formatin: db "%d",0
	formatout: db "%d",10,0
	mgs1: db  "Ola Mundo",10,0
section .text
	global _main
	extern _printf
extern _scanf
_main:
push mgs1
call _printf
add esp,4
ret