/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VisaoConsole;

import DAO.PalavraDAO;
import DAO.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author santo
 */
public class TelaJogar extends javax.swing.JFrame {

    /**
     * Creates new form TelaJogar
     */
    
    private int idAleatorio, i, tentativas = 5, pontuacao = 0;
    private ArrayList<String> letras; // Criada para armazenar as letras da palavra escolhida
    private ArrayList<String> tracos; // Criado para exibir os traços que serão substituídos
    private ArrayList<String> letrasUsadas = new ArrayList<>(); // Criado para exibir as letras usadas
    private StringBuilder stringBuilder = new StringBuilder(); // Constrói a String para o jogo
    private String letra = null; 
    private String dificuldade = null;
    private String dica = null;
    private final String nickname;
    
    
    public TelaJogar(String nick) throws SQLException {
        nickname = nick;
        System.out.println(nickname);
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo_da_forca?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=America/Sao_Paulo", "root", "");
        PalavraDAO palavraDAO = new PalavraDAO(connection);
        
        // Método que retorna o id aleatório
        try {
            idAleatorio = palavraDAO.getIdAleatorio();
            System.out.println("ID aleatório: " + idAleatorio);
        } catch (Exception e) {
            // Lida com a exceção SQLException aqui
            e.printStackTrace();
        }
        // Método que retorna a palavra aleatória
        try {
            letras = palavraDAO.recuperar(idAleatorio);
            System.out.println("Palavra recuperado = " + letras);
            tracos = new ArrayList<>(); // Inicializa o ArrayList tracos
            while(i<letras.size()){
                tracos.add("_ ");
                i++;
            }
        } catch (Exception e) {
            // Lida com a exceção SQLException aqui
            e.printStackTrace();
        }
        // Lê o arraylist para transformar em String
        for (String traco : tracos) {
            stringBuilder.append(traco);
        }
        
        // Inicia os components do JFrame
        initComponents();
        
        // Mostra as tentativas atualizadas
        labelTentativas.setText(String.valueOf(tentativas));
        // Ativa o enter para o btEnviar
        textLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btEnviar.doClick(); // Aciona o botão "Enviar"
            }
        });

        try {
            // Pega a dificuldade da palavra para calcular a pontuação
            dificuldade = palavraDAO.recuperarDificuldade(idAleatorio);
            dica = palavraDAO.recuperarDica(idAleatorio);
            labelDificuldade.setText(dificuldade);
            labelDica.setText(dica);
        
            // Faz o cálculo da pontuação
            if (dificuldade.equals("Facil")) {
                labelPontuacao.setText("10 pontos + Tentativas Restantes");
            } else if (dificuldade.equals("Medio")) {
                labelPontuacao.setText("15 pontos + Tentativas Restantes");
            } else {
                labelPontuacao.setText("20 pontos + Tentativas Restantes");
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaJogar.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Adicionar o DocumentFilter ao textLetra para que não possa digitar mais de um caracter e nem caracteres diferente de a-z
        AbstractDocument doc = (AbstractDocument) textLetra.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                int newLength = fb.getDocument().getLength() - length + text.length();
                // Valida se o texto inserido é uma letra e tem só um caracter
                if (text.matches("[a-zA-Z]") && newLength <= 1) {
                    // Permite a substituição do texto
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelPalavraSecreta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelTentativas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textLetra = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        btDesistir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelPontuacao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelDificuldade = new javax.swing.JLabel();
        labelLetrasUsadas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelDica = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        labelPalavraSecreta.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelPalavraSecreta.setText(stringBuilder.toString());

        jLabel1.setText("Nº Tentativas:");

        labelTentativas.setText("0");

        jLabel2.setText("Digite uma letra:");

        textLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLetraActionPerformed(evt);
            }
        });

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        btDesistir.setText("Voltar");
        btDesistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesistirActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor da Palavra:");

        labelPontuacao.setText("0");

        jLabel4.setText("Dificuldade:");

        labelLetrasUsadas.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N

        jLabel5.setText("Dica:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btDesistir)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPalavraSecreta)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTentativas)
                                    .addComponent(labelPontuacao)
                                    .addComponent(labelDificuldade)
                                    .addComponent(labelDica))))
                        .addGap(157, 157, 157))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(labelLetrasUsadas)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btDesistir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(labelLetrasUsadas)
                .addGap(18, 18, 18)
                .addComponent(labelPalavraSecreta)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelDica))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelDificuldade))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelPontuacao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelTentativas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btEnviar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDesistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesistirActionPerformed
        dispose(); // Joga a tela fora
    }//GEN-LAST:event_btDesistirActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        letra = textLetra.getText(); // Obter a letra digitada pelo usuário  
        Connection connection;
        try {
            // Faz a conexão com o banco
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo_da_forca?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=America/Sao_Paulo", "root", "");
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            PalavraDAO palavraDAO = new PalavraDAO(connection);
            
            // Controla se o jogo deve continuar ou não
            if (tentativas > 1) {
                // Controla se o usuário digitou alguma letra
                if (!letra.equals("")) {
                    // Controla se a letra já foi usada
                    if (!letrasUsadas.contains(letra)) {  // Verifica se a letra já foi usada
                        letrasUsadas.add(letra);  // Adiciona a letra às letras usadas

                        // Chamar a função substituirPorLetra para atualizar tracos
                        if (palavraDAO.substituirPorLetra(letras, tracos, letra)) {
                            // Atualizar o texto do labelPalavraSecreta
                            StringBuilder stringBuilder = new StringBuilder();
                            for (String elemento : tracos) {
                                stringBuilder.append(elemento.toUpperCase());
                            }
                            labelPalavraSecreta.setText(stringBuilder.toString());

                            if (palavraDAO.ganhou(tracos, letras)) {
                                // Controla a pontuação pela dificuldade da palavra
                                if (dificuldade.equals("Facil")) {
                                    pontuacao = tentativas + 10;
                                } else if (dificuldade.equals("Medio")) {
                                    pontuacao = tentativas + 15;
                                } else {
                                    pontuacao = tentativas + 20;
                                }
                                // Chama o método para alterar a pontuação
                                System.out.println(nickname);
                                usuarioDAO.alterar(nickname, pontuacao);

                                // Faz o OK do dialog voltar pro menu 
                                Object[] options = {"Menu Inicial"};
                                int result = JOptionPane.showOptionDialog(this, "Parabéns!!!\nVocê venceu e fez " + pontuacao + " pontos.", "Vitória", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
                                if (result == JOptionPane.OK_OPTION) {
                                    dispose();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Tente novamente!");
                            tentativas--;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Letra já utilizada!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Digite uma letra!");
                }
            } else {
                // Atualiza tentativas pra 0
                labelTentativas.setText("0");
                // Faz o OK do dialog voltar pro menu 
                Object[] options = {"Menu Inicial"};
                int result = JOptionPane.showOptionDialog(this, "Suas tentativas acabaram 💔", "Derrota", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
                if (result == JOptionPane.OK_OPTION) {
                    dispose(); // Joga a tela fora
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaJogar.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Atualiza as letras usadas
        labelLetrasUsadas.setText(String.valueOf(letrasUsadas).toUpperCase());
        // Muda o texto para quantidade de tentativas atual
        labelTentativas.setText(String.valueOf(tentativas));
        // Apaga a letra do textLetra para o usuário inserir a nova letra TODO: não está alterando
        //textLetra.setText(null);
    }//GEN-LAST:event_btEnviarActionPerformed

    private void textLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLetraActionPerformed
        // Criado sem querer
    }//GEN-LAST:event_textLetraActionPerformed
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDesistir;
    private javax.swing.JButton btEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDica;
    private javax.swing.JLabel labelDificuldade;
    private javax.swing.JLabel labelLetrasUsadas;
    private javax.swing.JLabel labelPalavraSecreta;
    private javax.swing.JLabel labelPontuacao;
    private javax.swing.JLabel labelTentativas;
    public javax.swing.JTextField textLetra;
    // End of variables declaration//GEN-END:variables
}
