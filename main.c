#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <locale.h> // Valida��o da acentua��o e caracteres especiais.

// Inclus�o das fun��es.
#include "bubblesort.h"
#include "selectionsort.h"
#include "binarysearch.h"
#include "linearsearch.h"
#include "dataset.h"

// Tamanhos dos conjuntos de dados para ordena��o.
#define SIZE1 100
#define SIZE2 1000
#define SIZE3 10000
#define SIZE4 100000

// Tamanhos dos conjuntos de dados para busca.
#define SIZE5 350000
#define SIZE6 3500000
#define SIZE7 35000000
#define SIZE8 350000000

 // Inicia cada array para cada conjunto de dados.
int* data_1;
int* data_2;
int* data_3;
int* data_4;
int* data_5;
int* data_6;
int* data_7;
int* data_8;
  
// Contador para quantidade de rodadas que o c�digo deve ter.
int count = 0; 

int main(int argc, char *argv[])
{
  setlocale(LC_ALL, "Portuguese"); // Valida��o da acentua��o e caracteres especiais.
  
  printf("Gerando arquivo CSV com os dados. Por favor, aguarde!");
  
// Aloca��o de mem�ria para garantir o trabalho com grandes dados.
  data_1 = (int*)malloc(SIZE1*sizeof(int));
  data_2 = (int*)malloc(SIZE2*sizeof(int));
  data_3 = (int*)malloc(SIZE3*sizeof(int));
  data_4 = (int*)malloc(SIZE4*sizeof(int));
  data_5 = (int*)malloc(SIZE5*sizeof(int));
  data_6 = (int*)malloc(SIZE6*sizeof(int));
  data_7 = (int*)malloc(SIZE7*sizeof(int));
  data_8 = (int*)malloc(SIZE8*sizeof(int));
  
  // Verifica��o da aloca��o.
  if (data_1 == NULL || data_2 == NULL || data_3 == NULL || data_4 == NULL || data_5 == NULL || data_6 == NULL || data_7 == NULL || data_8 == NULL) {
        printf("\nErro na aloca��o de mem�ria. Execute o programa novamente.\n");
        return 1;
  }
  
  FILE *file = fopen("dados.csv", "w"); // Abre o arquivo para escrita.

  if (file == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        return 1;
  }

  freopen("dados.csv", "w", stdout); // Redireciona a sa�da padr�o para o arquivo.
  
  while(count != 1){
              
  // Controle das rodadas.
  printf("Rodada de numero %d.\n\n", count);
  
  // Cabe�alho do CSV.
  printf("ALGORITMO;DATA_SET;SEGUNDOS\n");
  
  generateData(data_1, SIZE1); // Gera��o do conjunto de dados 1.
  generateData(data_2, SIZE2); // Gera��o do conjunto de dados 2.
  generateData(data_3, SIZE3); // Gera��o do conjunto de dados 3.
  generateData(data_4, SIZE4); // Gera��o do conjunto de dados 4.
  
  timeSelectionSort(data_1, SIZE1, 1); // Chama a fun��o de ordena��o para conjunto de dados 1.
  timeSelectionSort(data_2, SIZE2, 2); // Chama a fun��o de ordena��o para conjunto de dados 2.
  timeSelectionSort(data_3, SIZE3, 3); // Chama a fun��o de ordena��o para conjunto de dados 3.
  timeSelectionSort(data_4, SIZE4, 4); // Chama a fun��o de ordena��o para conjunto de dados 4.
  
  generateData(data_1, SIZE1); // Gera��o do conjunto de dados 1.
  generateData(data_2, SIZE2); // Gera��o do conjunto de dados 2.
  generateData(data_3, SIZE3); // Gera��o do conjunto de dados 3.
  generateData(data_4, SIZE4); // Gera��o do conjunto de dados 4.
    
  timeBubbleSort(data_1, SIZE1, 1); // Chama a fun��o de ordena��o para conjunto de dados 1.
  timeBubbleSort(data_2, SIZE2, 2); // Chama a fun��o de ordena��o para conjunto de dados 2.
  timeBubbleSort(data_3, SIZE3, 3); // Chama a fun��o de ordena��o para conjunto de dados 3.
  timeBubbleSort(data_4, SIZE4, 4); // Chama a fun��o de ordena��o para conjunto de dados 4.
  
  // In�co dos algoritmos de busca. Os dados j� gerados ordenadamente de 1 at� SIZE - 1.
  
  generateDataForSearch(data_5, SIZE5);
  generateDataForSearch(data_6, SIZE6);
  generateDataForSearch(data_7, SIZE7);
  generateDataForSearch(data_8, SIZE8);
  
  timeBinarySearch(data_5, SIZE5, SIZE5 - 1, 1); // Chama a fun��o de busca para conjunto de dados 1.  
  timeBinarySearch(data_6, SIZE6, SIZE6 - 1, 2); // Chama a fun��o de busca para conjunto de dados 2.
  timeBinarySearch(data_7, SIZE7, SIZE7 - 1, 3); // Chama a fun��o de busca para conjunto de dados 3.
  timeBinarySearch(data_8, SIZE8, SIZE8 - 1, 4); // Chama a fun��o de busca para conjunto de dados 4.
  
  timeLinearSearch(data_5, SIZE5, SIZE5 - 1, 1); // Chama a fun��o de busca para conjunto de dados 1.  
  timeLinearSearch(data_6, SIZE6, SIZE6 - 2, 2); // Chama a fun��o de busca para conjunto de dados 2.
  timeLinearSearch(data_7, SIZE7, SIZE7 - 3, 3); // Chama a fun��o de busca para conjunto de dados 3.
  timeLinearSearch(data_8, SIZE8, SIZE8 - 4, 4); // Chama a fun��o de busca para conjunto de dados 4.
  
  count++;
  
  printf("\n");
  } // Encerra o While.
  
  // Libera a mem�ria.
  free(data_1);
  free(data_2);
  free(data_3);
  free(data_4);
  free(data_5);
  free(data_6);
  free(data_7);
  free(data_8);
  
  fclose(file); // Fecha o arquivo.
  freopen("CON", "w", stdout); // Retorna a sa�da padr�o para o console.
  printf("Arquivo CSV gerado com sucesso!\n");
  system("start dados.csv"); // Abre o arquivo gerado.
  
  system("PAUSE");	
  return 0;
}

