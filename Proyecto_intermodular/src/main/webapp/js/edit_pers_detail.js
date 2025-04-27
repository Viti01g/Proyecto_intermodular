// document.addEventListener('DOMContentLoaded', function () {
// 	const index = localStorage.getItem('editIndex');
// 	const personas = JSON.parse(localStorage.getItem('personas')) || [];
// 	const persona = personas[index];

// 	document.getElementById('nombre').value = persona.nombre;
// 	document.getElementById('primerApellido').value = persona.primerApellido;
// 	document.getElementById('segundoApellido').value = persona.segundoApellido;
// 	document.getElementById('dni').value = persona.dni;
// 	document.getElementById('cargo').value = persona.cargo;
// 	document.getElementById('sexo').value = persona.sexo;
	
// 	document.getElementById('editarPersonaForm').addEventListener('submit', function (e) {
// 		e.preventDefault();

// 		personas[index] = {
// 			nombre: document.getElementById('nombre').value,
// 			primerApellido: document.getElementById('primerApellido').value,
// 			segundoApellido: document.getElementById('segundoApellido').value,
// 			dni: document.getElementById('dni').value,
// 			cargo: document.getElementById('cargo').value,
// 			sexo: document.getElementById('sexo').value
// 		};

// 		localStorage.setItem('personas', JSON.stringify(personas));
// 		alert('Persona actualizada correctamente');
// 		window.location.href = '../edit_pers.html';
// 	});
// });

// document.addEventListener('DOMContentLoaded', function() {
// 	const persona = JSON.parse(sessionStorage.getItem('personaAEditar'));
// 	if (persona) {
// 		document.getElementById('nombre').value = persona.nombre;
// 		document.getElementById('primerApellido').value = persona.primerApellido;
// 		document.getElementById('segundoApellido').value = persona.segundoApellido;
// 		document.getElementById('dni').value = persona.dni;
// 		document.getElementById('cargo').value = persona.cargo;
// 		document.getElementById('sexo').value = persona.sexo;
// 	}

// 	document.getElementById('editarPersonaForm').addEventListener('submit', function(event) {
// 		event.preventDefault();

// 		const formData = new FormData(this);

// 		fetch('editarPersona', {
// 			method: 'POST',
// 			body: formData
// 		})
// 		.then(response => {
// 			if (response.ok) {
// 				alert('Persona actualizada exitosamente');
// 				window.location.href = 'editar_persona.html';
// 			} else {
// 				alert('Error al actualizar persona');
// 			}
// 		})
// 		.catch(error => console.error('Error:', error));
// 	});
// });

function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	results = regex.exec(location.search);
	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function llamada(id, op){
	fetch('gest_Emple?id='+id+"&op="+op)
	.then(response => response.json())
	.then(data => pintarFormulario(data))
}

function pintarFormulario(persona){
	if (persona) {
		document.getElementById('id').value = persona.id;
		document.getElementById('nombre').value = persona.nombre;
		document.getElementById('apellido_1').value = persona.apellido_1;
		document.getElementById('apellido_2').value = persona.apellido_2;
		document.getElementById('dni').value = persona.dni;
		document.getElementById('cargo').value = persona.cargo;
		document.getElementById('sexo').value = persona.sexo;
	}
}

window.onload = function(){
	let id = getParameterByName("id");
	let op = getParameterByName("op");
	llamada(id,op);
}
