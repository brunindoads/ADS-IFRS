#include <time.h> //Contagem do tempo.
#include "linearsearch.h"
#include "dataset.h"

int linearSearch(int data[], int size, int value) {
    int i;
    
    for (i = 0; i < size; i++) {
        if (data[i] == value) {
            return i; // Retorna a posição quando o valor é encontrado.
        }
    }
    return -1; // Retorna -1 se não encontra o valor.
}

void timeLinearSearch(int data[], int size, int value_1, int value_2, int value_3, int value_4, int value_5, int value_6, int value_7, int value_8, int value_9, int value_10, int data_set){
    clock_t start, end; // Variáveis para controle de início e fim do tempo de execução.
    double cpu_time_used; // Variável para salvar o tempo de execução.
    start = clock(); // Inicia a contagem.
    
    // Faz 10 buscas de 10 valores diferente, mas ainda assim, o tempo é insignificante.
    int index_1 = linearSearch(data, size, value_1); // Faz a busca.
    int index_2 = linearSearch(data, size, value_2); // Faz a busca.
    int index_3 = linearSearch(data, size, value_3); // Faz a busca.
    int index_4 = linearSearch(data, size, value_4); // Faz a busca.
    int index_5 = linearSearch(data, size, value_5); // Faz a busca.
    int index_6 = linearSearch(data, size, value_6); // Faz a busca.
    int index_7 = linearSearch(data, size, value_7); // Faz a busca.
    int index_8 = linearSearch(data, size, value_8); // Faz a busca.
    int index_9 = linearSearch(data, size, value_9); // Faz a busca.
    int index_10 = linearSearch(data, size, value_10); // Faz a busca.
    
    end = clock(); // Finaliza a contagem.
    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC; // Faz o cálculo de quantos segundos.
    
    if(index_1 != -1 || index_2 != -1 || index_3 != -1 || index_4 != -1 || index_5 != -1 || index_6 != -1 || index_7 != -1 || index_8 != -1 || index_9 != -1 || index_10 != -1) printf("Linear Search;%d;%f\n", data_set, cpu_time_used); // Imprime na tela mostrando qual conjunto utilizado o tempo exigido para ordenação.
    else printf("Linear Search;%d;NULL\n", data_set);
}
