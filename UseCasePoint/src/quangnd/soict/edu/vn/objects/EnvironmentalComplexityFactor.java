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
public class EnvironmentalComplexityFactor {
    private String factorECF;
    private String description;
    private Float weight;
    private Float complex;
    private String idProject;

    public String getFactorECF() {
        return factorECF;
    }

    public void setFactorECF(String factorECF) {
        this.factorECF = factorECF;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
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

    public EnvironmentalComplexityFactor(String factorECF, String description, Float weight, Float complex, String idProject) {
        this.factorECF = factorECF;
        this.description = description;
        this.weight = weight;
        this.complex = complex;
        this.idProject = idProject;
    }
    
    
}
