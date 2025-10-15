package creational_patterns.factory;

/**
 * DTO (Data Transfer Object) клас для зберігання характеристик документа.
 * Створений, щоб уникнути великої кількості параметрів у методі фабрики.
 */
public class DocumentData {
    private String employeeName;
    private String position;
    private String productName;
    private Integer quantity;

    // Гетери та сетери
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
