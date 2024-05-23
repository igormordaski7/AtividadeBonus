public abstract class ObrasArte {
    private String titulo;
    private String artista;
    private int anoDeCriacao;
    private String localizacao;

    public ObrasArte(String titulo, String artista, int anoDeCriacao, String localizacao) {
        this.titulo = titulo;
        this.artista = artista;
        this.anoDeCriacao = anoDeCriacao;
        this.localizacao = localizacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoDeCriacao + ", " + getClass().getSimpleName() + ", " + localizacao;
    }

    public static ObrasArte fromString(String linha) {
        String[] dadosObra = linha.split(", ");
        String tipo = dadosObra[3];
        
        switch (tipo.toLowerCase()) {
            case "pintura":
                return new Pintura(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[4], dadosObra[5]);
            case "escultura":
                return new Escultura(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[4], dadosObra[5]);
            case "fotografia":
                return new Fotografia(dadosObra[0], dadosObra[1], Integer.parseInt(dadosObra[2]), dadosObra[4], dadosObra[5]);
            default:
                throw new IllegalArgumentException("\nTipo de obra desconhecido: " + tipo);
        }
    }
}
