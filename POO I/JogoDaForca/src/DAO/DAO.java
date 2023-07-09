
package DAO;

/**
 *
 * @author Robson Rosa
 */
interface DAO {
    public boolean existe(Object obj)throws Exception; // pesquisar
    
    public void inserir(Object obj)throws Exception; 
    
    public void alterar(Object obj1, Object obj2) throws Exception; // Altera pontuação
    
    public boolean excluir(Object obj) throws Exception;
}
