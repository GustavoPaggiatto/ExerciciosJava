package challenge.business;

import challenge.repository.*;
import challenge.Domain.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustavo
 */
public class DressBusiness extends BaseBusiness<Dress> {

    public DressBusiness() {
        super(Dress.class);
    }

    public void insert(Dress model) throws Exception {

        model.setBrand(model.getBrand().trim());
        if (model.getBrand() == null || model.getBrand().length() == 0) {
            throw new Exception("Marca não informada!!!");
        }

        model.setBuyLocal(model.getBuyLocal().trim());
        if (model.getBuyLocal() == null || model.getBuyLocal().length() == 0) {
            throw new Exception("Local de compra não informado!!!");
        }

        RepositoryFactory<DressRepository> repoFactory = new RepositoryFactory<DressRepository>(DressRepository.class);
        DressRepository repository = (DressRepository) repoFactory.getInstante();
        List<Dress> items = repository.list();

        if (items != null && items.size() > 0) {
            for (Dress item : items) {
                if (item.getCode() == model.getCode()) {
                    throw new Exception("Já existe um item com este código, informe outro!!!");
                }
            }
        }

        model.setDescription(model.getDescription().trim());
        if (model.getDescription() == null || model.getDescription().length() == 0) {
            throw new Exception("Descrição não informada!!!");
        }

        if (model.getPayValue() <= 0) {
            throw new Exception("O valor pago deve ser maior que zero (0)!!!");
        }

        if (model.getSuggestedPrice() <= 0) {
            throw new Exception("O valor do preço sugerido deve ser maior que zero (0)!!!");
        }

        if (model.getTagValue() <= 0) {
            throw new Exception("O valor da etiqueta deve ser maior que zero (0)!!!");
        }

        model.setType(model.getType().trim());
        if (model.getType() == null || model.getType().length() == 0) {
            throw new Exception("O tipo não foi informado!!!");
        }

        repository.insert(model);
    }

    public void update(Dress model) throws Exception {
        model.setBrand(model.getBrand().trim());
        if (model.getBrand() == null || model.getBrand().length() == 0) {
            throw new Exception("Marca não informada!!!");
        }

        model.setBuyLocal(model.getBuyLocal().trim());
        if (model.getBuyLocal() == null || model.getBuyLocal().length() == 0) {
            throw new Exception("Local de compra não informado!!!");
        }

        if (model.getCode() == 0) {
            throw new Exception("O código deve ser diferente de zero(0)!!!");
        }

        RepositoryFactory<DressRepository> repoFactory = new RepositoryFactory<DressRepository>(DressRepository.class);
        DressRepository repository = (DressRepository) repoFactory.getInstante();
        List<Dress> items = repository.list();
        boolean found = false;

        if (items != null && items.size() > 0) {
            for (Dress item : items) {
                if (item.getCode() == model.getCode()) {
                    found = true;
                }
            }
        }

        if (!found) {
            throw new Exception("Item com código não encontrado!!!");
        }

        model.setDescription(model.getDescription().trim());
        if (model.getDescription() == null || model.getDescription().length() == 0) {
            throw new Exception("Descrição não informada!!!");
        }

        if (model.getPayValue() <= 0) {
            throw new Exception("O valor pago deve ser maior que zero (0)!!!");
        }

        if (model.getSuggestedPrice() <= 0) {
            throw new Exception("O valor do preço sugerido deve ser maior que zero (0)!!!");
        }

        if (model.getTagValue() <= 0) {
            throw new Exception("O valor da etiqueta deve ser maior que zero (0)!!!");
        }

        model.setType(model.getType().trim());
        if (model.getType() == null || model.getType().length() == 0) {
            throw new Exception("O tipo não foi informado!!!");
        }

        repository.update(model);
    }

    public List<Dress> list() throws InstantiationException, IllegalAccessException, FileNotFoundException {
        RepositoryFactory<DressRepository> factory = new RepositoryFactory<DressRepository>(DressRepository.class);
        DressRepository repository = (DressRepository) factory.getInstante();
        List<Dress> items = repository.list();

        return items;
    }

    public void delete(int code) throws InstantiationException, IllegalAccessException, IOException, Exception {
        Dress model = this.getInstance();

        model.setCode(code);

        RepositoryFactory<DressRepository> repoFactory = new RepositoryFactory<DressRepository>(DressRepository.class);
        DressRepository repository = (DressRepository) repoFactory.getInstante();
        List<Dress> itens = repository.list();

        if (itens != null && itens.size() > 0) {
            boolean found = false;

            for (Dress item : itens) {
                if (item.getCode() == model.getCode()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new Exception("Código inesistente para exclusão.");
            }

            repository.delete(model);
        }
    }
}
