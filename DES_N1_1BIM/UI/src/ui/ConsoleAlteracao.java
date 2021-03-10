/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import challenge.Domain.Dress;
import challenge.business.BusinessFactory;
import challenge.business.DressBusiness;

/**
 *
 * @author Gustavo
 */
public class ConsoleAlteracao extends ConsoleInsercao {

    @Override
    public boolean execute() {

        try {
            BusinessFactory<DressBusiness> factory = new BusinessFactory<DressBusiness>(DressBusiness.class);
            DressBusiness business = factory.getInstante();
            Dress model = business.getInstance();

            this.draw(model);
            business.update(model);
            
            System.out.println("Roupa atualizada com sucesso!!!");
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        return false;
    }
}
