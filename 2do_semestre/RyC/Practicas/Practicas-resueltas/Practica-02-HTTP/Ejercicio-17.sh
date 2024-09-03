
form_fields=$(curl -sS http://www.redes.unlp.edu.ar/http/metodo-post.html | grep name=\"form | cut -d "=" -f 3 | cut -d \" -f 2);
query_string="";
for field in $form_fields; do
	query_string+=$field"=pepe&";
done;

curl -X POST http://www.redes.unlp.edu.ar/http/metodos-lectura-valores.php -d $query_string




