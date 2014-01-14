package tollBarrier.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;

import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import tollBarrier.barrier.TollBarrier;
import tollBarrier.vehicule.MoyenDePaiment;

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
public class ConfigDebit extends javax.swing.JFrame
{
	private JButton jButton1;
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JRadioButton jRadioButton4;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JComboBox jComboBox1;
	private JButton jButton2;
	private InterfaceGraphique parent;

	public ConfigDebit(InterfaceGraphique gui)
	{
		super();
		initGUI();
		parent = gui;
	}

	private void initGUI()
	{
		try
		{
			GroupLayout thisLayout = new GroupLayout(
					(JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			{
				jButton1 = new JButton();
				jButton1.setText("OK");
				jButton1.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent evt)
					{
						jButton1MouseClicked(evt);
					}
				});
			}
			{
				jButton2 = new JButton();
				jButton2.setText("Cancel");
				jButton2.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						jButton2Evt();
					}
				});
			}
			{
				ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
						new String[]
						{ "Voiture", "Camion", "Moto" });
				jComboBox1 = new JComboBox();
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jComboBox1ActionPerformed(evt);
					}
				});
			}
			{
				jRadioButton1 = new JRadioButton();
				jRadioButton1.setText("Carte Bancaire");
			}
			{
				jRadioButton2 = new JRadioButton();
				jRadioButton2.setText("Liquide");
			}
			{
				jRadioButton3 = new JRadioButton();
				jRadioButton3.setText("Abonnement");
			}
			{
				jRadioButton4 = new JRadioButton();
				jRadioButton4.setText("T�l�p�age");
				
			}
			{
				jTextField1 = new JTextField();
				jTextField1.setText("10");
			}
			{
				jLabel1 = new JLabel();
				jLabel1.setText("D�bit");
			}
			thisLayout.setVerticalGroup(thisLayout
					.createSequentialGroup()
					.addContainerGap()
					.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jRadioButton1, GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jRadioButton2, GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jRadioButton3, GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(jRadioButton4, GroupLayout.PREFERRED_SIZE,
							20, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(
							thisLayout
									.createParallelGroup(
											GroupLayout.Alignment.BASELINE)
									.addComponent(jTextField1,
											GroupLayout.Alignment.BASELINE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(jLabel1,
											GroupLayout.Alignment.BASELINE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
					.addGap(0, 43, Short.MAX_VALUE)
					.addGroup(
							thisLayout
									.createParallelGroup(
											GroupLayout.Alignment.BASELINE)
									.addComponent(jButton1,
											GroupLayout.Alignment.BASELINE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(jButton2,
											GroupLayout.Alignment.BASELINE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
			thisLayout
					.setHorizontalGroup(thisLayout
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									thisLayout
											.createParallelGroup()
											.addGroup(
													GroupLayout.Alignment.LEADING,
													thisLayout
															.createSequentialGroup()
															.addComponent(
																	jLabel1,
																	GroupLayout.PREFERRED_SIZE,
																	37,
																	GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(
																	LayoutStyle.ComponentPlacement.UNRELATED)
															.addComponent(
																	jTextField1,
																	GroupLayout.PREFERRED_SIZE,
																	62,
																	GroupLayout.PREFERRED_SIZE)
															.addPreferredGap(
																	LayoutStyle.ComponentPlacement.RELATED))
											.addGroup(
													GroupLayout.Alignment.LEADING,
													thisLayout
															.createSequentialGroup()
															.addComponent(
																	jComboBox1,
																	GroupLayout.PREFERRED_SIZE,
																	109,
																	GroupLayout.PREFERRED_SIZE)
															.addGap(13))
											.addComponent(
													jRadioButton1,
													GroupLayout.Alignment.LEADING,
													GroupLayout.PREFERRED_SIZE,
													122,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jRadioButton2,
													GroupLayout.Alignment.LEADING,
													GroupLayout.PREFERRED_SIZE,
													122,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jRadioButton3,
													GroupLayout.Alignment.LEADING,
													GroupLayout.PREFERRED_SIZE,
													122,
													GroupLayout.PREFERRED_SIZE)
											.addComponent(
													jRadioButton4,
													GroupLayout.Alignment.LEADING,
													GroupLayout.PREFERRED_SIZE,
													122,
													GroupLayout.PREFERRED_SIZE))
							.addGap(0, 77, Short.MAX_VALUE)
							.addComponent(jButton1, GroupLayout.PREFERRED_SIZE,
									59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(jButton2, GroupLayout.PREFERRED_SIZE,
									92, GroupLayout.PREFERRED_SIZE)
							.addContainerGap());
			pack();
			setSize(400, 300);
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jButton1MouseClicked(MouseEvent evt)
	{
		TollBarrier tb = TollBarrier.getInstance();
		HashSet<MoyenDePaiment> mdp = new HashSet<MoyenDePaiment>();
		if (jRadioButton1.isSelected())
			mdp.add(MoyenDePaiment.CB);
		if (jRadioButton2.isSelected())
			mdp.add(MoyenDePaiment.LIQUIDE);
		if (jRadioButton3.isSelected())
			mdp.add(MoyenDePaiment.ABONNEMENT);		
		if (jRadioButton4.isSelected() && jComboBox1.getSelectedItem() != "Camion")
			mdp.add(MoyenDePaiment.TELEPEAGE);
		
		tb.addDebit(jComboBox1.getSelectedItem().toString(),
				Integer.parseInt(jTextField1.getText()), mdp);
		parent.setVisible(true);
		this.setVisible(false);
	}

	private void jButton2Evt()
	{
		parent.setVisible(true);
		this.setVisible(false);
	}
	
	private void jComboBox1ActionPerformed(ActionEvent evt) {		
		if (jComboBox1.getSelectedItem() == "Camion")
		{
			System.out.println("désactivation du bouton");
			jRadioButton4.setEnabled(false);
		}
		else
			jRadioButton4.setEnabled(true);
	}

}
