
Program Main

Var 
    a:   array[1..10] Of integer;
    x,y,z:   integer;


Procedure A ()

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


Function t():   integer;
Begin
    y := y+1;
    z := z-6;
    return (y+x);
End;


Procedure B()

Var 
    d:   integer;
Procedure I ()
Begin
    x := 0;
    x := x+6;
End;
Begin
    // Probablemente sea x:=x+t() porque sino en cadena estática no tiene solución
    // Y si se llamara a B desde otro lugar que no sea A (o no tenga como previo a A),
    // tampoco tendría solucion en cadena dinámica

    // Yo lo tomo como t() en cadena estática
    // y t en cadena dinámica
    // Que debe ser lo que los hdps de los profesores querían lograr
    // ヽ(ಠ_ಠ)ノ 😡🤬😤😠🖕👊 (╯°□°）╯︵ ┻━┻ (es muy bueno ajsdaksdj)
    x := x+t;
    d := 0;
    While x>d Do
        Begin
            I();
            x := x-1;
            d := d + 2;
        End;
End;

Begin
    For x:=1 To 10 Do
        a[x] := x;
    x := 5;
    y := 1;
    z := 10;
    A();
    For x:=1 To 10 Do
        write(a[x],x);
End.
