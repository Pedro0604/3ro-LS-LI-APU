Program A
    Var
        x: integer;
        y: char;


    Procedure B;
        Var h: integer;
        Begin
            h:= 1+x;
            Write (y);
            C(D);
            Write (y);
        End;

    Procedure C (Subrutina S);
        Var
            x: integer;
            y: char;
        Begin
            x:= 3;
            y:= "b";
            x:= S(x,y);
            y:= "j";
            Write (x,y);
        End;

    Function D (j:integer, k:char);
        Begin
            j:= j+x;
            k:= y;
            Write (k);
            Return j;
        End;
        
    Begin
        x:= 0;
        y:= "a";
        B();
        Write (x,y);
    End.
