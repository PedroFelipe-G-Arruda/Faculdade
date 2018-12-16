; add1.asm
SECTION .data
    message1: db "Enter the first number: ", 0
    message2: db "Enter the second number: ", 0
    formatin: db "%d", 0
    formatout: db "%d", 10, 0 ; newline, nul terminator
    integer1: times 4 db 0 ; 32-bits integer = 4 bytes
    integer2: times 4 db 0 ;
SECTION .text
   global _main 
   extern _scanf 
   extern _printf     

_main:

   mov dword[integer1], 9
   inc dword[integer1]

   push ebx ; save registers
   push ecx
   push message1
   call _printf

   ;add esp, 4 ; remove parameters
   ;push integer1 ; address of integer1 (second parameter)
   ;push formatin ; arguments are right to left (first parameter)
   ;call _scanf

   add esp, 8 ; remove parameters
   push message2
   call _printf

   add esp, 4 ; remove parameters
   push integer2 ; address of integer2
   push formatin ; arguments are right to left
   call _scanf

   add esp, 8 ; remove parameters

   mov eax, 150
   mov edx, 0
   div  dword [integer2]
   ;add eax, ecx ; add the values          ; the addition
   push eax
   push formatout
   call _printf                            ; call printf to display the sum
   add esp, 8                             ; remove parameters
   pop eax
   pop ebx ; restore registers in reverse order
   mov eax, 0 ; no error
   ret