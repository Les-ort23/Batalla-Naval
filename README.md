# ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆
# ☆                                                                             ☆
# ☆              __|_                                                           ☆
# ☆         ------(_)------              BATALLA NAVAL CON MATRICES             ☆
# ☆           \  (   )  /                   DE TAMAÑO VARIABLE                  ☆
# ☆   ~~~~~~~~~~~~~~~~~~~~~~~~~~~                                               ☆
# ☆                                                                             ☆
# ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆


------------------------ Bienvenido al Juego de Batalla Naval --------------------------

Integrantes:
•	Arellano Alvarez Alberto David.
•	Barajas Lopez Cesar Uriel.
•	Barrientos Herrera Naomi Amayrami.
•	Guzmán Solís José Francisco.
•	Ortiz Domínguez Lesli.



---------------------------------- NOTA IMPORTANTE!!! ----------------------------------

Para la realización y compilación de este proyecto de Batalla Naval, utilizamos las siguientes herramientas, mismas que se recomienda utilizar para la correcta ejecución de este programa:

1. Apache NetBeans 24: Utilizamos Apache NetBeans 24, que es la última versión del IDE, publicada el 10 de diciembre de 2024. Esta versión es la más actual al día de la creación del programa. Puedes descargar la misma versión desde el siguiente enlace: 
https://netbeans.apache.org/front/main/download/

2. JDK (Java Development Kit) 23.0.1: También utilizamos JDK en su versión 23.0.1, la cual es la versión más reciente lanzada al día de la creación del programa. Puedes descargar esta versión desde la página oficial en el siguiente enlace:
https://www.oracle.com/mx/java/technologies/downloads/#jdk23-windows

Estas herramientas aseguraron un entorno de desarrollo robusto y actualizado para la implementación y ejecución eficiente del proyecto.



------------------------------------- Descripción -------------------------------------

Bienvenido al juego de Batalla Naval, implementado en Java. Este juego clásico te permite jugar contra un oponente virtual (bot) en un tablero de tamaño variable. El objetivo es hundir el barco del oponente antes de que el oponente hunda el tuyo.


------------------------------ Demostración del Programa ------------------------------ 

Para una comprensión más clara de cómo funciona nuestro programa de Batalla Naval, hemos preparado un video de demostración. Puedes verlo en el siguiente enlace:
https://youtu.be/ZYINsM81GHU


----------------------------------- Características -----------------------------------

Tableros: Dos tableros, uno para el jugador y otro para el bot.
Tamaño Variable: Cada tablero es una matriz de tamaño variable, especificado por el usuario.


------------------------------- Representación Gráfica --------------------------------

Agua: ~
Acierto: X
Fallo: O


----------------------------------- Reglas del Juego ----------------------------------

1. Configuración:
El usuario especifica el tamaño del tablero al inicio del juego.
Ambos jugadores colocan su barco en el tablero.

2. Turnos:
El jugador y el bot disparan alternadamente a una casilla del tablero del oponente.
Los disparos se realizan indicando la fila y columna (ej: 1A, 2B, 3C).
Si el disparo impacta en un barco enemigo, se representa con una X.
Si no hay ningún barco en esa casilla, se representa con una O.

3. Victoria:
El primer jugador que hunda el barco del oponente gana el juego.


--------------------------------- Ejemplo de Tableros ---------------------------------

Tablero Inicial de Tamaño 5x5

Tu tablero:
  A B C D E
1 ~ ~ ~ ~ ~
2 ~ ~ ~ ~ ~
3 ~ ~ ~ ~ ~
4 ~ ~ ~ ~ ~
5 ~ ~ ~ ~ ~

Tablero del bot:
  A B C D E
1 ~ ~ ~ ~ ~
2 ~ ~ ~ ~ ~
3 ~ ~ ~ ~ ~
4 ~ ~ ~ ~ ~
5 ~ ~ ~ ~ ~


Tablero Después de Fallar

Tu tablero:
  A B C D E
1 O ~ ~ ~ ~
2 ~ ~ ~ ~ ~
3 ~ ~ O ~ ~
4 ~ ~ ~ ~ ~
5 ~ ~ ~ ~ ~

Tablero del bot:
  A B C D E
1 ~ ~ O ~ ~
2 ~ ~ ~ ~ ~
3 ~ ~ ~ ~ ~
4 ~ O ~ ~ ~
5 ~ ~ ~ ~ ~


Tablero Después de Acertar

Tu tablero:
  A B C D E
1 X ~ ~ ~ ~
2 ~ ~ ~ ~ ~
3 ~ ~ O ~ ~
4 ~ ~ ~ ~ ~
5 ~ ~ ~ ~ ~

Tablero del bot:
  A B C D E
1 ~ ~ O ~ ~
2 ~ ~ ~ ~ ~
3 ~ ~ ~ ~ ~
4 ~ O ~ ~ ~
5 ~ ~ ~ X ~




--------------------------------- Estructura del Código ---------------------------------

Tablero: Gestiona el estado del tablero del jugador y del bot.
Jugador: Gestiona las acciones de cada jugador.
Juego: Gestiona la lógica del juego y el flujo de turnos.
BatallaNaval: Punto de entrada del programa.





         ~~~ Gracias por jugar Batalla Naval! ~~~


                           __|__         
                      ------(_)------     
                        \  (   )  /      
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~      
