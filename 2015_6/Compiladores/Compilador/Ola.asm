section .data
	formatin: db "%d",0
	formatout: db "%d",10,0
	x: dd 0
	i: dd 0
	mgs1: db "Ola Mundo",10,0
	mgs2: db "Digite um numero de 0 a 10:",10,0
section .text
	global _main
	extern _printf
	extern _scanf
	
_main:

mov dword[x], 3

push mgs1
call _printf
add esp,4

push mgs2
call _printf
add esp,4

push i
push formatin
call _scanf
add esp,8

_L1:
mov eax, dword[x]
cmp eax, dword[i]
jge _L2

mov eax, dword[x]
mov ecx, 1
add eax, ecx
mov dword[x], eax

jmp _L1

_L2:

mov ebx, dword[x]
push ebx
push formatout
call _printf
add esp, 8
ret