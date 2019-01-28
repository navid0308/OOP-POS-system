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
public interface IMapper {
    public Object get(OID oid);
    public void put(OID oid, Object obj);
}
