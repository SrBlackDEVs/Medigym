package General;

import javax.swing.JOptionPane;

public class Init {
    public static void main(String[] args) throws InterruptedException {
        login.mainWindow.Window();
    }

    public static void Pane() throws InterruptedException {
        String[] options = { "Ingreso", "Agregar" };

        int option = JOptionPane.showOptionDialog(login.mainWindow.window, "Permitir ingreso \n Agregar alumnos",
                "Seleccione una opcion",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (option == 0) {
        	new ArrayManagment.getValues();
            LoadUI.Window();
        }
        if (option == 1) {
            ChargeUI.Window();
    		new searcher.Engine(ChargeUI.searchBar);
        }
        if (option != 0 && option != 1) {
            System.exit(1);
        }
    }
}
