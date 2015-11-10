/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.teias.egitim.adresdefteri;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import tr.gov.teias.egitim.adresdefteri.entities.Adres;


/**
 *Adres kayıtları için repository servisi
 * 
 * @author ali
 */

@Repository
@Dependent
public abstract class AdresRepository extends AbstractEntityRepository<Adres, Long>{
    
    /**
     * verilen tckmlikno için adres defteri döndürür
     * 
     * @param tckn 11 hane TCKimlikno
     * 
     * @return eğer kayıt yoksa içi boş liste dönecek 
     */
    //Select c From Adres where c.tckn=: tckn
    public abstract List<Adres> findByTckn( String tckn);
    
    
    //ya da
    
    /*@Inject
    private EntityManager em;
    public List<Adres> findByTckn (String tckn){
    return em.createQuery("Select c From Adres c where c.Tckn=:Tckn")
            .setParameter("tckn", tckn)
            .getResultList();
            }
    */
}
