import * as apis from "../generated/openapi/apis"

import { Configuration } from "../generated/openapi"

const config = new Configuration({
  basePath: "http://localhost:3000"
})

export default {
    comunidadApi: new apis.ComunidadApi(config),
    usuariosApi: new apis.UsuariosApi(config)
}