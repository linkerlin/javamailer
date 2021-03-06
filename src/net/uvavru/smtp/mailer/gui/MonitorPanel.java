package net.uvavru.smtp.mailer.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Monitor panel class partially generated.
 * 
 * @author stepan
 * 
 */
public class MonitorPanel extends JPanel {

	public MonitorPanel() {
		super();
		create();
		textPaneInstance = textPane;
	}

	/**
     * 
     */
	private static final long serialVersionUID = -2702024507197138938L;
	private JLabel lblCurrentState;

	public JLabel getLblCurrentState() {
		return lblCurrentState;
	}

	public void setLblCurrentState(JLabel lblCurrentState) {
		this.lblCurrentState = lblCurrentState;
	}

	/**
	 * Thread safe console appending.
	 * 
	 * @param text Text to append
	 */
	public void appendToConsole(String text) {
		synchronized (textPaneInstance) {
			textPaneInstance.setText(textPaneInstance.getText() + text + "\n");
		}
	}

	private JTextPane textPaneInstance;

	JTextPane textPane = new JTextPane();
	JTabbedPane tabbedPaneMonitor = new JTabbedPane(JTabbedPane.TOP);
	JScrollPane scrollPane = new JScrollPane();

	private void create() {

		GridBagLayout gbl_panelMonitor = new GridBagLayout();
		gbl_panelMonitor.columnWidths = new int[] { 170, 0 };
		gbl_panelMonitor.rowHeights = new int[] { 169, 0 };
		gbl_panelMonitor.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelMonitor.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gbl_panelMonitor);

		tabbedPaneMonitor = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPaneMonitor = new GridBagConstraints();
		gbc_tabbedPaneMonitor.fill = GridBagConstraints.BOTH;
		gbc_tabbedPaneMonitor.gridx = 0;
		gbc_tabbedPaneMonitor.gridy = 0;
		this.add(tabbedPaneMonitor, gbc_tabbedPaneMonitor);
		tabbedPaneMonitor.setBorder(new TitledBorder(null, "Monitor",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPaneMonitor.addTab("Info", null, panelInfo, null);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[] { 200, 200, 0 };
		gbl_panelInfo.rowHeights = new int[] { 14, 14, 0, 0 };
		gbl_panelInfo.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelInfo.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panelInfo.setLayout(gbl_panelInfo);

		JLabel lblState = new JLabel("State:");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.fill = GridBagConstraints.BOTH;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 0;
		panelInfo.add(lblState, gbc_lblState);

		lblCurrentState = new JLabel("stopped");
		GridBagConstraints gbc_lblCurrentState = new GridBagConstraints();
		gbc_lblCurrentState.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentState.fill = GridBagConstraints.BOTH;
		gbc_lblCurrentState.gridx = 1;
		gbc_lblCurrentState.gridy = 0;
		panelInfo.add(lblCurrentState, gbc_lblCurrentState);
		lblCurrentState.setForeground(Color.RED);

		JLabel lblThreadsCount = new JLabel("Threads count (idle/total):");
		GridBagConstraints gbc_lblThreadsCount = new GridBagConstraints();
		gbc_lblThreadsCount.anchor = GridBagConstraints.WEST;
		gbc_lblThreadsCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblThreadsCount.gridx = 0;
		gbc_lblThreadsCount.gridy = 1;
		panelInfo.add(lblThreadsCount, gbc_lblThreadsCount);

		GridBagConstraints gbc_lblCurrentThreadsCount = new GridBagConstraints();
		gbc_lblCurrentThreadsCount.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentThreadsCount.anchor = GridBagConstraints.WEST;
		gbc_lblCurrentThreadsCount.gridx = 1;
		gbc_lblCurrentThreadsCount.gridy = 1;
		panelInfo.add(lblCurrentThreadsCount, gbc_lblCurrentThreadsCount);

		JPanel panelConsole = new JPanel();
		tabbedPaneMonitor.addTab("Console", null, panelConsole, null);
		GridBagLayout gbl_panelConsole = new GridBagLayout();
		gbl_panelConsole.columnWidths = new int[] { 364, 0 };
		gbl_panelConsole.rowHeights = new int[] { 0, 50, 0 };
		gbl_panelConsole.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelConsole.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panelConsole.setLayout(gbl_panelConsole);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTHEAST;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panelConsole.add(panel, gbc_panel);

		JButton btnClear = new JButton("clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
			}
		});
		btnClear.setMargin(new Insets(0, 2, 0, 2));
		panel.add(btnClear);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panelConsole.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(textPane);

		textPane.setAlignmentX(Component.RIGHT_ALIGNMENT);

	}

	private JLabel lblCurrentThreadsCount = new JLabel("0");

	/**
	 * Update monitor's components and others too.
	 * 
	 * @param panelControl
	 */
	public void update(ControlPanel panelControl) {
		String text = String.valueOf(panelControl.mailer
				.getSenderIdlePoolCount())
				+ " / "
				+ String.valueOf(panelControl.mailer.getSenderRunningCount());
		lblCurrentThreadsCount.setText(text);
	}

}