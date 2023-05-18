
package pilas;

import javax.swing.JOptionPane;

public class ColaLista {
    
    Nodo Punta;
    private int Limite,Tope;

    public ColaLista(int d) {
        this.Punta = Punta;
        this.Limite = d;
        this.Tope = 0;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    public int getLimite() {
        return Limite;
    }

    public void setLimite(int Limite) {
        this.Limite = Limite;
    }

    public int getTope() {
        return Tope;
    }

    public void setTope(int Tope) {
        this.Tope = Tope;
    }
    
    public void InsertarFinal (long cedula, String carrera, String nombre, String apellido, float ing,float mat,float bio,float esp){
        
        Nodo p = null , x = new Nodo();
        
        x.setApellido(apellido);
        x.setCarrera(carrera);
        x.setCedula(cedula);
        x.setNombre(nombre);
        
        x.Materias.Apilar(ing);
        x.Materias.Apilar(mat);
        x.Materias.Apilar(bio);
        x.Materias.Apilar(esp);
        
        if (Punta == null){
            Punta = x;
        } else {
            p = Punta;
            
            while (p.getLiga() != null){
                p = p.getLiga();
            }
            p.setLiga(x);
        }
    }
    
    public void Encolar(long cedula, String carrera, String nombre, String apellido, float ing, float mat, float bio, float esp) {

        Tope++;
        InsertarFinal(cedula, carrera, nombre, apellido, ing, mat, bio, esp);
    }
    
    public void Encolar2(Nodo n){
        
        Tope++;
        InsertarFinal2(n);
    }
    
    public void InsertarFinal2(Nodo n){
        
        Nodo p = null;
        
        if (Punta == null){
            Punta = n;
        } else {
            p = Punta;
            
            while (p.getLiga() != null){
                p = p.getLiga();
            }
            p.setLiga(n);
        }
    }
    
    public Nodo Desencolar() {

        Nodo r=Punta;
        Punta=Punta.getLiga();
        r.setLiga(null);
        Tope--;
        return r;
    }
    
    public boolean ColaVacia() {

        if (Tope == 0) {
            return (true);
        } else {
            return (false);
        }
    }

    public boolean ColaLlena() {

        boolean r = false;

        if (Tope == Limite) {
            r = true;
        }

        return (r);
    }
    
    public void MostrarCola(){
        
        Nodo p = Punta;
        String s = ""; 
        float promedio;
        
        while (p != null) {  
            
            promedio=p.Materias.Promedio();
            s = s + "["+ p.getCedula()+ "]"+"["+p.getNombre()+"]"+"["+ p.getApellido()+"]"+"["+p.getCarrera()+"]"+"["+promedio+"]"+"-->";
            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, s);
        
    }

    
    void BuscarDato(float d) {

        ColaLista Ca = new ColaLista(Limite + 1);
        Pila Pa = new Pila(Limite + 1);
        int option; 
        int a;
        float NN;
        String NuevoA, NuevoN, NuevaC;

        while (!ColaVacia()) {

            while (d!=Punta.getCedula()) {

                Ca.Encolar2(Desencolar());

            }
            if(d==Punta.getCedula()){
                
                do{
                option = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                             1. Modificar nombre.
                                                                             2. Modificar apellido.
                                                                             3. Modificar carrera.
                                                                             4. Modificar notas.
                                                                             5. Salir.
                                                                             """));

                    switch (option) {
                        case 1:
                            NuevoN = JOptionPane.showInputDialog("Ingrese nuevo nombre: ");
                            Punta.setNombre(NuevoN);
                            while(!Ca.ColaVacia()){
                                Encolar2(Ca.Desencolar());
                            }
                            break;
                        case 2:
                            NuevoA = JOptionPane.showInputDialog("Ingrese nuevo apellido: ");
                            Punta.setApellido(NuevoA);
                            while(!Ca.ColaVacia()){
                                Encolar2(Ca.Desencolar());
                            }
                            break;
                        case 3:
                            NuevaC = JOptionPane.showInputDialog("Ingrese nueva carrera: ");
                            Punta.setCarrera(NuevaC);
                            while(!Ca.ColaVacia()){
                                Encolar2(Ca.Desencolar());
                            }
                            break;
                        case 4:
                            a= Integer.parseInt(JOptionPane.showInputDialog("¿Qué nota desea modificar?: 1.Ingles 2.Matematicas 3.Biologia 4.Español"));
                            
                            switch (a) {
                                case 1:
                                    while (Punta.getMaterias().getTope()!=0) {
                                            Pa.Apilar(Punta.getMaterias().Desapilar());
                                    }
                                    Punta.getMaterias().Desapilar();
                                    NN = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nueva nota: "));
                                    Punta.getMaterias().Apilar(NN);
                                    Punta.getMaterias().LlenarPila(Pa);
                                    Punta.getMaterias().MostrarPila();
                                    break;
                                case 2:
                                    while (Punta.getMaterias().getTope()!=1) {
                                            Pa.Apilar(Punta.getMaterias().Desapilar());
                                    }
                                    Punta.getMaterias().Desapilar();
                                    NN = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nueva nota: "));
                                    Punta.getMaterias().Apilar(NN);
                                    Punta.getMaterias().LlenarPila(Pa);
                                    Punta.getMaterias().MostrarPila();
                                    break;
                                case 3:
                                    while (Punta.getMaterias().getTope()!=2) {
                                            Pa.Apilar(Punta.getMaterias().Desapilar());
                                    }
                                    Punta.getMaterias().Desapilar();
                                    NN = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nueva nota: "));
                                    Punta.getMaterias().Apilar(NN);
                                    Punta.getMaterias().LlenarPila(Pa);
                                    Punta.getMaterias().MostrarPila();
                                    break;
                                case 4:
                                    while (Punta.getMaterias().getTope()!=3) {
                                            Pa.Apilar(Punta.getMaterias().Desapilar());
                                    }
                                    Punta.getMaterias().Desapilar();
                                    NN = Float.parseFloat(JOptionPane.showInputDialog("Ingrese nueva nota: "));
                                    Punta.getMaterias().Apilar(NN);
                                    Punta.getMaterias().LlenarPila(Pa);
                                    Punta.getMaterias().MostrarPila();
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opción incorrecta");
                            }
                            
                        case 5:
                            while(!Ca.ColaVacia()){
                                Encolar2(Ca.Desencolar());
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción incorrecta");
                    }
                }while(option!=5);
                break;
            }
        }
    }
    
    void OrdenarCC(){
        
        ColaLista Ca=new ColaLista(Limite+1), Ca2 = new ColaLista(Limite+1);
        Nodo menor;
        
        while(!ColaVacia()){
            Ca.Encolar2(Desencolar());
        }
        
        do{
            
            menor=Ca.Desencolar();
            
            while(!Ca.ColaVacia()){
                
                if(Ca.Punta.getCedula()<menor.getCedula()){
                    
                    Ca2.Encolar2(menor);
                    menor=Ca.Desencolar();
                }
                
                else if(Ca.Punta.getCedula()>menor.getCedula()){
                    Ca2.Encolar2(Ca.Desencolar());
                }
            }
            Encolar2(menor);
            
            while(!Ca2.ColaVacia()){
                Ca.Encolar2(Ca2.Desencolar());
            }
            
        }while(!Ca.ColaVacia());
        MostrarCola();
    }
        
    
    
}
