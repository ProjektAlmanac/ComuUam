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

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface UsuarioCreado
 */
export interface UsuarioCreado {
    /**
     * 
     * @type {number}
     * @memberof UsuarioCreado
     */
    id: number;
    /**
     * 
     * @type {string}
     * @memberof UsuarioCreado
     */
    nombre: string;
    /**
     * 
     * @type {string}
     * @memberof UsuarioCreado
     */
    apellidos: string;
    /**
     * 
     * @type {string}
     * @memberof UsuarioCreado
     */
    correo: string;
}

/**
 * Check if a given object implements the UsuarioCreado interface.
 */
export function instanceOfUsuarioCreado(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "id" in value;
    isInstance = isInstance && "nombre" in value;
    isInstance = isInstance && "apellidos" in value;
    isInstance = isInstance && "correo" in value;

    return isInstance;
}

export function UsuarioCreadoFromJSON(json: any): UsuarioCreado {
    return UsuarioCreadoFromJSONTyped(json, false);
}

export function UsuarioCreadoFromJSONTyped(json: any, ignoreDiscriminator: boolean): UsuarioCreado {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['id'],
        'nombre': json['nombre'],
        'apellidos': json['apellidos'],
        'correo': json['correo'],
    };
}

export function UsuarioCreadoToJSON(value?: UsuarioCreado | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id': value.id,
        'nombre': value.nombre,
        'apellidos': value.apellidos,
        'correo': value.correo,
    };
}

