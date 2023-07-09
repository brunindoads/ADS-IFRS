package DAO;

import Modelo.Palavra;
//import Modelo.Usuario;
//import static java.lang.Math.random;
//import static java.lang.StrictMath.random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;


// @author Robson Rosa

public class PalavraDAO implements DAO{
    private final Connection connection;
    
    // Puxa a conexão com o BD
    public PalavraDAO(Connection connection){
        this.connection = connection;
    }
    
    public ArrayList<String> recuperar(int id) throws Exception {
        String query = "SELECT * FROM palavra WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        ArrayList<String> letras = new ArrayList<>();

        // Verifica se houve retorno
        while (resultSet.next()) {
            String palavra = resultSet.getString("palavra");
            for (int i = 0; i < palavra.length(); i++) {
                letras.add(Character.toString(palavra.charAt(i)));
            }
        }

        // Se não houver retorna null
        return letras;
    }
    
    public String recuperarDificuldade(int id) throws Exception {
        String query = "SELECT dificuldade FROM palavra WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        String dificuldade = null;

        // Verifica se houve retorno
        if (resultSet.next()) {
            dificuldade = resultSet.getString("dificuldade");
        }

        // Se não houver retorno, dificuldade será null
        return dificuldade;
    }
    
        public String recuperarDica(int id) throws Exception {
        String query = "SELECT dica FROM palavra WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        String dica = null;

        // Verifica se houve retorno
        if (resultSet.next()) {
            dica = resultSet.getString("dica");
        }

        // Se não houver retorno, dificuldade será null
        return dica;
    }
    
    public int getIdAleatorio() throws Exception{ // Retorna um ID aleatório para escolher a palavra que inicia o jogo
        try{    
            String sql = "SELECT MAX(id) FROM palavra";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            String sql2 = "SELECT MIN(id) FROM palavra";
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            ResultSet resultSet2 = statement2.executeQuery();

            if (resultSet.next() && resultSet2.next()) {
                int maxId = resultSet.getInt(1);
                int minId = resultSet2.getInt(1);
                // Gera um número aleatório entre minId e maxId
                Random random = new Random();
                int idAleatorio = random.nextInt(maxId - minId + 1) + 301;
                return idAleatorio;
            }
        }catch(SQLException e){
            e.printStackTrace(); // Exibe o erro de conexão do BD no output
        }catch(Exception e){
            e.printStackTrace(); // Exibe o erro 
        }
            return 0;
    }

    public boolean substituirPorLetra(ArrayList<String> letras, ArrayList<String> tracos, String letra) {
        String letraLowerCase = letra.toLowerCase(); // Converte a letra para minúscula
        boolean trocaFeita = false; // Variável para indicar se houve troca

        for (int i = 0; i < letras.size(); i++) {
            String elemento = letras.get(i).toLowerCase(); // Converte o elemento para minúscula
            if (elemento.equals(letraLowerCase)) {
                tracos.set(i, letra); // Substitui o valor correspondente em tracos pela letra
                trocaFeita = true; // Define a variável como true, indicando que houve troca
            }
        }

        return trocaFeita; // Retorna o valor indicando se houve troca ou não
    }
    
    public boolean ganhou(ArrayList<String> array1, ArrayList<String> array2) {
        // Verifica se os arrays têm tamanhos diferentes
        if (array1.size() != array2.size()) {
            return false;
        }

        // Compara cada elemento dos arrays, ignorando o caso
        for (int i = 0; i < array1.size(); i++) {
            if (!array1.get(i).equalsIgnoreCase(array2.get(i))) {
                return false; // Se um elemento for diferente, retorna falso
            }
        }

        return true; // Se todos os elementos forem iguais, retorna verdadeiro
    }
    
    

    @Override
    public boolean existe(Object obj) throws Exception {
        if (obj!=null && obj instanceof String){
            String palavra = (String)obj;
            String query = "SELECT COUNT(*) FROM palavra WHERE palavra = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, palavra);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Retorna true se já existe a palavra
            }
        }
        

        return false; // Caso ocorra algum problema na consulta
    }

    @Override
    public void inserir(Object obj) throws Exception {
        if (obj!=null && obj instanceof Palavra){
            Palavra palavraCadastrada = (Palavra)obj;
            String query = "INSERT INTO palavra (palavra, dificuldade, dica) VALUES (?, ?, ?)"; // Query para inserir uma nova palavra
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, palavraCadastrada.getPalavra());
            statement.setString(2, palavraCadastrada.getDificuldade().getDescricao());
            statement.setString(3, palavraCadastrada.getDica());
            statement.executeUpdate();
        }
        
    } 

    @Override
    public void alterar(Object obj1, Object obj2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(Object obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}