/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgs;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.orm.PersistentException;

/**
 *
 * @author franc
 */

public class Main {
    
    public static void createAdmin(){
        System.out.println("Criar admin: email/nome/senha");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String nome = scanner.nextLine();
        String senha = scanner.nextLine();
        
        try {
            sgs.AdministradorFunctions adminFunctions = new sgs.AdministradorFunctions();
            boolean result = adminFunctions.createAdministrador(email, nome, senha);
            if(result) System.out.println("Administrador " + nome + " criada com sucesso!\n");
            else System.out.println("Erro ao criar sala " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public static void createSala(){
        System.out.println("Criar sala: codigo/localizacao/capacidade");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        String localizacao = scanner.nextLine();
        int capacidade = scanner.nextInt();

        try {
            sgs.SalaFunctions salaFunction = new sgs.SalaFunctions();
            boolean result = salaFunction.createSala(codigo, localizacao, capacidade);
            if(result) System.out.println("Sala " + codigo + " criada com sucesso!\n");
            else System.out.println("Erro ao criar sala " + codigo + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public static void updateCapacidade(){
        System.out.println("Editar sala: codigo/localizacao/capacidade");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        Integer capacidade = scanner.nextInt();

        
        try {
            sgs.SalaFunctions salaFunction = new sgs.SalaFunctions();
            boolean result = salaFunction.updateCapacidade(codigo, capacidade);
            if(result) System.out.println("Sala " + codigo + " editada com sucesso!\n");
            else System.out.println("Erro ao editar sala " + codigo + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateLotacao(){
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        try {
            sgs.SalaFunctions salaFunction = new sgs.SalaFunctions();
            int lot = salaFunction.updateLotacao(codigo, -1);
            System.out.println("Sala " + codigo + " atualizada com sucesso! Lotacao = " + lot + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteSala(){
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        try {
            sgs.SalaFunctions salaFunction = new sgs.SalaFunctions();
            boolean result = salaFunction.deleteSala(codigo);
            System.out.println("Sala " + codigo + " eliminada com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createCurso(){
        System.out.println("Criar curso: codigo/nome/descricao/duracao");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        String nome = scanner.nextLine();
        String descricao = scanner.nextLine();
        Integer duracao = scanner.nextInt();

        try {
            sgs.CursoFunctions cursoFunction = new sgs.CursoFunctions();
            boolean result = cursoFunction.createCurso(nome, codigo, duracao, descricao);
            if(result) System.out.println("Curso " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao criar curso " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public static void updateCurso(){
        System.out.println("Editar curso: nome/descricao/duracao");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String descricao = scanner.nextLine();
        Integer duracao = scanner.nextInt();

        
        try {
            sgs.CursoFunctions cursoFunction = new sgs.CursoFunctions();
            boolean result = cursoFunction.updateCurso(nome, duracao, descricao);
            if(result) System.out.println("Curso " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao criar curso " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteCurso(){
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        try {
            sgs.CursoFunctions cursoFunction = new sgs.CursoFunctions();
            boolean result = cursoFunction.deleteCurso(nome);
            System.out.println("Sala " + nome + " eliminada com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createAluno(){
        System.out.println("Criar aluno: nome/cartao/email/senha/nomeCurso/idade/ano");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        
        String cartao = scanner.nextLine();
        String email = scanner.nextLine();
        String senha = scanner.nextLine();
        String nomeCurso = scanner.nextLine();
        Integer idade = scanner.nextInt();
        Integer ano = scanner.nextInt();

        try {
            sgs.AlunoFunctions alunoFunction = new sgs.AlunoFunctions();
            boolean result = alunoFunction.createAluno(nome, idade, cartao, email, senha, ano, nomeCurso);
            if(result) System.out.println("Aluno " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao criar aluno " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void updateAluno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editar aluno com email:");
        String email = scanner.nextLine();
        System.out.println("Editar aluno: nome/cartao/senha/idade/ano");
        String nome = scanner.nextLine();
        String cartao = scanner.nextLine();
        String senha = scanner.nextLine();
        Integer idade = scanner.nextInt();
        Integer ano = scanner.nextInt();

        try {
            sgs.AlunoFunctions alunoFunction = new sgs.AlunoFunctions();
            boolean result = alunoFunction.updateAluno(nome, idade, cartao, email, senha, ano);
            if(result) System.out.println("Aluno " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao editar aluno " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public static void deleteAluno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar aluno com email:");
        String email = scanner.nextLine();
        try {
            sgs.AlunoFunctions alunoFunction = new sgs.AlunoFunctions();
            boolean result = alunoFunction.deleteAluno(email);
            System.out.println("Aluno " + email + " eliminado com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createDocente(){
        System.out.println("Criar docente: nome/cartao/email/senha/departamento/genero/idade");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String cartao = scanner.nextLine();
        String email = scanner.nextLine();
        String senha = scanner.nextLine();
        String departamento = scanner.nextLine();
        Character genero = scanner.nextLine().toCharArray()[0];
        Integer idade = scanner.nextInt();

        try {
            sgs.DocenteFunctions docenteFunction = new sgs.DocenteFunctions();
            boolean result = docenteFunction.createDocente(nome, idade, cartao, email, senha, departamento, genero);
            if(result) System.out.println("Docente " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao criar docente " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public static void updateDocente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editar docente com email:");
        String email = scanner.nextLine();
        System.out.println("Editar docente: nome/cartao/senha/departamento/idade");
        String nome = scanner.nextLine();
        String cartao = scanner.nextLine();
        String senha = scanner.nextLine();
        String departamento = scanner.nextLine();
        Integer idade = scanner.nextInt();

        try {
            sgs.DocenteFunctions docenteFunction = new sgs.DocenteFunctions();
            boolean result = docenteFunction.updateDocente(nome, idade, cartao, email, senha, departamento);
            if(result) System.out.println("Docente " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao editar docente " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public static void deleteDocente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar docente com email:");
        String email = scanner.nextLine();
        try {
            sgs.DocenteFunctions docenteFunction = new sgs.DocenteFunctions();
            boolean result = docenteFunction.deleteDocente(email);
            System.out.println("Aluno " + email + " eliminado com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createUtilizador(){
        System.out.println("Criar utilizador: nome/cartao/email/senha/genero/idade");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String cartao = scanner.nextLine();
        String email = scanner.nextLine();
        String senha = scanner.nextLine();
        Character genero = scanner.nextLine().toCharArray()[0];
        Integer idade = scanner.nextInt();

        try {
            sgs.UtilizadorFunctions utilizadorFunction = new sgs.UtilizadorFunctions();
            boolean result = utilizadorFunction.createUtilizador(nome, idade, cartao, email, senha, genero);
            if(result) System.out.println("Utilizador " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao criar utilizador " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public static void updateUtilizador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editar utilizador com email:");
        String email = scanner.nextLine();
        System.out.println("Editar utilizador: nome/cartao/senha/idade");
        String nome = scanner.nextLine();
        String cartao = scanner.nextLine();
        String senha = scanner.nextLine();
        Integer idade = scanner.nextInt();

        try {
            sgs.UtilizadorFunctions utilizadorFunction = new sgs.UtilizadorFunctions();
            boolean result = utilizadorFunction.updateUtilizador(nome, idade, cartao, email, senha);
            if(result) System.out.println("Utilizador " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao editar utilizador " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteUtilizador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar utilizador com email:");
        String email = scanner.nextLine();
        try {
            sgs.UtilizadorFunctions utilizadorFunctions = new sgs.UtilizadorFunctions();
            boolean result = utilizadorFunctions.deleteUtilizador(email);
            System.out.println("Aluno " + email + " eliminado com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createDisciplina(){
        System.out.println("Criar disciplina: codigo/nome/codigoCurso/emailDocente/descricao/carga horaria");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        String nome = scanner.nextLine();
        String curso = scanner.nextLine();
        String docente = scanner.nextLine();
        String descricao = scanner.nextLine();
        Integer carga = scanner.nextInt();

        try {
            sgs.DisciplinaFunctions disciplinaFunction = new sgs.DisciplinaFunctions();
            boolean result = disciplinaFunction.createDisciplina(codigo, nome, curso, docente, descricao, carga);
            if(result) System.out.println("Disciplina " + nome + " criado com sucesso!\n");
            else System.out.println("Erro ao criar utilizador " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public static void updateDisciplina(){
        System.out.println("Editar disciplina com nome:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("Editar disciplina: curso/docente/descricao/carga horaria");
        String curso = scanner.nextLine();
        String docente = scanner.nextLine();
        String descricao = scanner.nextLine();
        Integer carga = scanner.nextInt();

        try {
            sgs.DisciplinaFunctions disciplinaFunction = new sgs.DisciplinaFunctions();
            boolean result = disciplinaFunction.updateDisciplina(nome, curso, docente, descricao, carga);
            if(result) System.out.println("Disciplina " + nome + " editado com sucesso!\n");
            else System.out.println("Erro ao editar disciplina " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public static void deleteDisciplina(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar disciplina com nome:");
        String nome = scanner.nextLine();
        try {
            sgs.DisciplinaFunctions disciplinaFunctions = new sgs.DisciplinaFunctions();
            boolean result = disciplinaFunctions.deleteDisciplina(nome);
            System.out.println("Disciplina " + nome + " eliminada com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createAula(){
        System.out.println("Criar aula: nome/turno/codigoSala/nomeDisc/data/inicio/fim");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        String turno = scanner.nextLine();
        String codigoSala = scanner.nextLine();
        String nomeDisc = scanner.nextLine();
        long data = scanner.nextLong();
        long inicio = scanner.nextLong();
        long fim = scanner.nextLong();

        try {
            sgs.AulaFunctions aulaFunction = new sgs.AulaFunctions();
            boolean result = aulaFunction.createAula(nome, data, inicio, fim, turno, codigoSala, nomeDisc);
            if(result) System.out.println("Aula " + nome + " criada com sucesso!\n");
            else System.out.println("Erro ao criar aula" + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void updateAula(){
        System.out.println("Editar aula com nome:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("Editar aula: turno/codigoSala/discNome/data/inicio/fim");
        String turno = scanner.nextLine();
        String codigoSala = scanner.nextLine();
        String discNome = scanner.nextLine();
        Long data = scanner.nextLong();
        Long inicio = scanner.nextLong();
        Long fim = scanner.nextLong();

        try {
            sgs.AulaFunctions aulaFunction = new sgs.AulaFunctions();
            boolean result = aulaFunction.updateAula(nome, inicio, fim, data, turno, codigoSala, discNome);
            if(result) System.out.println("Aula " + nome + " editada com sucesso!\n");
            else System.out.println("Erro ao editar aula " + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deleteAula(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar aula com nome:");
        String nome = scanner.nextLine();
        try {
            sgs.AulaFunctions aulaFunctions = new sgs.AulaFunctions();
            boolean result = aulaFunctions.deleteAula(nome);
            System.out.println("Aula " + nome + " eliminada com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createConferencia(){
        System.out.println("Criar conferencia codigo/nome/descricao/orador/tema/codigoSala/livre/inicio/fim");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();
        String nome = scanner.nextLine();
        String descricao = scanner.nextLine();
        String orador = scanner.nextLine();
        String tema = scanner.nextLine();
        String codigoSala = scanner.nextLine();
        boolean livre = scanner.nextBoolean();
        long inicio = scanner.nextLong();
        long fim = scanner.nextLong();

        try {
            sgs.ConferenciaFunctions conferenciaFunction = new sgs.ConferenciaFunctions();
            boolean result = conferenciaFunction.createConferencia(codigo, nome, codigoSala, inicio, fim, livre, descricao, orador, tema);
            if(result) System.out.println("Conferencia " + nome + " criada com sucesso!\n");
            else System.out.println("Erro ao criar conferencia" + nome + "\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public static void updateConferencia(){
    System.out.println("Editar conferencia com nome:");
    Scanner scanner = new Scanner(System.in);
    String nome = scanner.nextLine();
    System.out.println("Editar aula: descricao/orador/tema/codigoSala/livre/data/inicio/fim");
    String descricao = scanner.nextLine();
    String orador = scanner.nextLine();
    String tema = scanner.nextLine();
    String codigoSala = scanner.nextLine();
    boolean livre = scanner.nextBoolean();
    Long data = scanner.nextLong();
    Long inicio = scanner.nextLong();
    Long fim = scanner.nextLong();

    try {
        sgs.ConferenciaFunctions conferenciaFunction = new sgs.ConferenciaFunctions();
        boolean result = conferenciaFunction.updateConferencia(nome, inicio, fim, data, livre, descricao, orador, tema, codigoSala);
        if(result) System.out.println("Conferencia " + nome + " editada com sucesso!\n");
        else System.out.println("Erro ao editar conferencia " + nome + "\n");
    } catch (PersistentException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   
    
    public static void deleteConferencia(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eliminar conferencia com codigo:");
        String nome = scanner.nextLine();
        try {
            sgs.ConferenciaFunctions conferenciaFunction = new sgs.ConferenciaFunctions();
            boolean result = conferenciaFunction.deleteConferencia(nome);
            System.out.println("Aula " + nome + " eliminada com sucesso!\n");
        } catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public static void main(String[] args) {
        
        //createAdmin();
        //createSala();
        //updateCapacidade();
        //updateLotacao();
        //deleteSala();
        //createCurso();
        //updateCurso();
        //deleteCurso();
        //createAluno();
        //updateAluno();
        //deleteAluno();
        //createDocente();
        //updateDocente();
        //deleteDocente();
        //createUtilizador();
        //updateUtilizador();
        //deleteUtilizador();
        //createDisciplina();
        //updateDisciplina();
        //deleteDisciplina();
        //createAula();
        //updateAula();
        //deleteAula();
        //createConferencia();
        /*try {
            sgs.SalaFunctions salaFunction = new sgs.SalaFunctions();
            salaFunction.getEvento(sgs.SalaDAO.getSalaByORMID("cp2-1.07"));
        }
        catch (PersistentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //updateConferencia();
        //deleteConferencia(); 
       
        //sgs.SalaFunctions salaFunction = new sgs.SalaFunctions();
        //salaFunction.checkCartao("cp2-1.07", "pg50384@alunos.uminho.pt");
        
        
    }
}
