/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.model.rango_hora;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.edu.utez.model.Dao;
import mx.edu.utez.model.DaoInterface;

/**
 *
 * @author alexl
 */
public class DaoRango_Hora extends Dao implements DaoInterface<Rango_Hora> {
    
    @Override
    public int add(Rango_Hora obj) {
        mySQLRepository("rango_horaRepository", "rango_horaAdd");
        try {
            preparedStatement.setInt(1, obj.getRango_Hora());
            preparedStatement.setString(2, obj.getInicio());
            preparedStatement.setString(3, obj.getFin());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoRango_Hora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeAllConnections();
        }
        return 0;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Rango_Hora obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Rango_Hora> findAll() {
        mySQLRepository("rango_horaRepository","rango_horaFindAll");
        ArrayList<Rango_Hora> list = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(
                        new Rango_Hora(
                                resultSet.getInt("Rango_Hora"),
                                resultSet.getString("inicio"),
                                resultSet.getString("fin")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoRango_Hora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeAllConnections();
        }
        return list;
    }

    @Override
    public Rango_Hora findOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
