Program HelloWorld(output);

Var i:   integer
z:   char;
j:   ^integer;
Begin
    writeln ('Hello, World!');
    i := 0;
    z := 'a';
    new(j);
    j := 1;
    i := j+z;
    dispose(j);
    i := i+j^;
    writeln(j);
End.
