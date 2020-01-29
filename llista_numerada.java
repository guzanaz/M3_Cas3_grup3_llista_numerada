
/*
Progama java
M3_Cas3_grup3_llista_numerada
29 de Enero 2020
*/

/**
 * @author Daniela Gallardo
 */


import java.util.*;

class llista_numerada {

    public static void main(String args[]) throws Exception {
        /* 1. Activamos el scanner */
        Scanner sc = new Scanner(System.in);

        /* 2.Variable para guardarnos la opción que el usuario escogerá del menú*/
        int opcio;

        /* 3. Creamos un booleano para salir del menú*/
        boolean salir = false;

        /* 4. Asignamos la longitud del array en una constante */
        final int Num_elements = 4;

        /* 5. Creamos variable para un contador */
        int comptador = 0;

        /* 6. Variable para la posición de apellidos en la lista */
        int p = 0;

        /* 7. Creamos variable para guardarnos los elementos de la lista (apellidos) */
        String x;

        /* 8. Declaración del array sin ordenar */
        String[] llista = new String[Num_elements];

        /* 9. Declaración de array para ordenar lista  */
        String[] llista_ordenada = new String[Num_elements];

        /* creamos la regla con un do while para mostrar las opciones por pantalla */
        do {
            System.out.println("Què vols fer? ");
            System.out.println("1) Inserir ");
            System.out.println("2) Localitzar");
            System.out.println("3) Recuperar");
            System.out.println("4) Suprimir");
            System.out.println("5) Suprimir dada");
            System.out.println("6) Anular");
            System.out.println("7) Primerdarrer");
            System.out.println("8) Imprimir");
            System.out.println("9) Ordenar");
            System.out.println("10) Localitzar en ordenada");
            System.out.println("11) Suprimr dada en ordenada");
            System.out.println("12) Sortir");

            opcio = sc.nextInt();
            switch (opcio) {

                // Inserir
                case 1:

                    if (comptador == 0) {
                        //pide el nombre por teclado
                        System.out.println("Posa el cognom que vols afegir");
                        //el apellido será ingresado por teclado 
                        x = sc.next();
                        //elemento cero del array será igual a x
                        llista[0] = x;
                        comptador++;
                    } else if (comptador > 0 && comptador < Num_elements) {
                        System.out.println("Posa la posició que vols inserir");
                        p = sc.nextInt();
                        p = p - 1;
                        while (p < 0 || p > comptador) {
                            System.out.println("No és correcte. La posició només pot ser entre 1 i " + (comptador + 1));
                            p = sc.nextInt();
                            p = p - 1;
                        }
                        System.out.println("Posa el cognom que vols afegir");
                        x = sc.next();
                        for (int i = comptador; i > p; i--) {
                            llista[i] = llista[i - 1];
                        }
                        llista[p] = x;
                        comptador++;
                    } else if (comptador >= Num_elements) {
                        System.out.println("Posa la posició que vols inserir");
                        p = sc.nextInt();
                        p = p - 1;
                        System.out.println("La llista està plena, s'eliminarà l'element que té aquesta posició:" + (p + 1));
                        System.out.println("Posa el cognom que vols afegir");
                        x = sc.next();
                        llista[p] = x;
                    }
                    System.out.println("\n");
                    System.out.println("───────────────────────");
                    System.out.println("         LISTA         ");
                    System.out.println("───────────────────────");
                    for (int j = 0; j < comptador; j++) {
                        System.out.print((j + 1) + "." + llista[j] + "\n");
                    }
                    System.out.println("\n");
                    break;

                case 2: // Localitzar
                    if (comptador == 0) {
                        //advertencia
                        System.out.println("\n");
                        System.out.println("──────────────────────────────────────────────");
                        System.out.println("   Lista vacía ¡Nada que podamos localizar!   ");
                        System.out.println("──────────────────────────────────────────────");
                        System.out.println("\n");
                    } else {
                        System.out.println("Escribe el apellido que deseas localizar");
                        x = sc.next();
                        for (int i = 0; i <= Num_elements; i++) {
                            if (x.equals(llista[i])) {
                                System.out.print("La posición es: " + (i + 1) + "\n");
                                break;
                            } else {
                                System.out.print("El apellido " + x + " no está en la lista \n");
                                break;
                            }
                        }
                    }
                    break;

                case 3:// Recuperar
                    if (comptador == 0) {
                        //advertencia
                        System.out.println("\n");
                        System.out.println("──────────────────────────────────────────────");
                        System.out.println("   Lista vacía ¡Nada que podamos recuperar!   ");
                        System.out.println("──────────────────────────────────────────────");
                        System.out.println("\n");
                    } else {
                        System.out.println("Escribe la posición que desees recuperar");
                        p = sc.nextInt();
                        p = p - 1;

                        while (p < 0 || p > Num_elements) {
                            System.out.println("Posición incorrecta. Ha de ser entre 1 i " + Num_elements);
                            System.out.println("Escribe la posición que desees recuperar");
                            p = sc.nextInt();
                            p = p - 1;
                        }

                        for (int i = 0; i <= Num_elements; i++) {
                            if (p == i) {
                                System.out.print("El apellido en la posición " + (p + 1) + " es " + llista[i] + "\n");
                                break;
                            }
                        }
                    }
                    break;

                case 4://suprimir
                    if (comptador == 0) {
                        //mensaje
                        System.out.println("Lista vacía, nada que puedas borrar");
                    } //contador mayor que 0 y menor o igual al nro de elementos
                    else if (comptador > 0 || comptador <= Num_elements) {
                        System.out.println("Ingresa la posición que deseas borrar");
                        p = sc.nextInt();
                        p = p - 1;
                        //posición fuera de rango
                        if (p < 0 || p > comptador) {
                            System.out.println("Deber ser una posición válida");
                            System.out.println("Ingresa la posición que deseas borrar");
                            p = sc.nextInt();
                        } //posición en el rango
                        else if (p > 0 || p <= comptador) {
                            int k;
                            for (k = p; k < comptador - 1; k++) {
                                llista[k] = llista[k + 1];
                            }
                            llista[k] = null;
                            comptador--;
                        }
                    }
                    //imprimir lista
                    System.out.println("\n");
                    System.out.println("───────────────────────");
                    System.out.println("         LISTA         ");
                    System.out.println("───────────────────────");
                    for (int j = 0; j < comptador; j++) {
                        System.out.print((j + 1) + "." + llista[j] + "\n");
                    }
                    System.out.println("\n");

                    break;

                case 5://suprimir dada
                    if (comptador == 0) {
                        //mensaje
                        System.out.println("Lista vacía, nada que puedas borrar");
                    } else {
                        System.out.println("Qué apellido quieres suprimir?");
                        x = sc.next();
                        for (int i = 0; i < comptador; i++) {
                            if (x.equals(llista[i])) {
                                int c;
                                for (c = i; c < comptador; c++) {
                                    llista[c] = llista[c + 1];
                                }
                                ;
                                comptador--;

                            }//si el apellido no está en la lista
                            else if (!x.equals(llista[i])) {
                                System.out.println("El apellido no está en la lista");
                                break;
                            }
                        }
                    }

                    //imprimir lista
                    System.out.println("\n");
                    System.out.println("───────────────────────");
                    System.out.println("         LISTA         ");
                    System.out.println("───────────────────────");
                    for (int j = 0; j < comptador; j++) {
                        System.out.print((j + 1) + "." + llista[j] + "\n");
                    }
                    System.out.println("\n");

                    break;

                case 6://Anular
                    if (comptador == 0) {
                        //mensaje
                        System.out.println("Lista vacía, nada que puedas borrar");
                    } else {
                        comptador = 0;
                        //imprimir lista
                        System.out.println("\n");
                        System.out.println("───────────────────────");
                        System.out.println("         LISTA         ");
                        System.out.println("───────────────────────");
                        for (int j = 0; j < comptador; j++) {
                            System.out.print((j + 1) + "." + llista[j] + "\n");
                        }
                        System.out.println("");
                        //mensaje
                        System.out.println("\n ───── Lista vacía! ───── \n \n");
                    }
                    break;

                case 7://Primer-darrer

                    /*hacemos un submenú para la posición*/
                    System.out.println("\n");
                    System.out.println("──────────────────────────────────");
                    System.out.println("   ¿Qué posición quieres conocer?   ");
                    System.out.println("──────────────────────────────────");
                    System.out.println("1) La primera");
                    System.out.println("2) La última");
                    System.out.println("──────────────────────────────────");
                    System.out.println("\n");

                    int primer_darrer = sc.nextInt();
                    switch (primer_darrer) {
                        case 1:
                            if (comptador == 0) {
                                //mensaje
                                System.out.println("Lista vacía, no hay registros.");
                            } else {
                                System.out.println("La primera posición es: " + llista[0] + "\n \n");
                            }
                            break;
                        case 2:
                            if (comptador == 0) {
                                //mensaje
                                System.out.println("Lista vacía, no hay registros.");
                            } else {
                                System.out.println("La última posición es : " + llista[comptador - 1] + "\n \n");
                            }
                            break;
                    }
                    break;
                case 8://imprimir                    
                    System.out.println("\n");
                    System.out.println("───────────────────────");
                    System.out.println("         LISTA         ");
                    System.out.println("───────────────────────");
                    for (int j = 0; j < comptador; j++) {
                        System.out.print((j + 1) + "." + llista[j] + "\n");
                    }
                    System.out.println("");
                    //mensaje
                    System.out.println("\n ───── Lista vacía! ───── \n \n");
                    break;

                case 9://Ordenar
                    if (comptador == 0) {
                        System.out.println("\n Lista vacía, no hay nada que ordenar \n \n");
                    } else {
                        for (int i = 1; i < comptador; i++) {
                            for (int j = 0; j < comptador - 1; j++) {
                                int compareTo = llista[j].compareTo(llista[j + 1]);
                                if (compareTo > 0) {
                                    String aux = llista[j];
                                    llista[j] = llista[j + 1];
                                    llista[j + 1] = aux;
                                }
                            }
                        }
                    }

                    //imprimir
                    System.out.println("\n");
                    System.out.println("───────────────────────");
                    System.out.println("     LISTA ORDENADA    ");
                    System.out.println("───────────────────────");
                    for (int a = 0; a < comptador; a++) {
                        System.out.println((a + 1) + ". " + llista[a]);
                    }
                    System.out.println("\n");
                    break;

                case 10://Localitzar en ordenada

                    for (int i = 1; i < comptador; i++) {
                        for (int j = 0; j < comptador - 1; j++) {
                            int compareTo = llista[j].compareTo(llista[j + 1]);
                            if (compareTo > 0) {
                                String aux = llista[j];
                                llista[j] = llista[j + 1];
                                llista[j + 1] = aux;
                            }
                        }
                    }
                    if (comptador == 0) {
                        System.out.println("\n Lista vacía, no hay nada que localizar \n \n");
                    } else {
                        System.out.println("Qué apellido quieres buscar?");
                        x = sc.next();
                        int b = 0;
                        while (!x.equals(llista[b]) && (b <= comptador)) {
                            b++;
                        }
                        if (b >= comptador) {
                            System.out.println("\n \n El apellido no se encuentra en la lista \n \n");
                            break;
                        } else {
                            System.out.println("\n En la lista ordenada, "
                                    + "el apellido " + x + " se encuentra en la posición " + (b + 1));

                            System.out.println("\n");
                        }
                    }
                    break;

                case 11://Suprimr dada en ordenada
                    for (int i = 1; i < comptador; i++) {
                        for (int j = 0; j < comptador - 1; j++) {
                            int compareTo = llista[j].compareTo(llista[j + 1]);
                            if (compareTo > 0) {
                                String aux = llista[j];
                                llista[j] = llista[j + 1];
                                llista[j + 1] = aux;
                            }
                        }
                    }
                    System.out.println("Qué apellido quieres suprimir?");
                    x = sc.next();

                    for (int i = 0; i <= comptador; i++) {
                        if (x.equals(llista[i])) {
                            int c;
                            for (c = i; c < comptador; c++) {
                                llista[c] = llista[c + 1];
                            }
                            llista_ordenada[c] = null;
                            comptador--;

                        }//si el apellido no está en la lista
                        else {
                            System.out.println("El apellido no está en la lista");
                            break;
                        }
                    }
                    //imprimir lista
                    System.out.println("\n");
                    System.out.println("───────────────────────");
                    System.out.println("         LISTA         ");
                    System.out.println("───────────────────────");
                    for (int j = 0; j < comptador; j++) {
                        System.out.print((j + 1) + "." + llista[j] + "\n");
                    }
                    System.out.println("\n");

                    break;

                case 12://sortir
                    salir = true;
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("──────────────────────────────────────────────");
                    System.out.println("     Las opciones deben ser entre 1 y 12      ");
                    System.out.println("──────────────────────────────────────────────");
                    System.out.println("\n");
            }

        } while (!salir);
    }

}
