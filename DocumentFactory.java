package creational_patterns.factory;

import creational_patterns.Document;
import creational_patterns.NewEmployeeDocument;
import creational_patterns.ProductSupplyDocument;

/**
 * Creation Pattern: Factory
 */
public class DocumentFactory {

    // Метод створення документа за його типом
    public Document createDocument(String documentType) {
        if (NewEmployeeDocument.class.getSimpleName().equals(documentType)) {
            return new NewEmployeeDocument();
        }
        if (ProductSupplyDocument.class.getSimpleName().equals(documentType)) {
            return new ProductSupplyDocument();
        } else {
            throw new IllegalArgumentException("Such document doesn't exist");
        }
    }

    // Реалізація TODO:
    public Document createDocumentByCharacteristics(String employeeName, String position, String productName, Integer quantity) {
        if (employeeName != null && position != null && productName == null) {
            NewEmployeeDocument newEmployeeDocument = new NewEmployeeDocument();
            newEmployeeDocument.setEmployeeName(employeeName);
            newEmployeeDocument.setPosition(position);
            return newEmployeeDocument;
        } else if (productName != null && quantity != null && employeeName == null) {
            ProductSupplyDocument productSupplyDocument = new ProductSupplyDocument();
            productSupplyDocument.setProductName(productName);
            productSupplyDocument.setQuantity(quantity);
            return productSupplyDocument;
        } else {
            throw new IllegalArgumentException("Cannot determine document type from given characteristics");
        }
    }
}
