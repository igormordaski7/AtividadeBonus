public class Fotografia extends ObrasArte {
    
    private String camera;

    public Fotografia(String titulo, String artista, int anoDeCriacao, String localizacao, String camera) {
        super(titulo, artista, anoDeCriacao, localizacao);
        this.camera = camera;
    }

    public String getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + camera;
    }

    public static Fotografia fromString(String linha) {
        String[] dadosObra = linha.split(", ");
        return new Fotografia(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[4], dadosObra[5]);
    }
}
