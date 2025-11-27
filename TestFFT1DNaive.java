public class TestFFT1DNaive {

    public static void main(String[] args) {

        Complexe[] g = {
                new Complexe(1,0),
                new Complexe(2,0),
                new Complexe(3,0),
                new Complexe(4,0)
        };

        System.out.println("=== SIGNAL ORIGINAL g ===");
        afficher1D(g);

        // FFT NAIVE
        Complexe[] gtransfo = Fourier.FFT1DNaive(g);
        System.out.println("\n=== FFT 1D NAIVE gtransfo ===");
        afficher1D(gtransfo);

        // IFFT NAIVE
        Complexe[] gRec = Fourier.IFFT1DNaive(gtransfo);
        System.out.println("\n=== IFFT 1D NAIVE g (non normalisee) ===");
        afficher1D(gRec);
    }

    static void afficher1D(Complexe[] t) {
        for (Complexe c : t)
            System.out.printf("(%.2f , %.2f)  ", c.reel, c.imag);
        System.out.println();
    }
}
