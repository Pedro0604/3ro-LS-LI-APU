// A quien recontra verga se le ocurre
// ponerle Procedure Main en vez de 
// fucking Program
// 10 minutos para esa verga
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// (╯°□°）╯︵ ┻━┻ 
// Procedure Main;

// Así sí soretes de CPLP
// (╯°□°）╯︵ ┻━┻ 

Program Main;

Var 
    x, y:   integer;
    vec:   array[1..7] Of integer;

Procedure C();

Var 
    i, y:   integer;

Function B():   integer;
Begin
    vec[i] := y + 2;
 // vec[3] := 8
    i := i+2;
 // i := 3+2
    vec[i] := vec[1] * i;
 // vec[5] := vec[1] * 5
 // vec[5] :=    1   * 5
    B := vec[i]-vec[1];
 // B := vec[5]-vec[1]
 // B :=    5  -  1
End;
Begin
    i := 3;
    y := 6;
    vec[i] := vec[i] + B() - 1;
 // vec[5] := vec[3] + B() - 1
 // vec[5] es porque i se modifica a 5 dentro de B()
 // vec[3] es porque i antes de ejecutar B() vale 3
 // Tambien sería lo mismo que poner:
 
 // vec[5] := vec[3] + B() - 1
 // vec[5] :=    3   +  4  - 1
End;

Begin
    For x:= 1 To 7 Do
        vec[x] := x;
    C();
    For x:= 1 To 7 Do
        writeln('vec[', x, ']: ', vec[x]);
    // vec[1]: 1
    // vec[2]: 2
    // vec[3]: 8 (es el valor que queda al ser modificado dentro de B())
    // vec[4]: 4
    // vec[5]: 6 (es el valor que se aplica al salir de B() (línea 45))
    // vec[6]: 6
    // vec[7]: 7
End.
