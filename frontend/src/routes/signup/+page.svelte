<script lang="ts">
	import Card from '@smui/card';
	import LayoutGrid, { Cell } from '@smui/layout-grid';
	import TextField from '@smui/textfield';
	import Button from '@smui/button';
	import { getAuth, createUserWithEmailAndPassword } from 'firebase/auth';

	let name = '';
	let surname = '';
	let email = '';
	let password = '';
	let confirmPassword = '';

	let errorMessage: string | undefined = undefined;

	async function submit() {
		if (confirmPassword !== password) {
			errorMessage = 'Las contraseñas no coinciden';
			return;
		}

		const auth = getAuth();
		createUserWithEmailAndPassword(auth, email, password);
	}
</script>

<form on:submit|preventDefault={submit}>
	<Card>
		<LayoutGrid>
			<Cell span={6}>
				<TextField
					required
					variant="outlined"
					label="Nombre"
					style="width: 100%"
					bind:value={name}
				/>
			</Cell>
			<Cell span={6}>
				<TextField
					required
					variant="outlined"
					label="Apellido(s)"
					style="width: 100%"
					bind:value={surname}
				/>
			</Cell>
			<Cell span={12}>
				<div class="input-container">
					<TextField
						required
						variant="outlined"
						label="Correo electrónico"
						style="width: 100%"
						bind:value={email}
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
			<Cell span={12}>
				<div class="input-container">
					<TextField
						required
						variant="outlined"
						label="Confirmar contraseña"
						type="password"
						style="width: 100%;"
						bind:value={confirmPassword}
					/>
				</div>
			</Cell>
			{#if errorMessage}
				<Cell span={12}>
					<p class="error-message">{errorMessage}</p>
				</Cell>
			{/if}
			<Cell span={12}>
				<Button type="submit" variant="raised" style="width: 100%">Registrar cuenta</Button>
			</Cell>
		</LayoutGrid>
	</Card>
</form>

<style lang="sass">
    .input-container
        width: 500px

    .error-message
        backgound-color: red
</style>
