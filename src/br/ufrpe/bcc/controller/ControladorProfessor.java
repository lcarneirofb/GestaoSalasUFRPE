package br.ufrpe.bcc.controller;

import br.ufrpe.bcc.model.beans.Professor;
import br.ufrpe.bcc.repositorio.IRepositorioProfessor;
import br.ufrpe.bcc.repositorio.RepositorioProfessor;

import java.util.ArrayList;

public class ControladorProfessor implements IControladorProfessor{
    private static IControladorProfessor controller;
    private IRepositorioProfessor repositorio;

    private ControladorProfessor() {
        this.repositorio = RepositorioProfessor.getInstance();
    }

    public static IControladorProfessor getInstance() {
        if (controller == null) {
            controller = new ControladorProfessor();
        }
        return controller;
    }

    @Override
    public void cadastrar(Professor p) {
        repositorio.cadastrar(p);
    }

    @Override
    public void remover(Professor p) {
        repositorio.remover(p);
    }

    @Override
    public Professor buscar(String cpf) {
        return repositorio.buscar(cpf);
    }

    @Override
    public ArrayList<Professor> getList() {
        return repositorio.getList();
    }
}
