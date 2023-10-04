<script>
    let nombre = "";
    let visibilidad = "publico";
    let descripcion = "";

    function crearComunidad() {

        console.log("Nombre:", nombre);
        console.log("Visibilidad:", visibilidad);
        console.log("Descripción:", descripcion);
    }
</script>

<div>
    <h1>Crear Comunidad</h1>
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" bind:value={nombre} />

    <div>
        <label>Visibilidad:</label>
        <input type="radio" id="publico" name="visibilidad" value="publico" bind:group={visibilidad} />
        <label for="publico">Público</label>
        <input type="radio" id="privado" name="visibilidad" value="privado" bind:group={visibilidad} />
        <label for="privado">Privado</label>
    </div>

    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" rows="4" bind:value={descripcion}></textarea>

    <button on:click={crearComunidad}>Crear Comunidad</button>
</div>
