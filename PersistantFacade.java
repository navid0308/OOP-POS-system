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
public class PersistantFacade {
     public Object get (OID oid, Class   persistenceClass) {
     // an Imapper is keyed by the Class of the persistence Object
     Imapper mapper = (IMapper) mappers.get (persistenceClass)
     
     // delegate
     return  mapper.get ( oid ) ;
    }
     
    /*HashMap <IMapper> mappers = new HashMap  <IMapper> () ;
    mappers.put ( new ProducSpecification (), new ProductSpecificationRDBMapper () ) ;
    Mappers.put ( new Sale (), new SaleRDBMapper () ) ; */
 

}
