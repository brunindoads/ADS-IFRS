-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para jogo_da_forca
CREATE DATABASE IF NOT EXISTS `jogo_da_forca` /*!40100 DEFAULT CHARACTER SET armscii8 COLLATE armscii8_bin */;
USE `jogo_da_forca`;

-- Copiando estrutura para tabela jogo_da_forca.palavra
CREATE TABLE IF NOT EXISTS `palavra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `palavra` varchar(255) DEFAULT NULL,
  `dificuldade` varchar(50) DEFAULT NULL,
  `dica` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Copiando dados para a tabela jogo_da_forca.palavra: ~145 rows (aproximadamente)
INSERT INTO `palavra` (`id`, `palavra`, `dificuldade`, `dica`) VALUES
	(301, 'ABACAXI', 'Facil', 'Fruta tropical'),
	(302, 'AMOR', 'Facil', 'Sentimento'),
	(303, 'BICICLETA', 'Medio', 'Meio de transporte'),
	(304, 'CACHORRO', 'Facil', 'Animal de estimacao'),
	(305, 'DENTE', 'Facil', 'Parte da boca'),
	(306, 'ESCADA', 'Medio', 'Estrutura para subir'),
	(307, 'FELICIDADE', 'Medio', 'Estado emocional'),
	(308, 'GATO', 'Facil', 'Animal domestico'),
	(309, 'HOTEL', 'Facil', 'Estabelecimento de hospedagem'),
	(310, 'INVERNO', 'Medio', 'Estacao do ano'),
	(311, 'JANELA', 'Facil', 'Abertura em uma parede'),
	(312, 'LIVRO', 'Facil', 'Obra escrita'),
	(313, 'MACA', 'Facil', 'Fruta'),
	(314, 'NOITE', 'Facil', 'Periodo escuro'),
	(315, 'OURO', 'Facil', 'Metal precioso'),
	(316, 'PATO', 'Facil', 'Palavra nao encontrada'),
	(317, 'QUEIJO', 'Facil', 'Produto lacteo'),
	(318, 'RATO', 'Facil', 'Animal'),
	(319, 'SOL', 'Facil', 'Astro'),
	(320, 'TIGRE', 'Facil', 'Animal selvagem'),
	(321, 'UVA', 'Facil', 'Fruta'),
	(322, 'VENTO', 'Facil', 'Sopra'),
	(323, 'XADREZ', 'Medio', 'Jogo'),
	(324, 'ZEBRA', 'Facil', 'Animal listrado'),
	(325, 'AVIAO', 'Facil', 'Meio de transporte'),
	(326, 'BORBOLETA', 'Facil', 'Inseto colorido'),
	(327, 'CAMA', 'Facil', 'Movel para dormir'),
	(328, 'DANCA', 'Facil', 'Expressao artistica'),
	(329, 'ELEFANTE', 'Facil', 'Animal terrestre'),
	(330, 'FOGO', 'Facil', 'Elemento de combustao'),
	(331, 'GIRAFA', 'Facil', 'Animal de pescoco longo'),
	(332, 'HIPOPOTAMO', 'Medio', 'Animal aquatico'),
	(333, 'IGREJA', 'Facil', 'Local de culto religioso'),
	(334, 'JACARE', 'Facil', 'Reptil aquatico'),
	(335, 'KIWI', 'Facil', 'Fruta exotica'),
	(336, 'LEAO', 'Facil', 'Animal selvagem'),
	(337, 'MONTANHA', 'Medio', 'Formacao geografica'),
	(338, 'NAVIO', 'Facil', 'Embarcacao maritima'),
	(339, 'OCULOS', 'Facil', 'Acessorio para visao'),
	(340, 'PAO', 'Facil', 'Alimento'),
	(341, 'QUARTO', 'Facil', 'Compartimento de uma casa'),
	(342, 'RUA', 'Facil', 'Estrada'),
	(343, 'SAPO', 'Facil', 'Animal'),
	(344, 'TESOURO', 'Medio', 'Pirata'),
	(345, 'UNICORNIO', 'Medio', 'Fantasia'),
	(346, 'VELA', 'Facil', 'Objeto que produz luz'),
	(347, 'XICARA', 'Facil', 'Recipiente para bebidas'),
	(348, 'ZUMBIDO', 'Facil', 'Barulho chato'),
	(349, 'ARVORE', 'Facil', 'Planta'),
	(350, 'BOLA', 'Facil', 'Objeto redondo'),
	(351, 'CADEIRA', 'Facil', 'Movel para sentar'),
	(352, 'DRAGAO', 'Medio', 'Criatura mitica'),
	(353, 'ESCOLA', 'Facil', 'Instituicao educacional'),
	(354, 'FADA', 'Facil', 'Ser magico'),
	(355, 'GELO', 'Facil', 'Agua congelada'),
	(356, 'HORA', 'Facil', 'Unidade de tempo'),
	(357, 'ILHA', 'Facil', 'Massa de terra cercada de agua'),
	(358, 'JARDIM', 'Facil', 'Area verde com plantas'),
	(359, 'LOBO', 'Facil', 'Animal selvagem'),
	(360, 'MUSICA', 'Facil', 'Expressao sonora'),
	(361, 'NUVEM', 'Facil', 'Massa de vapor de agua'),
	(362, 'ONDA', 'Facil', 'Movimento em uma superficie liquida'),
	(363, 'PINCEL', 'Facil', 'Texugo'),
	(364, 'QUEIMADURA', 'Medio', 'Lesao na pele'),
	(365, 'RELOGIO', 'Facil', 'Instrumento de medicao do tempo'),
	(366, 'SEMENTE', 'Facil', 'Plantar'),
	(367, 'TATUAGEM', 'Facil', 'Tinta'),
	(368, 'URSO', 'Facil', 'Animal selvagem'),
	(369, 'VIOLAO', 'Facil', 'Instrumento musical'),
	(370, 'XALE', 'Facil', 'Acessorio de vestimenta'),
	(371, 'ZOOLOGICO', 'Medio', 'Animais'),
	(372, 'ABRACO', 'Facil', 'Gesto de carinho'),
	(373, 'BEBIDA', 'Facil', 'Liquido para consumo'),
	(374, 'CACHECOL', 'Facil', 'Acessorio de inverno'),
	(375, 'DIAMANTE', 'Facil', 'Pedra preciosa'),
	(376, 'ESTRELA', 'Facil', 'Corpo celeste'),
	(377, 'FUTEBOL', 'Facil', 'Esporte com bola'),
	(378, 'GAVETA', 'Facil', 'Compartimento de armazenamento'),
	(379, 'HELICOPTERO', 'Medio', 'Meio de transporte aereo'),
	(380, 'INJECAO', 'Medio', 'Administracao de medicamento'),
	(381, 'JORNAL', 'Facil', 'Publicacao impressa'),
	(382, 'LAGRIMA', 'Facil', 'Gota de emocao'),
	(383, 'MOCHILA', 'Facil', 'Saco para carregar objetos'),
	(384, 'NUVEM', 'Facil', 'Massa de vapor de agua'),
	(385, 'OCEANO', 'Facil', 'Grande massa de agua'),
	(386, 'PISCINA', 'Facil', 'Reservatorio de agua'),
	(387, 'QUADRO', 'Facil', 'Pintura'),
	(388, 'REDE', 'Facil', 'Internet'),
	(389, 'SORRISO', 'Facil', 'Felicidade'),
	(390, 'TARTARUGA', 'Facil', 'Lento'),
	(391, 'UNIVERSO', 'Medio', 'Conjunto de tudo que existe'),
	(392, 'VASSOURA', 'Facil', 'Utensilio de limpeza'),
	(393, 'XICARA', 'Facil', 'Recipiente para bebidas'),
	(394, 'YOGA', 'Facil', 'Exercicio'),
	(395, 'ZIPER', 'Facil', 'Fecho'),
	(396, 'ABACATE', 'Facil', 'Fruta'),
	(397, 'BALAO', 'Facil', 'Objeto inflavel'),
	(398, 'CAMISA', 'Facil', 'Peca de roupa'),
	(399, 'DINHEIRO', 'Facil', 'Meio de troca'),
	(400, 'ELETRICIDADE', 'Medio', 'Forma de energia'),
	(401, 'ACRIMONIA', 'Dificil', 'Rancor'),
	(402, 'BIZANTINO', 'Dificil', 'Imperio'),
	(403, 'CIRCUNSPECCAO', 'Dificil', 'Prudencia'),
	(404, 'DESIDRATAR', 'Dificil', 'Remover a agua'),
	(405, 'EFIGIE', 'Dificil', 'Imagem'),
	(406, 'FORTUITO', 'Dificil', 'Acidental'),
	(407, 'GARGULA', 'Dificil', 'Escultura ornamentada'),
	(408, 'HIATO', 'Dificil', 'Intervalo'),
	(409, 'INCUMBENCIA', 'Dificil', 'Tarefa'),
	(410, 'JARGAO', 'Dificil', 'Linguagem tecnica'),
	(411, 'LUDIBRIAR', 'Dificil', 'Enganar'),
	(412, 'MAGNANIMO', 'Dificil', 'Generoso'),
	(413, 'NENIA', 'Dificil', 'Cancao funebre'),
	(414, 'OBSTINADO', 'Dificil', 'Determinado'),
	(415, 'PACIENCIA', 'Dificil', 'Virtude'),
	(416, 'QUOTIDIANO', 'Dificil', 'Dia a dia'),
	(417, 'RAZAO', 'Dificil', 'Racionalidade'),
	(418, 'SARCOFAGO', 'Dificil', 'Mumia'),
	(419, 'TEMPERO', 'Dificil', 'Substancia para realcar o sabor'),
	(423, 'XADREZISTA', 'Dificil', 'Jogador'),
	(424, 'ZOMBARIA', 'Dificil', 'Zoacao'),
	(425, 'AMBITO', 'Dificil', 'Ambito'),
	(426, 'BONUS', 'Dificil', 'Beneficio extra'),
	(427, 'CATAFALCO', 'Dificil', 'Estrutura funeraria'),
	(428, 'DISSERTACAO', 'Dificil', 'Texto academico'),
	(429, 'EFICACIA', 'Dificil', 'Eficacia'),
	(430, 'FALACIA', 'Dificil', 'Argumento invalido'),
	(431, 'GENTILEZA', 'Dificil', 'Atitude educada'),
	(432, 'HIPOTETICO', 'Dificil', 'Suposicao'),
	(433, 'INTIMO', 'Dificil', 'Proximo afetivamente'),
	(434, 'JACENTE', 'Dificil', 'Deitado'),
	(435, 'LABIRINTICO', 'Dificil', 'Complexo e confuso'),
	(436, 'MAXIMA', 'Dificil', 'Principio ou regra'),
	(437, 'NUCLEO', 'Dificil', 'Centro'),
	(438, 'OBSTRUCAO', 'Dificil', 'Bloqueio'),
	(439, 'PAVIMENTO', 'Dificil', 'Rua'),
	(441, 'RAQUITICO', 'Dificil', 'Magro'),
	(442, 'SINTAXE', 'Dificil', 'Ortografia'),
	(443, 'TUNEL', 'Dificil', 'Passagem subterranea'),
	(444, 'UTILITARIO', 'Dificil', 'Tipo de veiculo'),
	(445, 'VICIO', 'Dificil', 'Mania'),
	(447, 'XAROPE', 'Dificil', 'Medicamento liquido'),
	(448, 'ZANGAO', 'Dificil', 'Inseto'),
	(449, 'ARROZ', 'Facil', ''),
	(450, 'ALFACE', 'Facil', 'S');

-- Copiando estrutura para procedure jogo_da_forca.somarPontuacao
DELIMITER //
CREATE PROCEDURE `somarPontuacao`(IN nomeParam VARCHAR(255), IN pontuacaoNova INT)
BEGIN
    UPDATE usuario SET pontuacao = pontuacao + pontuacaoNova WHERE nome = nomeParam;
END//
DELIMITER ;

-- Copiando estrutura para tabela jogo_da_forca.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `SENHA` varchar(50) NOT NULL DEFAULT '',
  `TIPO` int(11) NOT NULL,
  `PONTUACAO` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Copiando dados para a tabela jogo_da_forca.usuario: ~55 rows (aproximadamente)
INSERT INTO `usuario` (`ID`, `NOME`, `SENHA`, `TIPO`, `PONTUACAO`) VALUES
	(1, 'bruno', '123', 1, 34),
	(2, 'robson', '1234', 2, 0),
	(3, 'joao', '789', 1, 0),
	(4, '', '', 2, 0),
	(5, 'karen', 'karen', 2, 0),
	(6, 'fernando', '123', 2, 0),
	(7, 'joaosilva', '', 2, 0),
	(8, 'mariasilva', '', 2, 0),
	(9, 'pedroalmeida', '', 2, 0),
	(10, 'anacosta', '', 2, 0),
	(11, 'luizpereira', '', 2, 0),
	(12, 'fernandaoliveira', '', 2, 0),
	(13, 'andresouza', '', 2, 0),
	(14, 'carolinarodrigues', '', 2, 0),
	(15, 'ricardoferreira', '', 2, 0),
	(16, 'marianabarbosa', '', 2, 0),
	(17, 'alexandrecardoso', '', 2, 0),
	(18, 'julianagomes', '', 2, 0),
	(19, 'gabrielsantos', '', 2, 0),
	(20, 'lauramendes', '', 2, 0),
	(21, 'brunolima', '', 2, 0),
	(22, 'camilacastro', '', 2, 0),
	(23, 'thiagorocha', '', 2, 0),
	(24, 'patriciafernandes', '', 2, 0),
	(25, 'rafaeltorres', '', 2, 0),
	(26, 'isabelanunes', '', 2, 0),
	(27, 'carlosmello', '', 2, 0),
	(28, 'vanessacarvalho', '', 2, 0),
	(29, 'lucasmartins', '', 2, 0),
	(30, 'renataoliveira', '', 2, 0),
	(32, 'leticiacosta', '', 2, 0),
	(33, 'marceloramos', '', 2, 0),
	(34, 'beatrizalves', '', 2, 0),
	(35, 'guilhermecarvalho', '', 2, 0),
	(36, 'amandapereira', '', 2, 0),
	(37, 'andreiarodrigues', '', 2, 0),
	(38, 'leandroferreira', '', 2, 0),
	(39, 'larissamendonca', '', 2, 0),
	(40, 'felipealmeida', '', 2, 0),
	(41, 'vivianasantos', '', 2, 0),
	(42, 'gustavocosta', '', 2, 0),
	(43, 'sandramelo', '', 2, 0),
	(44, 'paulosilveira', '', 2, 0),
	(45, 'isabellasilva', '', 2, 0),
	(46, 'viniciusrocha', '', 2, 0),
	(47, 'anapereira', '', 2, 0),
	(48, 'matheusoliveira', '', 2, 0),
	(49, 'gabrielarodrigues', '', 2, 0),
	(50, 'lucianacarvalho', '', 2, 0),
	(51, 'rafaelmendes', '', 2, 0),
	(52, 'fernandomelo', '', 2, 0),
	(53, 'elisabarbosa', '', 2, 0),
	(54, 'ricardorodrigues', '', 2, 0),
	(55, 'jessicasouza', '', 2, 0),
	(56, 'caioferreira', '', 2, 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
