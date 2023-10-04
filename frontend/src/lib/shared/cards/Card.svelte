<script lang="ts">
    import Card, {
		Content,
		PrimaryAction,
		Media,
		MediaContent,
		Actions,
		ActionButtons,
		ActionIcons
	} from '@smui/card';
	import Button, { Label } from '@smui/button';
	import IconButton, { Icon } from '@smui/icon-button';
	import type { DetallesComunidad } from '$lib/generated/openapi';

	export let comunidad: DetallesComunidad;
	let clicked = 0;
</script>

<div class="card-display">
	<div class="card-container">
		<Card>
			<PrimaryAction on:click={() => clicked++}>
				<Media class="card-media-16x9" aspectRatio="16x9" />
				<Content class="mdc-typography--body2">
					<h2 class="mdc-typography--headline6" style="margin: 0;">{comunidad.nombre}</h2>
					<h3 class="mdc-typography--subtitle2" style="margin: 0 0 10px; color: #888;">
						Creado por: {comunidad.creadoPor.nombre}
					</h3>
					Descripcion: {comunidad.descripcion}
				</Content>
			</PrimaryAction>
			<Actions>
				<ActionButtons>
					<Button on:click={() => clicked++}>
						<Label>Inscribirme</Label>
					</Button>
				</ActionButtons>
			</Actions>
		</Card>
	</div>
</div>

<style>
	* :global(.card-media-16x9) {
		background-image: url(https://placehold.co/320x180?text=16x9);
	}
</style>
