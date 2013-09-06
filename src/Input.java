import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nerff on 06.09.13.
 */
public class Input {
    protected Scanner mScanner;
    boolean done = false;

    Input() {
        initManualInput();
    }

    Input(String path) {
        try {
            mScanner = new Scanner(new File(path));
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file " + path + ", falling back to manual input");
            initManualInput();
        }
    }

    private void initManualInput() {
        mScanner = new Scanner(System.in);
    }

    public boolean isDone() {
        return done;
    }

    String getNextLine() {
        String str;
        try {
            str = mScanner.nextLine().toUpperCase();
            if (str.equals("END")) {
                done = true;
            }
            return str;
        } catch (Throwable e) {
            done = true;
        }
        return "END";
    }
}
