Program P1;

Var 
    a:   integer;
    b:   char;
    c:   array[1..10] Of integer;


Procedure PP1();
Var 
    a:   char;
    p:   integer;

Function x():   integer;
Var 
    z:   integer;
Begin
    a := 'j';
    z := -1;
    x := z;
End;

Begin
    p := x();
    writeln('a: ', '"', a, '"');
    p := x()+3;
    c[p] := 8;
    p := x()+2;
    c[p] := x();
End;


Procedure x();
Var 
    b:   char;

Procedure PP2();
Begin
    writeln('Para qué estoy aquí?');
End;

Begin
    a := 1;
    c[a] := 4;
    b := 'a';
    // concat eliminado porque tira error entre
    // char e integer y ademas el writeln acepta varios parámetros
    writeln('c[1]: ', c[1], ' - b: "', b, '"');

    PP1();
    b := 'b';
    // concat eliminado porque tira error entre
    // char e integer y ademas el writeln acepta varios parámetros
    writeln('c[5]: ', c[5], ' - b: "', b, '"');
End;

Begin
    a := 3;
    b := 'c';
    For a:=3 To 10 Do
        Begin
            c[a] := 2*a;
        End;
    x();
    writeln('b: ', '"', b, '"');
    writeln('a: ', a);
    For a:=1 To 10 Do
        writeln('c[a]-3: ', c[a]-3);
End.
