// En este caso, referencia es igual que nombre
Program Main;
    Var
        j, m, i: integer;


    Procedure Recibe (var x:integer; var y:integer);
        Begin
            m := m + 1 + y;
            x := i + x + j;
            y := m - 1;
            writeln ('x: ', x, ' - y: ', y, ' - i: ', i, ' - j: ', j, ' - m: ', m);
        End;

    Procedure Dos;
        Var
            m: integer;
        Begin
            m := 5;
            Recibe(i, j);
            writeln('i: ', i, ' - j: ', j, ' - m: ', m);
        End;

    Begin
        m := 2;
        i := 1;
        j := 3;
        Dos;
        writeln('i: ', i, ' - j: ', j, ' - m: ', m);
    End.