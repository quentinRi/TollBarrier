package tollBarrier.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.barrier.TollBarrierListener;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class InterfaceGraphique extends javax.swing.JFrame implements
		TollBarrierListener {
	private static final long serialVersionUID = 7829192739725085653L;

	private JEditorPane jEditorPane1;
	private JEditorPane jEditorPane2;
	private JTextField jTextField1;
	private JButton jButton1;
	private JEditorPane jEditorPane5;
	private JButton jButton5;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JEditorPane jEditorPane4;
	private JButton jButton10;
	private JButton jButton9;
	private JButton jButton8;
	private JButton jButton7;
	private JTextField jTextField5;
	private JButton jButton11;
	private JTextField jTextField2;
	private JEditorPane jEditorPane6;
	private JEditorPane jEditorPane3;
	private JButton jButton6;

	private Timer timer;
	private ConfigDebit cd;
	private ViewDebit viewDebitFrame;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceGraphique inst = new InterfaceGraphique();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public InterfaceGraphique() {
		super();
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jEditorPane1 = new JEditorPane();
				jEditorPane1.setText("Logiciel simulation barrière");
				jEditorPane1.setEditable(false);
			}
			{
				jButton11 = new JButton();
				jButton11.setText("Consulter Débits");
				jButton11.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jButton11MouseClicked(evt);
					}
				});
			}
			{
				jEditorPane3 = new JEditorPane();
				jEditorPane3.setText("Nombre de voies automatiques");
				jEditorPane3.setEditable(false);
			}
			{
				jEditorPane6 = new JEditorPane();
				jEditorPane6.setText("Nombre de voies télépeage");
				jEditorPane6.setEditable(false);
			}
			{
				jTextField2 = new JTextField();
				jTextField2.setText("0");
			}
			{
				jTextField5 = new JTextField();
				jTextField5.setText("0");
			}
			{
				jButton7 = new JButton();
				jButton7.setText("+");
				jButton7.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						int tmp = Integer.parseInt(jTextField2.getText());
						tmp++;
						jTextField2.setText("" + tmp);
					}
				});
			}
			{
				jButton8 = new JButton();
				jButton8.setText("+");
				jButton8.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						int tmp = Integer.parseInt(jTextField5.getText());
						tmp++;
						jTextField5.setText("" + tmp);
					}
				});
			}
			{
				jButton9 = new JButton();
				jButton9.setText("-");
				jButton9.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{

						int tmp = Integer.parseInt(jTextField2.getText());
						if (tmp > 0)
							tmp--;
						jTextField2.setText("" + tmp);
					}
				});
			}
			{
				jButton10 = new JButton();
				jButton10.setText("-");
				jButton10.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{

						int tmp = Integer.parseInt(jTextField5.getText());
						if (tmp > 0)
							tmp--;
						jTextField5.setText("" + tmp);
					}
				});
			}
			{
				jButton6 = new JButton();
				jButton6.setText("Ajouter Débit");
				jButton6.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						jButton6MouseClicked(evt);
					}
				});
			}
			{
				jButton3 = new JButton();
				jButton3.setText("Démarrer simulation");
				jButton3.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						demarrerSimulation();
					}
				});
			}
			{
				jButton4 = new JButton();
				jButton4.setText("Arrêter simulation");
				jButton4.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						TollBarrier.getInstance().arreterSimulation();
					}
				});
			}
			{
				jButton5 = new JButton();
				jButton5.setText("Réinitialiser");
				jButton5.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						TollBarrier.reset();
					}
				});
			}
			{
				jEditorPane5 = new JEditorPane();
				jEditorPane5.setText("Nombre véhicule en attente");
				jEditorPane5.setEditable(false);
			}
			{
				jTextField4 = new JTextField();
				jTextField4.setText("0");
			}
			{
				jEditorPane4 = new JEditorPane();
				jEditorPane4.setText("Temps passage moyen ( seconde)");
			}
			{
				jTextField3 = new JTextField();
				jTextField3.setText("0");
			}
			{
				jButton1 = new JButton();
				jButton1.setText("+");
				jButton1.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						int tmp = Integer.parseInt(jTextField1.getText());
						tmp++;
						jTextField1.setText("" + tmp);
					}
				});
			}
			{
				jButton2 = new JButton();
				jButton2.setText("-");
				jButton2.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{

						int tmp = Integer.parseInt(jTextField1.getText());
						if (tmp > 0)
							tmp--;
						jTextField1.setText("" + tmp);
					}
				});
			}
			{
				jEditorPane2 = new JEditorPane();
				jEditorPane2.setText("Nombre de voies manuelles");
				jEditorPane2.setEditable(false);
			}
			{
				jTextField1 = new JTextField();
				jTextField1.setText("0");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jButton6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton11, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jEditorPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jEditorPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jButton9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jEditorPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jButton10, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jTextField5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jEditorPane6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(30)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(9))
				    .addComponent(jEditorPane4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jEditorPane5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)))
				.addContainerGap(78, 78));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jButton3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
				        .addGap(31)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
				                .addGap(24))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(36)
				                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jEditorPane6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jEditorPane5, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				                .addGap(21))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jEditorPane4, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				                .addGap(21))
				            .addComponent(jEditorPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                .addGap(12))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                .addGap(12))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addPreferredGap(jTextField4, jTextField5, LayoutStyle.ComponentPlacement.INDENT)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jTextField5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jTextField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))))
				        .addGap(12)))
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 44, Short.MAX_VALUE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jButton8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jButton7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jButton1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jButton10, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				            .addGroup(thisLayout.createSequentialGroup()
				                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
				        .addGap(0, 22, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(jButton5, jButton11, LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)))
				.addContainerGap(18, 18));
			pack();
			this.setSize(572, 402);
			TollBarrier.getInstance().addListener(this);
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButton6MouseClicked(MouseEvent evt) {
		cd = new ConfigDebit(this);
		cd.setVisible(true);
		this.setVisible(false);
	}

	@Override
	public void updateVehiculesEnAttente() {
		jTextField4.setText(TollBarrier.getInstance()
				.getNombreVehiculeEnAttente().toString());
	}

	@Override
	public void updateTempsPassageMoyen() {
		jTextField3.setText(TollBarrier.getInstance().getTempsPassageMoyen()
				.toString());
	}

	private void demarrerSimulation() {
		TollBarrier barrier = TollBarrier.getInstance();
		for (int i = 0; i < Integer.parseInt(jTextField1.getText()); i++)
			barrier.addBorne("Manuelle");
		for (int i = 0; i < Integer.parseInt(jTextField2.getText()); i++)
			barrier.addBorne("Automatique");
		for (int i = 0; i < Integer.parseInt(jTextField5.getText()); i++)
			barrier.addBorne("Telepeage");
		barrier.demarrerSimulation();
	}

	@Override
	public void updateAll()
	{
		updateVehiculesEnAttente();
		updateTempsPassageMoyen();
		updateArgentEncaisse();
	}

	private void jButton11MouseClicked(MouseEvent evt) {
		viewDebitFrame = new ViewDebit(this, TollBarrier.getInstance()
				.getListDebit());
		viewDebitFrame.setVisible(true);
		this.setVisible(false);
	}

	@Override
	public void updateArgentEncaisse()
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void startRunning()
	{
		// TODO Auto-generated method stub

		jButton1.setEnabled(false);
		jButton2.setEnabled(false);
		jButton3.setEnabled(false);
		jButton6.setEnabled(false);
		jButton7.setEnabled(false);
		jButton8.setEnabled(false);
		jButton9.setEnabled(false);
		jButton10.setEnabled(false);
	}

	@Override
	public void stopRunning()
	{
		// TODO Auto-generated method stub
		
		jButton1.setEnabled(true);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
		jButton6.setEnabled(true);
		jButton7.setEnabled(true);
		jButton8.setEnabled(true);
		jButton9.setEnabled(true);
		jButton10.setEnabled(true);
	}

}
