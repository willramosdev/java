
package model.estacionamento;

/**
 *
 * @author Will
 */
public class Estacionamento {
    private int tolerancia = 15; //minutos
    private double valorMinimo = 1; //reais
    private int periodoDeTarifacao = 60; //minutos
    private double valorPorPeriodo = 1; // 1 reais
    private double caixa = 0;

    /**
     * @return the tolerancia
     */
    public int getTolerancia() {
        return tolerancia;
    }

    /**
     * @param tolerancia the tolerancia to set
     */
    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }

    /**
     * @return the valorMinimo
     */
    public double getValorMinimo() {
        return valorMinimo;
    }

    /**
     * @param valorMinimo the valorMinimo to set
     */
    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    /**
     * @return the periodoDeTarifacao
     */
    public int getPeriodoDeTarifacao() {
        return periodoDeTarifacao;
    }

    /**
     * @param periodoDeTarifacao the periodoDeTarifacao to set
     */
    public void setPeriodoDeTarifacao(int periodoDeTarifacao) {
        this.periodoDeTarifacao = periodoDeTarifacao;
    }

    /**
     * @return the valorPorPeriodo
     */
    public double getValorPorPeriodo() {
        return valorPorPeriodo;
    }

    /**
     * @param valorPorPeriodo the valorPorPeriodo to set
     */
    public void setValorPorPeriodo(int valorPorPeriodo) {
        this.valorPorPeriodo = valorPorPeriodo;
    }

    /**
     * @return the caixa
     */
    public double getCaixa() {
        return caixa;
    }

    /**
     * @param caixa the caixa to set
     */
    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }
}
