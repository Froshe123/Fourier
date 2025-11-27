// =======================
// Classe Complexe
// =======================
public class Complexe {
    public final double reel;
    public final double imag;

    public Complexe(double reel, double imag) {
        this.reel = reel;
        this.imag = imag;
    }

    public Complexe ajouter(Complexe autre) {
        return new Complexe(this.reel + autre.reel, this.imag + autre.imag);
    }

    public Complexe soustraire(Complexe autre) {
        return new Complexe(this.reel - autre.reel, this.imag - autre.imag);
    }

    public Complexe multiplier(Complexe autre) {
        double r = this.reel * autre.reel - this.imag * autre.imag;
        double i = this.reel * autre.imag + this.imag * autre.reel;
        return new Complexe(r, i);
    }

}