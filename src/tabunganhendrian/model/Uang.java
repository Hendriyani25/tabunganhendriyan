/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabunganhendrian.model;

/**
 *
 * @author Asus
 */
public class Uang {
    private double value;
    
    public Uang() {
        this.value = 0d;
    }
    
    public Uang(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
