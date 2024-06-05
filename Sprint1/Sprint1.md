# Sprint 1: Estructura básica del juego y movimiento (3 puntos)
## Clases a implementar:
- Juego: Clase principal para iniciar y controlar el flujo del juego. 
- Habitación: Representa una habitación en el juego. 
- Jugador: Representa al jugador y rastrea su inventario y ubicación actual.

Se procede a crear las clases mencionadas:

![img.png](img.png)

**Habitacion.java:**
![img_13.png](img_13.png)

**Juego.java:**
![img_14.png](img_14.png)

**Jugador.java:**
![img_15.png](img_15.png)

## Tareas:
1. Inicialización del juego:
   - **Inicializa el juego con un conjunto de habitaciones.** 
      
      Se inicializa con solo 3 habitaciones (Salon, cocina, entrada) :
      ![img_1.png](img_1.png)
   
   - **Define la habitación inicial para el jugador.**
      
      En este caso el jugador empezara en la habitación entrada:
      ![img_2.png](img_2.png)
2. Movimiento del jugador:
   - **Permite al jugador moverse entre habitaciones usando comandos.**
      
      De esta manera podemos permitir al jugador moverse a la direccion que desee (las 4 mencionadas antes)
      ![img_4.png](img_4.png)
   
3. Interacción básica:
   - **Implementa comandos básicos para el movimiento (por ejemplo, "mover norte").**
      
     Se implemento la funcion procesarComandos para que el usuario escriba "mover norte", "mover sur", "mover este", "mover oeste"
     ![img_3.png](img_3.png)

## Enfoque TDD:
   - Escribe pruebas para la creación de habitaciones, movimiento del jugador e inicialización del
   juego.

      Se crea las clase de test de las 3 clases anteriores
      ![img_5.png](img_5.png)

      Clase Juego:
        ![img_10.png](img_10.png)
        ![img_11.png](img_11.png)

      Clase Jugador:

        ![img_8.png](img_8.png)
        ![img_9.png](img_9.png)
      Clase Habitacion:
        
      ![img_6.png](img_6.png)
      ![img_7.png](img_7.png)

## Salida:
   • Navegación funcional entre habitaciones.

   • Mostrar la descripción de la habitación actual al entrar.

En ete caso ya enviamos la direccion el norte y luego la dirección este, y nos indica la habitacion donde se entra.
   ![img_12.png](img_12.png)