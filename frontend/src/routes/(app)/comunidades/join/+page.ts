import type { PageLoad } from './$types';
import { browser } from '$app/environment';

export const load: PageLoad = ({ url }) => {
	let communityId = '';
	if (browser) communityId = url.searchParams.get('id') ?? '';
	return Promise.resolve({
		communityId
	});
};
