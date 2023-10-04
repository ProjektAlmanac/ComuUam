import * as apis from '../generated/openapi/apis';

import { Configuration } from '../generated/openapi';
import { getAuth } from 'firebase/auth';

const config = new Configuration({
	basePath: globalThis.location?.origin,
	accessToken: () => {
		const auth = getAuth();
		const token = auth.currentUser?.getIdToken() ?? '';
		return token;
	}
});

export default {
	comunidadApi: new apis.ComunidadApi(config),
	usuariosApi: new apis.UsuariosApi(config)
};
