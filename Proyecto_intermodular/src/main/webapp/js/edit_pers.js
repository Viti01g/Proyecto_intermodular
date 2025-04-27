// document.addEventListener('DOMContentLoaded', function () {
// 	const listaPersonas = document.getElementById('listaPersonas');
// 	const personas = JSON.parse(localStorage.getItem('personas')) || [];

// 	personas.forEach((persona, index) => {
// 		const li = document.createElement('li');
// 		li.innerHTML = `
// 			${persona.nombre} ${persona.primerApellido} ${persona.segundoApellido} - ${persona.dni} (${persona.cargo}, ${persona.sexo})
// 			<button onclick="editarPersona(${index})">Editar</button>
// 		`;
// 		listaPersonas.appendChild(li);
// 	});
// });

// function editarPersona(index) {
// 	localStorage.setItem('editIndex', index);
// 	window.location.href = '../edit_pers_detail.html';
// }

document.addEventListener('DOMContentLoaded', function() {
	fetch('gest_Emple?op=1')
		.then(response => response.json())
		.then(data => {
			const listaPersonas = document.getElementById('listaPersonas');
			listaPersonas.innerHTML = '';
			data.forEach(persona => {
				const li = document.createElement('li');
				li.textContent = `${persona.nombre} ${persona.apellido_1} ${persona.apellido_2} - ${persona.dni} - ${persona.cargo} - ${persona.sexo}`;
				const editarBtn = document.createElement('button');
				editarBtn.textContent = 'Editar';
				editarBtn.onclick = function() {
					// sessionStorage.setItem('personaAEditar', JSON.stringify(persona));
					// window.location.href = 'edit_pers_detail.html';
					window.location.href = 'edit_pers_detail.html?id=' + persona.id + '&op=2';
				};
				li.appendChild(editarBtn);
				listaPersonas.appendChild(li);
			});
		});
});
