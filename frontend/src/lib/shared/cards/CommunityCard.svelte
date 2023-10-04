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
	import type { DetallesComunidad } from '$lib/generated/openapi';

	export let comunidad: DetallesComunidad;

	export let inscrito: boolean = false;
</script>

<div class="card-display">
	<div class="card-container">
		<Card>
			<PrimaryAction>
				<img
					src="https://yt3.googleusercontent.com/2tjUUCtSdXwQthDFK4gPuKd1kbYAKgUH8A003UnShfJbzo4BQKl3weBIsCSJuWI0pHy75bpN=s900-c-k-c0x00ffffff-no-rj"
					width="300"
					alt="Imagen"
				/>
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
					{#if !inscrito}
						<a href="/comunidades/join?id={comunidad.id}">
							<Button>
								<Label>Inscribirme</Label>
							</Button>
						</a>
					{/if}
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
