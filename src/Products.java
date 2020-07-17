import java.math.BigDecimal;

public class Products {

    private String name;
    private BigDecimal price; // comparar <0
    private ProductCategory productCategory;
    private Integer quantityProduct;
    private static int totalProduct;


    public Products() {
    }

    public Products (String name, BigDecimal price, ProductCategory productCategory, Integer quantityProduct) {
        Products.totalProduct++;
        this.name = name;
////        if (price.intValue() < 0){
////            System.out.println("O preço do produto não pode ser negativo");
////        }
////        else {
////            ontinue;
//        }
        this.price = price;
        this.productCategory = productCategory;
        this.quantityProduct = quantityProduct;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }


    public void editName(String newName){
        if(this.name == null){
            System.out.println("Insira um nome para o produto!");
            this.name = newName;
            System.out.println("O nome do produto foi cadastrado com sucesso!");
        }
        else if(this.name != newName){
            this.name = newName;
            System.out.println("O nome do produto foi alterado com sucesso!");
            }
        else{
            System.out.println("O nome do produto não foi alterado.");
        }
        System.out.println("O nome do produto é: " + getName());
    }


    public void discount (BigDecimal percentDiscount) {
        this.price = (price.subtract ((price.multiply(percentDiscount)).divide(new BigDecimal(100))));
        System.out.println("O novo valor do produto com o desconto de " + percentDiscount + "% concedido é: R$" + getPrice());
    }
}
