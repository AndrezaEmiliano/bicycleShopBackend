package br.com.exactalabs.bicycleshop.Contoller;


import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById (@PathVariable Long id){
        var product = this.productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping
    public ResponseEntity<?> findAllProductByFilter(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "priceDirection", required = false, defaultValue = "ASC") String priceDirection,
            @RequestParam(value = "categoryDescription", required = false, defaultValue = "") String categoryDescription,
            @RequestParam(value = "productDescription", required = false, defaultValue = "") String productDescription){
        var products = this.productService.findAllProduct(
                pageNumber, priceDirection, categoryDescription, productDescription);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct (@RequestBody Product product){
        var newProduct = this.productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct (@PathVariable Long id, @RequestBody Product product){
        var updatedProduct = this.productService.updateProduct (id, product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedProduct);
    }
}
