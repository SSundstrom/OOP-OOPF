package orig2011.v5;

import java.beans.PropertyChangeListener;

public interface IObservable {
    void addObserver(PropertyChangeListener observer);
    void removeObserver(PropertyChangeListener observer);
}
