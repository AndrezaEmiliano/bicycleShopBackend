import java.math.BigDecimal;

public class Products {

    private String name;
    private BigDecimal price;
    private ProductCategory productCategory;
    private Integer quantityProduct;
    private static int totalProduct;


    public Products() {
        Products.totalProduct++;
    }

    public Products (String name, BigDecimal price, ProductCategory productCategory, Integer quantityProduct) {
        this();
        this.name = name;
        setPrice (price);
        this.productCategory = productCategory;
        this.quantityProduct = quantityProduct;
    }


    private void setPrice (BigDecimal price) throws PriceException {
        if (price == null) {
            throw new PriceException("O preço do produto não pode ser nulo!");
        }
        if (price.doubleValue() < 0) {
            throw new PriceException("O preço do produto não pode ser negativo!");
        }
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public static int getTotalProduct(){
        return Products.totalProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public void setDiscount (BigDecimal percentDiscount) {
        this.price = (price.subtract ((price.multiply(percentDiscount)).divide(BigDecimal.valueOf(100))));
    }
}
