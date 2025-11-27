public class Fourier {

    // ======================
    //      FFT 1D NAIVE
    // ======================
    public static Complexe[] FFT1DNaive(Complexe[] g) {
        int N = g.length;
        Complexe[] gtransfo = new Complexe[N];

        for (int u = 0; u < N; u++) {
            Complexe somme = new Complexe(0, 0);
            for (int x = 0; x < N; x++) {
                double angle = -2 * Math.PI * u * x / N;
                Complexe facteur = new Complexe(Math.cos(angle), Math.sin(angle));
                somme = somme.ajouter(g[x].multiplier(facteur));
            }
            gtransfo[u] = somme;
        }

        return gtransfo;
    }


    // ======================
    //      FFT 1D RAPIDE
    // ======================
    public static Complexe[] FFT1DRapide(Complexe[] g) {
        int N = g.length;

        if (N == 1) return new Complexe[] { g[0] };
        if ((N & (N - 1)) != 0) throw new IllegalArgumentException("N doit être une puissance de 2");

        Complexe[] pairs = new Complexe[N / 2];
        Complexe[] impairs = new Complexe[N / 2];

        for (int i = 0; i < N / 2; i++) {
            pairs[i] = g[2 * i];
            impairs[i] = g[2 * i + 1];
        }

        Complexe[] transfoPairs = FFT1DRapide(pairs);
        Complexe[] transfoImpairs = FFT1DRapide(impairs);

        Complexe[] gtransfo = new Complexe[N];

        for (int u = 0; u < N / 2; u++) {
            double angle = -2 * Math.PI * u / N;
            Complexe facteur = new Complexe(Math.cos(angle), Math.sin(angle));
            Complexe temp = facteur.multiplier(transfoImpairs[u]);

            gtransfo[u] = transfoPairs[u].ajouter(temp);
            gtransfo[u + N / 2] = transfoPairs[u].soustraire(temp);
        }

        return gtransfo;
    }


    // ======================
    //      IFFT 1D NAIVE
    // ======================
    public static Complexe[] IFFT1DNaive(Complexe[] gtransfo) {
        int N = gtransfo.length;
        Complexe[] g = new Complexe[N];

        for (int x = 0; x < N; x++) {
            Complexe somme = new Complexe(0, 0);
            for (int u = 0; u < N; u++) {
                double angle = 2 * Math.PI * u * x / N;
                Complexe facteur = new Complexe(Math.cos(angle), Math.sin(angle));
                somme = somme.ajouter(gtransfo[u].multiplier(facteur));
            }
            g[x] = new Complexe(somme.reel , somme.imag );
        }

        return g;
    }


    // ======================
    //      IFFT 1D RAPIDE
    // ======================
    public static Complexe[] IFFT1DRapide(Complexe[] g) {
        int N = g.length;

        if (N == 1) return new Complexe[] { g[0] };
        if ((N & (N - 1)) != 0) throw new IllegalArgumentException("N doit être une puissance de 2");

        Complexe[] pairs = new Complexe[N / 2];
        Complexe[] impairs = new Complexe[N / 2];

        for (int i = 0; i < N / 2; i++) {
            pairs[i] = g[2 * i];
            impairs[i] = g[2 * i + 1];
        }

        Complexe[] transfoPairs = IFFT1DRapide(pairs);
        Complexe[] transfoImpairs = IFFT1DRapide(impairs);

        Complexe[] gInverse = new Complexe[N];

        for (int u = 0; u < N / 2; u++) {
            double angle = 2 * Math.PI * u / N;
            Complexe facteur = new Complexe(Math.cos(angle), Math.sin(angle));
            Complexe temp = facteur.multiplier(transfoImpairs[u]);

            gInverse[u] = transfoPairs[u].ajouter(temp);
            gInverse[u + N / 2] = transfoPairs[u].soustraire(temp);
        }

        return gInverse;
    }


    // ======================
    //      FFT 2D NAIVE
    // ======================
    public static Complexe[][] FFT2DNaive(Complexe[][] g) {
        int N = g.length;
        int M = g[0].length;
        Complexe[][] gtransfo = new Complexe[N][M];

        for (int u = 0; u < N; u++) {
            for (int v = 0; v < M; v++) {
                Complexe somme = new Complexe(0, 0);
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < M; y++) {
                        double ab = -2 * Math.PI * ((double) u * x / N + (double) v * y / M);
                        Complexe facteur = new Complexe(Math.cos(ab), Math.sin(ab));
                        somme = somme.ajouter(g[x][y].multiplier(facteur));
                    }
                }
                gtransfo[u][v] = somme;
            }
        }

        return gtransfo;
    }


    // ======================
    //      FFT 2D RAPIDE
    // ======================
    public static Complexe[][] FFT2DRapide(Complexe[][] g) {
        int N = g.length;
        int M = g[0].length;

        Complexe[][] temp = new Complexe[N][M];
        for (int x = 0; x < N; x++) temp[x] = FFT1DRapide(g[x]);

        Complexe[][] gtransfo = new Complexe[N][M];

        for (int v = 0; v < M; v++) {
            Complexe[] col = new Complexe[N];
            for (int x = 0; x < N; x++) col[x] = temp[x][v];

            Complexe[] colT = FFT1DRapide(col);
            for (int x = 0; x < N; x++) gtransfo[x][v] = colT[x];
        }

        return gtransfo;
    }


    // ======================
    //      IFFT 2D NAIVE
    // ======================
    public static Complexe[][] IFFT2DNaive(Complexe[][] gtransfo) {
        int N = gtransfo.length;
        int M = gtransfo[0].length;

        Complexe[][] g = new Complexe[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                Complexe somme = new Complexe(0, 0);

                for (int u = 0; u < N; u++) {
                    for (int v = 0; v < M; v++) {
                        double ab = 2 * Math.PI * ((double) u * x / N + (double) v * y / M);
                        Complexe facteur = new Complexe(Math.cos(ab), Math.sin(ab));
                        somme = somme.ajouter(gtransfo[u][v].multiplier(facteur));
                    }
                }

                g[x][y] = new Complexe(somme.reel , somme.imag );
            }
        }

        return g;
    }


    // ======================
    //      IFFT 2D RAPIDE
    // ======================
    public static Complexe[][] IFFT2DRapide(Complexe[][] gtransfo) {
        int N = gtransfo.length;
        int M = gtransfo[0].length;

        Complexe[][] temp = new Complexe[N][M];
        for (int x = 0; x < N; x++) temp[x] = IFFT1DRapide(gtransfo[x]);

        Complexe[][] g = new Complexe[N][M];

        for (int v = 0; v < M; v++) {
            Complexe[] col = new Complexe[N];
            for (int x = 0; x < N; x++) col[x] = temp[x][v];

            Complexe[] colRec = IFFT1DRapide(col);
            for (int x = 0; x < N; x++) g[x][v] = colRec[x];
        }

        return g;
    }
}