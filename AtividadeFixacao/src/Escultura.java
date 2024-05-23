public class Escultura extends ObrasArte {
    
    private String material;

    public Escultura(String titulo, String artista, int anoDeCriacao, String localizacao, String material) {
        super(titulo, artista, anoDeCriacao, localizacao);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + material;
    }

    public static Escultura fromString(String linha) {
        String[] dadosObra = linha.split(", ");
        return new Escultura(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[4], dadosObra[5]);
    }
}
