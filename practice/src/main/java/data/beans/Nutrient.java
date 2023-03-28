/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.beans;

/**
 *
 * @author Dhananjay Kapar (dhirajdhananjay4@gmail.com)
 */
public class Nutrient {

        int id;
        String name;
        String unit_name;
        int nutrient_nbr;
        double rank;

        public Nutrient(int id, String name, String unit_name, int nutrient_nbr, double rank) {
                this.id = id;
                this.name = name;
                this.unit_name = unit_name;
                this.nutrient_nbr = nutrient_nbr;
                this.rank = rank;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getUnit_name() {
                return unit_name;
        }

        public void setUnit_name(String unit_name) {
                this.unit_name = unit_name;
        }

        public int getNutrient_nbr() {
                return nutrient_nbr;
        }

        public void setNutrient_nbr(int nutrient_nbr) {
                this.nutrient_nbr = nutrient_nbr;
        }

        public double getRank() {
                return rank;
        }

        public void setRank(double rank) {
                this.rank = rank;
        }

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Nutrient{");
                sb.append("id=").append(id);
               sb.append(", name=").append(name);
//                sb.append(", unit_name=").append(unit_name);
//                sb.append(", nutrient_nbr=").append(nutrient_nbr);
//                sb.append(", rank=").append(rank);
                sb.append('}');
                return sb.toString();
        }

}
