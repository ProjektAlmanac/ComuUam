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
 * Datos necesarios para crear un usuario
 * @export
 * @interface CreacionUsuario
 */
export interface CreacionUsuario {
    /**
     * 
     * @type {string}
     * @memberof CreacionUsuario
     */
    nombre: string;
    /**
     * 
     * @type {string}
     * @memberof CreacionUsuario
     */
    apellidos: string;
    /**
     * 
     * @type {string}
     * @memberof CreacionUsuario
     */
    correo: string;
    /**
     * 
     * @type {string}
     * @memberof CreacionUsuario
     */
    password: string;
}

/**
 * Check if a given object implements the CreacionUsuario interface.
 */
export function instanceOfCreacionUsuario(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "nombre" in value;
    isInstance = isInstance && "apellidos" in value;
    isInstance = isInstance && "correo" in value;
    isInstance = isInstance && "password" in value;

    return isInstance;
}

export function CreacionUsuarioFromJSON(json: any): CreacionUsuario {
    return CreacionUsuarioFromJSONTyped(json, false);
}

export function CreacionUsuarioFromJSONTyped(json: any, ignoreDiscriminator: boolean): CreacionUsuario {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'nombre': json['nombre'],
        'apellidos': json['apellidos'],
        'correo': json['correo'],
        'password': json['password'],
    };
}

export function CreacionUsuarioToJSON(value?: CreacionUsuario | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'nombre': value.nombre,
        'apellidos': value.apellidos,
        'correo': value.correo,
        'password': value.password,
    };
}

