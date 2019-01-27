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
import quangnd.soict.edu.vn.objects.Projects;
import quangnd.soict.edu.vn.objects.UseCaseEstimate;

/**
 *
 * @author quangnd
 */
public class UseCaseDAO {
    public ResultSet getIdProject() {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT id_project FROM project");
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet getAllUseCase() {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT name, phase, complexity, type, id_project  FROM use_case_estimate");
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public ResultSet getUseCaseAndActorByProject(String projectID) {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT name, phase, complexity, type, id_project  FROM use_case_estimate WHERE id_project=?");
                ps.setString(1, projectID);
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
     public Projects addNewUseCase(UseCaseEstimate useCaseEstimate) throws SQLException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO use_case_estimate(name, phase, type, complexity, id_project) VALUES (?,?,?,?,?)");
                ps.setString(1, useCaseEstimate.getNameOfUseCasePoint());
                ps.setFloat(2, useCaseEstimate.getPhase());
                ps.setString(3, useCaseEstimate.getType());
                ps.setFloat(4, useCaseEstimate.getComplex());
                ps.setString(5, useCaseEstimate.getIdProject());
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Đã tạo thành công UseCase: " + useCaseEstimate.getNameOfUseCasePoint()+ "!", "Thông báo!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                //Logger.getLogger(AddUserDAO.class.getName()).log(Level.SEVERE, null, ex);
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("SQLException:");
                System.err.println("ERROR code: " + vendorCode);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Message: " + sqlMessage + "\n----------------");
                if (vendorCode == 1062) {
                    JOptionPane.showMessageDialog(null, "Bạn không thể tạo mới được UseCase" + "\n" + "Do project " + useCaseEstimate.getIdProject()+ " đã tồn tại!", "Thông báo!", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra, vui lòng thử lại!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return null;
    }
}
