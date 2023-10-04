<script lang="ts">
	import TextField from '@smui/textfield';
	import Button from '@smui/button';
	import LayoutGrid, { Cell } from '@smui/layout-grid';
	import { getAuth, signInWithEmailAndPassword, type AuthError } from 'firebase/auth';
	import Card from '@smui/card';
	import { goto } from '$app/navigation';
	import services from '$lib/services';

	let username = '';
	let password = '';

	let errorMessage: string | undefined = undefined;

	async function submit(e: Event) {
		const auth = getAuth();
		try {
			await signInWithEmailAndPassword(auth, username, password);
			goto('/');
		} catch (e: any) {
			const authErr = e as AuthError;
			mostrarMensajeError(authErr.code);
		}
	}

	function mostrarMensajeError(errorCode: string) {
		switch (errorCode) {
			case 'auth/invalid-email':
				errorMessage = 'El correo electrónico no es válido';
				break;
			case 'auth/invalid-login-credentials':
				errorMessage = 'El correo electrónico o la contraseña no son válidos';
				break;
			default:
				errorMessage = 'Ha ocurrido un error';
		}
	}
</script>

<div>
	<form on:submit|preventDefault={submit}>
		<Card>
			<LayoutGrid>
				<Cell span={12}>
					<div class="input-container">
						<TextField
							required
							variant="outlined"
							label="Correo electrónico"
							style="width: 100%"
							bind:value={username}
						/>
					</div>
				</Cell>
				<Cell span={12}>
					<div class="input-container">
						<TextField
							required
							variant="outlined"
							label="Contraseña"
							type="password"
							style="width: 100%;"
							bind:value={password}
						/>
					</div>
				</Cell>
				{#if errorMessage}
					<Cell span={12}>
						<p class="error-message">{errorMessage}</p>
					</Cell>
				{/if}
				<Cell span={12}>
					<Button type="submit" variant="raised" style="width: 100%">Entrar</Button>
				</Cell>
			</LayoutGrid>
		</Card>
	</form>
</div>
<div class="test" />

<style lang="sass">
    .input-container
        width: 350px
    .error-message
        backgound-color: red
</style>
