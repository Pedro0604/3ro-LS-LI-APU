Program Main;
    Var
        j, m, i: integer;


    // Out parameters are only supported in Delphi and ObjFPC mode. For the other modes, out is a valid identifier. :|
    // Igual daría error xd
    Procedure Recibe (out x:integer; out y:integer);
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