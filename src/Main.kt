
/*
    El uso del null safety operator(?) hace que el atributo del artista
    pueda ser opcional, o sea null. De esta manera obliga a manejar de forma segura
    los casos en los que no hay datos.
 */
class Artist( val nombre : String,
    val canciones : List<String>?){}


fun main(array: String){

    /*
    En el caso en el que el artista no sea null, a la hora de imprimir no tenemos que
    verificar la nulidad del objeto artista..
     */
    val notNullArtista = Artist("Taylor Swift", listOf("Lover", "Shake It Off"))
    /*
    Para el atributo nombre no tenemos que verificar nulidad tampoco.
     */
    println("Artist: ${notNullArtista.nombre}")
    /*
    En el caso del atributo canciones tenemos que verificar nulidad porque
    en el constructor de artista tenemos List<String>? que sí puede ser
    nulo, por lo que hay que usar el safe call operator(?)
     */
    /*
    El ?: se llama Elvis operator y se usa para manejar valores null proporcionando un valor
    predeterminado. Si la expresión es null, devuelve el valor a la derecha
    del operador.
     */
    println("Artist: ${notNullArtista.canciones?.joinToString() ?: "No songs available"}")


    /*
    Artista que puede ser null usando el null safety operator. Las clases en Kotlin
    por defecto no son nullables y se puede hacer
     */
    var nullableArtist : Artist? = null
    /*
    Con Elvis operator, si el Artista es null, se imprime el valor de la derecha.
     */
    println("Nullable artist name: ${nullableArtist?.nombre ?: "Artist not available"}")

    /*
    Al poder ser la lista nullable, podemos crear un artista con ese
    valor en null
     */
    nullableArtist = Artist("Ed Sheeran", null)

    /**
     *
     */
    val canciones = nullableArtist?.canciones ?: listOf("No songs found")
    println("Canciones para ${nullableArtist.nombre}: ${canciones.joinToString()}")


    try{
        println("Forzando null exception: ${nullableArtist.canciones!!.joinToString()}")
    } catch (e: NullPointerException){
        println("Exception caught: ${e.message}")
    }

    // 5. Verificar si es null antes de usar
    if (nullableArtist.canciones != null) {
        println("Artist has songs: ${nullableArtist.canciones.joinToString()}")
    } else {
        println("Artist has no songs.")
    }

    nullableArtist  = null;
    println("Current artista: ${nullableArtist?.nombre ?: "No artista selected"}")

}