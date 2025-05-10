package cadastrobd;

import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridicaDAO;

public class CadastroBDTeste {

    public static void main(String[] args) {
        // Instanciar DAOs
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

        // OPERAÇÃO 1: Criar e persistir uma pessoa física
        System.out.println("=== CRIANDO PESSOA FÍSICA ===");
        PessoaFisica pessoaFisica = new PessoaFisica(0, "Ernaldo", "Rua A, 123", "Fortaleza", "CE", "1119292222", "ernal@email.com", "666.666.777-77");

        if (!pessoaFisicaDAO.cpfExiste(pessoaFisica.getCpf())) {
            pessoaFisicaDAO.incluir(pessoaFisica);
            System.out.println("Pessoa física criada e persistida!");
        } else {
            System.out.println("Erro: CPF já existe no banco de dados!");
        }

        // OPERAÇÃO 2: Alterar os dados da pessoa física
        System.out.println("\n=== ALTERANDO PESSOA FÍSICA ===");
        pessoaFisica.setNome("frffff ddddddda");
        pessoaFisica.setCpf("555.663.666-88");
        pessoaFisicaDAO.alterar(pessoaFisica);
        System.out.println("Pessoa física alterada!");

        // OPERAÇÃO 3: Consultar todas as pessoas físicas
        System.out.println("\n=== LISTANDO TODAS AS PESSOAS FÍSICAS ===");
        for (PessoaFisica pf : pessoaFisicaDAO.getPessoas()) {
            pf.exibir();
            System.out.println("-----");
        }

        // OPERAÇÃO 4: Excluir a pessoa física
        System.out.println("\n=== EXCLUINDO PESSOA FÍSICA ===");
        pessoaFisicaDAO.excluir(pessoaFisica.getId());
        System.out.println("Pessoa física excluída!");

        // OPERAÇÃO 5: Criar e persistir uma pessoa jurídica
        System.out.println("\n=== CRIANDO PESSOA JURÍDICA ===");
        PessoaJuridica pessoaJuridica = new PessoaJuridica(0, "xxxx Empresa Ltda.", "Rua nnnl, 555", "Fortaleza", "CE", "3333377778", "nnnnnnnnnnn@email.com", "89.999.432/0001-01");

        if (!pessoaJuridicaDAO.cnpjExiste(pessoaJuridica.getCnpj())) {
            pessoaJuridicaDAO.incluir(pessoaJuridica);
            System.out.println("Pessoa jurídica criada e persistida!");
        } else {
            System.out.println("Erro: CNPJ já existe no banco de dados!");
        }

        // OPERAÇÃO 6: Alterar os dados da pessoa jurídica
        System.out.println("\n=== ALTERANDO PESSOA JURÍDICA ===");
        pessoaJuridica.setNome("Elite Ltda.");
        pessoaJuridica.setCnpj("87.678.999/0001-02");
        pessoaJuridicaDAO.alterar(pessoaJuridica);
        System.out.println("Pessoa jurídica alterada!");

        // OPERAÇÃO 7: Consultar todas as pessoas jurídicas
        System.out.println("\n=== LISTANDO TODAS AS PESSOAS JURÍDICAS ===");
        for (PessoaJuridica pj : pessoaJuridicaDAO.getPessoas()) {
            pj.exibir();
            System.out.println("-----");
        }

        // OPERAÇÃO 8: Excluir a pessoa jurídica
        System.out.println("\n=== EXCLUINDO PESSOA JURÍDICA ===");
        pessoaJuridicaDAO.excluir(pessoaJuridica.getId());
        System.out.println("Pessoa jurídica excluída!");
    }
}