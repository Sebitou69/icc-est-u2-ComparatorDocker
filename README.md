# PL2.1 — Ordenamiento de estudiantes con Comparator y Comparable

**Universidad:** Universidad Politécnica Salesiana  
**Carrera:** Computación  
**Asignatura:** Estructura de Datos  
**Docente:** Ing. Pablo Torres, Mgtr.  
**Autores:** Sebastián Cárdenas y Erick Chang  
**Versión de Java:** JDK 17.0.19  
**Entorno de desarrollo:** Visual Studio Code  

## 1. Objetivo

Implementar distintos criterios de ordenamiento de estudiantes utilizando las interfaces `Comparable` y `Comparator` de Java, aplicando expresiones lambda, referencias a métodos y comparadores compuestos.

También se busca comprobar la estabilidad de los ordenamientos, el correcto funcionamiento de los desempates y la conservación de los registros originales.

## 2. Descripción del proyecto

El programa administra una lista de 20 estudiantes ficticios, cada uno con cinco atributos:

- Código
- Nombre
- Edad
- Nota
- Carrera

El orden natural de los estudiantes se establece mediante su código. Adicionalmente, se implementan diferentes criterios de comparación utilizando `Comparator`.

Cada consulta trabaja sobre una copia de la lista original para evitar modificar el orden inicial.

## 3. Estructura del proyecto

```text
PL2.1/
├── Estudiante.java
├── Main.java
├── README.md
└── assets/
    ├── C1
    ├── C2
    ├── C3
    ├── C4
    ├── C5
    ├── C6
    ├── C7
    ├── codC1C5
    ├── codC6C7
    └── evidencias.md
```

**Estudiante.java:** contiene el modelo de los estudiantes, sus atributos, constructor, getters, método `toString()` e implementación de `Comparable`.

**Main.java:** contiene los datos de prueba, los comparadores, los métodos de ejecución y las verificaciones.

**assets/:** contiene los resultados reales de las consultas y las pruebas realizadas.

## 4. Consultas implementadas

| ID | Criterio de ordenamiento | Implementación |
|---|---|---|
| C1 | Código ascendente | Comparable / naturalOrder |
| C2 | Nombre ascendente, código ascendente | Lambda de dos parámetros |
| C3 | Nota ascendente | comparingDouble y referencia a método |
| C4 | Nota descendente, nombre ascendente | reversed y thenComparing |
| C5 | Edad ascendente, nombre descendente | comparingInt y comparador secundario invertido |
| C6 | Carrera ascendente, nota descendente, nombre ascendente, código ascendente | Comparador compuesto |
| C7 | Nota ajustada descendente, nombre ascendente, código ascendente | Lambda y Math.min |

Para C2 también se implementa una versión alternativa con `comparing()` y `thenComparing()`.

En C7 se incrementa temporalmente en 0.5 la nota utilizada para ordenar a los estudiantes de Computación, sin superar 10.0 ni modificar el valor original.

## 5. Requisitos y ejecución

Se utiliza Java JDK 17.0.19 y Visual Studio Code.

Para compilar el proyecto desde una terminal ubicada en su directorio principal:

javac Estudiante.java Main.java

Para ejecutar el programa:

java Main

También puede ejecutarse desde Visual Studio Code mediante la extensión de Java y la opción de ejecutar el método `main`.

## 6. Pruebas y validaciones

El proyecto incluye comprobaciones de:

- Ordenamiento correcto de C1–C7.
- Conservación de los 20 registros.
- Equivalencia entre las dos implementaciones de C2.
- Estabilidad de C3 en estudiantes con nota 8.5.
- Estabilidad de C4 en empates completos.
- Procesamiento de listas vacías y de un elemento.
- Conservación del orden de la lista original.
- Conservación de las notas originales después de C7.
- Dos casos de prueba adicionales.

### Registro de pruebas

La tabla deberá completarse con los resultados obtenidos durante la ejecución del programa.

| Escenario | Resultado esperado | Resultado obtenido | Estado |
|---|---|---|---|
| C1: código ascendente | E001 hasta E020 | Pendiente de ejecutar | Pendiente |
| C2: nombre y código | E005, E010, E014, E017 al inicio | Pendiente | Pendiente |
| C3: estabilidad de nota 8.5 | E014, E007, E005, E008, E010 | Pendiente | Pendiente |
| C4: nota descendente | E017, E011, E001 al inicio | Pendiente | Pendiente |
| C5: edad y nombre | E001, E016, E004 al inicio | Pendiente | Pendiente |
| C6: cuatro criterios | E001, E018, E005, E010, E014 al inicio | Pendiente | Pendiente |
| C7: nota ajustada | E001 primero y E018 segundo | Pendiente | Pendiente |
| Lista original | Mantener secuencia inicial | Pendiente | Pendiente |

## 7. Análisis del ordenamiento

### Comparable y Comparator

`Comparable` establece el orden natural de los objetos mediante `compareTo()`. En este proyecto se utiliza para organizar estudiantes por código.

`Comparator` permite definir diferentes criterios de ordenamiento sin modificar el orden natural de la clase.

### Criterios de desempate

Los métodos `thenComparing()` permiten agregar condiciones secundarias que solamente se aplican cuando los valores del criterio anterior son iguales.

El uso de `reversed()` debe considerar qué parte del comparador se desea invertir. Si se invierte un comparador compuesto completo, también se invierten sus criterios secundarios.

### Estabilidad

Un ordenamiento estable conserva el orden relativo de los elementos cuando el comparador devuelve cero.

En C3, los estudiantes con la misma nota deben conservar el orden en que aparecieron originalmente.

## 8. Evidencias

Las salidas de las siete consultas y los resultados de las pruebas se almacenarán en la carpeta `assets/`.

Se incluirá la secuencia completa de códigos y el resultado de cada validación.

## 9. Conclusiones

Conclusión 1: Se observó que C1 pone un orden fijo por código, mientras que C2 nos permite ordenar por nombre sin tener que cambiar la clase. Por lo q se concluye que Comparator es flexible

Conclusión 2: thenComparing() nos deja ordenar por un segundo atributo en caso de que exista un empate o igual. La posición de reversed() es sumamente importante porque invierte solamente un criterio o toda la comparación.

Conclusión 3: Mientras que C3 conserva el orden origial de los estudiantes con notas iguales, C7 demuestra que se puede ordenar usando una nota calculada sin cambiar los datos originales.

## 10. Repositorio

Enlace de GitHub: **https://github.com/Sebitou69/icc-est-u2-ComparatorDocker**.

El repositorio contiene el código fuente, documentación, evidencias y el historial de commits del proyecto.
