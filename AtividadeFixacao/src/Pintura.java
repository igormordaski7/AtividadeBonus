public class Pintura extends ObrasArte {
    
    private String tecnica;

    public Pintura(String titulo, String artista, int anoDeCriacao, String localizacao, String tecnica) {
        super(titulo, artista, anoDeCriacao, localizacao);
        this.tecnica = tecnica;
    }

    public String getTecnica() {
        return tecnica;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + tecnica;
    }

    public static Pintura fromString(String linha) {
        String[] dadosObra = linha.split(", ");
        return new Pintura(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[4], dadosObra[5]);
    }
}
