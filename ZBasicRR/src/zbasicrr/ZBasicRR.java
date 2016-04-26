
package zbasicrr;

import java.util.Scanner;

public  class ZBasicRR {
        public static int single=5;
        public static int doble=5;
        public static int familiar=5;
    
    public static void main(String[] args) {
        basicRegisterHotel();
    }
    public static int leerN(){
        boolean salida=false;
        int x=0;
        do{
            try{
                Scanner s= new Scanner(System.in);
                x=s.nextInt();
                if(x<1){
                    System.out.println("El numero no debe ser negativo o cero, reingrese nuevamente");
                }else{
                salida=true;
                }
            }catch(Exception e){
                System.out.println("caracter ingresado no valido, reingrese nuevamente");
            }
        }while(salida=false);
        return x;
    }
    public static void menu1(){
        System.out.println("usuario: \n1. Administrador \n2. Usuario \n3. Salir");
    }
    public static void menu2(){
    
        System.out.println("1. Ver lista de clientes "
            + "\n2. Borrar datos y dejar disponibles todas las "
            + "habitaciones \n3. Volver al menu princpal");
    }
    public static void menu3(){
        System.out.println("1. Ver habitaciones disponibles"
                + "\n2. Reservar habitacion \n3. Abandonar Hotel \n4. Volver al menu principal ");
    }
    public static void piezasDisponibles(){
        System.out.println("Piezas Dsponibles: \nPiezas simples= "+single
                +"\nPiezas Dobles= "+doble+"\nPiezas familiares= "+familiar);
    }
    public static String ingresarNomAp(){
    String nombre=" ";
    String apellido=" ";
    Scanner s=new Scanner(System.in);
        System.out.println("ingrese nombres");
        nombre=s.nextLine();
        System.out.println("ingrese apellidos");
        apellido=s.nextLine();
        return nombre+" "+apellido;
    }
    public static String correo(){
        String x;
        boolean salida=false;
        do{
            Scanner s=new Scanner(System.in);
            System.out.println("ingrese correo");
            x=s.nextLine();
            if (x.matches("(([A-Za-z0-9])*(.)*([A-Za-z0-9])*@([A-Za-z0-9])*[.]([A-Za-z])*)") ){
                salida=true;
            }else{
                System.out.println("correo invalido");
            }
        }while(salida==false);
        return x;
    }
    public static String rut(){
         String x;
        boolean salida=false;
        do{
            Scanner s=new Scanner(System.in);
            System.out.println("ingrese rut");
            x=s.nextLine();
            if (x.matches("[0-9]{2}[0-9]{3}[0-9]{3}[-][0-9k]") ){
                salida=true;
            }else{
                System.out.println("rut invalido");
            }
        }while(salida==false);
        return x;
    }
    public static String numeroTel(){
        Scanner s=new Scanner(System.in);
        System.out.println("ingrese numero de telefono");
        return s.nextLine();
    }
    public static String numeroCel(){
        Scanner s=new Scanner(System.in);
        System.out.println("ingrese numero de celular");
        return s.nextLine();
    }
  
