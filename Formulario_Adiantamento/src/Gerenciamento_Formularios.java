import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;

public class Gerenciamento_Formularios {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Gerenciamento_Formularios window = new Gerenciamento_Formularios();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlGerenciamentoDeFormulrios = new Shell();
		shlGerenciamentoDeFormulrios.setMinimumSize(new Point(600, 480));
		shlGerenciamentoDeFormulrios.setSize(450, 300);
		shlGerenciamentoDeFormulrios.setText("Gerenciamento de Formul\u00E1rios");
		shlGerenciamentoDeFormulrios.setLayout(null);
		
		Label lblEscolhaOTipo = new Label(shlGerenciamentoDeFormulrios, SWT.NONE);
		lblEscolhaOTipo.setBounds(28, 5, 538, 50);
		lblEscolhaOTipo.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD));
		lblEscolhaOTipo.setText("Escolha o tipo de Formul\u00E1rio que deseja preencher e escolha \r\nas devidas op\u00E7\u00F5es: ");

		shlGerenciamentoDeFormulrios.open();
		shlGerenciamentoDeFormulrios.layout();
		while (!shlGerenciamentoDeFormulrios.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
