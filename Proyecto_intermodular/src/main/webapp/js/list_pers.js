// document.addEventListener('DOMContentLoaded', function () {
// 	const listaPersonas = document.getElementById('listaPersonas');
// 	const personas = JSON.parse(localStorage.getItem('personas')) || [];

// 	personas.forEach(persona => {
// 		const li = document.createElement('li');
// 		li.textContent = `${persona.nombre} ${persona.primerApellido} ${persona.segundoApellido} - ${persona.dni} (${persona.cargo}, ${persona.sexo})`;
// 		listaPersonas.appendChild(li);
// 	});
// });

// fetch('gest_Emple?id='+id+'&op=1')
// 	.then(response => response.json())
// 	.then(data => {
// 		data.forEach(persona => {
// 			const li = document.createElement('li');
// 			li.textContent = `${persona.nombre} ${persona.primerApellido} ${persona.segundoApellido} - ${persona.dni} (${persona.cargo}, ${persona.sexo})`;
// 			listaPersonas.appendChild(li);
// 		});
// 	})
// 	.catch(error => {
// 		console.error('Error fetching data:', error);
// 	});

/*function llamada(){
	fetch('gest_Emple?op=1')
	.then(response => response.json())
	.then(data => pintarTabla(data))
	
}

function borrar(id){
	
	if(confirm("Seguro que quieres borrar")){
		fetch('GestionUsuarios?id='+id+'&op=3')
		.then(response => response.json())
		.then(data => pintarTabla(data))
	}else{
		
	}
}

function pintarTabla(datos){
	
	let html = "<table border='2' class='tablabonitadecss'>";
		
	for(let i=0;i<datos.length;i++){	
					
			html +="<tr><td>"+datos[i].id+"</td>";
			html +="<td>"+datos[i].nombre+"</td>";
			html += "<td>"+datos[i].apellido1+"</td>";
			html += "<td>"+datos[i].apellido2+"</td>";
			html += "<td><a href='altaUsuario.html?id="+datos[i].id+"&op=2'>Editar</a></td><td><a href='javascript:borrar("+datos[i].id+")'>Borrar</a></td>";
			html +="</tr>";
	}
	
	html +="</table>";

	document.getElementById("listado").innerHTML = html;

		
}


window.onload = function() {

	llamada();
}*/

// document.addEventListener('DOMContentLoaded', function() {
// 	// Definimos la operación a realizar (en este caso, listar personas)
// 	const op = 1;

// 	// Realizamos una solicitud GET al servlet pasando la operación como parámetro
// 	fetch(`ServletUsuario?op=${op}`)
// 		.then(response => response.json())
// 		.then(data => {
// 			// Manejamos los datos recibidos (en este caso, una lista de personas en formato JSON)
// 			// y los mostramos en la página
// 			const listaPersonas = document.getElementById('listaPersonas');
// 			listaPersonas.innerHTML = '';
// 			data.forEach(persona => {
// 				const li = document.createElement('li');
// 				li.textContent = `${persona.nombre} ${persona.apellido_1} ${persona.apellido_2} - ${persona.dni} - ${persona.cargo} - ${persona.sexo}`;
// 				listaPersonas.appendChild(li);
// 			});
// 		})
// 		.catch(error => {
// 			console.error('Error al listar personas:', error);
// 		});
// });

document.addEventListener('DOMContentLoaded', function() {
	fetch('gest_Emple?op=1')
		.then(response => response.json())
		.then(data => {
			const listaPersonas = document.getElementById('listaPersonas');
			listaPersonas.innerHTML = '';
			data.forEach(persona => {
				const li = document.createElement('li');
				li.textContent = `${persona.nombre} ${persona.apellido_1} ${persona.apellido_2} - ${persona.dni} - ${persona.cargo} - ${persona.sexo}`;
				listaPersonas.appendChild(li);
			});
		});
});
