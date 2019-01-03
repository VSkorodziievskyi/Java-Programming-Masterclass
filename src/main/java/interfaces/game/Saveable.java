package interfaces.game;

import java.util.List;

public interface Saveable {
    List<String> save();

    void read(List<String> list);
}
