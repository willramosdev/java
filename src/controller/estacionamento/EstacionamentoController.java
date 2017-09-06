package controller.estacionamento;

import javax.swing.*;
import dao.estacionamento.VeiculoDAO;
import model.estacionamento.Veiculo;
import model.estacionamento.Estacionamento;
import java.sql.SQLException;
import java.text.ParseException;
import view.estacionamento.EstacionamentoEntradaUI;
import java.util.List;

/**
 *
 * @author Will
 */
public class EstacionamentoController {
    public static void abreTelaEntrada(){
        EstacionamentoEntradaUI entrada = new EstacionamentoEntradaUI();
        entrada.setVisible(true);
    }

    public void registraEntrada(String placa, int hora, int min) 
            throws SQLException, ParseException 
	{
        Veiculo veiculo  = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setHoraEntrada(hora);
        veiculo.setMinutoEntrada(min);

        new VeiculoDAO().salvar(veiculo);
    }
    
    public void alterar(String placa, int hora, int min) 
		throws ParseException, SQLException 
	{
        
	Veiculo veiculo  = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setHoraEntrada(hora);
        veiculo.setMinutoEntrada(min);
        
        new VeiculoDAO().alterar(veiculo);
    }
    
     public List listaVeiculos() {
        VeiculoDAO dao = new VeiculoDAO();
        try {
            return dao.findVeiculos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar veiculos" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }
     
    public void registraSaida(String placa) throws SQLException {
        new VeiculoDAO().excluir(placa);
    }

    public Veiculo buscaVeicuPelaPlaca(String placa) throws SQLException {
        VeiculoDAO dao = new VeiculoDAO();
        return dao.findByPlaca(placa);
    }
    
    public double preparaCobranca (String placa, int horaSaida, int minutoSaida) throws SQLException {
        double valorDeCobranca = 0;
        Estacionamento estacionamento = new Estacionamento ();
        Veiculo veiculo = buscaVeicuPelaPlaca(placa);
        
        double totalMinutosPermanencia = 
                (horaSaida * 60 + minutoSaida)
                    -
                (veiculo.getHoraEntrada() * 60 + veiculo.getMinutoEntrada());
                
        if(totalMinutosPermanencia < estacionamento.getTolerancia()){
            return valorDeCobranca;
        } 
        
        else if (totalMinutosPermanencia < 60 ) {
            valorDeCobranca = 1;
        } 
        
        else {
            double aux = totalMinutosPermanencia / estacionamento.getPeriodoDeTarifacao();
            
            if (aux - (int)aux > 0) {
                valorDeCobranca = ((int)aux + 1) * estacionamento.getValorPorPeriodo();
            } else {
                valorDeCobranca = aux * estacionamento.getValorPorPeriodo();
            }
            
        }
        
        return valorDeCobranca;
    }
    
    public void realizaCobranca (String placa, double valorDeCobranca) throws SQLException {
        //todo persistencia da parte do estacionamento
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.setCaixa(valorDeCobranca);
        
        Veiculo veiculo = buscaVeicuPelaPlaca(placa);
        
        registraSaida(placa);
        
        JOptionPane.showMessageDialog(null, 
				"Registrada com sucesso a saída do veiculo de placa: " +
                                veiculo.getPlaca() 
                                
        );
        
        
        
        
        
    }
    
}
