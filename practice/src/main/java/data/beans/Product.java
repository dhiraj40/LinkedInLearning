/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.beans;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dhiraj
 */
public class Product {

        private int fdc_id;
        private String description;
        
        private String brand_owner;
        private String ingredients;
        private Double serving_size;
        private String serving_size_unit;
        private String household_serving_fulltext;
        private Map<Integer, Double> productNutrientMap = new HashMap<>(); //nutrient-id is key and its amoung in product is value

        public Product() {
        }

        public Product(int fdc_id, String description) {
                this.fdc_id = fdc_id;
                this.description = description;
        }

        public int getFdc_id() {
                return fdc_id;
        }

        public void setFdc_id(int fdc_id) {
                this.fdc_id = fdc_id;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getIngredients() {
                return ingredients;
        }

        public void setIngredients(String ingredients) {
                this.ingredients = ingredients;
        }

        public String getServing_size_unit() {
                return serving_size_unit;
        }

        public void setServing_size_unit(String serving_size_unit) {
                this.serving_size_unit = serving_size_unit;
        }

        public Double getServing_size() {
                return serving_size;
        }

        public void setServing_size(Double serving_size) {
                this.serving_size = serving_size;
        }

        public String getHousehold_serving_fulltext() {
                return household_serving_fulltext;
        }

        public void setHousehold_serving_fulltext(String household_serving_fulltext) {
                this.household_serving_fulltext = household_serving_fulltext;
        }

        public String getBrand_owner() {
                return brand_owner;
        }

        public void setBrand_owner(String brand_owner) {
                this.brand_owner = brand_owner;
        }

        public Map<Integer, Double> getProductNutrientMap() {
                return productNutrientMap;
        }

	public void setProductNutrientMap(Map<Integer, Double> productNutrientMap) {
		this.productNutrientMap = productNutrientMap;
	}

        

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Product{");
                sb.append("fdc_id=").append(fdc_id);
                sb.append(", description=").append(description);
                sb.append(", brand_owner=").append(brand_owner);
//                sb.append(", ingredients=").append(ingredients);
//                sb.append(", serving_size=").append(serving_size);
//                sb.append(", serving_size_unit=").append(serving_size_unit);
//                sb.append(", household_serving_fulltext=").append(household_serving_fulltext);
//                sb.append(", productNutrientMap=").append(productNutrientMap);
                sb.append('}');
                return sb.toString();
        }
        
        

}
