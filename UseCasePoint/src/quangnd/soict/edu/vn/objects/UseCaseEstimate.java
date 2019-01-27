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
public class UseCaseEstimate {
    private String nameOfUseCasePoint;
    private Float phase;
    private String type;
    private Float complex;
    private String idProject;

    public String getNameOfUseCasePoint() {
        return nameOfUseCasePoint;
    }

    public void setNameOfUseCasePoint(String nameOfUseCasePoint) {
        this.nameOfUseCasePoint = nameOfUseCasePoint;
    }

    public Float getPhase() {
        return phase;
    }

    public void setPhase(Float phase) {
        this.phase = phase;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getComplex() {
        return complex;
    }

    public void setComplex(Float complex) {
        this.complex = complex;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public UseCaseEstimate(String nameOfUseCasePoint, Float phase, String type, Float complex, String idProject) {
        this.nameOfUseCasePoint = nameOfUseCasePoint;
        this.phase = phase;
        this.type = type;
        this.complex = complex;
        this.idProject = idProject;
    }
     
    
}
