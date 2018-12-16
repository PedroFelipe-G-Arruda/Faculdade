extern _printf
global _main

section .data
msg: 	db "Hello, world!",10,0
msg1:	db "Teste",10,0

section .text
_main:
    push msg
    call _printf
	add esp,4
	sub esp,4
	push msg1
    call _printf
	add esp,4
    ret
