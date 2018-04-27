package de.robfri.articles.model;

import java.util.*;
import java.util.stream.*;

import javax.swing.table.*;

import de.robfri.articles.data.*;

public class ArticleTableModel extends AbstractTableModel {

	private List<Article> articles;

	public ArticleTableModel() {
		
		this.articles = new ArrayList<>();
	}

	public ArticleTableModel(List<Article> articles) {
		
		this.articles = new ArrayList<>();
		this.articles.addAll(articles);
	}

	@Override
	public int getColumnCount() {
		
		return 4;
	}

	@Override
	public int getRowCount() {
		
		return articles.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Article article = articles.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return article.getId();

		case 1:
			return article.getName();

		case 2:
			return article.getDescription();

		case 3:
			return article.getPrice();

		default:
			throw new IndexOutOfBoundsException(
					"Article has only 4 attributes, but attribute " + columnIndex + " was requested!");
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return "ID";

		case 1:
			return "Name";

		case 2:
			return "Description";

		case 3:
			return "Price";

		default:
			throw new IndexOutOfBoundsException(
					"Article has only 4 attributes, but attribute " + columnIndex + " was requested!");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}

	@Override
	public void setValueAt(Object object, int rowIndex, int columnIndex) {
		
		String string = String.valueOf(object);
		
		Article article = articles.get(rowIndex);

		switch (columnIndex) {
		case 0:
			article.setId(Long.valueOf(string));
			break;

		case 1:
			article.setName(string);
			break;

		case 2:
			article.setDescription(string);
			break;

		case 3:
			article.setPrice(Double.valueOf(string));
			break;

		default:
			throw new IndexOutOfBoundsException(
					"Article has only 4 attributes, but attribute " + columnIndex + " was requested!");
		}
	}

	public void clear() {
		
		articles.clear();
		fireTableDataChanged();
	}

	public void add(Article article) {
		
		articles.add(article);
		fireTableDataChanged();
	}

	public Stream<Article> stream() {
		
		return articles.stream();
	}
}
