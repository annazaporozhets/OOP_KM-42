package creational_patterns.factory;

import creational_patterns.Document;
import creational_patterns.NewEmployeeDocument;
import creational_patterns.ProductSupplyDocument;

/**
 * Creation Pattern: Factory
 */
public class DocumentFactory {

    /**
     * Factory Method (через об’єкт-даних):
     * Створює тип документа залежно від характеристик, переданих у DocumentData.
     * Параметри перевіряються в одному порядку для узгодженості.
     */
    public Document createDocumentByCharacteristics(DocumentData data) {
        if (data == null) throw new IllegalArgumentException("Document data cannot be null");

        String employeeName = data.getEmployeeName();
        String position = data.getPosition();
        String productName = data.getProductName();
        Integer quantity = data.getQuantity();

        // Порядок перевірки: employeeName → position → productName → quantity
        if (employeeName != null && position != null && productName == null && quantity == null) {
            NewEmployeeDocument doc = new NewEmployeeDocument();
            doc.setEmployeeName(employeeName);
            doc.setPosition(position);
            return doc;
        } else if (employeeName == null && position == null && productName != null && quantity != null) {
            ProductSupplyDocument doc = new ProductSupplyDocument();
            doc.setProductName(productName);
            doc.setQuantity(quantity);
            return doc;
        } else {
            throw new IllegalArgumentException("Cannot determine document type from given characteristics");
        }
    }
}
