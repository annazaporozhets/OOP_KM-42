package grasp.items;

import grasp.exeption.ItemNotAddedException;

public class OrderItem {
    private Product product;
    private int number;
    private double kilos;

    public OrderItem(Product product, int number) {
        this.product = product;
        this.number = number;

        validateNumber(product, number);
    }

    public OrderItem(Product product, double kilos) {
        this.product = product;
        this.number = number;
        validateKilos(product, kilos);
    }

/* this all was overriden by using Polymorphism; if-else - замінені поліморфізмом, до цього треба наближатись в ООП програмуванні.
Застосовується поліморфізм на рівні різних видів продуктів, які забороняють наявність створити продукт не з тими параметрами,
а також на рівні конструкторів, які вимагають тільки певні
    public OrderItem(Product product, int number, double kilos) {
        this.product = product;
        this.number = number;

        validateNumbers(product, number, kilos);
    }

    private void validateNumbers(Product product, int number, double kilos) {
        if (product instanceof ProductByKilos){
            validateKilos(product, kilos);
        }else if (product instanceof ProductByQuantity){
            validateNumber(product, number);
        } else throw new UnsupportedOperationException( "No product of your type was found.");
    }

    private boolean validateTrhoughIfs(Product product, int number, double kilos){
        if (kilos > 0 && number > 0){
            throw new ItemNotAddedException("Please specify either the number or kilograms for product: " + product);
        }else if (number > 0) {
            return validateNumber(product, number);
        } else if (kilos > 0) {
            return validateKilos(product, kilos);
        } else if (kilos <= 0 && number <= 0) {
            throw new ItemNotAddedException("Please specify the number or kilograms for product: " + product);
        } else {
            throw new ItemNotAddedException("Please specify correct number or kilograms for product: " + product);
        } ,mmmk//L</;hbnkhfuy
    }*/

    private boolean validateKilos(Product product, double kilos) {
        if (kilos <= 0) {
            throw new ItemNotAddedException("The number of kilograms must be greater than 0 for the product: " + product);
        }

        if (product instanceof ProductByKilos p) {
            if (kilos > p.getAvailableKilos()) {
                throw new ItemNotAddedException(
                        "It is not possible to purchase more than is available. Available: " + p.getAvailableKilos() + " кг.");
            }
        }
        return true;
    }

    private boolean validateNumber(Product product, int number) {
           if (number <= 0) {
            throw new ItemNotAddedException("The number of units must be greater than 0 for the product: " + product);
        }

        if (product instanceof ProductByQuantity p) {
            if (number > p.getAvailableQuantity()) {
                throw new ItemNotAddedException(
                        "It is not possible to purchase more than is available. Available: " + p.getAvailableQuantity() + " шт.");
            }
        }
        return true;
    }

    public double countPrice(){
        return number * product.getPrice();
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", number=" + number +
                '}';
    }
}
