
package br.ufrpe.bcc.model.negocios.beans;

import java.io.Serializable;
import java.util.*;

public class Predio implements Serializable {
    private String nome;
    private String lote;
    private double longitude;
    private double latitude;
    private boolean disponivel;
    private ArrayList<Sala> salas;
    private int salasDisponiveis;
    private int salasOcupadas;

    public Predio(String nome, String lote, double longitude, double latitude) {
        this.nome = nome;
        this.lote = lote;
        this.longitude = longitude;
        this.latitude = latitude;
        this.salas = new ArrayList<>();
        this.disponivel = true;
        salasDisponiveis = this.numeroSalasDisponiveis();
        salasOcupadas = this.numeroSalasOcupadas();
    }

    @Override
    public String toString() {
        return "Predio{" +
                "nome='" + nome + '\'' +
                ", lote='" + lote + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", ocupado=" + disponivel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predio predio = (Predio) o;
        return Double.compare(predio.getLongitude(), getLongitude()) == 0 &&
                Double.compare(predio.getLatitude(), getLatitude()) == 0 &&
                Objects.equals(getNome(), predio.getNome()) &&
                Objects.equals(getLote(), predio.getLote());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNome(), getLote(), getLongitude(), getLatitude());
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public int numeroSalasOcupadas(){
        int salasexit = 0;
        for(Sala sala: salas){
            if(!sala.isDisponibilidade()){
                salasexit++;
            }
        }
        return salasexit;
    }

    public int numeroSalasDisponiveis(){
        int salasexit = 0;
        for(Sala sala: salas){
            if(sala.isDisponibilidade()){
                salasexit++;
            }
        }
        return salasexit;
    }

    public int getNumerosSalas(){
        int contador = 0;
        for(Sala sala: salas){
            contador++;
        }
        return contador;
    }

    public void novaSala(Sala salag){
        this.salas.add(salag);
        return;
    }


    public Sala getSala(int ID){
        for(Sala sala: salas){
            if(ID == sala.getId()){
                return sala;
            }
        }
        return null;
    }

}
