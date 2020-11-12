// Seyed Tavafi
// CS3560
// miniTweeter project
import view.*;
import Pool.*;

public class Main {
    private static ControlPanel CP;

    public static void main(String[] args) {
        Main.getControlPanelInstance();
    }

    /**
     * This method is used to get instance of Control Panel
     *
     * @return ControlPanel This returns ControlPanel.
     */
    public static ControlPanel getControlPanelInstance() {
        if (CP == null) {
            new ControlPanel(new Pool());
        }
        return CP;
    }
}