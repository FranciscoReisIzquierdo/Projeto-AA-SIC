CREATE TABLE Sala (Codigo varchar(255) NOT NULL, Capacidade int(10) NOT NULL, Localizacao varchar(255), Lotacao int(10) NOT NULL, PRIMARY KEY (Codigo)) CHARACTER SET UTF8;
CREATE TABLE Evento (Codigo varchar(255) NOT NULL, UtilizadorEmail varchar(255), DisciplinaCodigo varchar(255), SalaCodigo2 varchar(255), SalaCodigo varchar(255), HoraInicio bigint(20) NOT NULL, HoraFim bigint(20) NOT NULL, Nome varchar(255), Turno varchar(255), Livre tinyint(1), Descrição varchar(255), Orador varchar(255), Tema varchar(255), Discriminator varchar(255) NOT NULL, PRIMARY KEY (Codigo)) CHARACTER SET UTF8;
CREATE TABLE Utilizador (Email varchar(255) NOT NULL, CursoCodigo varchar(255), Nome varchar(255), Idade int(10), Numero varchar(255), Senha varchar(255), Genero char(1) NOT NULL, Ano int(10), Departamento varchar(255), Discriminator varchar(255) NOT NULL, PRIMARY KEY (Email)) CHARACTER SET UTF8;
CREATE TABLE Disciplina (Codigo varchar(255) NOT NULL, UtilizadorEmail varchar(255), CursoCodigo varchar(255) NOT NULL, Nome varchar(255), Descricao varchar(255), CargaHoraria int(10) NOT NULL, PRIMARY KEY (Codigo)) CHARACTER SET UTF8;
CREATE TABLE Curso (Codigo varchar(255) NOT NULL, Nome varchar(255), Duracao int(10) NOT NULL, Descricao varchar(255), PRIMARY KEY (Codigo)) CHARACTER SET UTF8;
CREATE TABLE Administrador (Email varchar(255) NOT NULL, Nome varchar(255), Senha varchar(255), PRIMARY KEY (Email)) CHARACTER SET UTF8;
CREATE TABLE Evento_Utilizador (EventoCodigo varchar(255) NOT NULL, UtilizadorEmail varchar(255) NOT NULL, PRIMARY KEY (EventoCodigo, UtilizadorEmail)) CHARACTER SET UTF8;
CREATE TABLE Evento_Utilizador2 (EventoCodigo varchar(255) NOT NULL, UtilizadorEmail varchar(255) NOT NULL, PRIMARY KEY (EventoCodigo, UtilizadorEmail)) CHARACTER SET UTF8;
CREATE TABLE Evento_Utilizador3 (EventoCodigo varchar(255) NOT NULL, UtilizadorEmail varchar(255) NOT NULL, PRIMARY KEY (EventoCodigo, UtilizadorEmail)) CHARACTER SET UTF8;
CREATE TABLE Disciplina_Utilizador (DisciplinaCodigo varchar(255) NOT NULL, UtilizadorEmail varchar(255) NOT NULL, PRIMARY KEY (DisciplinaCodigo, UtilizadorEmail)) CHARACTER SET UTF8;
CREATE TABLE Disciplina_Utilizador2 (DisciplinaCodigo varchar(255) NOT NULL, UtilizadorEmail varchar(255) NOT NULL, PRIMARY KEY (DisciplinaCodigo, UtilizadorEmail)) CHARACTER SET UTF8;
CREATE TABLE Evento_Utilizador4 (EventoCodigo varchar(255) NOT NULL, UtilizadorEmail varchar(255) NOT NULL, PRIMARY KEY (EventoCodigo, UtilizadorEmail)) CHARACTER SET UTF8;
ALTER TABLE Disciplina ADD CONSTRAINT FKDisciplina4615 FOREIGN KEY (CursoCodigo) REFERENCES Curso (Codigo);
ALTER TABLE Evento_Utilizador ADD CONSTRAINT FKEvento_Uti94959 FOREIGN KEY (EventoCodigo) REFERENCES Evento (Codigo);
ALTER TABLE Evento_Utilizador ADD CONSTRAINT FKEvento_Uti179197 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Evento ADD CONSTRAINT FKEvento76150 FOREIGN KEY (SalaCodigo) REFERENCES Sala (Codigo);
ALTER TABLE Evento ADD CONSTRAINT FKEvento754720 FOREIGN KEY (SalaCodigo2) REFERENCES Sala (Codigo);
ALTER TABLE Evento ADD CONSTRAINT FKEvento725817 FOREIGN KEY (DisciplinaCodigo) REFERENCES Disciplina (Codigo);
ALTER TABLE Utilizador ADD CONSTRAINT FKUtilizador339311 FOREIGN KEY (CursoCodigo) REFERENCES Curso (Codigo);
ALTER TABLE Evento_Utilizador2 ADD CONSTRAINT FKEvento_Uti721841 FOREIGN KEY (EventoCodigo) REFERENCES Evento (Codigo);
ALTER TABLE Evento_Utilizador2 ADD CONSTRAINT FKEvento_Uti637603 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Evento ADD CONSTRAINT FKEvento762607 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Disciplina ADD CONSTRAINT FKDisciplina380430 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Evento_Utilizador3 ADD CONSTRAINT FKEvento_Uti721840 FOREIGN KEY (EventoCodigo) REFERENCES Evento (Codigo);
ALTER TABLE Evento_Utilizador3 ADD CONSTRAINT FKEvento_Uti637602 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Disciplina_Utilizador ADD CONSTRAINT FKDisciplina617190 FOREIGN KEY (DisciplinaCodigo) REFERENCES Disciplina (Codigo);
ALTER TABLE Disciplina_Utilizador ADD CONSTRAINT FKDisciplina871234 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Disciplina_Utilizador2 ADD CONSTRAINT FKDisciplina826207 FOREIGN KEY (DisciplinaCodigo) REFERENCES Disciplina (Codigo);
ALTER TABLE Disciplina_Utilizador2 ADD CONSTRAINT FKDisciplina656957 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
ALTER TABLE Evento_Utilizador4 ADD CONSTRAINT FKEvento_Uti721839 FOREIGN KEY (EventoCodigo) REFERENCES Evento (Codigo);
ALTER TABLE Evento_Utilizador4 ADD CONSTRAINT FKEvento_Uti637601 FOREIGN KEY (UtilizadorEmail) REFERENCES Utilizador (Email);
