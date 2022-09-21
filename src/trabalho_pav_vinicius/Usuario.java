/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho_pav_vinicius;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */
public class Usuario implements Serializable {
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
    ArrayList<String> usuarios = new ArrayList<String>();
    
    public String usuarioNome() {
        return nome;
    }
    
    public String usuarioEndereco() {
        return endereco;
    }
    
    public String usuarioCpf() {
        return cpf;
    }
    
    public String usuarioTelefone() {
        return telefone;
    }
    
    public void atualizarNomeUsuario(String nome) {
        this.nome = nome;
    }
    
    public void atualizarEnderecoUsuario(String endereco) {
        this.endereco = endereco;
    }
    
    public void atualizarCpfUsuario(String cpf) {
        this.cpf = cpf;
    }
    
    public void atualizarTelefoneUsuario(String telefone) {
        this.telefone = telefone;
    }
    
    public void salvar() {
        ObjectOutputStream output = null;
        try {
            try {
                output = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
                
                for(int i=0; i<usuarios.size(); i++) {
                    output.writeObject(usuarios.get(i));
                }
                System.out.println("salvo com sucesso");
            }finally {
                if(output != null)
                    output.close();
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void abrir() {
        ObjectInputStream input = null;
        try {
            try {
                input = new ObjectInputStream(new FileInputStream("usuarios.dat"));
                Object obj = null;
                usuarios.clear();
                do {
                    obj = input.readObject();
                    usuarios.add(nome);
                }while(obj != null);
            }finally {
                if(input != null)
                    input.close();
            }
        }catch(EOFException e) {
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
