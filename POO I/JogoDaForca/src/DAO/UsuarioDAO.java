package DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author santo
 */
public class UsuarioDAO implements DAO{
    private Connection connection;
    
    // Puxa a conexão com o BD
    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }
    
    // Recebe os dados para criação de um novo usuário
    @Override
    public void inserir(Object obj) throws Exception {
        if (obj!=null && obj instanceof Usuario){
            Usuario usuario = (Usuario)obj;
            String query = "INSERT INTO usuario (nome, senha, tipo, pontuacao) VALUES (?, ?, ?, 0)"; // Query para inserir um novo usuário
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.setInt(3, usuario.getTipo());
            statement.executeUpdate();
            }
        
    } 
    
    @Override
    public void alterar(Object obj1, Object obj2) throws Exception {
        if (obj1!=null && obj2!=null && obj1 instanceof String && obj2 instanceof Integer){
            String nick = (String)obj1;
            int pontuacaoNova = (int)obj2;
            String query = "CALL somarPontuacao(?, ?)"; // Chama a procedure do BD
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nick);
            statement.setInt(2, pontuacaoNova);
            statement.execute();
        }
    }

    @Override
    public boolean existe(Object obj) throws Exception {
        if (obj!=null && obj instanceof String){
            String nome = (String)obj;
            String query = "SELECT COUNT(*) FROM usuario WHERE nome = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Retorna true se já existe um usuário com o mesmo nome
            }
        }
        

        return false; // Caso ocorra algum problema na consulta
    }

    public Usuario recuperar(String nome) throws Exception{
        String query = "SELECT * FROM usuario WHERE nome = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nome);
        ResultSet resultSet = statement.executeQuery();

        // Verifica se houve retorno
        if(resultSet.next()){
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setTipo(resultSet.getInt("tipo"));
            return usuario;           
        }
        // Se não houver retorna null
        return null;
    }
    
    @Override
    public boolean excluir(Object obj) throws Exception {
        String nickname = (String)obj;
        String query = "DELETE FROM usuario WHERE nome = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nickname);
        int rowsAffected = statement.executeUpdate();

        return rowsAffected > 0; // Retorna true se alguma linha foi afetada (usuário excluído com sucesso)
    }

    public boolean loginUsuario(String nome, String senha) throws Exception{
        String query = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";

        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, nome);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery(); 
            return resultSet.next(); // Retorna true
        }
        catch(SQLException e){
            e.printStackTrace(); // Exibe o erro de conexão do BD no output
        }
        catch(Exception e){
            e.printStackTrace(); // Exibe o erro 
        }
        return false;
    }
    
    // Método para retornar os usuários do tipo 2
    public ArrayList<Usuario> getUsuariosTipo2() {
        ArrayList<Usuario> usuariosTipo2 = new ArrayList<>();

        try {
            // Conexão com o banco de dados (supondo que já esteja configurada)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo_da_forca?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=America/Sao_Paulo", "root", "");
            // Criação da consulta SQL
            String query = "SELECT id, nome, pontuacao FROM usuario ORDER BY pontuacao DESC";
            // Criação do statement
            PreparedStatement statement = connection.prepareStatement(query);
            // Execução da consulta
            ResultSet resultSet = statement.executeQuery(query);

            // Iteração pelos resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int pontuacao = resultSet.getInt("pontuacao");

                // Criação de um objeto Usuario com os dados retornados
                Usuario usuario = new Usuario(id, nome, pontuacao);

                // Adição do usuário à lista de usuários do tipo 2
                usuariosTipo2.add(usuario);
            }

            // Fechamento das conexões
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuariosTipo2;
    }
    
}