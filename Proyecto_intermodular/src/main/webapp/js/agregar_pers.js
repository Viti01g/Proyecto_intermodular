// document.getElementById('agregarPersonaForm').addEventListener('submit', function (e) {
// 	e.preventDefault();
	
// 	const nombre = document.getElementById('nombre').value;
// 	const primerApellido = document.getElementById('primerApellido').value;
// 	const segundoApellido = document.getElementById('segundoApellido').value;
// 	const dni = document.getElementById('dni').value;
// 	const cargo = document.getElementById('cargo').value;
// 	const sexo = document.getElementById('sexo').value;

// 	const persona = {
// 		nombre,
// 		primerApellido,
// 		segundoApellido,
// 		dni,
// 		cargo,
// 		sexo
// 	};

// 	let personas = JSON.parse(localStorage.getItem('personas')) || [];
// 	personas.push(persona);
// 	localStorage.setItem('personas', JSON.stringify(personas));
	
// 	alert('Persona agregada correctamente');
// 	document.getElementById('agregarPersonaForm').reset();
// });

document.getElementById('agregarPersonaForm').addEventListener('submit', function(event) {
	event.preventDefault();

	const formData = new FormData(this);

	fetch('agregarPersona', {
		method: 'POST',
		body: formData
	})
	.then(response => {
		if (response.ok) {
			alert('Persona agregada exitosamente');
			this.reset();
		} else {
			alert('Error al agregar persona');
		}
	})
	.catch(error => console.error('Error:', error));
});

