<script lang="ts">
	import type { DetallesComunidad } from '$lib/generated/openapi';
	import services from '$lib/services';
	import { currentUser } from '$lib/store';
	import CommunityCard from '$lib/shared/cards/CommunityCard.svelte';
	import LayoutGrid, { Cell } from '@smui/layout-grid';

	const { usuariosApi } = services;

	let comunidadesPromise: Promise<DetallesComunidad[]> | undefined;

	$: comunidadesPromise = $currentUser?.id ? fetchComunidades($currentUser.id) : undefined;

	async function fetchComunidades(idUsuario: number) {
		const { comunidades } = await usuariosApi.getComunidadesUsuario({ id: idUsuario });
		return comunidades;
	}
</script>

{#if comunidadesPromise}
	{#await comunidadesPromise}
		<p>Loading...</p>
	{:then comunidades}
		<LayoutGrid>
			{#each comunidades as comunidad}
				<Cell span={3}>
					<CommunityCard {comunidad} inscrito />
				</Cell>
			{/each}
		</LayoutGrid>
	{/await}
{/if}
