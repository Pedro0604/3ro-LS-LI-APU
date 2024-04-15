
Program Main;

Var 
    a:   array[1..10] Of integer;
    x,y,z:   integer;

Function t():   integer;
Begin
    y := y+1;
    z := z-6;
    t := y+x;
End;


Procedure B();

Var 
    d:   integer;
Procedure I ();
Begin
    x := 0;
    x := x+6;
End;
Begin
    // En este archivo que corre, sí o sí tiene que llamarse a t()
    // en vez de a t, porque pascal es estático así que no correría de la otra manera
    // Maldito CPLP (╯°□°）╯︵ ┻━┻
    // ヽ(ಠ_ಠ)ノ 😡🤬😤😠🖕👊 (╯°□°）╯︵ ┻━┻
    x := x+t();
    d := 0;
    While x>d Do
        Begin
            I();
            x := x-1;
            d := d + 2;
        End;
End;


Procedure proc_A ();

Var 
    y,t:   integer;
Begin
    a[1] := a[1]+1;
    z := z+1;
    t := 1;
    y := 2;
    B();
    a[y] := a[y]+3;
    y := y+1;
    If z=11 Then
        Begin
            a[z-1] := a[z-2] + 3;
            z := z-4;
            a[z-y] := a[z] - a[y] + 5;
        End;
End;

Begin
    For x:=1 To 10 Do
        a[x] := x;
    x := 5;
    y := 1;
    z := 10;
    // Hay que renombrar el procedimiento A a proc_A
    // porque pascal es case insensitive
    // y ya está declarada la variable a (el array global)
    proc_A();
    For x:=1 To 10 Do
        writeln('a[x]: ',a[x],' - x: ',x);
End.
