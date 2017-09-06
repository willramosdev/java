/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.estacionamento;

import dao.estacionamento.VeiculoDAO;

/**
 *
 * @author Will
 */
public class Veiculo {
    
    private String placa;
    private int horaEntrada;
    private int minutoEntrada;

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the horaEntrada
     */
    public int getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @return the minutoEntrada
     */
    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    /**
     * @param minutoEntrada the minutoEntrada to set
     */
    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }
    
    
}
