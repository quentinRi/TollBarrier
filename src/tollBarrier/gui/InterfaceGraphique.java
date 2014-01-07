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


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class InterfaceGraphique extends javax.swing.JFrame {
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
	private JTextField jTextField2;
	private JEditorPane jEditorPane3;
	private Chrono task;
	private JButton jButton6;
	private Timer timer;
	private ConfigDebit cd;

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
	
	public void majVehiculeAttente () {
		task = new Chrono(jTextField4);
		timer = new Timer();
		timer.schedule(task, 0, 1000);
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jEditorPane1 = new JEditorPane();
				jEditorPane1.setText("Logiciel simulation barrière");
				jEditorPane1.setEditable(false);
			}
			{
				jButton6 = new JButton();
				jButton6.setText("Configurer Débit");
				jButton6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jButton6MouseClicked(evt);
					}
				});
			}
			{
				jButton3 = new JButton();
				jButton3.setText("Démarrer simulation");
				jButton3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						int nbrVoies = Integer.parseInt(jTextField1.getText());
						int debit = Integer.parseInt(jTextField2.getText());
						int tpsPassage = Integer.parseInt(jTextField3.getText());
						
						TollBarrier barrier = TollBarrier.getInstance();
						majVehiculeAttente();
						barrier.demarrerSimulation();
					}
				});
			}
			{
				jButton4 = new JButton();
				jButton4.setText("Arrêter simulation");
				jButton4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						TollBarrier barrier = TollBarrier.getInstance();
						timer.cancel();
						barrier.arreterSimulation();
					}
				});
			}
			{
				jButton5 = new JButton();
				jButton5.setText("Réinitialiser");
				jButton5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						TollBarrier barrier = TollBarrier.getInstance();						
						barrier.reinitialiser();
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
				jButton1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						int tmp = Integer.parseInt(jTextField1.getText());
						tmp++;
						jTextField1.setText(""+tmp);
					}
				});
			}
			{
				jButton2 = new JButton();
				jButton2.setText("-");
				jButton2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {

						int tmp = Integer.parseInt(jTextField1.getText());
						if(tmp > 0)
							tmp--;
						jTextField1.setText(""+tmp);
					}
				});
			}
			{
				jEditorPane3 = new JEditorPane();
				jEditorPane3.setText("Débit (nombre de voitures par min)");
				jEditorPane3.setEditable(false);
			}
			{
				jTextField2 = new JTextField();
				jTextField2.setText("0");
			}
			{
				jEditorPane2 = new JEditorPane();
				jEditorPane2.setText("Nombre de voies");
				jEditorPane2.setEditable(false);
			}
			{
				jTextField1 = new JTextField();
				jTextField1.setText("0");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jEditorPane1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jTextField1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jEditorPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(jTextField2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jButton6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				    .addComponent(jEditorPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jTextField3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jEditorPane4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jEditorPane5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(169, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jButton4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				                        .addGap(19))))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jEditorPane2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                        .addGap(154))
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addGap(46)
				                        .addComponent(jEditorPane1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jEditorPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
				                    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                        .addComponent(jEditorPane4, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
				                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
				                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(jTextField3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(jTextField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jEditorPane5, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                .addGap(38)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 30, Short.MAX_VALUE)))
				.addContainerGap(55, 55));
			pack();
			this.setSize(520, 402);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton6MouseClicked(MouseEvent evt) {
		cd = new ConfigDebit (this);
		cd.setVisible(true);
		this.setVisible(false);
	}

}