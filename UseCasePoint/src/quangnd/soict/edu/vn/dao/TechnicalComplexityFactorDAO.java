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
import javax.swing.JOptionPane;
import quangnd.soict.edu.vn.objects.TechnicalComplexityFactor;

/**
 *
 * @author quangnd
 */
public class TechnicalComplexityFactorDAO {

    public ResultSet getAllTCF() {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT factor_tcf, description, complexity_tcf, weight  FROM technical_complexity_factor");
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet getListTCFByProject(String projectID) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT factor_tcf, description, weight, complexity_tcf  FROM technical_complexity_factor WHERE id_project=?");
                ps.setString(1, projectID);
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    public TechnicalComplexityFactor addNewTCF(TechnicalComplexityFactor complexityFactor) {
        
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO technical_complexity_factor(factor_tcf, description, weight, complexity_tcf, id_project) VALUES (?,?,?,?,?)");
                ps.setString(1, complexityFactor.getFactorTCF());
                ps.setString(2, complexityFactor.getDescription());
                ps.setFloat(3, complexityFactor.getWeight());
                ps.setFloat(4, complexityFactor.getComplex());
                ps.setString(5, complexityFactor.getIdProject());
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Đã tạo thành công TechnicalComplexityFactor: " + complexityFactor.getFactorTCF()+ "!", "Thông báo!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                if (vendorCode == 1062) {
                    JOptionPane.showMessageDialog(null, "Bạn không thể tạo mới được TechnicalComplexityFactor" + "\n" + "Do project " + complexityFactor.getFactorTCF()+ " đã tồn tại!", "Thông báo!", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra, vui lòng thử lại!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return null;
    }
    
    public ResultSet calUTV(String projectID) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT SUM(weight*complexity_tcf) FROM technical_complexity_factor WHERE id_project=? ");
                ps.setString(1, projectID);
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
}
