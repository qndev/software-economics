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
import static quangnd.soict.edu.vn.dao.DBConnect.cnn;
import quangnd.soict.edu.vn.objects.Projects;

/**
 *
 * @author quangnd
 */
public class ProjectsDAO {
    
    public ResultSet getInfoProject() {
        PreparedStatement ps;
        ResultSet rs;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("SELECT id_project, name, description FROM project");
                rs = ps.executeQuery();
                return rs; 
            } catch (SQLException e) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return null;
    }
    
    public Projects addNewProject(Projects project) throws SQLException{
        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("INSERT INTO project(id_project, name, description) VALUES (?,?,?)");
                ps.setString(1, project.getIdProject());
                ps.setString(2, project.getName());
                ps.setString(3, project.getDescription());
                int i = ps.executeUpdate();
                if (i == 1) {
                    JOptionPane.showMessageDialog(null, "Đã tạo thành công Project: " + project.getIdProject() + "!", "Thông báo!",
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
                    JOptionPane.showMessageDialog(null, "Bạn không thể tạo mới được Project" + "\n" + "Do project " + project.getIdProject()+ " đã tồn tại!", "Thông báo!", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra, vui lòng thử lại!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
                }
            } finally {
                DBConnect.close(ps);
            }
        }
        return null;
    }
    
    public boolean updateProject(Projects projects){
        if (DBConnect.open()) {
            PreparedStatement ps = null;
            try {
                ps = cnn.prepareStatement("UPDATE project SET name=?, description=? WHERE id_project=?");
                ps.setString(1, projects.getName());
                ps.setString(2, projects.getDescription());
                ps.setString(3, projects.getIdProject());
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }else{
                return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectsDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
    }
    
    public boolean deleteProject(String idProject) {

        PreparedStatement ps = null;
        if (DBConnect.open()) {
            try {
                ps = DBConnect.cnn.prepareStatement("delete from project where id_project = ?");
                ps.setString(1, idProject);
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                String sqlMessage = ex.getMessage();
                String sqlState = ex.getSQLState();
                int vendorCode = ex.getErrorCode();
                System.err.println("Exception occurred:");
                System.err.println("Message: " + sqlMessage);
                System.err.println("SQL state: " + sqlState);
                System.err.println("Vendor code: " + vendorCode + "\n----------------");
                JOptionPane.showMessageDialog(null, "Bạn không thể xóa Project: " + idProject + "\nDo " + sqlMessage, "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                DBConnect.close(ps);
            }
        }
        return false;
}
}
