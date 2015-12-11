package app.ioo.tp.util;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class WideComboBox<E> extends JComboBox {
 
    public WideComboBox() { 
    } 
 
    public WideComboBox(final E items[]){
        super(items); 
    } 
 
    public WideComboBox(Vector<E> items) {
        super(items); 
    } 
 
    public WideComboBox(ComboBoxModel aModel) { 
        super(aModel); 
    } 
 
    private boolean layingOut = false; 
 
    public void doLayout(){ 
        try{ 
            layingOut = true; 
            super.doLayout(); 
        }finally{ 
            layingOut = false; 
        } 
    } 
 
    public Dimension getSize(){
        Dimension dim = super.getSize(); 
        if(!layingOut) 
            dim.width = Math.max(dim.width, getPreferredSize().width); 
        return dim; 
    } 
}