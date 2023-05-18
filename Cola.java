
package pilas;

public class Cola {
    
    //Atributos
    private int Limite, Tope, Cv[];
    
    //Métodos

    public Cola(int n) {
        Limite = n - 1;
        Tope = -1;
        Cv = new int[n];
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

    public int[] getCv() {
        return Cv;
    }

    public void setCv(int[] Cv) {
        this.Cv = Cv;
    }
    
    public int getCv(int t) {
        return Cv[t];
    }

    public void setCv(int t, int d) {
        Cv[t] = d;
    }
    
    public void Encolar(int d) {

        Tope++;
        Cv[Tope] = d;
    }
    
    public int Desencolar() {

        int r = Cv[0];
        
        for(int i=1;i<=Tope;i++){
            Cv[i-1]=Cv[i];
        }
        
        Tope--;
        return (r);
    }
    
    public boolean ColaVacia() {

        if (Tope == -1) {
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

    public void LlenarCola(Cola A) {

        while (!A.ColaVacia()) {
            Encolar(A.Desencolar());
        }
    }
}
