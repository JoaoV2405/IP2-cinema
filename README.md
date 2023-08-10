# [Projeto CineUrubu]

## Integrantes do grupo 
 * João Victor Mendonça Martins - mendoncajoao2323@gmail.com
 * Lucas Martins Siqueira da Silva - lucasmartinss2003@gmail.com
 * Thiago Diniz Cruz Ribeiro - thiago.diniz_ribeiro@hotmail.com
 * Daniel Tavares de Lima Marcelino - danieltavareslima72@gmail.com

## Descrição geral do projeto 
Esse projeto simula um sistema de administração de cinema. O administrador controla quais filmes estão em cartaz, os horários de exibição e as salas disponíveis. O funcionário do cinema é responsável pelas vendas dos ingressos, o cliente escolhe o filme desejado, o horário e o lugar disponível

## Requisitos do projeto
 * **REQ1** - Os usuários do sistema serão um administrador que controla quais filmes estarão em cartaz e um cliente responsável pela compra dos ingressos;
 * **REQ2** - O sistema deve permitir a consulta do histórico de ingressos comprados (filmes/sessões assistidos) por um cliente;
 * **REQ3** - O sistema deve armazenar os filmes disponíveis, horários das sessões e quantidade de ingressos disponíveis;
 * **REQ4** - O sistema deve analizar os assentos livres, assim como sua quantidade;
 * **REQ5** - O sistema deve permitir o gerenciamento (Create, Recover, Update e Delete - CRUD) de filmes, assim como acesso a quantidade de bilhetes vendidos para cada um em todo tempo de exibição;
* **REQ6** - O cliente deve escolher o tipo do ingresso (meia-entrada ou inteira) e sua idade deve ser compatível com a faixa etária do filme escolhido;
* **REQ7** - O sistema deve disponibilizar um relatório finanças, apresentando tanto a quantidade de vendas de cada filme quanto o total;
* **REQ8** - O sistema deve contar com diferentes opções de acessibilidade ao cliente, como ingressos especiais para cadeirantes;

## Cronograma de MVPs com seleção de requisitos
* **MVP1 - Cadastros** - [REQ1]: Cadastro do cliente;
* **MVP2 - Cadastros** - [REQ1,REQ5,REQ3]: Cadastro de filmes e sessões pelo admin;
* **MVP3 - Regras para cadastro do filme**-[REQ1, REQ3]: Filme deve ter título, sinopse, faixa etária, duração e gênero;
* **MVP4 - Regras para cadastro do sessão**-[REQ3,REQ5]:
  * Sessão deve ter filme e horário;
  * Sessões diferentes não podem ter o mesmo filme e horário, mas podem ter filmes iguais e horários diferentes e vice-versa;
* **MVP5 - Regras para compra do ingresso**-[REQ1,REQ3,REQ5,REQ8]:
  *  A idade do usuário deve ser igual ou maior a faixa etária do filme;
  *  A sessão escolhida deve ter cadeiras disponíveis;
  *  Horário da sessão deve ser depois que o horário local;
  *  O usuário deve escolher o tipo do ingresso (inteira ou meia-entrada);
  *  O usuário deve escolher se necessita de algum atendimento especial;
  *  Se o usuário não necessita de atendimento especial, ele não pode escolher o assento dedicado a pessoas com deficiencia
 * **MVP6 - Regras para geração de relatório de finanças**-[REQ1,REQ7]: Deve-se escolher um filme específico para verificar sua bilheteria ou solicitar o relatório de vendas gerais contendo todos os filmes;
