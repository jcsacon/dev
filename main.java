import java.util.Scanner;
/*
                            UNIVERSIDAD TÉCNICA PARTICULAR DE LOJA
                             FACULTAD DE INGENIERÍA Y ARQUITECTURA
                                TECNOLOGÍAS DE LA INFORMACIÓN
                                FUNDAMENTOS DE PROGRAMACIÓN
                           TUTOR:   BUSTAMANTE GRANDA WAYNER XAVIER

                                       AULA - 101-ECTS-RED
                           ALUMNO:  SACON MOREIRA JHON CRISTHIAN

    [APEB1-30%] Laboratorio virtual de programación:
    Implementar un programa que resuelve una sucesión numérica

    Práctico-experimental (APE) (X  )
    Implementar un programa que resuelve una sucesión numérica.
    Laboratorio Virtual de programación
    Revisión de las unidades 1 y 2
    Utiliza tipos de datos primitivos y tipos de datos abstractos.
    Modifica y amplía programas pequeños que utilizan estructuras de control
    condicionales e iterativas.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*--------------------------------------*");
        System.out.println("| APEB1 SUCESIÓN NUMÉRICA - JHON SACON |");
        System.out.println("*--------------------------------------*");
        System.out.println("***UTPL - FUNDAMENTOS DE PROGRAMACIÓN***");
        System.out.println("***-----------------------------------*");

        //DECLARACIÓN DE VARIABLES
        int n;
        double sumatoria = 0;

        //VARIABLE GENERAL ENTRADA DE DATOS
        Scanner dato = new Scanner(System.in);

        /*
        INICIO DEL PROGRAMA
        */

        //        VERIFICACIÓN DEL RANGO
        do {
            System.out.print("Ingrese la cantidad de resultados: ");
            if(dato.hasNextInt()) {
                n = dato.nextInt();
            } else {
                n = 0;
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
                System.out.println("▀               !!!ERROR !!!              ▀");
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
                System.out.println("▀El Número ingresado no es de tipo Entero ▀");
                System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
                dato.next();
            }
            dato.close();
        } while (n <= 0);

        //CUANDO SE CUMPLE N
        System.out.printf("A continuación el resultado de los %d términos :\n\n", n);
        var cont = 0; //inicia el contador de la serie

        //VARIABLES PARA CALCULAR NÚMEROS PRIMOS
        var generaNum = 1;
        boolean esPrimo;

        //VARIABLES PARA LA FIBONACCI
        var primero = 1;
        var segundo = 1;
        int fibo;

        //VARIABLE DE CONTROL PARA LA FIBONACCI
        var contPosFibo = 0;
        var cambiarPosFibo = 0;
        var esFiboNumerador = true;
        var numNatural = 1;
        double resultado;
        fibo = primero +segundo;
        segundo = fibo;
        cambiarPosFibo = fibo;
        System.out.print("S = \n");
        while (cont < n) {

            //Resolver números primos, generar un número y evalúa si es primo o no
            generaNum ++;
            esPrimo = true;
            for (var div = 2 ; div < generaNum; div ++) {
                if (generaNum % div == 0) {
                    esPrimo = false;
                    break;
                }
            }
            // SE CONDICIONA LOS RESULTADOS Y SE IMPRIME POR PANTALLA
            if (esPrimo) {
                if (esFiboNumerador) {
                    //imprime el código en vertical pero en tipo fracción
                    System.out.printf("\n  (%d)^%d\n+ -----\n    %d ", fibo, generaNum, numNatural);
                    //imprime código en horizontal, pero su fracción se interpreta lineal, quite el comentario para ver
                    //System.out.printf("+(%d)^%d/%d ", fibo, generaNum, numNatural);
                    resultado = (Math.pow(fibo, generaNum))/numNatural;
                } else {
                    //imprime el código en vertical pero en tipo fracción
                    System.out.printf("\n  (%d)^%d\n- -----\n    %d ", numNatural, generaNum, fibo);
                    //imprime código en horizontal, pero su fracción se interpreta lineal, quite el comentario para ver
                    //System.out.printf("-(%d)^%d/%d ", numNatural, generaNum, fibo);
                    resultado = -1 * ((Math.pow(numNatural, generaNum))/fibo);
                }
                sumatoria = sumatoria + resultado;
                contPosFibo ++;
                numNatural++;
                //CAMBIA EL SIGNO DE LOS TÉRMINOS
                if (contPosFibo == cambiarPosFibo) {
                    fibo = primero +segundo;
                    primero = segundo;
                    segundo = fibo;

                    contPosFibo = 0;
                    cambiarPosFibo = fibo;
                    esFiboNumerador = !esFiboNumerador;
                }
                cont ++;
            }
        }System.out.print("....");
        //IMPRIME EL RESULTADO DE LA SUMA DE LOS TÉRMINOS
        System.out.printf("\nLa suma de la sucesión de %d términos es = %f\n", n, sumatoria);
    }

}// FIN DEL PROGRAMA
//                    PERIODO ACADÉMICO ABRIL - AGOSTO 2024