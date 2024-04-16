Procedure Main;

Var 
    x, y:   integer;
    vec:   array[1..7] Of integer;


Function B:   integer;

Var y:   integer;
Begin
    y := 4;
    x := y - 2;
    return x;
End;


Procedure D;

Var 
    i, x:   integer;
    vec:   array[1..7] Of integer;

Procedure A;

Var y:   integer;
Begin
    y := x + 5;
    vec[i + 2] := vec[i + 2] + y;

    // Esto es llamada a la function B
    // (que en realidad debería ser B())
    // (╯°□°）╯︵ ┻━┻ 
    x := x + B;

    // Esto es llamada al procedure C
    // (que en realidad debería ser C())
    // (╯°□°）╯︵ ┻━┻ 
    C;
End;

Function B:   integer;
Begin
    vec[i] := y + 2;
    i := i+2;
    vec[i] := vec[1] * i;
    return ( vec[i]-vec[1] );
End;

Begin
    For x:= 1 To 7 Do
        vec[x] := 1;
    x := 1;
    i := 2;

    // Esto es llamada al procedure A
    // (que en realidad debería ser A())
    // (╯°□°）╯︵ ┻━┻ 
    If y = 7 Then A;

    // Esto es llamada al procedure C
    // (que en realidad debería ser C())
    // (╯°□°）╯︵ ┻━┻ 
    Else C;
    For x:= 1 To 7 Do
        write(vec[x]);
End;


Procedure C;

Var i, y:   integer;
Begin
    i := 1;
    y := 6;

    // Esto es llamada a la function B
    // (que en realidad debería ser B())
    // (╯°□°）╯︵ ┻━┻ 
    x := x + B;
    vec[2] := vec[2] * x;
    While (i < y) Do
        Begin
            // Esto es llamada a la function B
            // (que en realidad debería ser B())
            // (╯°□°）╯︵ ┻━┻ 
            vec[i] := vec[i] + B - 1;
            i := i + 3;
        End;
    y := y - 4;
End;

Begin
    For x:= 1 To 7 Do
        vec[x] := x;
    x := 3;

    // Esto es llamada a la function B
    // (que en realidad debería ser B())
    // (╯°□°）╯︵ ┻━┻ 
    y := B+5;

    // Esto es llamada al procedure D
    // (que en realidad debería ser D())
    // (╯°□°）╯︵ ┻━┻ 
    D;
    If (x = 2) Then
        Begin
            vec[x] := vec[x] + 2;
            vec[x + 3] := vec[x] * 3;
        End;
    For x:= 1 To 7 Do
        write(vec[x]);
End.
