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
import type { Visibilidad } from './Visibilidad';
import {
    VisibilidadFromJSON,
    VisibilidadFromJSONTyped,
    VisibilidadToJSON,
} from './Visibilidad';

/**
 * Datos de una comunidad creada
 * @export
 * @interface ComunidadCreada
 */
export interface ComunidadCreada {
    /**
     * 
     * @type {number}
     * @memberof ComunidadCreada
     */
    id: number;
    /**
     * 
     * @type {Visibilidad}
     * @memberof ComunidadCreada
     */
    visibilidad: Visibilidad;
    /**
     * 
     * @type {string}
     * @memberof ComunidadCreada
     */
    descripcion: string;
    /**
     * 
     * @type {Array<string>}
     * @memberof ComunidadCreada
     */
    categorias: Array<string>;
}

/**
 * Check if a given object implements the ComunidadCreada interface.
 */
export function instanceOfComunidadCreada(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "id" in value;
    isInstance = isInstance && "visibilidad" in value;
    isInstance = isInstance && "descripcion" in value;
    isInstance = isInstance && "categorias" in value;

    return isInstance;
}

export function ComunidadCreadaFromJSON(json: any): ComunidadCreada {
    return ComunidadCreadaFromJSONTyped(json, false);
}

export function ComunidadCreadaFromJSONTyped(json: any, ignoreDiscriminator: boolean): ComunidadCreada {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['id'],
        'visibilidad': VisibilidadFromJSON(json['visibilidad']),
        'descripcion': json['descripcion'],
        'categorias': json['categorias'],
    };
}

export function ComunidadCreadaToJSON(value?: ComunidadCreada | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'id': value.id,
        'visibilidad': VisibilidadToJSON(value.visibilidad),
        'descripcion': value.descripcion,
        'categorias': value.categorias,
    };
}