    public static void reservarHabitacion(String[][]m,int montoSingle,int montoDoble,int montoFamiliar){
        boolean salida=false;
        int monto=0;
        int i=0;
        int j=0;
        int op;
        int dias=0;
        do{
            if(m[i][j]==null){
                boolean terminar=false;
                m[i][j]=ingresarNomAp();
                j++;
                m[i][j]=correo();
                j++;
                m[i][j]=rut();
                j++;
                m[i][j]=numeroCel();
                j++;
                m[i][j]=numeroTel();
                j++;
                do{
                System.out.println("seleccione habitacion \n1. Habitacion simple"
                        + "\n2. Habitacion doble \n3. Habitacion familiar");
                op=leerN();
                switch(op){
                    case 1:
                        if (single<=5 && single>0) {
                        single=single-1;
                        m[i][j]="simple";
                        
                        terminar=true;
                        }else{
                            System.out.println("No se encuentran habitaciones disponibles de este tipo");
                        }
                    break;
                    case 2:
                        if (doble<=5 && doble>0) {
                        doble=doble-1;
                        m[i][j]="doble";
                        
                        terminar=true;
                        }else{
                            System.out.println("No se encuentran habitaciones disponibles de este tipo");
                        }
                        
                    break;
                    case 3:
                        if (familiar<=5 && familiar>0) {
                        familiar=familiar-1;
                        m[i][j]="familiar";
                        
                        terminar=true;
                        }else{
                            System.out.println("No se encuentran habitaciones disponibles de este tipo");
                        }
                    break;
                    default:
                        System.out.println("opcion no valida");
                    break;
                }
                
                }while(terminar==false);
                j++;
                System.out.println("Ingrese cantidad de dias en que desea reservar: ");
                dias=leerN();
                if (op==1) {
                    monto=dias*montoSingle;
                } else  {
                    if (op==2){
                        monto=dias*montoDoble;
                    }else{
                        monto=dias*montoFamiliar;
                    }
                    
                }
                m[i][j]=""+dias;
                j++;
                
                m[i][j]=""+i+1;
                j++;
                m[i][j]=""+monto;
                
                salida=true;
                
                System.out.println("Su reservacion se ha generado con exito,"
                        + " el numero de su habitacion es: "+(i+1));
            }
            if (i<m.length) {
                i++;
            }else{
                System.out.println("Lo sentimos, no se encuentran piezas disponibles");
                salida=true;
            }
        }while(salida==false);
    }
    public static void borrarDatos(String m[][]){
        single=5;
        doble=5;
        familiar=5;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < 9; j++) {
                m[i][j]=null;
            }
        }
    }
    public static void mostrarLista(String m[][]){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static String[][] generarRecibo(String m[][] ,int x){
        x=x-1;
        String[][] recibo=new String[9][2];
        recibo[0][0]="Nombre: ";
        recibo[1][0]="Correo: ";
        recibo[2][0]="Rut: ";
        recibo[3][0]="Numero Celular: ";
        recibo[4][0]="Numero Telefono: ";
        recibo[5][0]="Tipo de pieza: ";
        recibo[6][0]="Dias de reservacion: ";
        recibo[7][0]="Numero habitacion: ";
        recibo[8][0]="Monto a cancelar: ";
       
        for (int i = 0; i < 9; i++) {
            recibo[i][1]=m[x][i];
        }
        return recibo;
    }
    public static void abandonarHotel(String m[][]){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void basicRegisterHotel() {
    int montoSingle=30000;
        int montoDoble=45000;
        int montoFamiliar=60000;
        boolean salida=false;
        int totalPiezas=15;
            
        String lista[][]=new String[totalPiezas][9];
        do{
            
            menu1();
            int op=leerN();
          
            boolean terminar=false;
            switch(op){
            case 1:
               
            do{
               menu2();
                int a=leerN();
                switch(a){
                    case 1:
                        mostrarLista(lista);
                    break;
                    case 2:
                        borrarDatos(lista);
                    break;
                    case 3:
                        terminar=true;
                    break;
                    default:
                        System.out.println("opcion no valida");
                    break;
                    }
                }while(terminar==false);
                terminar=false;
            break;
            case 2:
              
            do{
               
                menu3();
                int o=leerN();
                switch(o){
                
                    case 1:
                        piezasDisponibles();
                        
                    break;
                    case 2:
                        reservarHabitacion(lista,montoSingle,montoDoble,montoFamiliar);
                        
                    break;   
                    case 3:
                        int x=0;
                        do{
                            System.out.println("ingrese numero de la habitacion");
                            x=leerN();
                        }while(x>15);
                        abandonarHotel(generarRecibo(lista,x));
                        x=x-1;
                        for (int i = 0; i < 9; i++) {
                            lista[x][i]=null;
                        }
                    break;
                    case 4:
                        terminar=true;
                    break;
                    default:
                        System.out.println("opcion no valida");
                    break;    
                }
                
            }while(terminar==false);
            break;
        case 3:
            salida=true;
        break;
        default:
            System.out.println("opcion no vaida");
        break;
        }
        }while(salida==false);
        
    }
}
