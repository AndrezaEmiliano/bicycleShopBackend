import java.math.BigDecimal;

public class Products {

    private String name;
    private BigDecimal price;
    private ProductCategory productCategory;
    private Integer quantityProduct;
    private static int totalProduct;


    public Products() {
    }

    public Products (String name, BigDecimal price, ProductCategory productCategory, Integer quantityProduct) {
        Products.totalProduct++;
        this.name = name;
        validatePrice (price);
        this.productCategory = productCategory;
        this.quantityProduct = quantityProduct;
    }


    private void validatePrice (BigDecimal price) throws PriceException{
        if (price.doubleValue() >=0){
            this.price = price;
        } else {
            throw new PriceException ("O preço do produto não pode ser negativo! O preço atual do produto é " + getPrice());
            }
    }

    public void setPrice(BigDecimal price) {
        validatePrice(price);
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
        this.price = (price.subtract ((price.multiply(percentDiscount)).divide(new BigDecimal(100))));
        System.out.println("O novo valor do produto com o desconto de " + percentDiscount + "% concedido é: R$" + getPrice());
    }
}
