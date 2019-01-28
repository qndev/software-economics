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
import quangnd.soict.edu.vn.objects.EnvironmentalComplexityFactor;

/**
 *
 * @author quangnd
 */
public class EnvironmentalComplexityFactorDAO {
    public ResultSet getAllECF() {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT factor_ecf, description, complexity_ecf, weight  FROM environmental_complexity_factor");
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet getListECFByProject(String projectID) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT factor_ecf, description, complexity_ecf, weight  FROM environmental_complexity_factor WHERE id_project=?");
                ps.setString(1, projectID);
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    public EnvironmentalComplexityFactor addNewECF(EnvironmentalComplexityFactor complexityFactor) {
        
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO environmental_complexity_factor(factor_ecf, description, weight, complexity_ecf, id_project) VALUES (?,?,?,?,?)");
                ps.setString(1, complexityFactor.getFactorECF());
                ps.setString(2, complexityFactor.getDescription());
                ps.setFloat(3, complexityFactor.getWeight());
                ps.setFloat(4, complexityFactor.getComplex());
                ps.setString(5, complexityFactor.getIdProject());
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Đã tạo thành công EnvironmentalComplexityFactor: " + complexityFactor.getFactorECF()+ "!", "Thông báo!",
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
                    JOptionPane.showMessageDialog(null, "Bạn không thể tạo mới được EnvironmentalComplexityFactor" + "\n" + "Do project " + complexityFactor.getFactorECF()+ " đã tồn tại!", "Thông báo!", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra, vui lòng thử lại!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return null;
    }
    
    public ResultSet calUEV(String projectID) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT SUM(weight*complexity_ecf) FROM environmental_complexity_factor WHERE id_project=? ");
                ps.setString(1, projectID);
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }

    public ResultSet countStability0(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT COUNT(*) FROM environmental_complexity_factor WHERE id_project=? AND weight*complexity_ecf <= 0");
                ps.setString(1, idProject); 
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet countStability1(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT COUNT(*) FROM environmental_complexity_factor WHERE id_project=? AND 0 < weight*complexity_ecf AND weight*complexity_ecf <= 1");
                ps.setString(1, idProject); 
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet countStability2(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT COUNT(*) FROM environmental_complexity_factor WHERE id_project=? AND 1 < weight*complexity_ecf AND weight*complexity_ecf <= 2");
                ps.setString(1, idProject); 
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet countStability3(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT COUNT(*) FROM environmental_complexity_factor WHERE id_project=? AND 2 < weight*complexity_ecf AND weight*complexity_ecf <= 3");
                ps.setString(1, idProject); 
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet countStability4(String idProject) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT COUNT(*) FROM environmental_complexity_factor WHERE id_project=? AND weight*complexity_ecf > 3");
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
