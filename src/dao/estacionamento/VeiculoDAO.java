
package dao.estacionamento;

import model.estacionamento.Veiculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Will
 */
public class VeiculoDAO extends GenericDAO {

    
    public void salvar(Veiculo veiculo) throws SQLException {
        String insert = "insert into estacionamento_db.veiculo (Placa, HoraEntrada, MinEntrada) "
                + "values (?,?,?)";
        save(insert, veiculo.getPlaca(), veiculo.getHoraEntrada(), veiculo.getMinutoEntrada());
    }
    

     public void alterar(Veiculo veiculo) throws SQLException {
        String update = "UPDATE veiculo " +
                "SET Placa = ?, HoraEntrada = ?, MinEntrada = ? " +
                "WHERE Placa = ?";
        update(update, veiculo.getPlaca(), veiculo.getHoraEntrada(), veiculo.getMinutoEntrada());
    }

    public void excluir(String placa) throws SQLException {
        String delete = "DELETE FROM veiculo WHERE placa = ?";
        delete(delete, placa);
    }

    public List findVeiculos() throws SQLException {
        List veiculos = new ArrayList();

        String select = "SELECT * FROM veiculo";

        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(rs.getString("Placa"));
            veiculo.setHoraEntrada(rs.getInt("HoraEntrada"));
            veiculo.setMinutoEntrada(rs.getInt("MinEntrada"));
            
            veiculos.add(veiculo);
        }

        rs.close();
        stmt.close();

        return veiculos;
    }
    
    public Veiculo findByPlaca(String placa) throws SQLException {
        String select = "SELECT * FROM veiculo WHERE Placa = ?";
        Veiculo veiculo = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, placa);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            veiculo = new Veiculo();
            veiculo.setPlaca(rs.getString("Placa"));
            veiculo.setHoraEntrada(rs.getInt("HoraEntrada"));
            veiculo.setMinutoEntrada(rs.getInt("MinEntrada"));
        }

        rs.close();
        stmt.close();
        return veiculo;
    }
}


