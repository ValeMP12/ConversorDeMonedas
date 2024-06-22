# Conversor De Monedas

¡Bienvenido al Conversor de Monedas! Este proyecto en Java permite convertir varias monedas de manera sencilla y rápida utilizando tasas de cambio actualizadas en tiempo real.

## Funcionalidades

- **Convertir Dólares a Pesos Argentinos, Reales Brasileños, Pesos Colombianos y Pesos Mexicanos.**
- **Convertir Pesos Argentinos, Reales Brasileños, Pesos Colombianos y Pesos Mexicanos a Dólares.**
- **Manejo de entradas no válidas con mensajes de error claros.**
- **Interfaz de usuario sencilla e intuitiva con un menú interactivo.**

## Requisitos

- **Java 11 o superior**
- **Biblioteca Gson para la manipulación de JSON**
- **Conexión a Internet para obtener las tasas de cambio**

## Instalación

1. **Clona el repositorio:**
   ```sh
   git clone https://github.com/ValeMP12/ConversorDeMonedas.git
2. **Navega al directorio del proyecto:**
    ```sh
   cd ConversorDeMonedas
3. **Compila el proyecto:**
   ```sh
   javac -cp gson-2.8.6.jar:. Principal.java ConsultaMoneda.java
4. **Ejecuta el proyecto:**
   ```sh
   java -cp gson-2.8.6.jar:. Principal

## Uso
1. **Al iniciar el programa, verás un menú con las opciones de conversión disponibles:**
![Captura de pantalla 2024-06-21 231635](https://github.com/ValeMP12/ConversorDeMonedas/assets/140870030/b09b0994-3e6e-456f-936d-8a86be456bd3)
2. **Selecciona la opción de conversión ingresando el número correspondiente.**
3. **Ingresa la cantidad a convertir cuando se te solicite.**
4. **El programa mostrará el resultado de la conversión y volverá al menú principal.**

## Ejemplo De Uso
![image](https://github.com/ValeMP12/ConversorDeMonedas/assets/140870030/c03f08a6-9f66-4d87-baa7-6aee065ddc9b)

## Estructura del Código
### Clase Principal
- **Menú Interactivo:** Muestra un menú interactivo para que el usuario elija la opción de conversión.
- **Manejo de Excepciones:** Captura entradas no válidas utilizando bloques try-catch para evitar errores de tipo InputMismatchException.
- **Realización de Conversión:** Llama al método obtenerTasas de la clase ConsultaMoneda para obtener las tasas de cambio y realiza la conversión según la opción seleccionada.
  
### Clase ConsultaMoneda
- **Obtención de Tasas de Cambio:** Se conecta a una API de tasas de cambio para obtener las tasas más recientes y las deserializa en un objeto Moneda utilizando la biblioteca Gson.
  
### Clase Moneda
- **Modelo de Datos:** Representa las tasas de cambio para varias monedas en un formato fácil de usar mediante un record.

## Contribuciones
Las contribuciones son bienvenidas. Si tienes ideas para mejorar este proyecto, no dudes en hacer un fork del repositorio y enviar un pull request.

##
¡Gracias por usar el Conversor de Monedas! Si tienes alguna pregunta o problema, no dudes en abrir un issue en el repositorio.
