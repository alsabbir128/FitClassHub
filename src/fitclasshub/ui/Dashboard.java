package fitclasshub.ui;

import fitclasshub.models.ClassSchedule;
import fitclasshub.models.Member;
import fitclasshub.main.CustomException;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Dashboard extends JFrame {
    private JTextField txtName, txtContact, txtMonths, txtFee, txtClassName, txtTime, txtTrainer;
    private JButton btnAddMember, btnAddClass, btnGenerateInvoice;

    public Dashboard() {
        setTitle("FitClassHub");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 5, 5));

        // Member form
        add(new JLabel("Member Name:"));
        txtName = new JTextField(); add(txtName);
        add(new JLabel("Contact:"));
        txtContact = new JTextField(); add(txtContact);
        add(new JLabel("Months:"));
        txtMonths = new JTextField(); add(txtMonths);
        add(new JLabel("Monthly Fee:"));
        txtFee = new JTextField(); add(txtFee);
        btnAddMember = new JButton("Add Member");
        add(btnAddMember); add(new JLabel(""));

        // Class form
        add(new JLabel("Class Name:"));
        txtClassName = new JTextField(); add(txtClassName);
        add(new JLabel("Time:"));
        txtTime = new JTextField(); add(txtTime);
        add(new JLabel("Trainer:"));
        txtTrainer = new JTextField(); add(txtTrainer);
        btnAddClass = new JButton("Add Class");
        add(btnAddClass); add(new JLabel(""));

        // Invoice button
        btnGenerateInvoice = new JButton("Generate Invoice");
        add(btnGenerateInvoice); add(new JLabel(""));

        // Event Listeners
        btnAddMember.addActionListener(e -> saveMember());
        btnAddClass.addActionListener(e -> saveClass());
        btnGenerateInvoice.addActionListener(e -> generateInvoice());
    }

    private void saveMember() {
        try {
            String name = txtName.getText().trim();
            String contact = txtContact.getText().trim();
            int months = Integer.parseInt(txtMonths.getText().trim());
            double fee = Double.parseDouble(txtFee.getText().trim());

            if (name.isEmpty() || contact.isEmpty()) throw new CustomException("Name/Contact cannot be empty");
            if (months <= 0 || fee <= 0) throw new CustomException("Months/Fee must be positive");

            Member m = new Member(name, contact, "Monthly", months, fee);
            double totalCost = (months >= 12) ? m.calculateMonthlyCost(10) : m.calculateMonthlyCost();

            FileWriter fw = new FileWriter("members.txt", true);
            fw.write(m.getDetails() + " | Total Cost: " + totalCost + "\n");
            fw.close();

            JOptionPane.showMessageDialog(this, "Member Added!");
        } catch (CustomException ce) {
            JOptionPane.showMessageDialog(this, ce.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }

    private void saveClass() {
        try {
            String cname = txtClassName.getText().trim();
            String time = txtTime.getText().trim();
            String trainer = txtTrainer.getText().trim();

            if (cname.isEmpty() || time.isEmpty() || trainer.isEmpty())
                throw new CustomException("All class fields required");

            ClassSchedule cs = new ClassSchedule(cname, time, trainer);
            FileWriter fw = new FileWriter("classes.txt", true);
            fw.write(cs.toString() + "\n");
            fw.close();

            JOptionPane.showMessageDialog(this, "Class Added!");
        } catch (CustomException ce) {
            JOptionPane.showMessageDialog(this, ce.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid class info");
        }
    }

    private void generateInvoice() {
        try {
            String name = JOptionPane.showInputDialog("Enter member name:");
            if (name == null || name.isEmpty()) throw new CustomException("Name required");

            BufferedReader br = new BufferedReader(new FileReader("members.txt"));
            String line; boolean found = false;
            FileWriter fw = new FileWriter("invoices.txt", true);
            while ((line = br.readLine()) != null) {
                if (line.contains(name)) {
                    fw.write("Invoice for: " + name + "\n" + line + "\n------------------\n");
                    found = true;
                    JOptionPane.showMessageDialog(this, "Invoice Generated!");
                    break;
                }
            }
            br.close();
            fw.close();
            if (!found) throw new CustomException("Member not found");
        } catch (CustomException ce) {
            JOptionPane.showMessageDialog(this, ce.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error generating invoice");
        }
    }
}
