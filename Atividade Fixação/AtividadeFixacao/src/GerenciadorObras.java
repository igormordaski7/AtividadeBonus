import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class GerenciadorObras {

    private static final String ARQUIVO = "obras.txt";

    public static void salvarObras(ObrasArte obras) throws Exception {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write(obras + "\n");
        } 
    }

    public static ArrayList<ObrasArte> listarObras() throws Exception{

        ArrayList<ObrasArte> listarObras = new ArrayList<>();

        try (FileReader fr = new FileReader(ARQUIVO);
            BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    
                    ObrasArte obras = ObrasArte.fromString(linha);
                    listarObras.add(obras);
                }
        
            if (listarObras.isEmpty()) {
                throw new Exception("\nNão há obras cadastradas!");
            }
        }
        
        return listarObras;

    }

    public static void buscarObras(String titulo) throws Exception {

        ArrayList<ObrasArte> buscaObra = listarObras();

        for (ObrasArte tempObrasArte : buscaObra) {
            if (tempObrasArte.getTitulo() == titulo) {
                System.out.println(tempObrasArte);
            }
        }

        throw new Exception("Obra " + titulo + " não encontrada!");
    }

    public static void atualizarObra(String titulo, ObrasArte novaObra) throws Exception {
        
        ArrayList<ObrasArte> listarObras = listarObras();
        boolean encontrado = false;

        for (int i = 0; i < listarObras.size(); i++) {
            if (listarObras.get(i).getTitulo().equals(titulo)) {
                listarObras.set(i, novaObra);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            throw new Exception("Obra " + titulo + " não encontrada!");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (ObrasArte obra : listarObras) {
                bw.write(obra.toString() + "\n");
            }
        }
    }

    public static void apagarObra(String titulo) throws Exception{

        ArrayList<ObrasArte> apagarObra = listarObras();

        boolean encontrou = false;

        for (ObrasArte tempObra : apagarObra) {
            if (tempObra.getTitulo() == titulo) {
                apagarObra.remove(tempObra);
                encontrou = true;
                break;
            }
        }

        if (!encontrou) {
            throw new Exception("\nA obra " + titulo + " não encontrada!");
        }

        try (FileWriter fw = new FileWriter(ARQUIVO);
            BufferedWriter bw = new BufferedWriter(fw)) {

                for (ObrasArte obras : apagarObra) {
                   bw.write(obras + "\n");
                }  
        } 
    }
}
