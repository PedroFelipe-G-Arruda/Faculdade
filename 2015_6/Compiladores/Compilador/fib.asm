section .data
	formatin: db "%d",0
	formatout: db "%d",10,0
	n: dd 0
	f: dd 0
	mgs1: db "Digite um numero para saber o fatorial dele",10,0
	mgs2: db "O fatorial e",10,0
section .text
	global _main
	extern _printf
	extern _scanf
	
_main:

mov dword[f], 1

push mgs1
call _printf
add esp,4

push n
push formatin
call _scanf
add esp,8

_L1:
mov eax, dword[n]
cmp eax, 1
jl _L2

mov eax, dword[f]
mov ecx, dword[n]
mul ecx
mov dword[f], eax

mov eax, dword[n]
mov ecx, 1
sub eax, ecx
mov dword[n], eax

jmp _L1

_L2:

push mgs2
call _printf
add esp,4

mov ebx, dword[f]
push ebx
push formatout
call _printf
add esp, 8
ret