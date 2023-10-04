<script lang="ts">
	import type { DetallesComunidad } from '$lib/generated/openapi';
	import services from '$lib/services';
	import { currentUserId } from '$lib/store';
	import CommunityCard from '$lib/shared/cards/CommunityCard.svelte';

	const { usuariosApi } = services;

	let comunidadesPromise: Promise<DetallesComunidad[]> | undefined;

	$: comunidadesPromise = $currentUserId ? fetchComunidades($currentUserId) : undefined;

	async function fetchComunidades(idUsuario: number) {
		const { comunidades } = await usuariosApi.getComunidadesUsuario({ id: idUsuario });
		return comunidades;
	}
</script>

{#if comunidadesPromise}
	{#await comunidadesPromise}
		<p>Loading...</p>
	{:then comunidades}
		{#each comunidades as comunidad}
			<CommunityCard {comunidad} inscrito />
		{/each}
	{/await}
{/if}
