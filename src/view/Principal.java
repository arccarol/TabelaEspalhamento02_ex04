package view;

import javax.swing.JOptionPane;

import controller.Departamento;
import controller.TabelaEspalhamento;

public class Principal {
    public static void main(String[] args) {
        TabelaEspalhamento tabela = new TabelaEspalhamento(100); 
        
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                            "1. Inserir departamento\n" +
                            "2. Consultar departamento\n" +
                            "3. Remover departamento\n" +
                            "0. Sair"));
                    
                    switch (opcao) {
                        case 1:
                            int andar = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar do departamento:"));
                            String nome = JOptionPane.showInputDialog("Digite o nome do departamento:");
                            String descricao = JOptionPane.showInputDialog("Digite a descrição do departamento:");
                            
                            Departamento departamento = new Departamento(andar, nome, descricao);
                            tabela.inserir(departamento);
                            JOptionPane.showMessageDialog(null, "Departamento inserido com sucesso!");
                            break;
                        
                        case 2:
                            int andarConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar do departamento para consulta:"));
                            
                            Departamento departamentoConsulta = tabela.consultar(andarConsulta);
                            if (departamentoConsulta != null) {
                                String mensagem = "Andar: " + departamentoConsulta.getAndar() + "\n" +
                                        "Nome do departamento: " + departamentoConsulta.getNome() + "\n" +
                                        "Descrição: " + departamentoConsulta.getDescricao();
                                JOptionPane.showMessageDialog(null, mensagem);
                            } else {
                                JOptionPane.showMessageDialog(null, "Departamento não encontrado!");
                            }
                            break;
                        
                        case 3:
                            int andarRemocao = Integer.parseInt(JOptionPane.showInputDialog("Digite o andar do departamento para remoção:"));
                            
                            boolean removido = tabela.remover(andarRemocao);
                            if (removido) {
                                JOptionPane.showMessageDialog(null, "Departamento removido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Departamento não encontrado!");
                            }
                            break;
                        
                        case 0:
                            JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                            break;
                        
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida!");
                            break;
                    }
                } while (opcao != 0);
            }
        }

