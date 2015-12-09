package orig2011.v7;

import java.beans.PropertyChangeListener;

public interface IObservable {
    void addObserver(PropertyChangeListener observer);
    void removeObserver(PropertyChangeListener observer);
}
