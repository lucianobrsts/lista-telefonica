## Lista Telefônica
> O projeto Lista Telefônica foi solicitado para servir de parâmentro de avaliação para os conhecimentos de preenchimento de uma vaga de desenvolvedor java na empresa Boavista Tecnologia. Seu proposito é cadastrar, listar, remover e atualizar contatos e usuários, gerar relatórios em pdf e xls e gerenciar o login de usuários dependencdo de sua permissão. 

#### Tecnologias utilizadas:

- Windows
- IDE Eclispe
- Java 8
- JSF
- Facelets
- Primefaces
- Ajax
- IReport
- Jasper Report
- Git
- GitHub
- Junit
- MySQL
- HIbernate
- JPA

#### Funcionalidade:

> O projeto tem como funcionalidade principal constrolar o fluxo de cadastro de contatos pessoais e profissionais de seus usuários dependendo de suas permissões. Utiliza uma interface amigável e intuitiva. Possui um CRUD da entidade Pessoa, da entidade Usuario e TipoUsuario. A renderização de todas as views envolve JSF, facelets e Primefaces(onde o back executa Ajax e javaScritp). Os testes unitários são feitos atravése do Junit para verificar a execução de todos os métodos da classe DAO. Como ferramenta de design de relatórios usou-se a ferramenta IReport e seu framework JasperReport (tanto integrada a IDE quanto por fora da IDE) no processo de desenho e geração de relatórios, onde o formato final dos mesmo resulta em um pdf. A persistência dos dados é feito via Hibernate/JPA no DB MySql.

#### ScreenShots:
```sh
Tela de Login
```
<img src="/src/main/webapp/resources/images/screenshots/telaDeLogin.PNG/" width="500">

```sh
Tela principal
```
<img src="/src/main/webapp/resources/images/screenshots/telaPrincipal.PNG/" width="500">

```sh
View de Contatos (dataTable preenchida)
```
<img src="/src/main/webapp/resources/images/screenshots/contatos.PNG/" width="500">

```sh
View para cadastro de novos contatos
```
<img src="/src/main/webapp/resources/images/screenshots/cadastroNovosContatos.PNG/" width="500">

```sh
Modal para edição de contatos
```
<img src="/src/main/webapp/resources/images/screenshots/modalEdicaoContatos.PNG/" width="500">

```sh
Modal para exclusão de contatos
```
<img src="/src/main/webapp/resources/images/screenshots/modalExcluirContatos.PNG/" width="500">

```sh
Modal para edição de contatos
```
<img src="/src/main/webapp/resources/images/screenshots/modalExibirContatos.PNG/" width="500">

```sh
Modelo do Relatório gerado com informações dos contatos
```
<img src="/src/main/webapp/resources/images/screenshots/relatorioContatos.PNG/" width="500">
