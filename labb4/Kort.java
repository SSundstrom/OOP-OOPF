import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Kort extends JColorfulButton {

    private Icon icon;
    public enum Status {DOLT, SYNLIGT, SAKNAS};
    private Status status;

    /**
     * Initialize a card with a icon and Status as SAKNAS
     * @param icon the cars icon
     */
    public Kort(Icon icon){
        this(icon, Status.SAKNAS);
    }

    /**
     * Initialize new card class
     * @param icon image for the cars
     * @param status the status the cars is in
     */
    public Kort(Icon icon, Status status){
        super();
        if(icon == null || status == null){
            throw new IllegalArgumentException("Icon or status can not be null");
        }
        this.icon = icon;
        setStatus(status);
    }

    /**
     * method to set status of the card
     * @param status Defines the new status the card will have
     */
    public void setStatus(Status status){
        this.status = status;
        switch (status){
            case DOLT:
                setIcon(new ImageIcon("cardback2.png"));
                setBackground(Color.white);
                this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                break;
            case SAKNAS:
                setIcon(null);
                setBackground(Color.white);
                setOpaque(false);
                this.setBorder(null);
                break;
            case SYNLIGT:
                setIcon(this.icon);
                setBackground(Color.white);
                this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        }
    }

    /**
     * metod to get the cards status
     * @return card status
     */
    public Status getStatus(){
        return this.status;
    }

    /**
     * Method to copy a card
     * @return a new instans of a card with same atributes as the original
     */
    public Kort copy(){
        return new Kort(this.icon, this.status);
    }

    /**
     * Equals method to compare two cards' icon
     * @param kort the card to compare with
     * @return if true the cards icon is equal
     */
    public boolean sammaBild(Kort kort){
        if(kort == null){
            return false;
        }
        if(this.icon == kort.getRealIcon()){
                return true;
            }
        return false;
    }

    /**
     * Getter to get a cards icon
     * @return the cards icon
     */
    public Icon getRealIcon(){
        return this.icon;
    }
}
