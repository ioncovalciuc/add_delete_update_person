package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PersonGUI extends JFrame {
    private PersonManager personManager;
    private JTextField nameField, ageField, addressField;

    public PersonGUI() {
        personManager = new PersonManager();

        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel addressLabel = new JLabel("Address:");

        nameField = new JTextField(20);
        ageField = new JTextField(3);
        addressField = new JTextField(30);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String address = addressField.getText();
                Person person = new Person(name, age, address);
                personManager.addPerson(person);
                clearFields();
                displayAllPersons();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String address = addressField.getText();
                Person person = new Person(name, age, address);
                personManager.deletePerson(person);
                clearFields();
                displayAllPersons();
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String address = addressField.getText();
                Person oldPerson = new Person(name, age, address);

                String newName = JOptionPane.showInputDialog("Enter new name:");
                int newAge = Integer.parseInt(JOptionPane.showInputDialog("Enter new age:"));
                String newAddress = JOptionPane.showInputDialog("Enter new address:");
                Person newPerson = new Person(newName, newAge, newAddress);

                personManager.updatePerson(oldPerson, newPerson);
                clearFields();
                displayAllPersons();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        displayAllPersons();

        setTitle("Person Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayAllPersons() {
        List<Person> allPersons = personManager.getPersonList();
        StringBuilder sb = new StringBuilder();
        for (Person person : allPersons) {
            sb.append(person.getName()).append(" - ").append(person.getAge()).append(" - ").append(person.getAddress()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "All Persons", JOptionPane.PLAIN_MESSAGE);
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        new PersonGUI();
    }
}