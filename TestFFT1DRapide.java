public class TestFFT1DRapide {

    public static void main(String[] args) {

        Complexe[] g = {
                new Complexe(1,0),
                new Complexe(2,0),
                new Complexe(3,0),
                new Complexe(4,0)
        };

        System.out.println("=== SIGNAL ORIGINAL g ===");
        afficher1D(g);

        // FFT RAPIDE
        Complexe[] gtransfo = Fourier.FFT1DRapide(g);
        System.out.println("\n=== FFT 1D RAPIDE gtransfo ===");
        afficher1D(gtransfo);

        // IFFT RAPIDE
        Complexe[] gRec = Fourier.IFFT1DRapide(gtransfo);
        System.out.println("\n=== IFFT 1D RAPIDE g (non normalisee) ===");
        afficher1D(gRec);
    }

    static void afficher1D(Complexe[] t) {
        for (Complexe c : t)
            System.out.printf("(%.2f , %.2f)  ", c.reel, c.imag);
        System.out.println();
    }
}
