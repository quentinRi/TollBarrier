package tollBarrier.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import tollBarrier.barrier.Debit;
import tollBarrier.barrier.TollBarrier;
import tollBarrier.barrier.TollBarrierListener;
import tollBarrier.bornes.Borne;

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
		TollBarrierListener
{
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
	private JTextField jTextField6;
	private JTextField jTextField8;
	private JEditorPane jEditorPane9;
	private JTextField jTextField7;
	private JEditorPane jEditorPane8;
	private JEditorPane jEditorPane7;
	private JRadioButton jRadioButton1;
	private JButton jButton11;
	private JTextField jTextField2;
	private JEditorPane jEditorPane6;
	private JEditorPane jEditorPane3;
	private JButton jButton6;

	private ConfigDebit cd;
	private ViewDebit viewDebitFrame;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				InterfaceGraphique inst = new InterfaceGraphique();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public InterfaceGraphique()
	{
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
				jEditorPane1.setText("Logiciel simulation barri�re");
				jEditorPane1.setEditable(false);
			}
			{
				jRadioButton1 = new JRadioButton();
				jRadioButton1.setText("Accélérer (X10)");
				jRadioButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						jRadioButton1ActionPerformed(evt);
					}
				});
			}
			{
				jEditorPane9 = new JEditorPane();
				jEditorPane9.setText("Argent encaissé par borne en moyenne");
			}
			{
				jTextField8 = new JTextField();
				jTextField8.setText("0");
				jTextField8.setEditable(false);
			}
			{
				jEditorPane8 = new JEditorPane();
				jEditorPane8.setText("Argent total encaissé");
			}
			{
				jTextField7 = new JTextField();
				jTextField7.setText("0");
				jTextField7.setEditable(false);
			}
			{
				jEditorPane7 = new JEditorPane();
				jEditorPane7.setText("Nombre alarmes déclenchées");
			}
			{
				jTextField6 = new JTextField();
				jTextField6.setEditable(false);
				jTextField6.setText("0");
			}
			{
				jButton11 = new JButton();
				jButton11.setText("Consulter D�bits");
				jButton11.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						jButton11MouseClicked();
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
				jEditorPane6.setText("Nombre de voies t�l�peage");
				jEditorPane6.setEditable(false);
			}
			{
				jTextField2 = new JTextField();
				jTextField2.setText("0");
				jTextField2.setEditable(false);
			}
			{
				jTextField5 = new JTextField();
				jTextField5.setText("0");
				jTextField5.setEditable(false);
			}
			{
				jButton1 = new JButton();
				jButton1.setText("+");
				jButton1.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().addBorne("Manuelle");
					}
				});
			}
			{
				jButton7 = new JButton();
				jButton7.setText("+");
				jButton7.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().addBorne("Automatique");
					}
				});
			}
			{
				jButton8 = new JButton();
				jButton8.setText("+");
				jButton8.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().addBorne("Telepeage");
					}
				});
			}
			{
				jButton2 = new JButton();
				jButton2.setText("-");
				jButton2.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().rmBorne("Manuelle");
					}
				});
			}
			{
				jButton9 = new JButton();
				jButton9.setText("-");
				jButton9.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().rmBorne("Automatique");
					}
				});
			}
			{
				jButton10 = new JButton();
				jButton10.setText("-");
				jButton10.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().rmBorne("Telepeage");
					}
				});
			}
			{
				jButton6 = new JButton();
				jButton6.setText("Ajouter D�bit");
				jButton6.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						jButton6MouseClicked();
					}
				});
			}
			{
				jButton3 = new JButton();
				jButton3.setText("D�marrer simulation");
				jButton3.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().demarrerSimulation();
					}
				});
			}
			{
				jButton4 = new JButton();
				jButton4.setText("Arr�ter simulation");
				jButton4.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.getInstance().arreterSimulation();
					}
				});
			}
			{
				jButton5 = new JButton();
				jButton5.setText("R�initialiser");
				jButton5.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						TollBarrier.reset();
					}
				});
			}
			{
				jEditorPane5 = new JEditorPane();
				jEditorPane5.setText("Nombre v�hicule en attente");
				jEditorPane5.setEditable(false);
			}
			{
				jTextField4 = new JTextField();
				jTextField4.setText("0");
				jTextField4.setEditable(false);
			}
			{
				jEditorPane4 = new JEditorPane();
				jEditorPane4.setText("Temps passage moyen ( seconde)");
			}
			{
				jTextField3 = new JTextField();
				jTextField3.setText("0");
				jTextField3.setEditable(false);
			}
			{
				jEditorPane2 = new JEditorPane();
				jEditorPane2.setText("Nombre de voies manuelles");
				jEditorPane2.setEditable(false);
			}
			{
				jTextField1 = new JTextField();
				jTextField1.setText("0");
				jTextField1.setEditable(false);
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
				    .addComponent(jButton5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jButton4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(31)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(10))
				    .addComponent(jEditorPane4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(6))
				    .addComponent(jEditorPane5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(10))
				    .addComponent(jEditorPane7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(10))
				    .addComponent(jEditorPane8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(jEditorPane9, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 10, Short.MAX_VALUE)))
				.addContainerGap(91, 91));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jEditorPane8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jTextField7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
				        .addGap(33))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jButton3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
				                .addGap(30)))
				        .addGap(25)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
				                .addGap(8))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGap(42)
				                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jEditorPane6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jEditorPane2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jTextField5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
				        .addGap(12)))
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jButton8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jButton7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jButton1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(jButton10, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jButton9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				            .addComponent(jButton2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				        .addGap(22))
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(jButton8, jButton11, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(thisLayout.createSequentialGroup()
				                .addGap(0, 0, Short.MAX_VALUE)
				                .addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addPreferredGap(jButton11, jButton5, LayoutStyle.ComponentPlacement.INDENT)
				                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
				                .addGap(0, 10, Short.MAX_VALUE)))))
				.addContainerGap(46, 46));
			pack();
			this.setSize(594, 572);
			TollBarrier.getInstance().addListener(this);
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButton6MouseClicked()
	{
		cd = new ConfigDebit(this);
		cd.setVisible(true);

		lockAll();
	}

	@Override
	public void updateArgentEncaisseMoyen() {
		jTextField8.setText("" + TollBarrier.getInstance().getArgentEncaisseMoyen());
	}

	@Override
	public void updateNombreAlarmes() {
		int nbAlarme = 0;
		for (Borne b : TollBarrier.getInstance().getBornes())
			nbAlarme += b.getNbAlarme();
		jTextField6.setText("" + nbAlarme);
	}
	
	@Override
	public void updateArgentEncaisse()
	{
		jTextField7.setText("" + TollBarrier.getInstance().getArgentEncaisse());
	}

	@Override
	public void updateVehiculesEnAttente()
	{
		jTextField4.setText(TollBarrier.getInstance()
				.getNombreVehiculeEnAttente().toString());
	}

	@Override
	public void updateTempsPassageMoyen()
	{
		jTextField3.setText(TollBarrier.getInstance().getTempsPassageMoyen()
				.toString());
	}

	@Override
	public void updateAll()
	{
		updateVehiculesEnAttente();
		updateTempsPassageMoyen();
		updateArgentEncaisse();
		updateBornes();
		updateArgentEncaisseMoyen();
		updateNombreAlarmes();
	}

	private void jButton11MouseClicked()
	{
		viewDebitFrame = new ViewDebit(this, TollBarrier.getInstance()
				.getListDebit());
		viewDebitFrame.setVisible(true);
		lockAll();
	}

	@Override
	public void startRunning()
	{
		jButton3.setEnabled(false);
		jButton5.setEnabled(false);
		jButton6.setEnabled(false);
	}

	@Override
	public void stopRunning()
	{
		jButton3.setEnabled(true);
		jButton5.setEnabled(true);
		jButton6.setEnabled(true);
	}

	private void lockAll()
	{
		jButton1.setEnabled(false);
		jButton2.setEnabled(false);
		jButton3.setEnabled(false);
		jButton4.setEnabled(false);
		jButton5.setEnabled(false);
		jButton6.setEnabled(false);
		jButton7.setEnabled(false);
		jButton8.setEnabled(false);
		jButton9.setEnabled(false);
		jButton10.setEnabled(false);
		jButton11.setEnabled(false);
		
		jRadioButton1.setEnabled(false);
	}

	protected void unlockAll()
	{
		jButton1.setEnabled(true);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
		jButton4.setEnabled(true);
		jButton5.setEnabled(true);
		jButton6.setEnabled(true);
		jButton7.setEnabled(true);
		jButton8.setEnabled(true);
		jButton9.setEnabled(true);
		jButton10.setEnabled(true);
		jButton11.setEnabled(true);
		
		jRadioButton1.setEnabled(true);
	}

	private void jRadioButton1ActionPerformed(ActionEvent evt)
	{
		for (Borne b : TollBarrier.getInstance().getBornes())
			b.accelerate();
		for (Debit d : TollBarrier.getInstance().getListDebit())
			d.accelerate();
	}

	@Override
	public void updateBornes()
	{
		jTextField1.setText(""+TollBarrier.getInstance().getNombreBornes("Manuelles"));
		jTextField2.setText(""+TollBarrier.getInstance().getNombreBornes("Automatiques"));
		jTextField5.setText(""+TollBarrier.getInstance().getNombreBornes("Telepeage"));
	}

}
