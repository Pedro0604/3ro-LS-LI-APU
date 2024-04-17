Program Main;
    Var
        x, y, z: integer;
        a, b:   array[1..6] Of integer;


    Procedure B;
        Var
            y, x:   integer;
        
        Procedure C;
            Var
                c:   integer;
            Begin
                y := y + 2;
                c := 2;
                a[x] := a[x] * y;
                If (y > 7) Then
                    b[y-6] := b[4] * 2 + b[y-6];

                // Esto es llamada al procedure D
                // (que en realidad debería ser D())
                // (╯°□°）╯︵ ┻━┻ 
                D;
            End;

        Begin
            x := 2;
            y := x + 3;

            // Esto es llamada al procedure C
            // (que en realidad debería ser C())
            // (╯°□°）╯︵ ┻━┻ 
            C;
            x := x + 1;
            write (x, y);
        End;


    Procedure D;
        Begin
            // Probablemente sea x:= C() + 5 + x porque sino en cadena estática no tiene solución
            // Y si se llamara a D desde otro lugar que no sea el procedure C (o no tenga como previo a C),
            // tampoco tendría solucion en cadena dinámica

            // Yo lo tomo como C() en cadena estática
            // y c en cadena dinámica (la variable del procedure C() que llama a D())
            // Que debe ser lo que los hdps de los profesores querían lograr

            // ヽ(ಠ_ಠ)ノ 😡🤬😤😠🖕👊 (╯°□°）╯︵ ┻━┻
            x := c + 5 + x;
            y := y + 2;
        End;


    Function C:   integer;
        Begin
            b[x] := b[x] + 1;
            x := x + 1;
            a[y] := a[y] + b[x] + 3;
            a[x+2] := a[x] + 2;
            return b[x];
        End


    Begin
        x := 1;
        y := 2;
        For z:=1 To 6 Do
            Begin
                a[z] := z;
                b[z] := z + 2;
            End;

        // Esto es llamada al procedure B
        // (que en realidad debería ser b[)]
        // (╯°□°）╯︵ ┻━┻ 
        B;
        For z:=1 To 6 Do
            write (a[z], b[z]);
    End.
