package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.entity.Curso;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CursoEntityStreamTest {

    public static List<Curso> cursos = new ArrayList<>();

    @BeforeAll
    public static void load () {
        cursos.clear();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));
    }

    @Test
    //Obtener la cantidad de cursos con una duración mayor a 5 horas.
    public void cursosMayorA5Horas(){
        Function<Curso,Boolean> validaMayora = c -> c.getDuracion() > 5;
       List <Curso> cursoResult =  cursos.stream().filter(t -> validaMayora.apply(t))//.peek(System.out::println)
               .collect(Collectors.toList());

       cursoResult.stream().forEach(System.out::println);
    }

    private Predicate<Curso> getCursoPredicate() {
        return c -> c.getDuracion() > 5;
    }

    @Test
    //Obtener la cantidad de cursos con una duración menor a 2 horas
    public void cantidadCursosDuracionMenorA2H(){
        Long result =cursos.stream().filter(c -> c.getDuracion() < 2).count();
        System.out.println("numero de registros con duracion menor a 2= " + result);
    }

    @Test
    //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
    public void tituloCursoMayorDuracionMay50(){
        List<String> titulos = cursos.stream().filter(c -> c.getVideos() >= 50)
                .map(Curso::getTitulo).peek(System.out::println)
                .collect(Collectors.toList());

    }

    @Test
    public void mostrarTitulo(){

      //  Map<String, Float> resultMap =
        cursos.stream()
                .collect(Collectors.toMap(Curso::getTitulo, Curso::getDuracion)).keySet().stream().forEach(System.out::println);
    }

    @Test
    public void mostrarTitulosPorEncimaDelPromedio(){

        //  Map<String, Float> resultMap =
        double avg = cursos.stream().mapToDouble(a -> (double) a.getDuracion()).average().orElse(0);
        System.out.println("promedio = " + avg);

        cursos.stream().filter(c-> c.getDuracion() > avg).collect(Collectors.toList()).stream().forEach(System.out::println);
    }


}
