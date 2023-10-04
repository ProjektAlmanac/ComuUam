// Import the functions you need from the SDKs you need

import { currentUser } from '$lib/store';
import { initializeApp } from 'firebase/app';
import { getAuth } from 'firebase/auth';

export function inicializarFirebase() {
	// TODO: Add SDKs for Firebase products that you want to use

	// https://firebase.google.com/docs/web/setup#available-libraries

	// Your web app's Firebase configuration

	const firebaseConfig = {
		apiKey: 'AIzaSyDV-1HfBJmnY-qZQK_UgFyz4hfVYjVJlhg',

		authDomain: 'comu-uam.firebaseapp.com',

		projectId: 'comu-uam',

		storageBucket: 'comu-uam.appspot.com',

		messagingSenderId: '275563017724',

		appId: '1:275563017724:web:c39e2e101eb3db1bbbae79'
	};

	console.log('Firebase inicializado');

	// Initialize Firebase

	initializeApp(firebaseConfig);

	const auth = getAuth();
	auth.onAuthStateChanged((user) => {
		currentUser.set(user);
	});
}
