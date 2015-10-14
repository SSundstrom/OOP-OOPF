import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Kort extends JColorfulButton {

    private Icon icon;
    public enum Status {DOLT, SYNLIGT, SAKNAS};
    private Status status;


    public Kort(Icon icon){
        this(icon, Status.SAKNAS);
    }

    public Kort(Icon icon, Status status){
        super();
        if(icon == null || status == null){
            throw new IllegalArgumentException("Icon or status can not be null");
        }
        this.icon = icon;
        setStatus(status);
    }

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
    public Status getStatus(){

        return this.status;
    }
    public Kort copy(){
        return new Kort(this.icon, this.status);
    }
    public boolean sammaBild(Kort kort){
        if(kort == null){
            return false;
        }
        if(this.icon == kort.getRealIcon()){
                return true;
            }
        return false;
    }
    public Icon getRealIcon(){
        return this.icon;
    }
}
