# Introducción y alcance

El [Tute](https://es.wikipedia.org/wiki/Tute) es el juego más popular de cartas en España. Su sencillez permite sentar en una misma mesa nietos y abuelos, cuya toma de decisiones y cálculo mental son excelentes para ambos.

Por eso, también es un juego sencillo de programar y que da mucha versatilidad a un programador con experiencia media o avanzada para realizar un proyecto propio con buenas prácticas fuera de las excigencias de su trabajo profesional. Aunque sea un proyecto personal, con la finalidad de consolidar conocimientos de programación, puede servir de modelo formativo para otros desarrolladores.

El objetivo principal es construir algoritmos de inteligencia artifical capaces de ganar a un jugador humano. 

Los objetivos no tangibles de este proyecto son:
* Implementar un modelo de POJO's y sus services state-less siguiendo patrones idoneos.
* Desarrollar prácticas de código límpio.
* Desarrollar siguiendo las practicas del Test Development Driven (TDD).
* Implementación de los principios SOLID.
  * Single Responsability: Los POJO's cumplen una finalidad concreta y mapeable al mundo real. La lógica está en servicios stateless.
  * Open/Close: no ha habido necesidad de ejercer este principio
  * Liskov Principle: a través de la clase AbstractStrategy, se pueden implemntar nuevos algoritmos de toma de decisión en el juego. Los jugadores usan estrategias derivadas de esa clase abstracta. El código está preparado para soportarlo.
  * Interfaces segregation principle: no se fuerza a ninguna implementación a desarrollar métodos no necesarios.
  * Dependency Inversion Principle: siempre ha seguido la composición, cuando un servicio ha necesitado de otro. El mecanismo usado para la inversión ha sido por constructor.

En esta fase del proyecto queda descartada la construcción de una interfaz para la experimentación o el juego libre entre jugadores humanos o automáticos. Es decir, se configurarán experimentos y las partidas serán completamente automáticas.

# Implementación

La lógica sobre el desarrollo de la partida se encuentra en el paquete [juego](https://github.com/jimenezict/tute/tree/main/src/main/java/com/dataontheroad/tute/juego).
La única razón para desarrollar en ese paquete es la de implementar nuevos algoritmos de IA, que se harán como extensión de la clase AbstractStrategy. La lógica para simular experimentaciones se encuentra en el paquete experimento, se puede configurar el número de iteraciones, jugadores, y sus algoritmos de juegos, el resultado del experimento muestra número de partidas ganidas y los puntos obtenidos en cada partida.

## Desarrollo de algoritmos de IA

Para realizar un algoritmo de IA hay que extender la clase abstracta StrategyAbstract, que consta exclusivamente del método:
```
public abstract Carta jugarCarta(Mesa mesa, Jugador jugador);
```
Los parámetros de entrada son el Jugador, de donde se obtiene las cartas que tiene en la mano y sobre la que tomará la decisión de jugar. Del objeto mesa se obtiene la carta de muestra. Esta signatura puede variar en el futuro para que algoritmo tenga más datos para realizar la decisión.

La Carta que retorna, es la carta que el jugador ha decidido jugar. La lógica sobre como esto impacta en la partida, está fuera de la responsabilidad de este método.

## Ejecución de experimentos

Existen dos objetos para crear experimentos, el individual y el colectivo. Des de un punto de vista práctico, solo explicaremos el colectivo.

Para configurar un experimento debe llamarse al método estático "executar", pasando como parámetros el número de ejecuciones y un array de jugadores. El array de jugadores, estarán inicializados con la estrategia de juego del que se le quiera dotar.

Un ejemplo de array de jugadores es:

```
public static ArrayList<Jugador> creadorListaJugardoresPartidaConLaMismaEstrategia(int numeroJugadores, StrategyAbstract strategyAbstract) {
        ArrayList<Jugador> listJugador = new ArrayList<>();
        for(int i=0; i < numeroJugadores; i++) {
            listJugador.add(new Jugador(strategyAbstract));
        }
        return listJugador;
    }
```
Como se ve, en cada .add se crea un nuevo jugador usando el constructor con el parámetro de estrategia. El primer parámetro se indica el número de jugadores. 

Esta forma de configurar la partida es la más sencilla, y cambiará cuando queramos que los jugadores tengan diferentes algoritmos.

La función executar contiene el número de repeticiones del experimento y la configuración de los jugadores.

```
ExperimentoColectivo experimentoColectivo = executar(1000, jugadorList);
```

El POJO *ExperimentoColectivo* recoge los datos. Los campos más relevantes son:
* listaGanadores: es un array de Integer donde dice cuantas veces ha ganado cada jugador. La posición en la array indica el Jugador del que se trata.
* listaDeResultados: matriz con el número de puntos hecho por partida y jugador. Las filas representan el jugador, la columna la partida, el valor, el puntaje.


# Algoritmos de IA

Como se ha dicho anteriormente, los algoritmos son extensiones de la classe AbstractStategy. 

## PrimeraCartaDeLaManoStrategy

Es el algoritmo más sencillo. Consiste en tirar la primera carta de la mano, lo que en el mundo analógico significaría tirar la carta de la izquierda. De esta forma, al robar una carta, esta pasaría a ser la de más a la derecha.

Al no existir ningun racionamiento, se ha usado para comprobar la correcta implementación de la lógica del juego. Los detalles se explican en la sección *análisis de resultados*.

# Análisis de resultados

## Teoría del análisis

Partimos de la idea que el algoritmo más sencillo es aquel donde un jugador juega una carta al azar, sin razonar porque la ha tirado. Si todos los jugadores juegan de la misma manera, significa que para un número elevado de partidas, las victorias se distribuirán uniformemente. También la distribución de puntos obtenidos por partida, tendirán a hacer lo mismo. Cada vez que se cumpla las igualdades en la distribución, diremos que el algortimo está balanceado.

Por otro lado, cada vez que se implemente un nuevo algoritmo queremos saber si este es mejor que los anteriores. Para conseguirlo, diseñaremos un experimento con un número alto de iteraciones, donde un jugador usa el algortimo que queremos estudiar, y los otros jugadores de la partida, tendrán uno de los algortimos ya existentes. De forma general, para saber la bondad de un algortimo que esté bajo estudio, se comparará la diferencia de victorias en una partida a cuatro jugadores donde los tres jugadores restantes juegan con PrimeraCartaDeLaManoStrategy. A esto se le llamara "Factor De Inteligencia" (FdI)

```
FdI = (#victorias del jugador con algoritmo bajo estudio) * 100 / (#total de experimentos)  
```
