extern _printf
global _main

section .data
msg: 	db "Hello, world!",10,0

section .text
_main:
    push msg
    call _printf
	add esp,4
    ret
