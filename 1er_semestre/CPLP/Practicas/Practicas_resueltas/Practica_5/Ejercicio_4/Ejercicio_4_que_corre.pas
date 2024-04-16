// A quien recontra verga se le ocurre
// ponerle Procedure Main en vez de 
// fucking Program
// 10 minutos para esa verga
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// Procedure Main;

// Así sí soretes de CPLP
// (╯°□°）╯︵ ┻━┻ 

Program Main;

Var 
    x, y:   integer;
    vec:   array[1..7] Of integer;

Function B():   integer;

Var 
    y:   integer;
Begin
    y := 4;
    x := y - 2;
    B := x;
End;


Procedure C();

Var 
    i, y:   integer;
Begin
    i := 1;
    y := 6;
    x := x + B();
    vec[2] := vec[2] * x;
    While (i < y) Do
        Begin
            vec[i] := vec[i] + B() - 1;
            i := i + 3;
        End;
    y := y - 4;
End;


Procedure D();

Var 
    i, x:   integer;
    vec:   array[1..7] Of integer;

Procedure A();

Var y:   integer;
Begin
    y := x + 5;
    vec[i + 2] := vec[i + 2] + y;
    writeln('hola');
    x := x + B();
    C();
End;

Function B():   integer;
Begin
    vec[i] := y + 2;
    i := i+2;
    vec[i] := vec[1] * i;
    B := vec[i]-vec[1];
End;
Begin
    For x:= 1 To 7 Do
        vec[x] := 1;
    x := 1;
    i := 2;
    If y = 7 Then
        A()
    Else
        C();
    For x:= 1 To 7 Do
        writeln('vec[x]: ', vec[x]);
End;

Begin
    For x:= 1 To 7 Do
        vec[x] := x;
    x := 3;
    y := B()+5;
    D();
    If (x = 2) Then
        Begin
            vec[x] := vec[x] + 2;
            vec[x + 3] := vec[x] * 3;
        End;
    For x:= 1 To 7 Do
        writeln('vec[x]: ', vec[x]);
End.
