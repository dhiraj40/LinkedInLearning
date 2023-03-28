/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import data.beans.Nutrient;
import data.beans.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Dhananjay Kapar (dhirajdhananjay4@gmail.com)
 */


@SuppressWarnings("serial")
@WebServlet (urlPatterns = "/dataloader")
public class DataLoader extends HttpServlet {

	private Dao dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = Dao.getInstance();
		System.out.println("...loading products");
		loadProducts();
		System.out.println("...loading nutrients");
		loadNutrients();
		System.out.println("...loading productNutrients");
		loadProductNutrients();
		System.out.println("...data loading completed");
		
	}

	@Override
	public void destroy() {
		Dao.nutrientMap = null;
		Dao.productMap = null;
		try {
			if (dao.connection != null) {
				dao.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void loadProducts() {

		String query = "select fdc_id,short_description from branded_food";

		try {
			ResultSet resultSet = dao.connection.prepareStatement(query).executeQuery();
			while (resultSet.next()) {
				Product product = new Product(resultSet.getInt(1), resultSet.getString(2));
				Dao.productMap.put(product.getFdc_id(), product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			query = "select fdc_id, brand_owner, ingredients, serving_size, serving_size_unit, household_serving_fulltext from branded_food";
			ResultSet resultSet = dao.connection.prepareStatement(query).executeQuery();

			while (resultSet.next()) {
				Product tProduct = Dao.productMap.getOrDefault(resultSet.getString(1), null);

				if (tProduct == null) {
					continue;
				}

				tProduct.setBrand_owner(resultSet.getString(2));
				tProduct.setIngredients(resultSet.getString(3));
				tProduct.setServing_size(resultSet.getDouble(4));
				tProduct.setServing_size_unit(resultSet.getString(5));
				tProduct.setHousehold_serving_fulltext(resultSet.getString(6));

				Dao.productMap.put(tProduct.getFdc_id(), tProduct);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void loadNutrients() {

		String query = "select * from nutrient";

		try {
			ResultSet resultSet = dao.connection.prepareStatement(query).executeQuery();

			while (resultSet.next()) {
				Nutrient nutrient = new Nutrient(
					  resultSet.getInt(1),
					  resultSet.getString(2),
					  resultSet.getString(3),
					  resultSet.getInt(4),
					  resultSet.getDouble(5)
				);

				Dao.nutrientMap.put(nutrient.getId(), nutrient);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	private void loadProductNutrients() {

		String query = "select fdc_id, nutrient_id, amount from food_nutrient where amount>0";

		class ProdNut {

			int fdc_id;
			int nutrient_id;
			double amount;

			public ProdNut(int fdc_id, int nutrient_id, double amount) {
				this.fdc_id = fdc_id;
				this.nutrient_id = nutrient_id;
				this.amount = amount;
			}

		}
		
		List<ProdNut> pns = new ArrayList<>();

		try {
			ResultSet resultSet = dao.connection.prepareStatement(query).executeQuery();

			while (resultSet.next()) {
				pns.add(new ProdNut(resultSet.getInt(1),resultSet.getInt(2),resultSet.getDouble(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(ProdNut pn:pns)
		{
			if(!Dao.productMap.containsKey(pn.fdc_id)) continue;
			if(!Dao.nutrientMap.containsKey(pn.nutrient_id)) continue;
			
			Dao.productMap.get(pn.fdc_id).getProductNutrientMap().put(pn.nutrient_id, pn.amount);
		}

	}

}
