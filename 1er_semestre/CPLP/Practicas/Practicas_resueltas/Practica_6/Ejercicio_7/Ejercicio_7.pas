Program Uno;
    Var
        y, z:   integer;
        r1:   array[1..6] Of integer;
        r2:   array[1..5] Of integer;


    Procedure Dos(nombre x, t:integer; Var io:integer; valor-resultado y:integer);
        Procedure Dos(nombre t1:integer);
            Procedure Tres;
                Begin
                    y := y + 1;
                    z := z + 1;
                End;

            Begin
                t1 := t1 + 1;
                t := t + 1;
                Tres;
                t1 := t1 + 2;
                t := t + 2;
            End;

        Begin
            x := x + 1;
            t := t + 1;
            io := io + 1;
            x := x + 2;
            If z =2 Then Dos ( t );
        End;

    Begin
        For y:= 1 To 6 Do
            r1(y) := 2;
        For y:= 1 To 5 Do
            r2(y) := 1;
        z := 2;
        y := 1;
        Dos( r1( y + r2( y )), r2( z ), y, z);
        For y:= 1 To 6 Do
            write (r1(y));
        For y:= 1 To 5 Do
            write (r2(y));
    End.