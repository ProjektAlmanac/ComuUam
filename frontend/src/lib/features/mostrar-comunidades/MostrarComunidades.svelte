<script lang="ts">
	import type { ListaComunidades } from '$lib/generated/openapi';
	import services from '$lib/services';
	import Card from '$lib/shared/cards/Card.svelte';
	import { onMount } from 'svelte';
	import Button, { Label } from '@smui/button';
 
  	let clicked = 0;
	
	let comunidades: ListaComunidades = { comunidades: [] }

	onMount(async () => {
		comunidades = await services.comunidadApi.getComunidades()
		console.log(comunidades)
	})
</script>

<div class="titulo">
	<h1>Lista de Comunidades de la UAM</h1>
</div>
<hr />

<div class="boton">
	<a href="/crear-comunidad">
		<Button color="secondary" on:click={() => clicked++} variant="raised">
			<Label>Crear nueva comunidad</Label>
		</Button>
	</a>
	
</div>

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
	.boton {
		margin-left: 50px;
		margin-bottom: 50px;
	}
</style>
