import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorObras {

    private static final String ARQUIVO = "obras.txt";

    public static void salvarObras(ObrasArte obras) throws IOException {
        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(obras.toString() + "\n");
        }
    }

    public static ArrayList<ObrasArte> listarObras() throws IOException {
        ArrayList<ObrasArte> listarObras = new ArrayList<>();
        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                ObrasArte obras = ObrasArte.fromString(linha);
                listarObras.add(obras);
            }
        }
        return listarObras;
    }

    public static ObrasArte buscarObras(String titulo) throws Exception {
        ArrayList<ObrasArte> listaObras = listarObras();
        for (ObrasArte obra : listaObras) {
            if (obra.getTitulo().equals(titulo)) {
                return obra;
            }
        }
        throw new Exception("Obra " + titulo + " não encontrada!");
    }

    public static void atualizarObra(String titulo, ObrasArte novaObra) throws Exception {
        ArrayList<ObrasArte> listaObras = listarObras();
        boolean encontrado = false;
        for (int i = 0; i < listaObras.size(); i++) {
            if (listaObras.get(i).getTitulo().equals(titulo)) {
                listaObras.set(i, novaObra);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new Exception("Obra " + titulo + " não encontrada!");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (ObrasArte obra : listaObras) {
                bw.write(obra.toString() + "\n");
            }
        }
    }

    public static void apagarObra(String titulo) throws Exception {
        ArrayList<ObrasArte> listaObras = listarObras();
        boolean encontrou = false;
        Iterator<ObrasArte> iterator = listaObras.iterator();
        while (iterator.hasNext()) {
            ObrasArte obra = iterator.next();
            if (obra.getTitulo().equals(titulo)) {
                iterator.remove();
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            throw new Exception("A obra " + titulo + " não encontrada!");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (ObrasArte obra : listaObras) {
                bw.write(obra.toString() + "\n");
            }
        }
    }

    public static ArrayList<ObrasArte> buscarObrasPorArtista(String artista) throws IOException {
        ArrayList<ObrasArte> listaObras = listarObras();
        ArrayList<ObrasArte> obrasArtista = new ArrayList<>();
        for (ObrasArte obra : listaObras) {
            if (obra.getArtista().equalsIgnoreCase(artista)) {
                obrasArtista.add(obra);
            }
        }
        return obrasArtista;
    }

    public static ArrayList<ObrasArte> buscarObrasPorAno(int ano) throws IOException {
        ArrayList<ObrasArte> listaObras = listarObras();
        ArrayList<ObrasArte> obrasAno = new ArrayList<>();
        for (ObrasArte obra : listaObras) {
            if (obra.getAnoDeCriacao() == ano) {
                obrasAno.add(obra);
            }
        }
        return obrasAno;
    }

    public static ArrayList<ObrasArte> buscarObrasPorTipo(String tipo) throws IOException {
        ArrayList<ObrasArte> listaObras = listarObras();
        ArrayList<ObrasArte> obrasTipo = new ArrayList<>();
        for (ObrasArte obra : listaObras) {
            if (obra.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                obrasTipo.add(obra);
            }
        }
        return obrasTipo;
    }
}
