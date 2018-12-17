section .data
	formatin: db "%d",0
	formatout: db "%d",10,0
	n: dd 0
section .text
	global _main
	extern _printf
	extern _scanf
	
_main:

mov dword[n], 1

mov ebx, dword[n]
push ebx
push formatout
call _printf
add esp, 8
ret