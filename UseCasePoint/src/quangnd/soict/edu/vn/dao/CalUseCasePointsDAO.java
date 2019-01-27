/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quangnd.soict.edu.vn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangnd
 */
public class CalUseCasePointsDAO {
    public ResultSet getUseCase(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT SUM(complexity) FROM use_case_estimate WHERE id_project=? AND type = 'UseCase'");
                ps.setString(1, idProject);
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet getActor(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT SUM(complexity) FROM use_case_estimate WHERE id_project=? AND type = 'Actor'");
                ps.setString(1, idProject); 
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
}
