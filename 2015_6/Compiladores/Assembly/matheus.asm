	        PUSH   print_string
            PUSH          str_0
            CALL         printf
            POP            EAX
            POP            EAX
            PUSH           _y_0
            PUSH       scan_int
            CALL          scanf
            POP            EAX
            POP            EAX
    INSTRUCTION              -           _y_0              1
    INSTRUCTION              =           _n_1            STK
            label        while_0
    INSTRUCTION             !=           _n_1              1
    INSTRUCTION              %           _y_0           _n_1
    INSTRUCTION             !=            STK              0
    INSTRUCTION             &&            STK            STK
            EVAL     endwhile_0
    INSTRUCTION              -           _n_1              1
    INSTRUCTION              =           _n_1            STK
            JMP        while_0
            label     endwhile_0
            label           if_0
    INSTRUCTION             ==           _n_1              1
            EVAL         else_0
            PUSH   print_string
            PUSH          str_1
            CALL         printf
            POP            EAX
            POP            EAX
            JMP        endif_0
            label         else_0
            PUSH   print_string
            PUSH          str_2
            CALL         printf
            POP            EAX
            POP            EAX
            label        endif_0



SECTION .data
    _y_0                        DD                        0
    _n_1                        DD                        0
    str_0                       DB"Digite_um_numero:", 0xA, 0
    str_1                       DB        "E_primo", 0xA, 0
    str_2                       DB    "Nao_e_primo", 0xA, 0
    print_int                   DB            "%d" , 0xA, 0
    print_string                DB             "%s", 0xA, 0
    scan_int                    DB                     "%d"

   ; nasm -f elf file.hhh
; gcc-6 -m32 file.asm -o file
SECTION .text
    global                   main
    extern                   printf
    extern                   scanf


main:
    PUSH             print_string
    PUSH                    str_0
    CALL                   printf
    POP                      EAX
    POP                      EAX
    PUSH                     _y_0
    PUSH                 scan_int
    CALL                    scanf
    POP                      EAX
    POP                      EAX

    MOV               dword EBX,                        1
    MOV                     EAX,                   [_y_0]
    SUB                     EAX,                      EBX
    PUSH                      EAX

    POP                      EBX
    MOV                  [_n_1],                      EBX

    while_0:

    MOV               dword EBX,                        1
    MOV                     EAX,                   [_n_1]
    CMP                     EAX,                      EBX
    LAHF
    NOT                      EAX
    PUSH                      EAX


                      MOV                     EBX,                   [_n_1]
                      MOV                     EAX,                   [_y_0]
                      XOR                     EDX,                      EDX
                     IDIV                      EBX
                      MOV                     EAX,                      EDX
                     PUSH                      EAX


                      MOV               dword EBX,                        0
                      POP                      EAX
                      CMP                     EAX,                      EBX
                     LAHF
                      NOT                      EAX
                     PUSH                      EAX


                      POP                      EBX
                      POP                      EAX
                      AND                     EAX,                      EBX
                     PUSH                      EAX


                      POP                      EAX
                      AND                      AH,                       64
                      CMP                      AH,                        0
                       JE               endwhile_0

                      MOV               dword EBX,                        1
                      MOV                     EAX,                   [_n_1]
                      SUB                     EAX,                      EBX
                     PUSH                      EAX

                      POP                      EBX
                      MOV                  [_n_1],                      EBX

                      JMP                  while_0
              endwhile_0:
                    if_0:

                      MOV               dword EBX,                        1
                      MOV                     EAX,                   [_n_1]
                      CMP                     EAX,                      EBX
                     LAHF
                     PUSH                      EAX


                      POP                      EAX
                      AND                      AH,                       64
                      CMP                      AH,                        0
                       JE                   else_0
                     PUSH             print_string
                     PUSH                    str_1
                     CALL                   printf
                      POP                      EAX
                      POP                      EAX
                      JMP                  endif_0
                  else_0:
                     PUSH             print_string
                     PUSH                    str_2
                     CALL                   printf
                      POP                      EAX
                      POP                      EAX
                 endif_0:

                      RET




