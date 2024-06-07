package br.unipar.trabalho_lista_encadeada2bi;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;


public class CadastroCliente {
    
    private static final ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    
    public static void main(String[] args) {
   
        while (true) {
            String opcao = JOptionPane.showInputDialog(null, "1. Adicionar Cliente\n2. Remover Cliente\n3. Alterar Cliente\n4. Buscar Cliente\n5. Listar de Todos os Clientes\n6. Sair", "Menu", JOptionPane.QUESTION_MESSAGE);
            if (opcao == null) break;
            switch (opcao) {
                case "1" -> addCliente();
                case "2" -> removerCliente();
                case "3" -> alterarCliente();
                case "4" -> buscarCliente();
                case "5" -> listarTodosClientes();
                case "6" -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void addCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do Cliente:", "Adicionar Cliente", JOptionPane.QUESTION_MESSAGE));
            String nome = JOptionPane.showInputDialog(null, "Nome do Cliente:", "Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);
            String Nascimento = JOptionPane.showInputDialog(null, "Data de Nascimento (dd/mm/yyyy):", "Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);
            String telefone = JOptionPane.showInputDialog(null, "Telefone do Cliente:", "Adicionar Cliente", JOptionPane.QUESTION_MESSAGE);

            Cliente novoCliente = new Cliente(codigo, nome, Nascimento, telefone);
            lista.adicionar(novoCliente);
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void removerCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do Cliente a remover:", "Remover Cliente", JOptionPane.QUESTION_MESSAGE));
            Cliente cliente = lista.buscar(codigo);
            if (cliente != null && lista.remover(codigo)) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!\n" + cliente.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alterarCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do Cliente a alterar:", "Alterar Cliente", JOptionPane.QUESTION_MESSAGE));
            Cliente cliente = lista.buscar(codigo);
            if (cliente != null) {
                String nome = JOptionPane.showInputDialog(null, "Novo Nome do Cliente:", "Alterar Cliente", JOptionPane.QUESTION_MESSAGE);
                String Nascimento = JOptionPane.showInputDialog(null, "Nova Data de Nascimento (dd/mm/yyyy):", "Alterar Cliente", JOptionPane.QUESTION_MESSAGE);
                String telefone = JOptionPane.showInputDialog(null, "Novo Telefone do Cliente:", "Alterar Cliente", JOptionPane.QUESTION_MESSAGE);

                cliente.nome = nome;
                cliente.Nascimento = Nascimento;
                cliente.telefone = telefone;

                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void buscarCliente() {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código do Cliente a buscar:", "Buscar Cliente", JOptionPane.QUESTION_MESSAGE));
            Cliente cliente = lista.buscar(codigo);
            if (cliente != null) {
                JOptionPane.showMessageDialog(null, cliente.toString(), "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido! Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarTodosClientes() {
        String listarTodosClientes = lista.listarTodos();
        JOptionPane.showMessageDialog(null, listarTodosClientes.isEmpty() ? "Nenhum cliente cadastrado." : listarTodosClientes, "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
