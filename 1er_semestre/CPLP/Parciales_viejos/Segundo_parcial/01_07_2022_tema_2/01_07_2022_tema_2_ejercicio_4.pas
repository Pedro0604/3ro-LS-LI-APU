Program Main;
Var
    z: integer;
    b: array [1..6] of integer;

function a(y: integer): integer;
begin
    if(y = 1) then
    begin
        writeln('caso base');
        a:= y;
    end
    else
    begin
        b[y]:= b[y]*z;
        a:= a(y-1);
    end;
end;
begin
    for z:= 1 to 6 do
        b[z]:= z;
    z:= a(3);
    for z:= 1 to 6 do
        writeln('b[', z, ']: ', b[z]);
end.