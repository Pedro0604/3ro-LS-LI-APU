// Es una simulacion de como sería
Program Main;
    Var
        j, m, i: integer;


    Procedure Recibe (x:integer; y:integer);
        Begin
            m := m + 1 + y;
            x := i + x + j;
            y := m - 1;
            writeln ('x: ', x, ' - y: ', y, ' - i: ', i, ' - j: ', j, ' - m: ', m);
            // Esto se agrega para simular el resultado
            i:= x;
            j:= y;
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