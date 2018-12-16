
section .data

message:
    db      'hello, world!', 0

section .text

global _start
_start:
    mov     eax, 4
    mov     edi, 1
    mov     esi, message
    mov     edx, 13
    syscall

    mov     eax, 1
    xor     edi, rdi
    syscall