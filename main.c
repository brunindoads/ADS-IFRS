#include <stdio.h>
#include <stdlib.h>
#include <locale.h> //Validação da acentuação e caracteres especiais.

//Inclusão das funções.
#include "bubblesort.h"
#include "selectionsort.h"
#include "dataset.h"

//Tamanhos dos conjuntos de dados.
#define SIZE1 10000
#define SIZE2 20000
#define SIZE3 30000
#define SIZE4 40000

int main(int argc, char *argv[])
{
  setlocale(LC_ALL, "Portuguese"); // Validação da acentuação e caracteres especiais.
  
  printf("Gerando arquivo CSV com os dados. Por favor, aguarde!\n");
   
  FILE *file = fopen("dados.csv", "w"); // Abre o arquivo para escrita.

  if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
  }

  freopen("dados.csv", "w", stdout); // Redireciona a saída padrão para o arquivo.
  
  //printf("Avaliacao 2 - Estrutura de Dados\n\nBruno Santos, Lucas Henrique e Matheus Freitas\n\n");
  printf("ALGORITMO;DATA_SET;SEGUNDOS\n");
  
  //Inicia cada array para cada conjunto de dados.
  int data_1[SIZE1];
  int data_2[SIZE2];
  int data_3[SIZE3];
  int data_4[SIZE4];
  
  generateData(data_1, SIZE1); // Geração do conjunto de dados 1.
  generateData(data_2, SIZE2); // Geração do conjunto de dados 2.
  generateData(data_3, SIZE3); // Geração do conjunto de dados 3.
  generateData(data_4, SIZE4); // Geração do conjunto de dados 4.
  
  timeSelectionSort(data_1, SIZE1, 1); // Chama a função de ordenação para conjunto de dados 1.
  timeSelectionSort(data_2, SIZE2, 2); // Chama a função de ordenação para conjunto de dados 2.
  timeSelectionSort(data_3, SIZE3, 3); // Chama a função de ordenação para conjunto de dados 3.
  timeSelectionSort(data_4, SIZE4, 4); // Chama a função de ordenação para conjunto de dados 4.
  
  generateData(data_1, SIZE1); // Geração do conjunto de dados 1.
  generateData(data_2, SIZE2); // Geração do conjunto de dados 2.
  generateData(data_3, SIZE3); // Geração do conjunto de dados 3.
  generateData(data_4, SIZE4); // Geração do conjunto de dados 4.
    
  timeBubbleSort(data_1, SIZE1, 1); // Chama a função de ordenação para conjunto de dados 1.
  timeBubbleSort(data_2, SIZE2, 2); // Chama a função de ordenação para conjunto de dados 2.
  timeBubbleSort(data_3, SIZE3, 3); // Chama a função de ordenação para conjunto de dados 3.
  timeBubbleSort(data_4, SIZE4, 4); // Chama a função de ordenação para conjunto de dados 4.

  fclose(file);
  freopen("CON", "w", stdout);
  printf("Arquivo CSV gerado com sucesso!\n");
  system("start dados.csv");
  
  system("PAUSE");	
  return 0;
}

