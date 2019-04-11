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
