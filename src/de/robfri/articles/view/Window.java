package de.robfri.articles.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import de.robfri.articles.controller.*;
import de.robfri.articles.data.*;
import de.robfri.articles.model.*;

public class Window extends JFrame {

	public JPanel rootPane;
	public JTable table;
	public JTextField idTextField;
	public JTextField nameTextField;
	public JTextField descriptionTextField;
	public JTextField priceTextField;
	public JTableHeader tableHeader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			try {
				Window frame = new Window();
				frame.setLocationRelativeTo(null);
				frame.pack();
				frame.setVisible(true);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {

		ArticleTableModel model = new ArticleTableModel(Arrays.asList(new Article(), new Article()));
		Controller controller = new Controller(this, model);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ArticleManagement");

		Dimension dimension = new Dimension(800, 600);
		setSize(dimension);
		setMinimumSize(dimension);
		setPreferredSize(dimension);

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);

		JMenu menuFile = new JMenu("File");
		menu.add(menuFile);

		JMenuItem menuFileSave = new JMenuItem("Save");
		menuFile.add(menuFileSave);
		menuFileSave.addActionListener(controller::onFileSave);

		JMenuItem menuFileLoad = new JMenuItem("Load");
		menuFile.add(menuFileLoad);
		menuFileLoad.addActionListener(controller::onFileLoad);

		JMenu menuHelp = new JMenu("Help");
		menu.add(menuHelp);

		JMenuItem menuHelpAbout = new JMenuItem("About");
		menuHelp.add(menuHelpAbout);
		menuHelpAbout.addActionListener(controller::onHelpAbout);

		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		rootPane.setLayout(new BorderLayout(0, 0));
		setContentPane(rootPane);

		JPanel tableWrapper = new JPanel();
		rootPane.add(tableWrapper, BorderLayout.CENTER);
		tableWrapper.setLayout(new BorderLayout(0, 0));

		table = new JTable();
		tableWrapper.add(table, BorderLayout.CENTER);
		table.setModel(model);

		tableHeader = table.getTableHeader();
		tableWrapper.add(tableHeader, BorderLayout.NORTH);

		JPanel formWrapper = new JPanel();
		rootPane.add(formWrapper, BorderLayout.EAST);
		Dimension minFormWrapperWidth = new Dimension(260, 0);
		formWrapper.setPreferredSize(minFormWrapperWidth);
		formWrapper.setLayout(null);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(10, 14, 75, 14);
		formWrapper.add(idLabel);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 45, 75, 14);
		formWrapper.add(nameLabel);

		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(10, 76, 75, 14);
		formWrapper.add(descriptionLabel);

		JLabel priceLabel = new JLabel("Price:");
		priceLabel.setBounds(10, 107, 75, 14);
		formWrapper.add(priceLabel);

		idTextField = new JTextField();
		idTextField.setBounds(95, 11, 150, 20);
		formWrapper.add(idTextField);
		idTextField.setColumns(10);

		nameTextField = new JTextField();
		nameTextField.setBounds(95, 42, 150, 20);
		formWrapper.add(nameTextField);
		nameTextField.setColumns(10);

		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(95, 73, 150, 20);
		formWrapper.add(descriptionTextField);
		descriptionTextField.setColumns(10);

		priceTextField = new JTextField();
		priceTextField.setBounds(95, 104, 150, 20);
		formWrapper.add(priceTextField);
		priceTextField.setColumns(10);

		JButton addArticleButton = new JButton("Add");
		addArticleButton.setBounds(20, 135, 215, 23);
		formWrapper.add(addArticleButton);
		addArticleButton.addActionListener(controller::onAddArticle);
		
		JLabel footerLabel = new JLabel("(c) and App by Robert Andreas Fritsch");
		rootPane.add(footerLabel, BorderLayout.SOUTH);
	}
}
