<script lang="ts">
	import Paper from '@smui/paper';
	import Textfield from '@smui/textfield';
	import ChatMessage from '$lib/features/chat/ChatMessage.svelte';

	let message = '';

	const arr = new Array(20).fill(0);
</script>

<div class="chat">
	<Paper class="chat-card">
		<div class="chat-messages">
			{#each arr as element}
				<ChatMessage content="Message {element}" author="User {element}" />
			{/each}
		</div>
		<Paper class="input-card">
			<Textfield label="Manda un mensaje" bind:value={message} style="width: 100%" />
		</Paper>
	</Paper>
</div>

<style lang="sass">
    .chat :global(.chat-card)
        margin: 1rem
        height: 95%

    .chat
        height: 100%

    .chat-messages
        height: 600px
        overflow: auto
</style>
