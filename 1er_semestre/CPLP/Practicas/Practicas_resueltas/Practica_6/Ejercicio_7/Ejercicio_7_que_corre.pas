// Se simulan los pasajes por nombre y valor resultado porque no existen en pascal
Program Uno;
    Var
        y, z:   integer;
        r1:   array[1..6] Of integer;
        r2:   array[1..5] Of integer;


    Procedure Dos(Var io:integer; y:integer);
        Procedure Dos();
            Procedure Tres;
                Begin
                    y:= y + 1;
                    z:= z + 1;
                End;

            Begin
                r2[z]:= r2[z] + 1;
                r2[z]:= r2[z] + 1;
                Tres;
                r2[z]:= r2[z] + 2;
                r2[z]:= r2[z] + 2;
            End;

        Begin
            r1[y + r2[y]]:= r1[y + r2[y]] + 1;
            r2[z]:= r2[z] + 1;
            io:= io + 1;
            r1[y + r2[y]]:= r1[y + r2[y]] + 2;
            If z = 2 Then
                Dos();

            // Simula el resultado del parametro y que es valor-resultado
            z:= y;
        End;

    Begin
        For y:= 1 To 6 Do
            r1[y]:= 2;
        For y:= 1 To 5 Do
            r2[y]:= 1;
        z:= 2;
        y:= 1;

        // El primer parametro real r1[y + r2[y]] que corresponde
        // al parametro formal x de la funcion Dos, no se pasa porque
        // es por nombre y se va a reemplazar por la expresion r1[y + r2[y]]
        // cada vez que se llame a x en la funcion Dos
        // Lo mismo pasa con el segundo parametro r2[z] (t)
        Dos(y, z);
        For y:= 1 To 6 Do
            writeln('r1[', y, ']: ', r1[y]);
        For y:= 1 To 5 Do
            writeln('r2[', y, ']: ', r2[y]);
    End.