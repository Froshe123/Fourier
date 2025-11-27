public class TestFFT2DNaive {

    public static void main(String[] args) {

        Complexe[][] g = {
                { new Complexe(1,2), new Complexe(2,3) },
                { new Complexe(4,4), new Complexe(5,8) },
        };

        System.out.println("=== SIGNAL ORIGINALE g ===");
        afficher2D(g);

        // FFT 2D NAIVE
        Complexe[][] gtransfo = Fourier.FFT2DNaive(g);
        System.out.println("\n=== FFT 2D NAIVE gtransfo ===");
        afficher2D(gtransfo);

        // IFFT 2D NAIVE
        Complexe[][] gRec = Fourier.IFFT2DNaive(gtransfo);
        System.out.println("\n=== IFFT 2D NAIVE g (non normalisee) ===");
        afficher2D(gRec);
    }

    static void afficher2D(Complexe[][] t) {
        for (Complexe[] ligne : t) {
            for (Complexe c : ligne)
                System.out.printf("(%.2f , %.2f)  ", c.reel, c.imag);
            System.out.println();
        }
    }
}
