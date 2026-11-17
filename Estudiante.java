
public final class Estudiante implements Comparable<Estudiante> {

    private final String codigo;
    private final String nombre;
    private final int edad;
    private final double nota;
    private final String carrera;

    public Estudiante(String codigo, String nombre,
                      int edad, double nota, String carrera) {

        if (codigo == null || nombre == null || carrera == null
                || codigo.isEmpty() || nombre.isEmpty()
                || carrera.isEmpty()) {
            throw new IllegalArgumentException("Texto invalido");
        }
        if (edad <= 0 || !Double.isFinite(nota)
                || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Edad o nota invalida");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getNota() {
        return nota;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | Edad: " + edad
                + " | Nota: " + nota + " | Carrera: " + carrera;
    }
}
