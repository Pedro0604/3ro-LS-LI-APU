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
    z := -1;
    return z;
End;

Begin
    // Esto es llamada a la function x
    // (que en realidad debería ser x())
    // (╯°□°）╯︵ ┻━┻ 
    p := x;
    write(a);
    // Esto es llamada a la function x
    // (que en realidad debería ser x())
    // (╯°□°）╯︵ ┻━┻ 
    p := x+3;
    c[p] := 8;
    // Esto es llamada a la function x
    // (que en realidad debería ser x())
    // (╯°□°）╯︵ ┻━┻ 
    p := x+2;
    // Esto es llamada a la function x
    // (que en realidad debería ser x())
    // (╯°□°）╯︵ ┻━┻ 
    c[p] := x;
End;


Procedure x;
Var 
    b:   char;

Procedure PP2;
Begin
    write("para qué estoy aquí?");
End;

Begin
    a := 1;
    c[a] := 4;
    b := "a";
    // concat convierte a string los
    // parámetros, concatena y retorna un string;
    write(concat(c[1],b));
    PP1();
    b := "b";
    // concat convierte a string los
    // parámetros, concatena y retorna un string;
    write(concat(c[5],b));
End;

Begin
    a := 3;
    b := "c";
    For a:=3 To 10 Do
        Begin
            c[a] := 2*a;
        End;
    // Esto es llamada al procedure x
    // (que en realidad debería ser x())
    // (╯°□°）╯︵ ┻━┻ 
    x;
    write(b);
    write(a);
    For a:=1 To 10 Do
        write(c[a]-3);
End.
