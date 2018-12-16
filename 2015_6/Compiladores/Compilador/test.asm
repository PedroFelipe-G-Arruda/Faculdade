section .data
	formatin: db "%d",0
	formatout: db "%d",10,0
	mgs1: db "Digite um numero para saber o fatorial dele",10,0
	n: times 4 db 0
	mgs2: db "LOOP",10,0
	mgs3: db "LOOP",10,0
	mgs4: db "Maior",10,0
	mgs5: db "Menor",10,0
	mgs6: db "O fatorial e",10,0
section .text
	global _main
	extern _printf
	extern _scanf
	
_main:
	
push mgs1
call _printf
add esp,4
	
push n
push formatin
call _scanf
add esp,8
	
push mgs2
call _printf
add esp,4
	
push mgs3
call _printf
add esp,4
	
push mgs4
call _printf
add esp,4
	
push mgs5
call _printf
add esp,4
	
push mgs6
call _printf
add esp,4
ret