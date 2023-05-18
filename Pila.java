package pilas;

import javax.swing.JOptionPane;

public class Pila {

    //Atributos
    private int Limite, Tope;
    private float Vp[];

    //Métodos
    public Pila(int n) {
        Limite = n - 1;
        Tope = -1;
        Vp = new float[n];
    }

    public int getTope() {
        return Tope;
    }

    public void setTope(int Tope) {
        this.Tope = Tope;
    }

    public float[] getVp() {
        return Vp;
    }

    public void setVp(float[] Vp) {
        this.Vp = Vp;
    }

    public float getVp(int t) {
        return Vp[t];
    }

    public void setVp(int t, int d) {
        Vp[t] = d;
    }

    public void Apilar(float nota) {

        Tope++;
        Vp[Tope] = nota;
    }

    public float Desapilar() {

        float r = Vp[Tope];
        Tope--;
        return (r);
    }

    public boolean PilaVacia() {

        if (Tope == -1) {
            return (true);
        } else {
            return (false);
        }
    }

    public boolean PilaLlena() {

        boolean r = false;

        if (Tope == Limite) {
            r = true;
        }

        return (r);
    }

    public void LlenarPila(Pila A) {

        while (!A.PilaVacia()) {
            Apilar(A.Desapilar());
        }
    }
    
    public float Promedio(){
        
        Pila Pa = new Pila(Limite + 1);
        float promedio=0, aux;
        
        while(!PilaVacia()){
            aux=Desapilar();
            promedio=promedio+aux;
            Pa.Apilar(aux);
        }
        promedio=promedio/4;
        LlenarPila(Pa);
        return promedio;
    }
    
    void MostrarPila() {

        String s = "";

        Pila Pa = new Pila(Limite + 1);
        float aux;

        do {
            aux = Desapilar();
            Pa.Apilar(aux);

            if (Tope != -1) {
                s = s + "|" + aux + "|\n";
            } else {
                s = s + "|" + aux + "|\n" + "__";
            }
        } while (!PilaVacia());

        LlenarPila(Pa);

        JOptionPane.showMessageDialog(null, s);
    }

}






/*void OrdenarDescendente() {

        Pila Pa = new Pila(Limite + 1), Pa2 = new Pila(Limite + 1);
        float mayor;

        Pa.LlenarPila(this);

        do {

            mayor = Pa.Desapilar();

            while (Pa.PilaVacia() == false) {

                if (Pa.Vp[Pa.Tope] > mayor) {
                    Pa2.Apilar(mayor);
                    mayor = Pa.Desapilar();

                }
                else if (Pa.Vp[Pa.Tope] < mayor) {
                    Pa2.Apilar(Pa.Desapilar());

                }
            }
            Apilar(mayor);

            while (!Pa2.PilaVacia()) {
                Pa.Apilar(Pa2.Desapilar());
            }

        } while (!Pa.PilaVacia());
        MostrarPila();

    }
*/