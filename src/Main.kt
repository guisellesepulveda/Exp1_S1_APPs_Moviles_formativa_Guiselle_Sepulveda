fun main () {
    // Paso 1: Declaración de variables y tipos de datos


//Datos del Cliente (mutables para permitir registro por consola

    var nombreCliente: String = ""
    var direccionCliente: String = ""
    var telefonoCliente: Int = 0


//Datos del Producto (pizza)

    val nombrePizza: String = "Pepperoni"
    val precioUnitario: Double = 12990.0
    var ingredientesDisponibles: Int = 10 //Stock inicial de ingredientes

//Datos del pedido

    val idPedido: Int = 101
    var cantidadPizzas: Int = 0
    var totalPedido: Double = 0.0
    var estadoPedido: String = "En preparación"
    val repartidorAsignado: String = "Carlos Ramírez"

// Paso 2: Entrada y salida de datos (I/O)

    println("----REGISTRO DE CLIENTE Y PEDIDO - PIZZERÍA----")

    println("Ingrese el nombre del cliente:")
    nombreCliente = readLine()?.takeIf{ it.isNotBlank()} ?: "Cliente Genérico"

    println("Ingrese la dirección de entrega:")
    nombreCliente = readLine()?.takeIf{ it.isNotBlank()} ?: "Sin dirección"

    println("Ingrese el número de contacto (teléfono:")
    telefonoCliente = try {
        readLine()?.toInt() ?: 0
    } catch (e: NumberFormatException) {
        println("Error en el formato del teléfono. Se asignará 0 por defecto.")
        0
    } as Int

    println("Ingrese la cantidad de pizzas que desea pedir:")
    cantidadPizzas = try {
        readLine()?.toInt() ?: 1
    } catch (e: NumberFormatException) {
        println("Entrada inválida.Se asignará 1 por defecto.")
        1
    }

    // Paso 3: Cálculo del total del pedido con descuento

    //Cálculo base

    val subtotal = precioUnitario * cantidadPizzas

    // Aplicar 10% de descuento si la cantidad es mayor a 3 usando una expresión if

    totalPedido = if (cantidadPizzas > 3) {
        println("¡Descuento aplicado del 10% por comprar más de 3 pizzas!")
        subtotal * 0.90
    } else {
        subtotal
    }

    //Paso 4: Verificación de stock

    // Verificamos stock requerido (asumimos 2 unidades de ingredientes por pizza)
    val ingredientesNecesarios = cantidadPizzas * 2

    val resultadoStock = if (ingredientesDisponibles >= ingredientesNecesarios) {
        ingredientesDisponibles -= ingredientesNecesarios
        estadoPedido = "Confirmado / En preparación"
        "Stock suficiente.¡Pedido confirmado y enviado a cocina!"
    } else {
        estadoPedido = "Rechazado por stock"
        "Stock insuficiente. No hat suficientes ingredientes para preparar el pedido."
    }
    println(resultadoStock)

    //Paso 5 y 6: Resumen del pedido

    println("=========================================")
    println("           RESUMEN DEL PEDIDO            ")
    println("=========================================")
    println(" ID del Pedido: $idPedido")
    println(" Cliente: $nombreCliente")
    println(" Dirección: $direccionCliente")
    println(" Telefono: $telefonoCliente")
    println(" ----------------------------------------")
    println(" Producto: $nombrePizza")
    println(" Precio Unitario: \$precioUnitario")
    println(" Cantidad Solicitada: $cantidadPizzas")
    println(" ----------------------------------------")
    println(" Total a Pagar: \$totalPedido")
    println(" Repartidor Asignado: $repartidorAsignado")
    println(" Estado del Pedido: $estadoPedido")
    println(" Ingredientes restantes en bodega: $ingredientesDisponibles")
    println(" =========================================")

}

