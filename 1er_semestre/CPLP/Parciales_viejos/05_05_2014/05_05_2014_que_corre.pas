Program parcial;
    Type 
        vector = array [1..10] Of integer;

    Var 
        p, q:   integer;
        pint:   integer;


    Function valor():   integer;
        Var 
            h:   integer;
        Function q():   integer;
            Begin
                q := (pint - 1);
            End;

        Begin //Function valor
            // q es llamada a función (╯°□°）╯︵ ┻━┻
            h := 2 + q;
            valor := ((p + h) - 9);
        End;


    Procedure auxiliar();
        Var 
            aux, i, pint:   integer;
            v:   vector;
        Begin
            pint := 5;
            For i:=1 To 10 Do
                v[i] := p * i;
            aux := p + 1;
            p := q + 2;
            v[p - 3] := v[pint] - 4;
            If v[aux] = 30 Then
                // valor es llamada a función (╯°□°）╯︵ ┻━┻
                v[aux] := v[valor] + 5;
        End;


    Begin // Program
        p := 5;
        q := 10;
        pint := 3;
        auxiliar();

        // valor es llamada a función (╯°□°）╯︵ ┻━┻
        q := valor + 9;
        writeln('q: ', q);
        writeln('p: ', p);
    End.