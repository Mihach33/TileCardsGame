import javax.swing.*;
import java.awt.*;

public class MyCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
        if ( index == 0 ) {
            c.setBackground( Color.decode("#ffd11a") );
        }
        else if ( index == 1 ){
            c.setBackground( Color.decode("#d9d9d9") );
        }
        else if ( index == 2 ){
            c.setBackground( Color.decode("#cc6600") );
        }
        return c;
    }
}
