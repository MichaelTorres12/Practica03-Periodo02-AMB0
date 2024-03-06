import java.util.Scanner;

// Clase base: Libro
//Se crean los getter y setters, además de crear los metodos para mostrar informacion del libro y su descripcion
class Libro {
    private String titulo;
    private String autor;
    private int Publicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.Publicacion = anioPublicacion;
    }
//método para mostrar informacion del libro
    public void MostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + Publicacion);
    }
//metodo para mostrar la descripción del libro
    public void Descripcion() {
        System.out.println("Descripción general del libro.");
    }
}

// Clase derivada: LibroFiccion
//esta clase extiende la clase libro tomando o subgenero llamado libroficcion
class LibroFiccion extends Libro {
    private String genero;

    public LibroFiccion(String titulo, String autor, int anioPublicacion, String genero) {
        super(titulo, autor, anioPublicacion);
        this.genero = genero;
    }
//ayuda a verificar que el metodo se esté sobreescribiendo correctamente, en este caso, la descripción de la clase libroficcion
    @Override
    public void Descripcion() {
        System.out.println("Libro de ficción. Género: " + genero);
    }
}

// Clase derivada: LibroNoFiccion
//esta clase extiende la clase libro tomando o subgenero llamado libronoficcion
class LibroNoFiccion extends Libro {
    private String tema;

    public LibroNoFiccion(String titulo, String autor, int anioPublicacion, String tema) {
        super(titulo, autor, anioPublicacion);
        this.tema = tema;
    }

    //ayuda a verificar que el metodo se esté sobreescribiendo correctamente, en este caso, la descripción de la clase libronoficcion
    @Override
    public void Descripcion() {
        System.out.println("Libro de no ficción. Tema: " + tema);
    }
}

// Clase derivada: LibroReferencia
class LibroReferencia extends Libro {
    private String tipo;

    public LibroReferencia(String titulo, String autor, int anioPublicacion, String tipo) {
        super(titulo, autor, anioPublicacion);
        this.tipo = tipo;
    }

    //ayuda a verificar que el metodo se esté sobreescribiendo correctamente, en este caso, la descripción de la clase libroreferencia
    @Override
    public void Descripcion() {
        System.out.println("Libro de referencia. Tipo: " + tipo);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ingreso base de la información
        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese el año de publicación del libro: ");
        int anioPublicacion = sc.nextInt();
        sc.nextLine(); 
//aqui e ingresa el tipo de lib ro que uno quiere por medio de strings y dependiendo de cual coincida con el switch, a esa opción lo mandará
        System.out.print("Seleccione el tipo de libro (ficcion/no ficcion/referencia): ");
        String tipoLibro = sc.nextLine();

        Libro libro;

        //Se crea un switch para poder tener un meejor control de lo que queremos pedir y asi mandar los datos de una mejor manera y no haya confusiones
        //Todo se almacena en la variable libro pero se manda a llamar a una clase derivada diferente dependiendo de lo que busque el usuario
        switch (tipoLibro.toLowerCase()) {
            case "ficcion":
                System.out.print("Ingrese el género del libro de ficción: ");
                String genero = sc.nextLine();
                libro = new LibroFiccion(titulo, autor, anioPublicacion, genero);
                break;
            case "no ficcion":
                System.out.print("Ingrese el tema del libro de no ficción: ");
                String tema = sc.nextLine();
                libro = new LibroNoFiccion(titulo, autor, anioPublicacion, tema);
                break;
            case "referencia":
                System.out.print("Ingrese el tipo de libro de referencia: ");
                String Ref = sc.nextLine();
                libro = new LibroReferencia(titulo, autor, anioPublicacion, Ref);
                break;
            default:
                System.out.println("El tipo de libro ingresado no es válido.");
                return;
                
        }
        //muestra la información del libro mandando a llamar los métodos
        System.out.println("\nInformación del libro:");
        libro.MostrarInfo();
        libro.Descripcion();

        sc.close();
    }
}