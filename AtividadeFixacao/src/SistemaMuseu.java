import java.io.IOException;
import java.util.ArrayList;

public class SistemaMuseu {

    private static void exibirMenu() {
        System.out.println("\nGERENCIADOR DE OBRAS DE ARTE");
        System.out.println("1) Cadastrar Obra");
        System.out.println("2) Buscar Obra");
        System.out.println("3) Listar Todas as Obras");
        System.out.println("4) Atualizar Obra");
        System.out.println("5) Apagar Obra");
        System.out.println("6) Buscar obras por artista");
        System.out.println("7) Buscar obras por ano");
        System.out.println("8) Buscar obras por tipo");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
    }

    private static void verificarOpcao(int op) {
        switch (op) {
            case 1:
                salvarObra();
                break;
            case 2:
                buscarObra();
                break;
            case 3:
                listarTodas();
                break;
            case 4:
                atualizarObra();
                break;
            case 5:
                apagarObra();
                break;
            case 6:
                buscarObrasPorArtista();
                break;
            case 7:
                buscarObrasPorAno();
                break;
            case 8:
                buscarObrasPorTipo();
                break;
            case 0:
                System.out.println("\nO Programa foi finalizado...");
                break;
            default:
                System.out.println("\nOpção inválida. Digite novamente:");
                break;
        }
    }

    private static void salvarObra() {
    
        System.out.println("\nNova Obra:");

        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        System.out.print("Informe o artista: ");
        String artista = Console.lerString();

        System.out.print("Informe o ano de criação: ");
        int anoDeCriacao = Console.lerInt();

        System.out.print("Informe a localização: ");
        String localizacao = Console.lerString();

        System.out.print("Informe o tipo de obra (Pintura, Escultura, Fotografia): ");
        String tipo = Console.lerString();

        ObrasArte obra = null;
        switch (tipo.toLowerCase()) {
            case "pintura":
                System.out.print("Informe a técnica da pintura: ");
                String tecnica = Console.lerString();
                obra = new Pintura(titulo, artista, anoDeCriacao, localizacao, tecnica);
                break;
            case "escultura":
                System.out.print("Informe o material da escultura: ");
                String material = Console.lerString();
                obra = new Escultura(titulo, artista, anoDeCriacao, localizacao, material);
                break;
            case "fotografia":
                System.out.print("Informe a câmera usada na fotografia: ");
                String camera = Console.lerString();
                obra = new Fotografia(titulo, artista, anoDeCriacao, localizacao, camera);
                break;
            default:
                System.out.println("\nTipo de obra inválido!");
                return;
        }

        try {
            GerenciadorObras.salvarObras(obra);
            System.out.println("\nObra salva com sucesso!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObra() {
        
        System.out.println("\nBuscar Obra");
        System.out.print("Informe o título: ");
        String titulo = Console.lerString();

        try {
            ObrasArte obra = GerenciadorObras.buscarObras(titulo);
            System.out.println("\nObra encontrada: " + obra);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarTodas() {
        System.out.println("\nObras Cadastradas:");
        try {
            ArrayList<ObrasArte> obras = GerenciadorObras.listarObras();
            for (ObrasArte obra : obras) {
                System.out.println(obra);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarObra() {
    
        System.out.println("\nAtualizar Obra");
        System.out.print("Informe o título da obra a ser atualizada: ");
        String titulo = Console.lerString();

        System.out.print("Informe o novo título: ");
        String novoTitulo = Console.lerString();

        System.out.print("Informe o novo artista: ");
        String novoArtista = Console.lerString();

        System.out.print("Informe o novo ano de criação: ");
        int novoAnoDeCriacao = Console.lerInt();

        System.out.print("Informe a nova localização: ");
        String novaLocalizacao = Console.lerString();

        System.out.print("Informe o novo tipo de obra (Pintura, Escultura, Fotografia): ");
        String novoTipo = Console.lerString();

        ObrasArte novaObra = null;
        switch (novoTipo.toLowerCase()) {
            case "pintura":
                System.out.print("Informe a nova técnica da pintura: ");
                String novaTecnica = Console.lerString();
                novaObra = new Pintura(novoTitulo, novoArtista, novoAnoDeCriacao, novaLocalizacao, novaTecnica);
                break;
            case "escultura":
                System.out.print("Informe o novo material da escultura: ");
                String novoMaterial = Console.lerString();
                novaObra = new Escultura(novoTitulo, novoArtista, novoAnoDeCriacao, novaLocalizacao, novoMaterial);
                break;
            case "fotografia":
                System.out.print("Informe a nova câmera usada na fotografia: ");
                String novaCamera = Console.lerString();
                novaObra = new Fotografia(novoTitulo, novoArtista, novoAnoDeCriacao, novaLocalizacao, novaCamera);
                break;
            default:
                System.out.println("\nTipo de obra inválido!");
                return;
        }

        try {
            GerenciadorObras.atualizarObra(titulo, novaObra);
            System.out.println("\nObra atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void apagarObra() {
        
        System.out.println("\nApagar Obra");
        System.out.print("Informe o título da obra que deseja apagar: ");
        String titulo = Console.lerString();

        try {
            GerenciadorObras.apagarObra(titulo);
            System.out.println("\nObra excluída com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObrasPorArtista() {
        
        System.out.println("\nBuscar Obras por Artista");
        System.out.print("Informe o nome do artista: ");
        String artista = Console.lerString();

        try {
            ArrayList<ObrasArte> obras = GerenciadorObras.buscarObrasPorArtista(artista);
            if (obras.isEmpty()) {
                System.out.println("\nNenhuma obra encontrada para o artista: " + artista);
            } else {
                for (ObrasArte obra : obras) {
                    System.out.println(obra);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObrasPorAno() {
        
        System.out.println("\nBuscar Obras por Ano");
        System.out.print("Informe o ano: ");
        int ano = Console.lerInt();

        try {
            ArrayList<ObrasArte> obras = GerenciadorObras.buscarObrasPorAno(ano);
            if (obras.isEmpty()) {
                System.out.println("\nNenhuma obra encontrada para o ano: " + ano);
            } else {
                for (ObrasArte obra : obras) {
                    System.out.println(obra);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObrasPorTipo() {
        
        System.out.println("\nBuscar Obras por Tipo");
        System.out.print("Informe o tipo de obra (Pintura, Escultura, Fotografia): ");
        String tipo = Console.lerString();

        try {
            ArrayList<ObrasArte> obras = GerenciadorObras.buscarObrasPorTipo(tipo);
            if (obras.isEmpty()) {
                System.out.println("\nNenhuma obra encontrada do tipo: " + tipo);
            } else {
                for (ObrasArte obra : obras) {
                    System.out.println(obra);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void executar() {
        
        int op;
        do {
            exibirMenu();
            op = Console.lerInt();
            verificarOpcao(op);
        } while (op != 0);
    }
}
   
