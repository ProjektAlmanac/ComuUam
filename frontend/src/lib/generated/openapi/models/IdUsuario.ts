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
 * @interface IdUsuario
 */
export interface IdUsuario {
    /**
     * 
     * @type {number}
     * @memberof IdUsuario
     */
    idUsuario: number;
}

/**
 * Check if a given object implements the IdUsuario interface.
 */
export function instanceOfIdUsuario(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "idUsuario" in value;

    return isInstance;
}

export function IdUsuarioFromJSON(json: any): IdUsuario {
    return IdUsuarioFromJSONTyped(json, false);
}

export function IdUsuarioFromJSONTyped(json: any, ignoreDiscriminator: boolean): IdUsuario {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'idUsuario': json['idUsuario'],
    };
}

export function IdUsuarioToJSON(value?: IdUsuario | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'idUsuario': value.idUsuario,
    };
}

