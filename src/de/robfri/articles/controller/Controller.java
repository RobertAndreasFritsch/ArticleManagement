package de.robfri.articles.controller;

import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

import javax.swing.*;

import de.robfri.articles.data.*;
import de.robfri.articles.model.*;
import de.robfri.articles.view.*;

public class Controller {

	private Window window;
	private ArticleTableModel model;

	public Controller(Window window, ArticleTableModel model) {

		this.window = window;
		this.model = model;
	}

	public void onFileSave(ActionEvent ignore) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(window);

		File file = fileChooser.getSelectedFile();
		if (file == null) {
			// exited fileChooser
			return;
		}

		try (PrintStream out = new PrintStream(file)) {

			model.stream()
			     .map(Articles::toCSV)
			     .forEach(out::println);

		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(window, "Can not access file\nError: " + e.getMessage(), "Error",
					JOptionPane.OK_OPTION);
		}
	}

	public void onFileLoad(ActionEvent ignore) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(window);

		File file = fileChooser.getSelectedFile();
		if (file == null) {
			// exited fileChooser
			return;
		}

		try {

			model.clear();

			Files.lines(file.toPath())
			     .map(Articles::fromCSV)
			     .forEach(model::add);

		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(window, "Can not access file\nError: " + e.getMessage(), "Error",
					JOptionPane.OK_OPTION);
			
		} catch (IllegalArgumentException e) {
			
			JOptionPane.showMessageDialog(window, "File is corrupted!", "Error",
					JOptionPane.OK_OPTION);
		}
	}

	public void onHelpAbout(ActionEvent ignore) {

		JOptionPane.showMessageDialog(window, "", "Error", JOptionPane.OK_OPTION);
	}

	public void onAddArticle(ActionEvent ignore) {

		String id          = window.idTextField.getText();
		String name        = window.nameTextField.getText();
		String description = window.descriptionTextField.getText();
		String price       = window.priceTextField.getText();
		
		try {
			
			model.add(Articles.fromArgs(id, name, description, price));
			
			window.idTextField.setText("");
			window.nameTextField.setText("");
			window.descriptionTextField.setText("");
			window.priceTextField.setText("");
			
		} catch (IllegalArgumentException e) {
			
			JOptionPane.showMessageDialog(window, "Given attributes are corrupted!", "Error",
					JOptionPane.OK_OPTION);
		}
	}
}
