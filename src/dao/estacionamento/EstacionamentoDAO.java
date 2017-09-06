
package dao.estacionamento;

import model.estacionamento.Estacionamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Will
 */
public class EstacionamentoDAO extends GenericDAO {

    
    public void salvar(Estacionamento estacionamento) throws SQLException {
        String insert = "insert into estacionamento_db.estacionamento ("
                + "id, tolerancia, valorMinimo, periodoDeTarifacao, valorPorPeriodo, caixa) "
                + "values (?,?,?,?,?,?)";
        save(
                insert, estacionamento.getId(), estacionamento.getTolerancia(), 
                estacionamento.getValorMinimo(), estacionamento.getPeriodoDeTarifacao(), 
                estacionamento.getValorPorPeriodo(), estacionamento.getCaixa()
        );
    }
    

     public void alterar(Estacionamento estacionamento) throws SQLException {
        String update = "UPDATE estacionamento " +
                "SET id = ?, tolerancia = ?, valorMinimo = ?, " +
                "periodoDeTarifacao = ?, valorPorPeriodo = ?, " +
                "caixa = ? WHERE id = ?";
        update(update, estacionamento.getId(), estacionamento.getTolerancia(), 
                estacionamento.getValorMinimo(), estacionamento.getPeriodoDeTarifacao(), 
                estacionamento.getValorPorPeriodo(), estacionamento.getCaixa()
        );
    }


    public List findEstacionamentoConfigs() throws SQLException {
        List estacionamentos = new ArrayList();

        String select = "SELECT * FROM estacionamento";

        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Estacionamento estacionamento = new Estacionamento();
            estacionamento.setId(rs.getInt("id"));
            estacionamento.setTolerancia(rs.getInt("tolerancia"));
            estacionamento.setValorMinimo(rs.getDouble("valorMinimo"));
            estacionamento.setPeriodoDeTarifacao(rs.getInt("periodoDeTarifacao"));
            estacionamento.setValorPorPeriodo(rs.getDouble("valorPorPeriodo"));
            estacionamento.setCaixa(rs.getDouble("caixa"));
            
            estacionamentos.add(estacionamento);
        }

        rs.close();
        stmt.close();

        return estacionamentos;
    }
    
    public Estacionamento findByID(int id) throws SQLException {
        String select = "SELECT * FROM estacionamento WHERE id = ?";
        Estacionamento estacionamento = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            estacionamento = new Estacionamento();
            estacionamento.setId(rs.getInt("id"));
            estacionamento.setTolerancia(rs.getInt("tolerancia"));
            estacionamento.setValorMinimo(rs.getDouble("valorMinimo"));
            estacionamento.setPeriodoDeTarifacao(rs.getInt("periodoDeTarifacao"));
            estacionamento.setValorPorPeriodo(rs.getDouble("valorPorPeriodo"));
            estacionamento.setCaixa(rs.getDouble("caixa"));
            
        }

        rs.close();
        stmt.close();
        return estacionamento;
    }
}


