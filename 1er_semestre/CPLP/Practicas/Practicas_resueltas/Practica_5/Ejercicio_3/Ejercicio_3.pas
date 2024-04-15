Program P1;

Var 
    a:   integer;
    b:   char;
    c:   array[1..10] Of integer;


Procedure PP1;
Var 
    a:   char;
    p:   integer;

Function x:   integer;
Var 
    z:   integer;
Begin
    a := "j";
    z =   -1;
    return z;
End;

Begin
    p := x;
    write(a);
    p := x+3;
    c[p] =   8;
    p := x+2;
    c[p] =   x;
End;


Procedure x;
Var 
    b:   char;

Procedure PP2;
Begin
    write("para qué estoy aquí?");
End;

Begin
    // Me quedé en esta linea (acabo de terminar el registro de activación del procedure x)
    a := 1;
    c[a] := 4;
    b := "a";
    write(concat(c[1],b));
    /*concat convierte a string los
    parámetros, concatena y retorna un string;
    */
    PP1();
    b := "b";
    write(concat(c[5],b));
    /*concat convierte a string los
    parámetros, concatena y retorna un string;
    */
End;

Begin
    a := 3;
    b := "c";
    For a:=3 To 10 Do
        Begin
            c[a] := 2*a;
        End;
    x;
    write(b);
    write(a);
    For a:=1 To 10 Do
        write(c[a]-3);
End.
