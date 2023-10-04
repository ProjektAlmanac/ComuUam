<script lang="ts">
	import Card from '$lib/shared/cards/Card.svelte';
	import { Row } from '@smui/top-app-bar';

	let comunidades = {
		comunidades: [
			{
				nombre: 'Comunidad Java',
				creadoPor: {
					id: 1,
					nombre: 'Miguel Guzman'
				},
				descripcion: 'Ven y aprende'
			},
			{
				nombre: 'Comunidad Java 2',
				creadoPor: {
					id: 1,
					nombre: 'Miguel Guzman'
				},
				descripcion: 'Ven y aprende'
			},
			{
				nombre: 'Comunidad Java 2',
				creadoPor: {
					id: 1,
					nombre: 'Miguel Guzman'
				},
				descripcion: 'Ven y aprende'
			},
			{
				nombre: 'Comunidad Java 2',
				creadoPor: {
					id: 1,
					nombre: 'Miguel Guzman'
				},
				descripcion: 'Ven y aprende'
			},
			{
				nombre: 'Comunidad Java 2',
				creadoPor: {
					id: 1,
					nombre: 'Miguel Guzman'
				},
				descripcion: 'Ven y aprende'
			}
		]
	};
</script>

<div class="titulo">
	<h1>Lista de Comunidades de la UAM</h1>
</div>
<hr />

<div class="row">
	{#each comunidades.comunidades as comunidad}
		<div class="col-sm-12 col-lg-3 m-4">
			<Card {comunidad} />
		</div>
	{/each}
</div>

<style>
	.titulo {
		text-align: center;
	}
</style>
