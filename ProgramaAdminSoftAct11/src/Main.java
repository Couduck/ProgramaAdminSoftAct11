import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        showMenu();
    }

    public static void showMenu()    //Despliega el menu principal de la actividad
    {
        double operando1 = 0, operando2 = 0, resultado = 0;
        String operando1STR, operando2STR, operador = "";

        //Menu de opciones a realizar
        String[] opcionesOperaciones = {
                "Suma (+)",
                "Resta (-)",
                "Multiplicacion (*)",
                "Division (/)"};

        String eleccionCompleta;        //Captura el valor de la string elegida completa
        int salirProceso, repetirProceso;               //La opcion que guarda el int que dicta si salir del programa o no
        boolean accionValida = false, operando1Valido = false, operando2Valido = false;   //Boolean que permite que las opciones puedan repetirse indefinidamente hasta que el usuario desee salir del programa

        do
        {
            accionValida = true;

            try
            {

                do
                {
                    try
                    {
                        operando1Valido = true;
                        operando1STR = (String) JOptionPane.showInputDialog(null, "Ingrese el primer operando de la operacion", "PROGRAMA JAVA", JOptionPane.QUESTION_MESSAGE);

                        operando1 = Double.parseDouble(operando1STR);
                    }

                    catch(NumberFormatException a)
                    {
                        JOptionPane.showMessageDialog(null,"El valor ingresado no puede ser convertido a un valor numerico, intentelo de nuevo", "PROGRAMA JAVA", JOptionPane.ERROR_MESSAGE);
                        operando1Valido = false;
                    }
                }
                while(!operando1Valido);

                do
                {
                    try
                    {
                        operando2Valido = true;
                        operando2STR = (String) JOptionPane.showInputDialog(null, "Ingrese el segundo operando de la operacion", "PROGRAMA JAVA", JOptionPane.QUESTION_MESSAGE);

                        operando2 = Double.parseDouble(operando2STR);
                    }

                    catch(NumberFormatException a)
                    {
                        JOptionPane.showMessageDialog(null,"El valor ingresado no puede ser convertido a un valor numerico, intentelo de nuevo", "PROGRAMA JAVA", JOptionPane.ERROR_MESSAGE);
                        operando2Valido = false;
                    }
                }
                while(!operando2Valido);


                //Panel que despliega el atributo a calcular
                eleccionCompleta = (String) JOptionPane.showInputDialog(null,"Seleccione la operacion a ejecutar:", "PROGRAMA JAVA", JOptionPane.QUESTION_MESSAGE, null, opcionesOperaciones, opcionesOperaciones[0]);

                switch(eleccionCompleta) //Dependiendo de la figura elegida, se ejecuta la acción especifica
                {
                    case "Suma (+)":
                        resultado = operando1 + operando2;
                        operador = "+";
                        break;

                    case "Resta (-)":
                        resultado = operando1 - operando2;
                        operador = "-";
                        break;

                    case "Multiplicacion (*)":
                        resultado = operando1 * operando2;
                        operador = "*";
                        break;

                    case "Division (/)":
                        resultado = operando1 / operando2;
                        operador = "/";
                        break;
                }

                JOptionPane.showMessageDialog(null,"El resultado de la operacion fue el siguiente:\n\n\t" + operando1 +" "+ operador +" "+ operando2 +" = "+ resultado, "PROGRAMA JAVA", JOptionPane.INFORMATION_MESSAGE);

                repetirProceso = JOptionPane.showConfirmDialog(null,"Quiere repetir con otra operacion?", "PROGRAMA JAVA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                //Si presiona Si
                if(repetirProceso == JOptionPane.YES_OPTION)
                {
                    accionValida = false;
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Programa terminado", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }

            catch(NullPointerException a) //El usuario seleccionó la opcion de cerrar el mensaje o de cancelar
            {
                //Se pregunta si el usuario desea salir del programa usando unicamente la opcion de si o no
                salirProceso = JOptionPane.showConfirmDialog(null,"Quiere salir del programa?", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                //Si presiona Si
                if(salirProceso == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null,"Programa terminado", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                //Si presiona No
                else
                {
                    accionValida = false;
                }
            }

            catch(IndexOutOfBoundsException b) //El usuario no ingresó nada y dió aceptar de todas formas
            {
                JOptionPane.showMessageDialog(null,"Comando no reconocido, vuelva a intentarlo", "ACTIVIDAD 12 Lista de Contactos", JOptionPane.ERROR_MESSAGE);
                accionValida = false;
            }
        }
        while(!accionValida);
    }
}