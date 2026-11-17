
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>(List.of(
            new Estudiante("E014", "Ana", 20, 8.5, "Computacion"),
            new Estudiante("E003", "Luis", 19, 7.8, "Electronica"),
            new Estudiante("E018", "Maria", 21, 9.2, "Computacion"),
            new Estudiante("E007", "Pedro", 20, 8.5, "Mecatronica"),
            new Estudiante("E001", "Sofia", 18, 9.5, "Computacion"),
            new Estudiante("E012", "Diego", 22, 6.8, "Electronica"),
            new Estudiante("E005", "Ana", 19, 8.5, "Computacion"),
            new Estudiante("E020", "Carlos", 21, 7.8, "Mecatronica"),
            new Estudiante("E009", "Lucia", 20, 9.2, "Electronica"),
            new Estudiante("E016", "Mateo", 18, 7.0, "Computacion"),
            new Estudiante("E002", "Elena", 22, 8.0, "Mecatronica"),
            new Estudiante("E011", "Pablo", 21, 9.5, "Electronica"),
            new Estudiante("E006", "Sara", 19, 6.8, "Computacion"),
            new Estudiante("E019", "Juan", 20, 8.0, "Mecatronica"),
            new Estudiante("E004", "Diana", 18, 9.2, "Electronica"),
            new Estudiante("E015", "Bruno", 22, 7.0, "Computacion"),
            new Estudiante("E008", "Carla", 21, 8.5, "Mecatronica"),
            new Estudiante("E017", "Andres", 19, 9.5, "Electronica"),
            new Estudiante("E010", "Ana", 20, 8.5, "Computacion"),
            new Estudiante("E013", "Luis", 19, 7.8, "Electronica")
        ));

        // C1: Codigo ascendente
        Comparator<Estudiante> c1 = Comparator.naturalOrder();

        // C2: Nombre ascendente, codigo ascendente
        Comparator<Estudiante> c2 = (a, b) -> {
            int r = a.getNombre().compareTo(b.getNombre());
            return r != 0 ? r : a.getCodigo().compareTo(b.getCodigo());
        };

        // C2 alternativa
        Comparator<Estudiante> c2Alt =
            Comparator.comparing(Estudiante::getNombre)
                      .thenComparing(Estudiante::getCodigo);

        // C3: Nota ascendente
        Comparator<Estudiante> c3 =
            Comparator.comparingDouble(Estudiante::getNota);

        // C4: Nota descendente, nombre ascendente
        Comparator<Estudiante> c4 =
            Comparator.comparingDouble(Estudiante::getNota)
                      .reversed()
                      .thenComparing(Estudiante::getNombre);

        // C5: Edad ascendente, nombre descendente
        Comparator<Estudiante> c5 =
            Comparator.comparingInt(Estudiante::getEdad)
                      .thenComparing(
                          Comparator.comparing(Estudiante::getNombre)
                                    .reversed()
                      );

        // C6: Carrera, nota, nombre, codigo
        Comparator<Estudiante> c6 =
            Comparator.comparing(Estudiante::getCarrera)
                      .thenComparing(
                          Comparator.comparingDouble(Estudiante::getNota)
                                    .reversed()
                      )
                      .thenComparing(Estudiante::getNombre)
                      .thenComparing(Estudiante::getCodigo);

        // C7: Nota ajustada, nombre, codigo
        Comparator<Estudiante> c7 =
            Comparator.comparingDouble((Estudiante e) ->
                e.getCarrera().equals("Computacion")
                    ? Math.min(10.0, e.getNota() + 0.5)
                    : e.getNota()
            )
            .reversed()
            .thenComparing(Estudiante::getNombre)
            .thenComparing(Estudiante::getCodigo);

        // Ejecutar las consultas
        mostrar("C1 - Codigo ascendente", estudiantes, c1, false);
        mostrar("C2 - Nombre ascendente, codigo ascendente", estudiantes, c2, false);
        mostrar("C3 - Nota ascendente", estudiantes, c3, false);
        mostrar("C4 - Nota descendente, nombre ascendente", estudiantes, c4, false);
        mostrar("C5 - Edad ascendente, nombre descendente", estudiantes, c5, false);
        mostrar("C6 - Carrera, nota, nombre y codigo", estudiantes, c6, false);
        mostrar("C7 - Nota ajustada descendente", estudiantes, c7, true);

        // Verificar equivalencia de C2
        List<Estudiante> a = new ArrayList<>(estudiantes);
        List<Estudiante> b = new ArrayList<>(estudiantes);
        a.sort(c2);
        b.sort(c2Alt);

        System.out.println("\nC2 equivalente: " +
            a.stream().map(Estudiante::getCodigo).toList()
             .equals(b.stream().map(Estudiante::getCodigo).toList()));

        System.out.println("Lista original conservada: " +
            estudiantes.get(0).getCodigo().equals("E014"));

        System.out.println("\nTODAS LAS CONSULTAS FINALIZADAS");
    }

    public static void mostrar(String titulo, List<Estudiante> original,
                               Comparator<Estudiante> comp, boolean ajustada) {

        List<Estudiante> copia = new ArrayList<>(original);
        copia.sort(comp);

        System.out.println("\n========== " + titulo + " ==========");

        for (Estudiante e : copia) {
            if (ajustada) {
                double nota = e.getCarrera().equals("Computacion")
                    ? Math.min(10.0, e.getNota() + 0.5)
                    : e.getNota();

                System.out.println(e + " | Nota ajustada: " + nota);
            } else {
                System.out.println(e);
            }
        }

        System.out.println("Codigos: " +
            copia.stream().map(Estudiante::getCodigo).toList());
    }
}
