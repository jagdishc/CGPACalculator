/*
 * CGPACalculatorView.java
 */

package cgpacalculator;

import java.awt.ItemSelectable;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * The application's main frame.
 */
public class CGPACalculatorView extends FrameView {

    public CGPACalculatorView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
       

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                   
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                   
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    
                }
            }
        });
        
        ActionListener actionListener = new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {                
                ItemSelectable is = (ItemSelectable)actionEvent.getSource();                
                if(selectedString(is).equals("7") || selectedString(is).equals("1"))
                {
                    sub_credit_9.setVisible(false);
                    sub_grade_9.setVisible(false);
                }
                else if(selectedString(is).equals("8"))
                {
                    sub_credit_9.setVisible(false);
                    sub_grade_9.setVisible(false);
                    sub_credit_8.setVisible(false);
                    sub_grade_8.setVisible(false);
                    sub_credit_7.setVisible(false);
                    sub_grade_7.setVisible(false);
                    sub_credit_6.setVisible(false);
                    sub_grade_6.setVisible(false);
                    sub_credit_5.setVisible(false);
                    sub_grade_5.setVisible(false);
                    sub_credit_4.setVisible(false);
                    sub_grade_4.setVisible(false);
                    sub_credit_3.setVisible(false);
                    sub_grade_3.setVisible(false);
                }
                else
                {
                    sub_credit_9.setVisible(true);
                    sub_grade_9.setVisible(true);
                }
                
                statusLabel.setText("Add grades for semester " + selectedString(is));
            }
        };
        semesters.addActionListener(actionListener);
        
        if(semesters.getSelectedItem().toString().equals("1")==true)
        {
             sub_credit_9.setVisible(false);
             sub_grade_9.setVisible(false);
        }
        
        sm = new StoreMarks();
        reset();
        semesters.setSelectedIndex(0);    
        
        statusLabel.setText("Add grades for semester " + semesters.getSelectedItem().toString());
    }
    
    private String selectedString(ItemSelectable is)
    {
        Object selected[] = is.getSelectedObjects();
        return ((selected.length == 0) ? "null" : (String)selected[0]);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = CGPACalculatorApp.getApplication().getMainFrame();
            aboutBox = new CGPACalculatorAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        CGPACalculatorApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        selectSemLabel = new javax.swing.JLabel();
        semesters = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        creditsLabel = new javax.swing.JLabel();
        selectGradeLabel = new javax.swing.JLabel();
        sub_credit_1 = new javax.swing.JSpinner();
        sub_grade_1 = new javax.swing.JComboBox();
        sub_credit_2 = new javax.swing.JSpinner();
        sub_grade_2 = new javax.swing.JComboBox();
        sub_credit_3 = new javax.swing.JSpinner();
        sub_grade_3 = new javax.swing.JComboBox();
        sub_credit_4 = new javax.swing.JSpinner();
        sub_grade_4 = new javax.swing.JComboBox();
        sub_credit_5 = new javax.swing.JSpinner();
        sub_grade_5 = new javax.swing.JComboBox();
        sub_credit_6 = new javax.swing.JSpinner();
        sub_grade_6 = new javax.swing.JComboBox();
        sub_credit_7 = new javax.swing.JSpinner();
        sub_grade_7 = new javax.swing.JComboBox();
        sub_credit_8 = new javax.swing.JSpinner();
        sub_grade_8 = new javax.swing.JComboBox();
        sub_credit_9 = new javax.swing.JSpinner();
        sub_grade_9 = new javax.swing.JComboBox();
        continue_btn = new javax.swing.JButton();
        calcGPA = new javax.swing.JButton();
        calcCGPA = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        new_data = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cgpacalculator.CGPACalculatorApp.class).getContext().getResourceMap(CGPACalculatorView.class);
        selectSemLabel.setFont(resourceMap.getFont("selectSemLabel.font")); // NOI18N
        selectSemLabel.setText(resourceMap.getString("selectSemLabel.text")); // NOI18N
        selectSemLabel.setName("selectSemLabel"); // NOI18N

        semesters.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        semesters.setName("semesters"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        jSeparator2.setName("jSeparator2"); // NOI18N

        creditsLabel.setFont(resourceMap.getFont("creditsLabel.font")); // NOI18N
        creditsLabel.setText(resourceMap.getString("creditsLabel.text")); // NOI18N
        creditsLabel.setName("creditsLabel"); // NOI18N

        selectGradeLabel.setFont(resourceMap.getFont("selectGradeLabel.font")); // NOI18N
        selectGradeLabel.setText(resourceMap.getString("selectGradeLabel.text")); // NOI18N
        selectGradeLabel.setName("selectGradeLabel"); // NOI18N

        sub_credit_1.setName("sub_credit_1"); // NOI18N

        sub_grade_1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_1.setName("sub_grade_1"); // NOI18N

        sub_credit_2.setName("sub_credit_2"); // NOI18N

        sub_grade_2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_2.setName("sub_grade_2"); // NOI18N

        sub_credit_3.setName("sub_credit_3"); // NOI18N

        sub_grade_3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_3.setName("sub_grade_3"); // NOI18N

        sub_credit_4.setName("sub_credit_4"); // NOI18N

        sub_grade_4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_4.setName("sub_grade_4"); // NOI18N

        sub_credit_5.setName("sub_credit_5"); // NOI18N

        sub_grade_5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_5.setName("sub_grade_5"); // NOI18N

        sub_credit_6.setName("sub_credit_6"); // NOI18N

        sub_grade_6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_6.setName("sub_grade_6"); // NOI18N

        sub_credit_7.setName("sub_credit_7"); // NOI18N

        sub_grade_7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_7.setName("sub_grade_7"); // NOI18N

        sub_credit_8.setName("sub_credit_8"); // NOI18N

        sub_grade_8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_8.setName("sub_grade_8"); // NOI18N

        sub_credit_9.setName("sub_credit_9"); // NOI18N

        sub_grade_9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "A", "B", "C", "D", "E", "U" }));
        sub_grade_9.setName("sub_grade_9"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cgpacalculator.CGPACalculatorApp.class).getContext().getActionMap(CGPACalculatorView.class, this);
        continue_btn.setAction(actionMap.get("continueAddingMarks")); // NOI18N
        continue_btn.setText(resourceMap.getString("continue_btn.text")); // NOI18N
        continue_btn.setName("continue_btn"); // NOI18N

        calcGPA.setAction(actionMap.get("calculateMyGPA")); // NOI18N
        calcGPA.setText(resourceMap.getString("calcGPA.text")); // NOI18N
        calcGPA.setName("calcGPA"); // NOI18N

        calcCGPA.setAction(actionMap.get("calculateMyCGPA")); // NOI18N
        calcCGPA.setText(resourceMap.getString("calcCGPA.text")); // NOI18N
        calcCGPA.setName("calcCGPA"); // NOI18N

        statusLabel.setFont(resourceMap.getFont("statusLabel.font")); // NOI18N
        statusLabel.setText(resourceMap.getString("statusLabel.text")); // NOI18N
        statusLabel.setName("statusLabel"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(selectSemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(semesters, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(creditsLabel)
                .addGap(94, 94, 94)
                .addComponent(selectGradeLabel)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(sub_credit_9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sub_credit_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addComponent(continue_btn))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sub_grade_9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sub_grade_1, 0, 84, Short.MAX_VALUE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(calcGPA)
                        .addGap(37, 37, 37)
                        .addComponent(calcCGPA)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addComponent(statusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSemLabel)
                    .addComponent(semesters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditsLabel)
                    .addComponent(selectGradeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub_credit_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_grade_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continue_btn)
                    .addComponent(calcGPA)
                    .addComponent(calcCGPA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        new_data.setAction(actionMap.get("clear")); // NOI18N
        new_data.setText(resourceMap.getString("new_data.text")); // NOI18N
        new_data.setName("new_data"); // NOI18N
        fileMenu.add(new_data);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    
    private void addValues()
    {
        String sem = semesters.getSelectedItem().toString();
        credits_grades = new HashMap<String, String[][]>();    
        String temp1, temp2, temp[][];
        
        if(sem.equals("7")==false && sem.equals("1")==false)
        {
              temp1 = sub_credit_1.getValue().toString();                
              temp2 = sub_grade_1.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_1", temp);
              
              temp1 = sub_credit_2.getValue().toString();
              temp2 = sub_grade_2.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_2", temp);
              
              temp1 = sub_credit_3.getValue().toString();
              temp2 = sub_grade_3.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_3", temp);
              
              temp1 = sub_credit_4.getValue().toString();
              temp2 = sub_grade_4.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_4", temp);
              
              temp1 = sub_credit_5.getValue().toString();
              temp2 = sub_grade_5.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_5", temp);
              
              temp1 = sub_credit_6.getValue().toString();
              temp2 = sub_grade_6.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_6", temp);
              
              temp1 = sub_credit_7.getValue().toString();
              temp2 = sub_grade_7.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_7", temp);
              
              temp1 = sub_credit_8.getValue().toString();
              temp2 = sub_grade_8.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_8", temp);
              
              temp1 = sub_credit_9.getValue().toString();
              temp2 = sub_grade_9.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_9", temp);
        }
        else if(sem.equals("8"))
        {
              temp1 = sub_credit_1.getValue().toString();                
              temp2 = sub_grade_1.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_1", temp);
              
              temp1 = sub_credit_2.getValue().toString();
              temp2 = sub_grade_2.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_2", temp);
        }
        else
        {
            
              temp1 = sub_credit_1.getValue().toString();                
              temp2 = sub_grade_1.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_1", temp);
              
              temp1 = sub_credit_2.getValue().toString();
              temp2 = sub_grade_2.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_2", temp);
              
              temp1 = sub_credit_3.getValue().toString();
              temp2 = sub_grade_3.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_3", temp);
              
              temp1 = sub_credit_4.getValue().toString();
              temp2 = sub_grade_4.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_4", temp);
              
              temp1 = sub_credit_5.getValue().toString();
              temp2 = sub_grade_5.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_5", temp);
              
              temp1 = sub_credit_6.getValue().toString();
              temp2 = sub_grade_6.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_6", temp);
              
              temp1 = sub_credit_7.getValue().toString();
              temp2 = sub_grade_7.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_7", temp);
              
              temp1 = sub_credit_8.getValue().toString();
              temp2 = sub_grade_8.getSelectedItem().toString();
              temp = new String[1][2];
              temp[0][0] = temp1;
              temp[0][1] = temp2;              
              credits_grades.put("sub_8", temp);              
        }
    }
    @Action
    public void continueAddingMarks() 
    {
        String selected = semesters.getSelectedItem().toString();
        if(sm.grades.containsKey(selected) == false)
        {            
            addValues();
            sm.addValue(selected, credits_grades);        
            reset(); 
        }
        else
        {
            statusLabel.setText("Cannot enter duplicated data. Select different semester and add grades.");
        }
               
    }

    @Action
    public void calculateMyGPA() 
    {
        String selected = semesters.getSelectedItem().toString();
        if(sm.grades.containsKey(selected) == false)
        {
            continueAddingMarks();
            calc = new Calculator(selected, sm);
            calc.calculateGPA();
        }
        else
        {
            calc = new Calculator(selected, sm);
            calc.calculateGPA();
            //statusLabel.setText("Cannot enter duplicated data. Select different semester and add grades.");
        }
    }

    @Action
    public void calculateMyCGPA() 
    {
        String selected = semesters.getSelectedItem().toString();
        if(sm.grades.containsKey(selected) == false)
        {
            continueAddingMarks();
            calc = new Calculator(sm);    
            calc.calculateCGPA();
        }
        else
        {
            calc = new Calculator(sm);    
            calc.calculateCGPA();
            //statusLabel.setText("Cannot enter duplicated data. Select different semester and add grades.");
        }
    }
    
    private void reset()
    {
        //semesters.setSelectedIndex(semesters.getSelectedIndex() + 1);        
        sub_credit_1.setModel(snm1);
        sub_credit_2.setModel(snm2);
        sub_credit_3.setModel(snm3);
        sub_credit_4.setModel(snm4);
        sub_credit_5.setModel(snm5);
        sub_credit_6.setModel(snm6);
        sub_credit_7.setModel(snm7);
        sub_credit_8.setModel(snm8);
        sub_credit_9.setModel(snm9);
        
        sub_grade_1.setSelectedIndex(0);
        sub_grade_2.setSelectedIndex(0);
        sub_grade_3.setSelectedIndex(0);
        sub_grade_4.setSelectedIndex(0);
        sub_grade_5.setSelectedIndex(0);
        sub_grade_6.setSelectedIndex(0);
        sub_grade_7.setSelectedIndex(0);
        sub_grade_8.setSelectedIndex(0);
        sub_grade_8.setSelectedIndex(0);
        
        statusLabel.setText("Select different semester and continue adding your grades.");
    }

    @Action
    public void clear() 
    {
        sm = new StoreMarks();
        statusLabel.setText("Select the semester and add your grades.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcCGPA;
    private javax.swing.JButton calcGPA;
    private javax.swing.JButton continue_btn;
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem new_data;
    private javax.swing.JLabel selectGradeLabel;
    private javax.swing.JLabel selectSemLabel;
    private javax.swing.JComboBox semesters;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JSpinner sub_credit_1;
    private javax.swing.JSpinner sub_credit_2;
    private javax.swing.JSpinner sub_credit_3;
    private javax.swing.JSpinner sub_credit_4;
    private javax.swing.JSpinner sub_credit_5;
    private javax.swing.JSpinner sub_credit_6;
    private javax.swing.JSpinner sub_credit_7;
    private javax.swing.JSpinner sub_credit_8;
    private javax.swing.JSpinner sub_credit_9;
    private javax.swing.JComboBox sub_grade_1;
    private javax.swing.JComboBox sub_grade_2;
    private javax.swing.JComboBox sub_grade_3;
    private javax.swing.JComboBox sub_grade_4;
    private javax.swing.JComboBox sub_grade_5;
    private javax.swing.JComboBox sub_grade_6;
    private javax.swing.JComboBox sub_grade_7;
    private javax.swing.JComboBox sub_grade_8;
    private javax.swing.JComboBox sub_grade_9;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    public StoreMarks sm;
    private JDialog aboutBox;
    public HashMap<String, String[][]> credits_grades;
    public Calculator calc;
    private SpinnerModel snm1 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm2 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm3 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm4 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm5 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm6 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm7 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm8 = new SpinnerNumberModel(4, 2, 5, 1);
    private SpinnerModel snm9 = new SpinnerNumberModel(4, 2, 5, 1);
}
