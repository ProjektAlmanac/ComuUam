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
import type { DetallesComunidad } from './DetallesComunidad';
import {
    DetallesComunidadFromJSON,
    DetallesComunidadFromJSONTyped,
    DetallesComunidadToJSON,
} from './DetallesComunidad';

/**
 * 
 * @export
 * @interface ListaComunidades
 */
export interface ListaComunidades {
    /**
     * 
     * @type {DetallesComunidad}
     * @memberof ListaComunidades
     */
    comunidades: DetallesComunidad;
}

/**
 * Check if a given object implements the ListaComunidades interface.
 */
export function instanceOfListaComunidades(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "comunidades" in value;

    return isInstance;
}

export function ListaComunidadesFromJSON(json: any): ListaComunidades {
    return ListaComunidadesFromJSONTyped(json, false);
}

export function ListaComunidadesFromJSONTyped(json: any, ignoreDiscriminator: boolean): ListaComunidades {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'comunidades': DetallesComunidadFromJSON(json['comunidades']),
    };
}

export function ListaComunidadesToJSON(value?: ListaComunidades | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'comunidades': DetallesComunidadToJSON(value.comunidades),
    };
}

