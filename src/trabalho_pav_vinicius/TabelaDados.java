/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho_pav_vinicius;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vincius
 */
public class TabelaDados extends AbstractTableModel {
    private static final int COL_NOME = 0;
    private static final int COL_ENDERECO = 1;
    private static final int COL_CPF = 2;
    private static final int COL_TELEFONE = 3;
       
    private String[] colunas = new String[]{"Nome", "Endereco", "Email", "Telefone"};
    private List<Usuario> usuarios;
    
    public TabelaDados(List<Usuario>usuarios) {
        this.usuarios = new ArrayList<Usuario>(usuarios);
    }
    
    
    public int getColumnCount() {
        return colunas.length;
    }
    
    public int getRowCount() {
        return usuarios.size();
    }
    
    public String getColumnName(int colIndice) {
        return colunas[colIndice];
    }
    
    public boolean isCellEditable(int linhaIndice, int colunaIndice) {
        return false;
    }
    
    public Object getValueAt(int linha, int coluna) {
        Usuario usuario = usuarios.get(linha);
        switch(coluna) {
            case COL_NOME:
                return usuario.usuarioNome();
            case COL_ENDERECO:
                return usuario.usuarioEndereco();
            case COL_CPF:
                return usuario.usuarioCpf();
            case COL_TELEFONE:
                return usuario.usuarioTelefone();
        }
        return "";
    }
    
    public void setValueAt(Object valor, int linha, int coluna) {
        Usuario usuario = usuarios.get(linha);
        switch(coluna) {
            case COL_NOME:
                usuario.atualizarNomeUsuario(valor.toString());
                break;
            case COL_ENDERECO:
                usuario.atualizarEnderecoUsuario(valor.toString());
                break;
            case COL_CPF:
                usuario.atualizarEnderecoUsuario(valor.toString());
                break;
            case COL_TELEFONE:
                usuario.atualizarTelefoneUsuario(valor.toString());
                break;
        }
    }
    
    public Usuario pegaUsuario(int indice) {
        return usuarios.get(indice);
    }
    
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        int n = getRowCount()-1;
        fireTableRowsInserted(n, n);
    }
    
    public void atualizarUsuario(int indice, Usuario usuario) {
        usuarios.set(indice, usuario);
        fireTableRowsUpdated(indice, indice);
    }
    
    public void deletarPessoa(int indice) {
        usuarios.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }
}
