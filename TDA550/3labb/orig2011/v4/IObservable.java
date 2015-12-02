package orig2011.v4;

import java.beans.PropertyChangeListener;

public interface IObservable {
    void addObserver(PropertyChangeListener observer);
    void removeObserver(PropertyChangeListener observer);
}
