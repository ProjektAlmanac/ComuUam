<script lang="ts">
	import type { PageData } from './$types';
	import type { Comunidad } from '$lib/generated/openapi';
	import { onMount } from 'svelte';
	import { marked } from 'marked';
	import services from '$lib/services';
	import Button from '@smui/button';
	import Card from '@smui/card';
	import { currentUser } from '$lib/store';
	import { goto } from '$app/navigation';

	export let data: PageData;

	const { comunidadApi } = services;

	let comunidadPromise: Promise<Comunidad>;

	onMount(() => {
		comunidadPromise = comunidadApi.getInfoComunidad({
			idComunidad: Number(data.communityId)
		});
	});

	async function inscribirComunidad(idComunidad: number) {
		await comunidadApi.agregarMiembroComunidad({
			idComunidad,
			idUsuario: {
				idUsuario: $currentUser?.id!
			}
		});
		goto(`/comunidades?id=${data.communityId}`);
	}
</script>

{#if comunidadPromise}
	{#await comunidadPromise}
		<p>Cargando...</p>
	{:then comunidad}
		<div class="community">
			<Card class="community-card">
				<h1 class="nombre-comunidad">{comunidad.nombre}</h1>
				<h2>Descripción</h2>
				<p>
					{@html marked(comunidad.descricion)}
				</p>
				<div class="botones">
					<Button variant="raised" on:click={() => inscribirComunidad(comunidad.idComunidad)}
						>Inscribirme</Button
					>
					<Button variant="raised" on:click={() => history.back()}>Regresar</Button>
				</div>
			</Card>
		</div>
	{:catch error}
		<p>Ha ocurrido un error</p>
	{/await}
{/if}

<style lang="sass">
    .community :global(.community-card)
        margin: 1rem
        padding: 1rem

    .nombre-comunidad
        text-align: center

    .botones
        width: 100%
        display: flex
        justify-content: center
        gap: 1rem
</style>
