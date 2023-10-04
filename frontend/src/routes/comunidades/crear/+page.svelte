<script lang="ts">
	import Textfield from '@smui/textfield';
	import FormField from '@smui/form-field';
	import Radio from '@smui/radio';
	import Button, { Label } from '@smui/button';
	import LayoutGrid, { Cell } from '@smui/layout-grid';
	import services from '$lib/services';
	import { Visibilidad } from '$lib/generated/openapi';
	import { currentUser } from '$lib/store';

	let nombre = '';
	let visibilidad: Visibilidad = 'Publico';
	let descripcion = '';

	const { comunidadApi } = services;

	function crearComunidad() {
		comunidadApi.crearComunidad(
			{
				creacionComunidad: {
					categorias: [],
					descripcion,
					nombre,
					visibilidad
				}
			},
			{ credentials: 'include' }
		);
	}
</script>

<div class="crear-comunidad">
	<form on:submit|preventDefault={crearComunidad}>
		<LayoutGrid>
			<Cell span={12}>
				<h1>Crear Comunidad</h1>
			</Cell>

			<Cell span={12}>
				<Textfield
					class="input-nombre"
					required
					variant="filled"
					bind:value={nombre}
					label="Nombre"
				/>
			</Cell>

			<Cell span={12}>
				<FormField>
					<Radio bind:group={visibilidad} value={Visibilidad.Publico} />
					<Label slot="label">Pública</Label>
				</FormField>
				<FormField>
					<Radio bind:group={visibilidad} value={Visibilidad.Privado} />
					<Label slot="label">Privada</Label>
				</FormField>
			</Cell>

			<Cell span={12}>
				<Textfield
					textarea
					bind:value={descripcion}
					required
					label="Descripción"
					style="width: 100%;"
				/>
			</Cell>

			<Cell span={12}>
				<div class="button-container">
					<Button variant="raised" type="submit">Crear Comunidad</Button>
				</div>
			</Cell>
		</LayoutGrid>
	</form>
</div>

<style lang="sass">
    .crear-comunidad :global(.input-nombre)
        width: 300px
    
    .button-container
        width: 100%
        display: flex
        justify-content: flex-end
</style>
