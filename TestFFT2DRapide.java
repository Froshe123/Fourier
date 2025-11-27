public class TestFFT2DRapide {

    public static void main(String[] args) {

        Complexe[][] g = {
                { new Complexe(1,2), new Complexe(2,3) },
                { new Complexe(4,4), new Complexe(5,8) },
        };

        System.out.println("=== IMAGE ORIGINALE g ===");
        afficher2D(g);

        // FFT 2D RAPIDE
        Complexe[][] gtransfo = Fourier.FFT2DRapide(g);
        System.out.println("\n=== FFT 2D RAPIDE gtransfo ===");
        afficher2D(gtransfo);

        // IFFT 2D RAPIDE
        Complexe[][] gRec = Fourier.IFFT2DRapide(gtransfo);
        System.out.println("\n=== IFFT 2D RAPIDE g (non normalisee) ===");
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
