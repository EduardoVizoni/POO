import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("1. Gerenciar Planos");
                System.out.println("2. Gerenciar Serviços Adicionais");
                System.out.println("3. Gerenciar Clientes");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        gerenciarPlanos(sc);
                        break;
                    case 2:
                        gerenciarServicosAdicionais(sc);
                        break;
                    case 3:
                        gerenciarClientes(sc);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine();
            }
        }
    }

    private static void gerenciarPlanos(Scanner scanner) throws SQLException {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- GERENCIAR PLANOS ---");
            System.out.println("1. Cadastrar Plano");
            System.out.println("2. Consultar Planos");
            System.out.println("3. Atualizar Plano");
            System.out.println("4. Remover Plano");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPlano(scanner);
                    break;
                case 2:
                    consultarPlanos(scanner);
                    break;
                case 3:
                    atualizarPlano(scanner);
                    break;
                case 4:
                    removerPlano(scanner);
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarPlano(Scanner scanner) throws SQLException {
        System.out.print("Operadora: ");
        String operadora = scanner.nextLine();
        System.out.print("Nome do Plano: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade de Dados: ");
        double quantidadeDados = scanner.nextDouble();
        System.out.print("Quantidade de Dados Bônus (opcional): ");
        double quantidadeDadosBonus = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Benefícios: ");
        String beneficios = scanner.nextLine();
        System.out.print("Valor do Plano:R$ ");
        double valor = scanner.nextDouble();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "INSERT INTO plano (operadora, nome, quantidade_dados, quantidade_dados_bonus, beneficios, valor) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, operadora);
            stmt.setString(2, nome);
            stmt.setDouble(3, quantidadeDados);
            stmt.setDouble(4, quantidadeDadosBonus);
            stmt.setString(5, beneficios);
            stmt.setDouble(6, valor);
            stmt.executeUpdate();
            System.out.println("Plano cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar plano: " + e.getMessage());
        }
    }

    private static void consultarPlanos(Scanner scanner) throws SQLException {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM plano";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Operadora: " + rs.getString("operadora"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Quantidade de Dados: " + rs.getDouble("quantidade_dados"));
                System.out.println("Quantidade de Dados Bônus: " + rs.getDouble("quantidade_dados_bonus"));
                System.out.println("Benefícios: " + rs.getString("beneficios"));
                System.out.println("Valor:R$ " + rs.getDouble("valor"));
                System.out.println("-------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar planos: " + e.getMessage());
        }
    }

    private static void atualizarPlano(Scanner scanner) throws SQLException {
        System.out.print("ID do Plano para Atualizar: ");
        int idPlano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo Nome do Plano: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Valor:R$ ");
        double valor = scanner.nextDouble();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "UPDATE plano SET nome = ?, valor = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setInt(3, idPlano);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Plano atualizado com sucesso!");
            } else {
                System.out.println("Plano não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar plano: " + e.getMessage());
        }
    }

    private static void removerPlano(Scanner scanner) throws SQLException {
        System.out.print("ID do Plano para Remover: ");
        int idPlano = scanner.nextInt();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "DELETE FROM plano WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPlano);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Plano removido com sucesso!");
            } else {
                System.out.println("Plano não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover plano: " + e.getMessage());
        }
    }

    private static void gerenciarServicosAdicionais(Scanner scanner) throws SQLException {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- GERENCIAR SERVIÇOS ADICIONAIS ---");
            System.out.println("1. Cadastrar Serviço");
            System.out.println("2. Consultar Serviços");
            System.out.println("3. Atualizar Serviço");
            System.out.println("4. Remover Serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarServico(scanner);
                    break;
                case 2:
                    consultarServicos(scanner);
                    break;
                case 3:
                    atualizarServico(scanner);
                    break;
                case 4:
                    removerServico(scanner);
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarServico(Scanner scanner) {
        System.out.print("Descrição do Serviço: ");
        String descricao = scanner.nextLine();
        System.out.print("Custo Mensal do Serviço: ");
        double custoMensal = scanner.nextDouble();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "INSERT INTO servicoAdicional (descricao, custo_mensal) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao);
            stmt.setDouble(2, custoMensal);
            stmt.executeUpdate();
            System.out.println("Serviço cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar serviço: " + e.getMessage());
        }
    }

    private static void consultarServicos(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM servicoAdicional";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Custo Mensal: " + rs.getDouble("custo_mensal"));
                System.out.println("-------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar serviços: " + e.getMessage());
        }
    }

    private static void atualizarServico(Scanner scanner) {
        System.out.print("ID do Serviço para Atualizar: ");
        int idServico = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nova Descrição do Serviço: ");
        String descricao = scanner.nextLine();
        System.out.print("Novo Custo Mensal: ");
        double custoMensal = scanner.nextDouble();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "UPDATE servicoAdicional SET descricao = ?, custo_mensal = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao);
            stmt.setDouble(2, custoMensal);
            stmt.setInt(3, idServico);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Serviço atualizado com sucesso!");
            } else {
                System.out.println("Serviço não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar serviço: " + e.getMessage());
        }
    }

    private static void removerServico(Scanner scanner) {
        System.out.print("ID do Serviço para Remover: ");
        int idServico = scanner.nextInt();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "DELETE FROM servicoAdicional WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idServico);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Serviço removido com sucesso!");
            } else {
                System.out.println("Serviço não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover serviço: " + e.getMessage());
        }
    }

    private static void gerenciarClientes(Scanner scanner) throws SQLException {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- GERENCIAR CLIENTES ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Consultar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    consultarClientes(scanner);
                    break;
                case 3:
                    atualizarCliente(scanner);
                    break;
                case 4:
                    removerCliente(scanner);
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Telefone do Cliente: ");
        String telefone = scanner.nextLine();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private static void consultarClientes(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM cliente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("-------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar clientes: " + e.getMessage());
        }
    }

    private static void atualizarCliente(Scanner scanner) {
        System.out.print("ID do Cliente para Atualizar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Novo Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, telefone);
            stmt.setInt(4, idCliente);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    private static void removerCliente(Scanner scanner) {
        System.out.print("ID do Cliente para Remover: ");
        int idCliente = scanner.nextInt();

        try (Connection conn = Conexao.getConexao()) {
            String sql = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }
}