# CurrencyConverterChallenge

## Índice

- [Descripción del Challenge](#descripción-del-challenge)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Demostración del sistema](#demostración-del-sistema)
- [Datos Relevantes](#datos-relevantes)

## Descripción del Challenge
Conversor de Monedas con la ayuda de la API [ExchangeRateAPI](https://www.exchangerate-api.com/). En este proyecto se utilizan algunas funcionalidades como solicitudes HTTP, manejo y manipulación de objetos de tipo json (con ayuda de la libreria de google [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)), y por último el filtrado y muestra de las monedas, sus tasas de cambio y conversiones correspondientes.

## Requisitos del Sistema
Como requisito para este proyecto se necesitarón las siguientes herramientas:
- IntelliJ IDEA Community Edition
    - Como entorno de desarrollo.
    - [Jetbrains](https://www.jetbrains.com/idea/)
- Postman API Platform
    - Para probar las rutas proporcionadas por la API ExchangeRateAPI.
    - [Postman](https://www.postman.com/)
- Librería Gson 2.10.1
    - Para el manejo de objetos de tipo json. Dicha librería debe ser agregada al proyecto siguiendo los siguientes pasos en IntelliJ IDEA:
        - File --> Project Structure --> Modules --> Add (+) --> 1 JARs or Directories --> gson-2.10.1
    - [Link de descarga](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar)

## Demostración del Sistema
Se recomienda ver el siguiente video para comprender mejor la explicación posterior.<br>
[![Enlace del video](https://img.youtube.com/vi/b2C5C921YFM/maxresdefault.jpg)](https://youtu.be/b2C5C921YFM)

### 1. Se despliega el Menú Principal del sistema. 
   - Muestra las siguientes opciones:
     - Mostrar todas las tasas de cambio que existen hasta la fecha de una moneda en específico.
     - Obtener la tasa de cambio actual entre dos monedas especificadas por el usuario.
     - Despliega un submenu donde se pueden realizacion conversiones de cantidades de una moneda a otra.
     - Salir del sistema.
### 2. El submenu que se despliega en la opcion 3 tiene las siguientes alternativas:
   - Las opciones del 1 al 8 convierten datos de la moneda base a la otra especificada explícitamente en la opción.
   - La opción 9 permite hacer una conversion de una cantidad de moneda especificada por el usuario, quien tambien especifica la moneda base y la moneda a la que quiere convertir dicha cantidad.
### 3. El sistema proporciona alertas, al momento de ingreso de datos por parte del usuario, cuando es requerido. <br> 
Por ejemplo cuando el usuario ingresa un código de moneda que la API [ExchangeRateAPI](https://www.exchangerate-api.com/) no reconoce o no soporta. 

## Datos Relevantes
[Alura Badge](https://drive.google.com/file/d/1DoknLjbnrN7H6MjaIbr4HPivT6jO-gyS/view?usp=sharing)
<br>
<b>Autor: Eduardo Soriano</b>. <br>
Perfil de Github: [ceduardoHN](https://github.com/ceduardoHN/) <br>

<b>Fecha de Lanzamiento: 25 de abril de 2024</b>
