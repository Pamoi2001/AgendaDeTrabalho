O projeto de Gerenciamneto de Tarefas (AgendaDeTrabalho2) com Banco de Dados PostgreSQL:

Este projeto de gerenciamento de tarefas foi desenvolvido utilizando : Java, JavaServer Faces, PrimeFaces e banco de dados (PostgreSQL). 
O objetivo desse projeto é cadastrar, listar, editar e excluir tarefas, também marcar uma tarefa como concluída, utilizando um banco de dados para armazenar as informações.

O projeto possui as seguintes funcionalidades:

 Cadastro de Tarefa: Permite cadastrar novas atividades/tarefas com as informações: número, título, descição, prioridade e deadline.

 Listagem de Tarefas: Exibe uma tabela com todas as tarefas cadastradas, exibindo os campos de número, título, responsável e as ações(editar, excluir e concluir).

 Edição de Tarefas: Possui a capasidade de editar as informações de uma atividade/tarefa existente, possuindo título, descrição, responsável, prioridade e deadline.

 Exclusão de Tarefas: Exclui uma tarefa do sistema.

 Marcar Tarefa como concluída: permite marcar uma atividade/tarefa como concluída, mudando o status da atividade/tarefa.

Para executar o projeto em um ambiente local com banco de dados PostgreSQL:
Eclipse IDE (ou qualquer outra IDE) com suporte a Java e JSF.
 Servidor de aplicdação Java (Apache Tomcat, entre outros).
 Banco de dados PostgreSQL instalado e configurdo localmente.
Clone o repositório na máquina local.
 Abra o Eclipse e importe o projeto selecionando a opção "Importar projeto existente".
 Configure o servidor de aplicação Java no Eclipse.
 Quando a importação e a configuração do projeto concluir abra o arquivo src/main/resources/META-INF/persistence.xml e atualize as configurações de conexão
com o banco de dados PostgresSQL de acordo dom o seu ambiente.
 Ao iniciar o servidor de aplicação no Eclipse, o sistema será carregado e criará automaticamente as tabelas necessárias no banco de dados configurado.
 Abra um navegador na web e acesse o endereço http://localhost:8080/AgendaDeTrabalho2
 O sistema será carregado e então será possível começar a utilizar as funcionalidades de gerenciamento de ativividade/tarefas.
 http://localhost:8080/AgendaDeTrabalho2/CadastraTarefa.xhtml para a aba de cadastro de tarefas.
 use o http://localhost:8080/AgendaDeTrabalho2/ListagemTarefas.xhtml para a aba de listagem de tarefas.

 Obs:
 Tenha certeza de que tenha configurado corretamente todas as dependências, bibliotecas e drivers necessários para a conexão com o banco de dados PostgreSQL.
Além disso, verifique se o banco de dados PostgreSQL está em execução e acessível.
 Agora você está pronto para executar o projeto de gerenciamento de tarefas com banco de dados PostgreSQL localmente.