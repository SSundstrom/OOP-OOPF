package orig2011.v7;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReversiScoreView  implements PropertyChangeListener{


    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals("Turn") && pce.getSource().getClass() == ReversiModel.class) {
            ReversiModel rm = (ReversiModel) pce.getSource();
            System.out.println("White player score : " + rm.getWhiteScore());
            System.out.println("Black player score : " + rm.getBlackScore());
            if (rm.getTurnColor() == ReversiModel.Turn.WHITE) {
                System.out.println("It's Whites turn");
            } else {
                System.out.println("It's Blacks turn");
            }

        }
    }
}
