<script lang="ts">
	import Paper from '@smui/paper';
	import Textfield from '@smui/textfield';
	import ChatMessage from '$lib/features/chat/ChatMessage.svelte';
	import {
		getFirestore,
		getDocs,
		doc,
		collection,
		query,
		onSnapshot,
		orderBy,
		addDoc,
		serverTimestamp
	} from '@firebase/firestore';
	import { onMount } from 'svelte';
	import { currentCommunityId, currentUser } from '$lib/store';

	interface Message {
		author: string;
		content: string;
	}

	let message = '';

	let messages: Message[] = [];

	onMount(() => {
		const db = getFirestore();
		const ref = collection(db, 'chats', String($currentCommunityId), 'messages');
		const q = query(ref, orderBy('timestamp'));
		return onSnapshot(q, (collection) => {
			messages = collection.docs.map((doc) => doc.data() as Message);
		});
	});

	function mandarMensaje() {
		if (message === '') return;
		const db = getFirestore();
		const ref = collection(db, 'chats', String($currentCommunityId), 'messages');
		addDoc(ref, {
			author: $currentUser?.nombre + ' ' + $currentUser?.apellidos,
			content: message,
			timestamp: serverTimestamp()
		});
		message = '';
	}
</script>

<div class="chat">
	<Paper class="chat-card">
		<div class="chat-messages">
			{#each messages as { content, author }}
				<ChatMessage {content} {author} />
			{/each}
		</div>
		<Paper class="input-card">
			<form on:submit|preventDefault={mandarMensaje}>
				<Textfield label="Manda un mensaje" bind:value={message} style="width: 100%" />
			</form>
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
