package projectClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class myTable {
        private final SimpleStringProperty country;
        private final SimpleIntegerProperty count;

        public myTable(String country, Integer count) {
            this.country = new SimpleStringProperty(country);
            this.count = new SimpleIntegerProperty(count);
        }

        public String getCountry() {
            return country.get();
        }

        public void setCountry(String country) {
            this.country.set(country);
        }

        public int getCount() {
            return count.get();
        }


        public void setCount(int count) {
            this.count.set(count);
        }
}
