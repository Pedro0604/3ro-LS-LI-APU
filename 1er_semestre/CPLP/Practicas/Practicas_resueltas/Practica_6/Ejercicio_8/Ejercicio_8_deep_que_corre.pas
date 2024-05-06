// Simula el pasaje de subrutinas como parametros
// Con resolución de referencias no locales shallow
Program A;
    Var
        x: integer;
        y: char;


    // La funcion D queda acá, de esta manera, el ámbito de
    // las referencias no locales es el deep
    Function D(j: integer; k: char): integer;
        Begin
            j:= j + x;
            k:= y;
            writeln('k: "', k, '"');
            D:= j;
        End;

    // Se elimina el parametro S
    Procedure C();
        Var
            x: integer;
            y: char;
        Begin
            x:= 3;
            y:= 'b';

            // Se llama directamente a la funcion D
            x:= D(x, y);
            y:= 'j';
            writeln('x: ', x, ' - y: "', y, '"');
        End;

    Procedure B;
        Var
            h: integer;
        Begin
            h:= 1+x;
            writeln('y: "', y, '"');
            C();
            writeln('y: "', y, '"');
        End;
        
    Begin
        x:= 0;
        y:= 'a';
        B();
        writeln('x: ', x, ' - y: "', y, '"');
    End.
