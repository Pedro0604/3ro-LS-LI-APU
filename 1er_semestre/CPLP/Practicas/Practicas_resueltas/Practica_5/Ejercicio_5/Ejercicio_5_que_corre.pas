
Program Main;

Var 
    x, y, z:   integer;
    a, b:   array[1..6] Of integer;

Function C:   integer;
Begin
    b[x] := b[x] + 1;
    x := x + 1;
    a[y] := a[y] + b[x] + 3;
    a[x+2] := a[x] + 2;
    C := b[x];
End;

Procedure D;
Begin
    x := c + 5 + x;
 // x := 4 + 5 + 2 = 11


    // Variante propuesta para el ejercicio 5)c)
    // Lo único que hace diferente es evaluar el
    // x antes de ejecutar la funcion C(), por lo
    // que el valor de x es 1 en vez de 2 y 
    // la asignacion termina en 10 en vez de 11

    // x := x + c + 5;
    // Es lo mismo que:
    // x := 1 + 4 + 5 = 10
    y := y + 2;
End;


Procedure ProcB;

Var 
    y, x:   integer;

Procedure C;

Var 
    c:   integer;
Begin
    y := y + 2;
    c := 2;
    a[x] := a[x] * y;
    If (y > 7) Then
        b[y-6] := b[4] * 2 + b[y-6];
    D();
End;

Begin
    x := 2;
    y := x + 3;
    C();
    x := x + 1;
    writeln('x: ', x, ' - y: ', y);
End;

Begin
    x := 1;
    y := 2;
    For z:=1 To 6 Do
        Begin
            a[z] := z;
            b[z] := z + 2;
        End;
    ProcB();
    For z:=1 To 6 Do
        writeln('a[z]: ', a[z], ' - b[z]: ', b[z]);
End.
