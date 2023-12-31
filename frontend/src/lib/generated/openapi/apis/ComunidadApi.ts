/* tslint:disable */
/* eslint-disable */
/**
 * Comuam
 * Correo de contacto del API
 *
 * The version of the OpenAPI document: 1.0
 * Contact: miguel.gzm98@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  Comunidad,
  ComunidadCreada,
  CreacionComunidad,
  IdUsuario,
  ListaComunidades,
} from '../models/index';
import {
    ComunidadFromJSON,
    ComunidadToJSON,
    ComunidadCreadaFromJSON,
    ComunidadCreadaToJSON,
    CreacionComunidadFromJSON,
    CreacionComunidadToJSON,
    IdUsuarioFromJSON,
    IdUsuarioToJSON,
    ListaComunidadesFromJSON,
    ListaComunidadesToJSON,
} from '../models/index';

export interface AgregarMiembroComunidadRequest {
    idComunidad: any;
    idUsuario?: IdUsuario;
}

export interface CrearComunidadRequest {
    creacionComunidad?: CreacionComunidad;
}

export interface GetInfoComunidadRequest {
    idComunidad: any;
}

/**
 * 
 */
export class ComunidadApi extends runtime.BaseAPI {

    /**
     * Agrega a un miembro a una comunidad
     * Agregar miembro a comunidad
     */
    async agregarMiembroComunidadRaw(requestParameters: AgregarMiembroComunidadRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<void>> {
        if (requestParameters.idComunidad === null || requestParameters.idComunidad === undefined) {
            throw new runtime.RequiredError('idComunidad','Required parameter requestParameters.idComunidad was null or undefined when calling agregarMiembroComunidad.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("jwt", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/api/comunidades/{idComunidad}/miembros`.replace(`{${"idComunidad"}}`, encodeURIComponent(String(requestParameters.idComunidad))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: IdUsuarioToJSON(requestParameters.idUsuario),
        }, initOverrides);

        return new runtime.VoidApiResponse(response);
    }

    /**
     * Agrega a un miembro a una comunidad
     * Agregar miembro a comunidad
     */
    async agregarMiembroComunidad(requestParameters: AgregarMiembroComunidadRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<void> {
        await this.agregarMiembroComunidadRaw(requestParameters, initOverrides);
    }

    /**
     * Registra una nueva comunidad en el sistema
     * Crear una nueva comunidad
     */
    async crearComunidadRaw(requestParameters: CrearComunidadRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ComunidadCreada>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("jwt", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/api/comunidades`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: CreacionComunidadToJSON(requestParameters.creacionComunidad),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ComunidadCreadaFromJSON(jsonValue));
    }

    /**
     * Registra una nueva comunidad en el sistema
     * Crear una nueva comunidad
     */
    async crearComunidad(requestParameters: CrearComunidadRequest = {}, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ComunidadCreada> {
        const response = await this.crearComunidadRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Recupera una lista con todas las comunidades que se han registrado
     * Your GET endpoint
     */
    async getComunidadesRaw(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ListaComunidades>> {
        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("jwt", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/api/comunidades`,
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ListaComunidadesFromJSON(jsonValue));
    }

    /**
     * Recupera una lista con todas las comunidades que se han registrado
     * Your GET endpoint
     */
    async getComunidades(initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ListaComunidades> {
        const response = await this.getComunidadesRaw(initOverrides);
        return await response.value();
    }

    /**
     * Obtiene la información de la comunidad
     * Obtener información de la comunidad
     */
    async getInfoComunidadRaw(requestParameters: GetInfoComunidadRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Comunidad>> {
        if (requestParameters.idComunidad === null || requestParameters.idComunidad === undefined) {
            throw new runtime.RequiredError('idComunidad','Required parameter requestParameters.idComunidad was null or undefined when calling getInfoComunidad.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        if (this.configuration && this.configuration.accessToken) {
            const token = this.configuration.accessToken;
            const tokenString = await token("jwt", []);

            if (tokenString) {
                headerParameters["Authorization"] = `Bearer ${tokenString}`;
            }
        }
        const response = await this.request({
            path: `/api/comunidades/{idComunidad}`.replace(`{${"idComunidad"}}`, encodeURIComponent(String(requestParameters.idComunidad))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ComunidadFromJSON(jsonValue));
    }

    /**
     * Obtiene la información de la comunidad
     * Obtener información de la comunidad
     */
    async getInfoComunidad(requestParameters: GetInfoComunidadRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Comunidad> {
        const response = await this.getInfoComunidadRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
