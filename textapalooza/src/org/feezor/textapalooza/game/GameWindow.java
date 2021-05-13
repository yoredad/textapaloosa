package org.feezor.textapalooza.game;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class GameWindow {

	protected Shell shell;
	private Text text;
	private Text txtHello;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GameWindow window = new GameWindow();
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
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(934, 550);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(10, 478, 819, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(851, 476, 57, 25);
		btnNewButton.setText("Submit");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 42, 898, 428);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		txtHello = new Text(scrolledComposite, SWT.BORDER);
		txtHello.setText("Hello");
		scrolledComposite.setContent(txtHello);
		scrolledComposite.setMinSize(txtHello.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 10, 898, 21);
		lblNewLabel.setText("Textapalooza V1.0");

	}
}
