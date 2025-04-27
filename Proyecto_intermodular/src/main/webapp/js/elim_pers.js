// document.addEventListener('DOMContentLoaded', function () {
// 	const listaPersonas = document.getElementById('listaPersonas');
// 	const personas = JSON.parse(localStorage.getItem('personas')) || [];

// 	personas.forEach((persona, index) => {
// 		const li = document.createElement('li');
// 		li.innerHTML = `
// 			${persona.nombre} ${persona.primerApellido} ${persona.segundoApellido} - ${persona.dni} (${persona.cargo}, ${persona.sexo})
// 			<button onclick="borrar(${index})">Eliminar</button>
// 		`;
// 		listaPersonas.appendChild(li);
// 	});
// });

// function eliminarPersona(index) {
// 	let personas = JSON.parse(localStorage.getItem('personas')) || [];
// 	personas.splice(index, 1);
// 	localStorage.setItem('personas', JSON.stringify(personas));
// 	location.reload();
// }

// function borrar(id)
// {
// 	if (confirm("¿Estás seguro de que deseas eliminar este registro?"))
// 	{
// 		fetch('gest_Emple?id='+id+'op=3')
// 		.then(response => response.json())
// 	}
// }

// document.addEventListener('DOMContentLoaded', function() {
// 	fetch('gest_Emple?op=3')
// 		.then(response => response.json())
// 		.then(data => {
// 			const listaPersonas = document.getElementById('listaPersonas');
// 			data.forEach(persona => {
// 				const li = document.createElement('li');
// 				li.textContent = `${persona.nombre} ${persona.primerApellido} (${persona.dni})`;
// 				const button = document.createElement('button');
// 				button.textContent = 'Eliminar';
// 				button.addEventListener('click', () => {
// 					if (confirm(`¿Está seguro de eliminar a ${persona.nombre} ${persona.primerApellido}?`)) {
// 						fetch('eliminarPersona', {
// 							method: 'POST',
// 							headers: {
// 								'Content-Type': 'application/x-www-form-urlencoded'
// 							},
// 							body: `dni=${persona.dni}`
// 						})
// 						.then(response => {
// 							if (response.ok) {
// 								li.remove();
// 							} else {
// 								alert('Error al eliminar persona');
// 							}
// 						})
// 						.catch(error => console.error('Error:', error));
// 					}
// 				});
// 				li.appendChild(button);
// 				listaPersonas.appendChild(li);
// 			});
// 		})
// 		.catch(error => console.error('Error:', error));
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
				const editarBtn = document.createElement('button');
				editarBtn.textContent = 'Eliminar';
				editarBtn.onclick = function() {
					if(confirm("Seguro que quieres borrar")){
						fetch('gest_Emple?id='+persona.id+'&op=3')
						.then(response => response.json())
						.then(data => pintarTabla(data))
					}else{
						
					}
				};
				li.appendChild(editarBtn);
				listaPersonas.appendChild(li);
			});
		});
});

// function borrar(id){
		
// 	if(confirm("Seguro que quieres borrar")){
// 		fetch('GestionUsuarios?id='+id+'&op=3')
// 		.then(response => response.json())
// 		.then(data => pintarTabla(data))
// 	}else{
		
// 	}
// }
