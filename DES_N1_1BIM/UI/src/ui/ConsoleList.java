/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import challenge.Domain.Dress;
import challenge.business.BusinessFactory;
import challenge.business.DressBusiness;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ConsoleList extends BaseConsole {

    @Override
    public boolean execute() {
        BusinessFactory<DressBusiness> factory = new BusinessFactory<DressBusiness>(DressBusiness.class);
        DressBusiness dressBusiness;

        try {
            dressBusiness = factory.getInstante();

            List<Dress> itens = dressBusiness.list();
            String contentScreen = "";

            if (itens == null || itens.size() == 0) {
                System.out.println("Não existem roupas cadastradas...");
            } else {
                for (Dress item : itens) {
                    contentScreen
                            = "Código: "
                            + item.getCode()
                            + " - Marca: "
                            + item.getBrand()
                            + " - Loca de Compra: "
                            + item.getBuyLocal()
                            + " - Descrição: "
                            + item.getDescription()
                            + " - Tipo: "
                            + item.getType()
                            + " - Tamanho: "
                            + item.getSize()
                            + " - Cor: "
                            + item.getColor()
                            + " - Preço: R$ "
                            + item.getTagValue();

                    System.out.println(contentScreen);
                }
            }

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        return false;
    }
}
