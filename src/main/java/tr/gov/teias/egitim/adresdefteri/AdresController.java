/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.teias.egitim.adresdefteri;

import java.io.Serializable;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import tr.gov.teias.egitim.adresdefteri.entities.Adres;

/**
 *
 * @author ali
 */
@Named
@SessionScoped
//Session scope uyku yatarılabilmesi için serializable olması gerekir.
public class AdresController implements Serializable {

    @Inject
    private AdresRepository repository;

    private List<Adres> adresler;
    private Adres current;

    public AdresRepository getRepository() {
        return repository;
    }

    public void setRepository(AdresRepository repository) {
        this.repository = repository;
    }

    public Adres getCurrent() {
        return current;
    }

    public void setCurrent(Adres current) {
        this.current = current;
    }

    public void setAdresler(List<Adres> adresler) {
        this.adresler = adresler;
    }

    public List<Adres> getAdresler() {
        if (adresler == null) {
            populateAdresler();
        }
        return adresler;
    }

    protected void populateAdresler() {
        adresler = repository.findAll(0, 100);
    }

    public void createNewAdres() {
        current = new Adres();
    }

    @Transactional
    public void save() {
        repository.save(current);
    }
    
    public void edit(Long id){
        current= repository.findBy(id);
    }
    
    @Transactional
    public void delete() {
        repository.remove(current);
        current = null;
    }

}
