/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package store3;

/**
 *
 * @author Tanzir
 */
public class ProductSpecificationRDBMapper implements IMapper {
    Object get (OID oid) {
       ProductSpecification ps = new ProductSpecification () ;
       //SQL statements to get produc specification from tbl_product_specification
       ps.setProductName (pName) ;
       ps.setPrice (pPrice) ;
       return ps ;
   }

}
