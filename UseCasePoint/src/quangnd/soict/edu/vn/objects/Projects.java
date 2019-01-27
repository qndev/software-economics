/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quangnd.soict.edu.vn.objects;

/**
 *
 * @author quangnd
 */
public class Projects {
    private String idProject;
    private String name;
    private String description;

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Projects(String idProject, String name, String description) {
        this.idProject = idProject;
        this.name = name;
        this.description = description;
    }

    public Projects() {
    }
    
}
