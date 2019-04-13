import java.util.*

fun main(args:Array<String>){
    println("Hola mundo")

    //variables

    //variables que pueden mutar
    //variable mutable

    var nombre = "Cesar"
    nombre="Andres"

    //variable inmutable

    val nombreI="Cesar"
    //nombreI="Andres"  //esto no se puede hacer en una variable inmutable
    //lo recomendable es hacer las cosas inmutables porque


    //TIPOS DE DATOS

    val apellido: String ="Balcazar"
    val edad: Int =23
    val sueldo: Double =0.0
    val casado=false
    val estudiante=true
    val hijos: Nothing? =null


   // el proceso de entender el tipo de datos
    // se llama Duck typing

    //si paraece, camina, suena y vuela como pato, entonces debe ser un pato

    //condicionales

    if(apellido=="Balcazar"){
        println("V")

    }else{
        println("F")
    }

    val tieneNombreyApellido=if (apellido!=null && nombre!=null) "ok" else "no"

    println(tieneNombreyApellido)

    //en kotlin no existe swtich, sino when xD

    estaJalado(10.0)


    holaMundo("people equal shit")

    var aux=sumar(2.4,6.5)
    println(aux)


    val arregloCumpleanos:Array<Int> = arrayOf(1,2,3,4)
    val arregloCumpleanos2:Array<Any> = arrayOf(1,"Alv",10.2,true)

    arregloCumpleanos[0]=5
    arregloCumpleanos.set(0,5)
    //en el caso de los arreglos inmutables se puede cambiar valores por seperados pero no toda la instancia del mismo

    val fecha=Date()
    fecha.time=11231231
    fecha.year=2000


    val notas= arrayListOf<Int>(1,2,3,4,5,6,7)
    println("Notas: ")
    notas.forEach {

        println(it)
    }

    println("Notas: ")
    notas.forEach { nota: Int ->
        println(nota)
    }

    println("Notas indexadas: ")
    notas.forEachIndexed { index, i ->

        println("Index: $index Nota: $i ")
    }


    notas.forEachIndexed { index, i ->
        notas[index]+=1
    }

    //operador map , itera y modifica el arreglo







    //aplicar una funcion dentro del map



    notas.map { nota->
        nota+1
    }


    notas.forEachIndexed { index, i ->

        println("Index: $index Nota: $i ")
    }


    val notas2=notas.map { nota->
        if(nota%2==0){
            nota+2
        }else{
            nota+1
        }
    }

    println("--------")
    notas2.forEachIndexed { index, i ->

        println("Index: $index Nota: $i ")
    }


    val notas3=notas.map { nota->
        var modulo=nota%2
        var espar=0
        when(modulo){
            espar->{
                nota+5
            }
            else->{
                nota+10
            }
        }

    }

    notas3.forEach { it->
        println(it)
    }


     val respuestaFilter = notas
        .filter {
            // Filtra el arreglo
            it in 3..4
            // it > 2 && it < 5
        }
        .map {
            // Mutar o Cambiar el arreglo
            it * 2
        }

    respuestaFilter.forEach { println(it) }

    val novias = arrayListOf(1, 2, 2, 3, 4, 5)

    val respuestaNovia: Boolean = novias.any {
        it == 7
    }

    println(respuestaNovia) // true
    println(respuestaNovia) // false

    val tazos = arrayListOf(1,2,3,4,5,6,7)

    val respuestaTazos = tazos.all {
        it > 1
    }

    println(respuestaTazos) // falso

    val totalTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }
    println(totalTazos)


    



}

fun estaJalado(nota:Double){ //el tipo de retorno cuando no se devuelve nada es Unit
    when(nota){
        7.0-> {
          println("pasaste con las justas mmv")
        }

        10.0 ->{
            println("pasaste bien")
        }

        else ->{
            println("tu nota es: ${nota} o $nota")

        }
    }
}



fun holaMundo(mensaje:Any):Unit{
    println("Mensaje $mensaje")
}


fun sumar(num1:Double,num2:Double):Double{

    return num1+num2

}