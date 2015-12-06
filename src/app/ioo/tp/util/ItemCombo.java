package app.ioo.tp.util;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

/**
 * Created by josur on 03/12/2015.
 */
public class ItemCombo {

    private Object objeto;

    private String texto;

    public ItemCombo(Object objeto, String texto) {
        this.objeto = objeto;
        this.texto = texto;
    }

    public Object getValue() {
        return objeto;
    }

    public String getTexto() {
        return texto;
    }


    public static class ItemComboRender extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value != null){
                ItemCombo item = (ItemCombo) value;
                setText(item.getTexto());
            }

            return this;
        }
    }
}
