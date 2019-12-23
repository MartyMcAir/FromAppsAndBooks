package z_OOP_BiG_Pack.OOP_PatternAdapter_1904;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
