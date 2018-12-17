SECTION .data
    formatin: db "%d",0
    formatout: db "%20ld",10,0
    msg1: db "Digite um numero: "
    var: times 4 db 0

SECTION .text
    global _main
    extern _printf
    extern _scanf


_main:
    push ebx
    push ecx

    push msg1
    call _printf
    add esp, 4 
   
    push var 
    push formatin 
    call _scanf
    add esp,8

    xor eax,eax
    xor ebx,ebx
    inc ebx

_print:
    push eax
    push ecx
    
    mov esi, formatout
    call _printf
    mov esi,eax
    xor eax,eax
    add esp, 4
    

    pop ecx
    pop eax

    mov edx,eax
    mov eax,ebx
    add ebx,edx

    push ecx
    mov ecx,var
    dec ecx
    jnz _print

    pop ebx
    ret

